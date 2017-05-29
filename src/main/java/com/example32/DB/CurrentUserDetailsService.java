package com.example32.DB;

import com.example32.DB.User;
import com.example32.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = userService.getPersonByName(email);
              //  .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new User(person);
    }
}