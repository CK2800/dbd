package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.UserManagement;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.dto.UserOverview;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;
import dk.cphbusiness.mrv.twitterclone.util.Constants;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.*;

public class UserManagementImpl implements UserManagement {

    private final Jedis jedis;

    public UserManagementImpl(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public boolean createUser(UserCreation userCreation) {
        /**
         * USER gemmes i sættet USERS.
         * USER er en hash med flg. attributter:
         * name, login, password, tweets, retweets
         *
         * PSEUDO:
         * tjek at bruger ikke findes i forvejen.
         * opret bruger
         * tilføj bruger til sættet.
         * opret lister til tweets, retweets
         */

        String member = UserValidation.validateUser(this.jedis, userCreation.username);
        if(member == null)
        {
            member = Constants.USER.label + userCreation.username;
            List<Object> result = null;

            try(Transaction transaction = jedis.multi()){
                // Opret bruger
                transaction.hset(member, userCreation.toMap());
                // Tilføj bruger til sættet
                transaction.sadd(Constants.USERS.label, member);

                // Opret liste til tweets
                // Opret liste til retweets

                result = transaction.exec();
            }
            // result skal indeholde 1 i begge objekter.
            return result != null && (long)(result.get(0)) >= 1 && (long)(result.get(1)) >= 1;
        }
        return false;


    }

    @Override
    public UserOverview getUserOverview(String username) {
        /**
         * PSEUDO
         * get USER:username som er en hash
         * returner UserOverview obj. med flg.:
         * USER:username:firstname
         * USER:username:lastname
         */
        String member = UserValidation.validateUser(this.jedis, username);
        // defensive!!
        if (member != null)
        {
            UserOverview uo = new UserOverview();
            uo.firstname = jedis.hget(member, "firstname");
            uo.lastname = jedis.hget(member, "lastname");

            uo.numFollowers = jedis.smembers(member + Constants.FOLLOWEDBY.label).size();
            uo.numFollowing = jedis.smembers(member + Constants.FOLLOWS.label).size();
            return uo;
        }
        return null;
    }

    @Override
    public boolean updateUser(UserUpdate userUpdate) {
        /**
         * PSEUDO
         * check om user findes.
         * Hvis - så:
         * hent user
         * gem user i klient
         * og opdater.
         * Er der tilføjet felter - rollback TBD i v2 efter eksamen eller noget.
         */
        String member = UserValidation.validateUser(this.jedis, userUpdate.username);
        if (member != null)
        {

            List<Object> result = null;

            try (Transaction transaction = jedis.multi())
            {
                //if (ValidateUserUpdate(userUpdate)) // hvis userUpdate har nulls eller "", skal intet opdateres.
                  //  transaction.hset(member, userUpdate.toMap());
                if (userUpdate.username != null && userUpdate.username != "")
                    transaction.hset(member, "username", userUpdate.username);
                if (userUpdate.firstname != null && userUpdate.firstname != "")
                    transaction.hset(member, "firstname", userUpdate.firstname);
                if (userUpdate.lastname != null && userUpdate.lastname != "")
                    transaction.hset(member, "lastname", userUpdate.lastname);
                if (userUpdate.birthday != null && userUpdate.birthday != "")
                    transaction.hset(member, "birthday", userUpdate.birthday);
                result = transaction.exec();
            }

            return result != null && (long) (result.get(0)) == 0; // 0 indikerer at ingen nye felter blev tilføjet.

        }
        return false;
    }

    @Override
    public boolean followUser(String username, String usernameToFollow) {
        /**
         * PSEUDO
         * Check at begge brugere findes.
         * Hvis - så oprettes forbindelsen.
         */
        String follower = UserValidation.validateUser(this.jedis, username);
        String followed = UserValidation.validateUser(this.jedis, usernameToFollow);
        if (follower != null && followed != null)
        {
            List<Object> result = null;
            try(Transaction transaction = jedis.multi())
            {
                // Tilføj til sæt, så vi ikke har duplikater.
                transaction.sadd(follower + Constants.FOLLOWS.label, followed);
                transaction.sadd(followed + Constants.FOLLOWEDBY.label, follower);

                result = transaction.exec();
            }
            // for hver tilføjelse til et sæt returneres 0, hvis elementet allerede findes, ellers 1.
            // Begge elementer i result bør således samlet være mellem 0 og 2.
            long sum = (long)result.get(0) + (long)result.get(1);
            return result != null && (sum >= 0 && sum <= 2);
        }
        return false;
    }

    @Override
    public boolean unfollowUser(String username, String usernameToUnfollow) {
        /**
         * PSEUDO
         * Check at begge brugere findes.
         * Hvis - så fjernes forbindelsen.
         */
        String follower = UserValidation.validateUser(this.jedis, username);
        String followed = UserValidation.validateUser(this.jedis, usernameToUnfollow);
        if (follower != null && followed != null)
        {
            List<Object> result = null;
            try(Transaction transaction = jedis.multi())
            {
                transaction.srem(follower + Constants.FOLLOWS.label, followed);
                transaction.srem(followed + Constants.FOLLOWEDBY.label, follower);

                result = transaction.exec();
            }
            // for hver fjernelse fra et sæt returneres 0, hvis elementet ikke fandtes, ellers 1.
            // Begge elementer i result bør således samlet være mellem 0 og 2.
            long sum = (long)result.get(0) + (long)result.get(1);
            return result != null && (sum >= 0 && sum <= 2);
        }
        return false;
    }

    @Override
    public Set<String> getFollowedUsers(String username) {
        String member = UserValidation.validateUser(jedis, username);
        if (member != null)
        {
            String key = member + Constants.FOLLOWS.label;
            Set<String> followedUserKeys = jedis.smembers(key);
            Set<String> followers = new HashSet<>();
            for (String followedUserKey : followedUserKeys)
                followers.add(jedis.hget(followedUserKey, "username"));

            return followers;
        }
        return null;
    }

    @Override
    public Set<String> getUsersFollowing(String username) {
        String member = UserValidation.validateUser(jedis, username);
        if (member != null)
        {
            String key = member + Constants.FOLLOWEDBY.label;
            Set<String> followingUserKeys = jedis.smembers(key);
            Set<String> followings = new HashSet<>();
            for (String followingUserKey : followingUserKeys)
                followings.add(jedis.hget(followingUserKey, "username"));
            return followings;
        }
        return null;
    }

    public static boolean ValidateUserUpdate(UserUpdate userUpdate)
    {

        if (!UserValidation.anyIsNull(userUpdate.username, userUpdate.firstname, userUpdate.lastname, userUpdate.birthday))
            return (userUpdate.username != "" && userUpdate.firstname != "" && userUpdate.lastname != "" && userUpdate.birthday != "");

        return false;
    }



}
