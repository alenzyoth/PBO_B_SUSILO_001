//class abstract Users
package com.praktikum.users;

public abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    // Method abstrak login, akan diimplementasikan oleh subclass
    public abstract void login();

    // Method abstrak untuk menampilkan menu aplikasi
    public abstract void displayAppMenu();
}