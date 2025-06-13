package com.praktikum.  Data;

import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<User> userList = new ArrayList<>();
    public static List<Item> reportedItems = new ArrayList<>();

    public static void initializeDefaultUsers() {
        userList.clear();
        reportedItems.clear();

        userList.add(new Admin("admin", "admin048", "admin", "admin048"));
        userList.add(new Mahasiswa("Rafi", "202410370110048"));

    }

    public static List<User> getUserList() {

        return userList;
    }
}
