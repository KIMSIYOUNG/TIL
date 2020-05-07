package com.example.oauth2google.user.config.auth;

import java.util.Map;

import com.example.oauth2google.user.domain.Role;
import com.example.oauth2google.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OauthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OauthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name,
        String picture, String email) {
        this.attributes = attributes;
        this.name = name;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
        this.picture = picture;
    }

    public static OauthAttributes of(String registrationId, String userNameAttributeName,
        Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OauthAttributes ofGoogle(String userNameAttributeName,
        Map<String, Object> attributes) {
        return OauthAttributes.builder()
            .name((String)attributes.get("name"))
            .email((String)attributes.get("email"))
            .picture((String)attributes.get("picture"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    public User toEntity() {
        return User.builder()
            .name(name)
            .email(email)
            .picture(picture)
            .role(Role.GUEST)
            .build();
    }
}
