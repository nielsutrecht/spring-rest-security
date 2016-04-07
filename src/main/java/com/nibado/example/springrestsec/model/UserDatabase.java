package com.nibado.example.springrestsec.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDatabase implements UserDetailsService {
    private Set<String> userSet = new HashSet<>();

    public boolean canLogin(String user, String password) {
        try {
            UserDetails details = loadUserByUsername(user);
            return details.getPassword().equals(password);
        }
        catch(UsernameNotFoundException e) {
            return false;
        }
    }

    public void addUser(String... users) {
        for(String user : users) {
            userSet.add(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if(userSet.contains(name)) {
            return new User(name, reverse(name), Arrays.asList(new UserRole()));
        }
        else {
            throw new UsernameNotFoundException(name);
        }
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static class UserRole implements GrantedAuthority {
        @Override
        public String getAuthority() {
            return "ROLE_USER";
        }
    }
}
