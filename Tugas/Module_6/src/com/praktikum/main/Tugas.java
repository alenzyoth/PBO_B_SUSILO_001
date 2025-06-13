package com.praktikum.main;

import com.praktikum.Data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Tugas {
    public static List<User> userList = new ArrayList<>();
    public static List<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeUsers();

        while (true) {
            System.out.println("Pilih Login");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");

            try {

                int pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1:
                        loginAdmin(scanner);
                        break;
                    case 2:
                        loginMahasiswa(scanner);
                        break;
                    case 0:
                        System.out.println("Keluar");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    public static void initializeUsers() {
        userList.add(new Admin("Admin", "000", "admin", "admin048"));
        userList.add(new Mahasiswa("Rafi", "202410370110048"));
    }

    public static void loginAdmin(Scanner scanner) {
        System.out.print("Username Admin: ");
        String user = scanner.nextLine();
        System.out.print("Password Admin: ");
        String pass = scanner.nextLine();

        for (User u : userList) {
            if (u instanceof Admin && u.login(user, pass)) {
                u.displayInfo();
                u.displayAppMenu();
                return;
            }
        }
        System.out.println("Login gagal.");
    }

    public static void loginMahasiswa(Scanner scanner) {
        System.out.print("Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        for (User u : userList) {
            if (u instanceof Mahasiswa && u.login(nama, nim)) {
                u.displayInfo();
                u.displayAppMenu();
                return;
            }
        }
        System.out.println("Login gagal.");
    }
}
