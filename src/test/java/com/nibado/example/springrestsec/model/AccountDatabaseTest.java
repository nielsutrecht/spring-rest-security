package com.nibado.example.springrestsec.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDatabaseTest {
    private AccountDatabase database;

    @Before
    public void setUp() throws Exception {
        database = new AccountDatabase();
        database.createAccount("tom", 100000);
        database.createAccount("sally", 200000);
    }

    @Test
    public void testCreateAccount() throws Exception {
        assertThat(database.getAccount("tom")).isNotNull();
        assertThat(database.getAccount("sally")).isNotNull();
        assertThat(database.getAccount("john")).isNull();

        assertThat(database.getAccount("tom").getBalance()).isEqualTo(100000);
        assertThat(database.getAccount("sally").getBalance()).isEqualTo(200000);

        assertThat(database.getAccount("tom").number).isBetween(10000, 99999);

    }

    @Test
    public void testTransfer() throws Exception {
        database.transfer("tom", "sally", 50000);

        assertThat(database.getAccount("tom").getBalance()).isEqualTo(50000);
        assertThat(database.getAccount("sally").getBalance()).isEqualTo(250000);
    }
}