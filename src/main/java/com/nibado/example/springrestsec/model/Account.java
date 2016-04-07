package com.nibado.example.springrestsec.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Account {
    public final int number;
    private long balance;
    private List<Transfer> transfers;

    public Account(int number) {
        this(number, 0);
    }

    public Account(int number, long balance) {
        this.number = number;
        this.balance = balance;
        this.transfers = new ArrayList<>();
    }

    public long getBalance() {
        return balance;
    }

    public List<Transfer> getTransfers() {
        return unmodifiableList(transfers);
    }

    public void addTransfer(Transfer transfer) {
        transfers.add(transfer);
        balance += transfer.amount;
    }
}
