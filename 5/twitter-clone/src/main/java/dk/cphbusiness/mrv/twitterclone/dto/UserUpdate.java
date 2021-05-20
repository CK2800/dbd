package dk.cphbusiness.mrv.twitterclone.dto;

import java.util.HashMap;
import java.util.Map;

public class UserUpdate {
    public String username;
    public String firstname; // if null, don't update
    public String lastname; // if null, don't update
    public String birthday; // if null, don't update

    public UserUpdate(String username, String firstname, String lastname, String birthday) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public Map<String, String> toMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("birthday", birthday);
        map.put("firstname", firstname);
        map.put("lastname", lastname);
        return map;
    }
}
