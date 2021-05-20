package dk.cphbusiness.mrv.twitterclone.dto;

import java.util.HashMap;
import java.util.Map;

public class UserCreation {
    public String username;
    public String firstname;
    public String lastname;
    public String passwordHash;
    public String birthday;

    public UserCreation(String username,
                        String firstname,
                        String lastname,
                        String passwordHash,
                        String birthday) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passwordHash = passwordHash;
        this.birthday = birthday;
    }

    public Map<String, String> toMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("birthday", birthday);
        map.put("firstname", firstname);
        map.put("lastname", lastname);
        map.put("passwordHash", passwordHash);
        return map;
    }
}
