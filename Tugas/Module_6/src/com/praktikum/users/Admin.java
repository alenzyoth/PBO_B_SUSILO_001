package com.praktikum.users;

public class Admin extends  User {
    private String password;

    public Admin(String nama, String password) {
        super(nama);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}