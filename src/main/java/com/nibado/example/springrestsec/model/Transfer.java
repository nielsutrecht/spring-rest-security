package com.nibado.example.springrestsec.model;

public class Transfer {
    public final int from;
    public final int to;
    public final long amount;
    public final long timestamp;

    public Transfer(int from, int to, long amount, long timestamp) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transfer invert() {
        return new Transfer(to, from, -amount, timestamp);
    }
}
