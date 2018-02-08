package com.vrishankgupta.instaclone.Models;

/**
 * Created by vrishankgupta on 08/02/18.
 */

public class User {
    private String user_id;
    private long phone_no;
    private String email;
    private String username;

    public User(String user_id, long phone_no, String email, String username) {
        this.user_id = user_id;
        this.phone_no = phone_no;
        this.email = email;
        this.username = username;
    }

    public User()
    {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
