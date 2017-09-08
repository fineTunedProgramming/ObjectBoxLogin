package com.programming.finetune.objectboxlogin;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cedex on 9/8/2017.
 */
@Entity
public class User {
    @Id(assignable = true)
    private long id;

    private String userName;
    private String mobNumber;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidUsername(){
        return !userName.isEmpty();
    }

    public boolean isValidPassword(){
        return password.length() > 4;
    }
}
