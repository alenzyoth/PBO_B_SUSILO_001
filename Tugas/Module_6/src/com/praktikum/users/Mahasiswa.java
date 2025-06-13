package com.praktikum.users;

import com.praktikum.Data.Item;

import java.util.Scanner;

public class Mahasiswa extends User {

    public Mahasiswa(String name, String nim) {
        super(name, nim);
    }

    @Override
    public boolean login(String username, String password) {
        return this.name.equalsIgnoreCase(username) && this.id.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa: " + name + " (NIM: " + id + ")");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu Mahasiswa: ");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Barang yang Dilaporkan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        reportItem(scanner);
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 0:
                        System.out.println("Logout...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                choice = 4;//menandai input tidak valid agar loop tetap jalan
            }
        } while (choice != 0);
    }

    public void reportItem(Scanner scanner) {
        System.out.print("Nama Barang: ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String desc = scanner.nextLine();
        System.out.print("Lokasi Ditemukan: ");
        String loc = scanner.nextLine();

        Item item = new Item(name, desc, loc, getName() );
        Tugas.reportedItems.add(item);
        System.out.println("Barang berhasil dilaporkan!");
    }

    public void viewReportedItems() {
        boolean found = false;
        System.out.println("Daftar Barang Dilaporkan: ");
        for (Item item : Tugas.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                System.out.println("- " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation());
                found = true;
            }
        }
        if (!found) System.out.println("Belum ada laporan barang.");
    }
}
