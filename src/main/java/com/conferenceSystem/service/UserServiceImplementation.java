package com.conferenceSystem.service;

import com.conferenceSystem.model.User;
import com.conferenceSystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImplementation  implements UserDetailsService {
    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public UserServiceImplementation() {

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null){
            throw  new UsernameNotFoundException("Could not find the user");

        }
        return new MyUserDetails(user);
    }
}
