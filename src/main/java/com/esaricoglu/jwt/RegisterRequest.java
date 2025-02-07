package com.esaricoglu.jwt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RegisterRequest {

    @NotEmpty(message = "Username can't be empty.")
    private String username;

    @NotEmpty(message = "Username can't be empty.")
    private String password;

    @NotEmpty(message = "Username can't be empty.")
    @Email(message = "Please enter a valid e-mail address.")
    private String email;

    public RegisterRequest() {}

    public RegisterRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
