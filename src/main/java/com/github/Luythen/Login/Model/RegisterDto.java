package com.github.Luythen.Login.Model;

import jakarta.validation.constraints.NotBlank;

public class RegisterDto {

    @NotBlank(message = "Cannot be empty")
    private String email;

    @NotBlank(message = "Cannot be empty")
    private String firstName;

    @NotBlank(message = "Cannot be empty")
    private String lastName;

    @NotBlank(message = "Cannot be empty")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
