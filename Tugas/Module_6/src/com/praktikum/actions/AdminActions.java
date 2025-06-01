package com.praktikum.actions;

import com.praktikum.data.Item;
import com.praktikum.users.User;

import java.util.ArrayList;
import java.util.Scanner;

public interface AdminActions {
    void manageItems(ArrayList<Item> reportedItems, Scanner scanner);
    void manageUsers(ArrayList<User> userList, Scanner scanner);
}