package dk.cphbusiness.mrv.twitterclone.util;

import java.util.HashMap;
import java.util.Map;

public enum Constants
{
    USERS("USERS"),
    USER("USER:"),
    FOLLOWS(":FOLLOWS"),
    FOLLOWEDBY(":FOLLOWEDBY"),
    POSTS(":POSTS");

    public final String label;
    private Constants(String label)
    {
        this.label = label;
    }
}
