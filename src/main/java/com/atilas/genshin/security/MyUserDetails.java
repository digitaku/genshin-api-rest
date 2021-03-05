package com.atilas.genshin.security;

import java.util.Optional;

import com.atilas.genshin.model.User;
import com.atilas.genshin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário com nome " + username + " não foi encontrado.");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.get().getPassword())//
                .authorities(user.get().getRoles())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }

}
