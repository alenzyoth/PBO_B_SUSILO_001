//class admin
package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.AdminActions;

//Kelas Admin mewarisi User dan mengimplementasikan AdminActions.
public class Admin extends User implements AdminActions {

    public Admin(String username) {
        super(username);
    }

    // Implementasi method login
    @Override
    public void login() {
        System.out.println("Admin " + username + " login berhasil.");
    }

    // Menampilkan menu khusus untuk Admin
    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    // Fitur kelola laporan barang (belum tersedia)
    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    // Fitur kelola data mahasiswa (belum tersedia)
    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}
