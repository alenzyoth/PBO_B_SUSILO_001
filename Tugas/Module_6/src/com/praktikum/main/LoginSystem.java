package com.praktikum.main;

import com.praktikum.data.DataStore;
import com.praktikum.users.*;

public class LoginSystem {
    public static User login(String role, String nama, String passOrNIM) {
        if (role.equals("Admin")) {
            for (Admin admin : DataStore.adminList) {
                if (admin.getNama().equals(nama) && admin.getPassword().equals(passOrNIM)) {
                    return admin;
                }
            }
        } else {
            for (Mahasiswa mhs : DataStore.mahasiswaList) {
                if (mhs.getNama().equals(nama) && mhs.getNim().equals(passOrNIM)) {
                    return mhs;
                }
            }
        }
        return null;
    }
}