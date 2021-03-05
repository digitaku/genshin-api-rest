package com.atilas.genshin.controller;

import com.atilas.genshin.dto.UserDto;
import com.atilas.genshin.dto.UserResponseDto;
import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.UserAlreadyExistException;
import com.atilas.genshin.exception.UserBadRequest;
import com.atilas.genshin.exception.UserPasswordNotFoundException;
import com.atilas.genshin.model.User;
import com.atilas.genshin.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class LoginController {
    // cadastro
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signup")
    public ResponseEntity<String> create(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UserBadRequest e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto user) {
        try {
            return new ResponseEntity<>(userService.login(modelMapper.map(user, User.class)), HttpStatus.OK);
        } catch (UserPasswordNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UserBadRequest e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public UserResponseDto getUserByUserName(@RequestParam String user) {

        System.out.println(user);
        return userService.getUser(user);

    }
}
