package com.nibado.example.springrestsec.controller;

import com.nibado.example.springrestsec.model.Account;
import com.nibado.example.springrestsec.model.AccountDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nibado.example.springrestsec.security.SecurityUtil.checkUser;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountDatabase database;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable String user) {
        checkUser(user);
        return database.getAccount(user);
    }
}
