package ru.chekalinev.fortravelers.domain.repository;

import java.util.List;

import ru.chekalinev.fortravelers.domain.models.Landmark;

public interface UserRepository {
    public boolean ChangeUserInfo(String password, List<Landmark> favLandmark);
    public boolean SignIn(String login, String password);
    public  boolean LogOut();
}
