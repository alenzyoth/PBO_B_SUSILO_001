package com.praktikum.main;

import com.praktikum.actions.AdminActions;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    private static final ArrayList<User> userList = new ArrayList<>();
    private static final ArrayList<Item> reportedItems = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Data admin dan mahasiswa
        userList.add(new Admin("susil", "001"));
        userList.add(new Mahasiswa("adi", "001"));

        System.out.println("===== SISTEM PELAPORAN BARANG KAMPUS =====");

        while (true) {
            System.out.print("\nUsername: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User loggedInUser = login(username, password);

            if (loggedInUser != null) {
                System.out.println("Login berhasil. Selamat datang, " + loggedInUser.getUsername() + "!");

                if (loggedInUser instanceof Admin) {
                    runAdminMenu((AdminActions) loggedInUser);
                } else if (loggedInUser instanceof Mahasiswa) {
                    runMahasiswaMenu((MahasiswaActions) loggedInUser);
                }
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }

            System.out.print("\nApakah Anda ingin keluar dari sistem? (y/n): ");
            String exit = scanner.nextLine();
            if (exit.equalsIgnoreCase("y")) {
                System.out.println("Terima kasih telah menggunakan sistem.");
                break;
            }
        }
    }

    private static User login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void runAdminMenu(AdminActions admin) {
        while (true) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        admin.manageItems(reportedItems, scanner);
                        break;
                    case 2:
                        admin.manageUsers(userList, scanner);
                        break;
                    case 3:
                        System.out.println("Logout berhasil.");
                        return;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private static void runMahasiswaMenu(MahasiswaActions mahasiswa) {
        while (true) {
            System.out.println("\n===== MENU MAHASISWA =====");
            System.out.println("1. Laporkan Barang Hilang");
            System.out.println("2. Lihat Laporan Barang");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        mahasiswa.reportItem(reportedItems, scanner);
                        break;
                    case 2:
                        mahasiswa.viewReportedItems(reportedItems);
                        break;
                    case 3:
                        System.out.println("Logout berhasil.");
                        return;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }
}