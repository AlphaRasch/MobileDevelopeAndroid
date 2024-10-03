package ru.chekalinev.fortravelers.data.repository;

import java.util.List;

import ru.chekalinev.fortravelers.domain.models.Landmark;
import ru.chekalinev.fortravelers.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private String login;
    private String password;

    public UserRepositoryImpl(){
        this.login = "user1";
        this.password = "passw";
    }
    @Override
    public boolean ChangeUserInfo(String password, List<Landmark> favLandmark) {
        return false;
    }

    @Override
    public boolean SignIn(String login, String password) {
        return login.equals(this.login) && password.equals(this.password);
    }

    @Override
    public boolean LogOut() {
        return false;
    }
}
