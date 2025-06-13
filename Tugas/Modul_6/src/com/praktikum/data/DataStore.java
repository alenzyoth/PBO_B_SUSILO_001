package com.praktikum.data;

import com.praktikum.data.Item;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.Admin;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<Item> itemList = new ArrayList<>();
    public static List<Mahasiswa> mahasiswaList = new ArrayList<>();
    public static List<Admin> adminList = new ArrayList<>();

    static {
        // Data dummy
        mahasiswaList.add(new Mahasiswa("Adi", "202410370110001"));
        mahasiswaList.add(new Mahasiswa("idris", "20241037011001"));
        adminList.add(new Admin("Admin", "admin123"));
    }
}
