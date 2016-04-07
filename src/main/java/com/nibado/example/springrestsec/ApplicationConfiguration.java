package com.nibado.example.springrestsec;

import com.nibado.example.springrestsec.model.Account;
import com.nibado.example.springrestsec.model.AccountDatabase;
import com.nibado.example.springrestsec.model.UserDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public UserDatabase getUserDatabase() {
        UserDatabase database = new UserDatabase();

        database.addUser("tom", "sally", "john", "greg");

        return database;
    }

    @Bean
    public AccountDatabase getAccountDatabase() {
        AccountDatabase database = new AccountDatabase();

        Account a = database.createAccount("tom", 100000);
        Account b = database.createAccount("sally", 200000);
        Account c = database.createAccount("john", 300000);
        Account d = database.createAccount("greg", 400000);

        database.transfer("tom", "sally", 2500);
        database.transfer("tom", "sally", 2000);
        database.transfer("tom", "john", 5000);
        database.transfer("sally", "john", 15000);
        database.transfer("john", "tom", 50000);

        return database;
    }
}
