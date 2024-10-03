package ru.chekalinev.fortravelers.domain.models;

import java.util.List;

public class User {
    private String login;
    private String password;
    private List<Landmark> favLandmark;

    public User(String login, String password, List<Landmark> favLandmark){
        this.login = login;
        this.password = password;
        this.favLandmark = favLandmark;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public List<Landmark> getFavLandmark(){
        return favLandmark;
    }

    public boolean SetPassword(String password){
        if(!password.isEmpty()){
            this.password = password;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean SetFavLandmarks(List<Landmark> favLandmark){
        if(!favLandmark.isEmpty()){
            this.favLandmark = favLandmark;
            return true;
        }
        else{
            return false;
        }
    }
}
