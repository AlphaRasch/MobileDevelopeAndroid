package ru.chekalinev.fortravelers.domain.usecases;

import ru.chekalinev.fortravelers.domain.repository.UserRepository;

public class SignInUseCase {
    private UserRepository userRepository;
    public SignInUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(String login, String password) {
        return userRepository.SignIn(login, password);
    }
}
