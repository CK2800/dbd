package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.PostManagement;
import dk.cphbusiness.mrv.twitterclone.dto.Post;
import dk.cphbusiness.mrv.twitterclone.util.Constants;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PostManagementImpl implements PostManagement
{
    private final Jedis jedis;
    private final Time time;

    public PostManagementImpl(Jedis jedis, Time time) {
        this.jedis = jedis;
        this.time = time;
    }

    @Override
    public boolean createPost(String username, String message) {
        String member = UserValidation.validateUser(this.jedis, username);
        if (member != null)
        {
            List<Object> result = null;
            try(Transaction transaction = jedis.multi())
            {
                transaction.zadd(member + Constants.POSTS.label, time.getCurrentTimeMillis(), message);
                result = transaction.exec(); // zadd returnerer antallet af elementer der tilføjedes.
            }
            if ((long)result.get(0) > 0)
                return true;
        }
        return false;
    }

    @Override
    public List<Post> getPosts(String username) {
        String member = UserValidation.validateUser(jedis, username);
        List<Post> posts = new ArrayList<>();
        if (member != null)
        {
            Set<Tuple> tuples = jedis.zrangeWithScores(member + Constants.POSTS.label, 0, -1);
            for(Tuple tuple:tuples)
            {
                posts.add(new Post((long)tuple.getScore(), tuple.getElement()));
            }
        }
        return posts;
    }

    @Override
    public List<Post> getPostsBetween(String username, long timeFrom, long timeTo) {
        String member = UserValidation.validateUser(jedis, username);
        List<Post> posts = new ArrayList<Post>();
        if (member != null)
        {
            Set<Tuple> tuples = jedis.zrangeByScoreWithScores(member + Constants.POSTS.label, timeFrom, timeTo);
            for(Tuple tuple : tuples)
            {
                // ouch, narrowing the score !!!
                posts.add(new Post((long)tuple.getScore(), tuple.getElement()));
            }
        }
        return posts;
    }

}
