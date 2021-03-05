package com.atilas.genshin.dto;

import java.util.List;

import com.atilas.genshin.model.Role;

public class UserResponseDto {
    private String userName;

    List<Role> roles;

    public UserResponseDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
