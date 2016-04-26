package net.naturesnap.apiclient.http.results;

/**
 * Created by Nathaniel on 4/26/2016.
 */
public class UserResponse extends Result {
    public boolean success;
    public String user_id;
    public String username;
    public String name;
    public String last_name;
    public String email;
    public String latest_login;
    public String ip_address;
    public boolean getSuccess() {
        return success;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }
    public String getLatest_login() {
        return latest_login;
    }
    public String getIp_address() {
        return ip_address;
    }
}