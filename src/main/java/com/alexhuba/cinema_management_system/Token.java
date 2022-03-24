package com.alexhuba.cinema_management_system;

import java.util.UUID;

/*
* This class is important for refunds
* */

public class Token {
    UUID token;

    public Token() {
    }

    public Token(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
