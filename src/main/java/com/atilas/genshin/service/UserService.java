package com.atilas.genshin.service;

import java.util.Arrays;
import java.util.Optional;

import com.atilas.genshin.dto.UserResponseDto;
import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.UserAlreadyExistException;
import com.atilas.genshin.exception.UserBadRequest;
import com.atilas.genshin.exception.UserPasswordNotFoundException;
import com.atilas.genshin.model.Role;
import com.atilas.genshin.model.User;
import com.atilas.genshin.repository.UserRepository;
import com.atilas.genshin.security.JwtTokenProvider;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    public String signup(User user) {
        if (user.getPassword() == null || user.getUserName() == null) {
            throw new UserBadRequest("Username or password is required.");
        }
        if (userRepository.existsById(user.getUserName())) {
            throw new UserAlreadyExistException("Username is already in use");
        }

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList(Role.CLIENT));
            userRepository.save(user);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        return jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
    }

    public String login(User user) {
        if (user.getPassword() == null || user.getUserName() == null) {
            throw new UserBadRequest("Username or password is required.");
        }
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        } catch (AuthenticationException e) {
            throw new UserPasswordNotFoundException(e.getMessage());
        }

        Optional<User> userExist = userRepository.findById(user.getUserName());
        return jwtTokenProvider.createToken(user.getUserName(), userExist.get().getRoles());
    }

    public UserResponseDto getUser(String user) {
        Optional<User> userExist = userRepository.findById(user);

        if (userExist.isEmpty()) {
            throw new UsernameNotFoundException(user + ": Not found");
        }
        return modelMapper.map(userExist.get(), UserResponseDto.class);
    }

}
