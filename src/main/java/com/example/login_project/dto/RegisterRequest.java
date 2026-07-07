package com.example.login_project.dto;

public class RegisterRequest {

    private String username;
    private  String password;
    private String name;
    String surname;
    private String email;


    public RegisterRequest(){

    }

    public  RegisterRequest(String username, String password,String name,String surname, String email){
        this.username=username;
        this.password=password;
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
