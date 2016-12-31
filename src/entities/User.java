package entities;

import util.ICopyable;
/**
 * Created by captaincode on 12/29/16.
 */
public class User implements ISysEntity, ICopyable{
    private String email;
    private String password;

    public User(){
        this.email = "";
        this.password = "";
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public ICopyable copy(){
        User tmpuser = new User();
        tmpuser.setEmail(this.email);
        tmpuser.setPassword(this.password);
        return tmpuser;
    }

    public User copyUser(){
        return (User) this.copy();
    }
}
