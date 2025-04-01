package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {


    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Email inválido")
    private String email;


    @NotBlank(message = "A senha é obrigatoria")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
