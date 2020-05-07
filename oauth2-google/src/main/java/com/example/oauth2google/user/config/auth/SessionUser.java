package com.example.oauth2google.user.config.auth;

import java.io.Serializable;

import com.example.oauth2google.user.domain.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
