package com.nibado.example.springrestsec.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDatabaseTest {

    @Test
    public void testCanLogin() throws Exception {
        UserDatabase database = new UserDatabase();

        database.addUser("tom", "sally");

        assertThat(database.canLogin("tom", "mot")).isTrue();
        assertThat(database.canLogin("sally", "yllas")).isTrue();
        assertThat(database.canLogin("john", "nhoj")).isFalse();
        assertThat(database.canLogin("tom", "nhoj")).isFalse();
    }
}