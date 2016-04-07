package com.nibado.example.springrestsec.security;

import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {
    public static String getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public static void checkUser(String user) {
        if(!getUser().equals(user)) {
            throw new AuthorizationServiceException(user);
        }
    }
}
