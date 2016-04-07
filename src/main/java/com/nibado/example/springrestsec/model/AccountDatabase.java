package com.nibado.example.springrestsec.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AccountDatabase {
    private static final Random RANDOM = new Random();
    private Map<String, Account> accounts;

    public AccountDatabase() {
        accounts = new HashMap<>();
    }

    public Account createAccount(String user, long balance) {
        Account account = new Account(10000 + RANDOM.nextInt(9000), balance);

        accounts.put(user, account);

        return account;
    }

    public Account getAccount(String user) {
        return accounts.get(user);
    }

    public void transfer(String from, String to, long amount) {
        Account fromAccount = getAccount(from);
        Account toAccount = getAccount(to);

        Transfer transfer = new Transfer(fromAccount.number, toAccount.number, amount, randomTime());

        toAccount.addTransfer(transfer);
        fromAccount.addTransfer(transfer.invert());
    }

    private long randomTime() {
        long hour = 1000 * 60 * 60;
        int hoursPerWeek = 24 * 7;
        return System.currentTimeMillis() - (RANDOM.nextInt(hoursPerWeek * 4) * hour);
    }
}
