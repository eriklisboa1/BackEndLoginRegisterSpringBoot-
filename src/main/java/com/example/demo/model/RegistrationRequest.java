package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegistrationRequest {


    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "A confirmação de senha é obrigatoria")
    private String confirmPassword;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
