package com.praktikum.actions;

import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.Scanner;

public interface MahasiswaActions {
    void reportItem(ArrayList<Item> reportedItems, Scanner scanner);
    void viewReportedItems(ArrayList<Item> reportedItems);
}

