package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.util.Constants;
import redis.clients.jedis.Jedis;

public class UserValidation
{
    /**
     * Validerer at user med username findes i USERS.
     *
     * @param jedis
     * @param username
     * @return Returnerer member i formen: USER:username hvis username er gyldigt. Ellers null.
     */
    public static String validateUser(Jedis jedis, String username)
    {
        String member = Constants.USER.label + username;
        if (jedis.sismember(Constants.USERS.label, member))
            return member;
        return null;
    }

    public static boolean anyIsNull(Object... objects)
    {
        for (Object object : objects)
        {
            if (object == null)
                return true;
        }
        return false;
    }
}
