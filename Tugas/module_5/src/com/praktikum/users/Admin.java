package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void manageItems(ArrayList<Item> reportedItems, Scanner scanner) {
        System.out.println("\n1. Lihat Semua Laporan");
        System.out.println("2. Tandai Barang Telah Diambil");
        System.out.print("Pilih: ");

        try {
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                if (reportedItems.isEmpty()) {
                    System.out.println("Tidak ada laporan barang.");
                } else {
                    for (int i = 0; i < reportedItems.size(); i++) {
                        Item item = reportedItems.get(i);
                        System.out.println(i + ". " + item.getItemName() + " - " + item.getDescription() + " - " +
                                item.getLocation() + " - Status: " + item.getStatus());
                    }
                }
            } else if (pilihan == 2) {
                System.out.println("Barang yang dilaporkan:");
                for (int i = 0; i < reportedItems.size(); i++) {
                    if (reportedItems.get(i).getStatus().equals("Reported")) {
                        System.out.println(i + ". " + reportedItems.get(i).getItemName());
                    }
                }

                System.out.print("Masukkan indeks barang yang ingin ditandai: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                try {
                    Item item = reportedItems.get(index);
                    item.setStatus("Claimed");
                    System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Indeks tidak valid!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    @Override
    public void manageUsers(ArrayList<User> userList, Scanner scanner) {
        System.out.println("\n1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih: ");

        try {
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Nama Mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("NIM Mahasiswa: ");
                String nim = scanner.nextLine();
                userList.add(new Mahasiswa(nama, nim));
                System.out.println("Mahasiswa berhasil ditambahkan.");
            } else if (pilihan == 2) {
                System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                String nim = scanner.nextLine();
                boolean found = false;

                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i) instanceof Mahasiswa) {
                        Mahasiswa mhs = (Mahasiswa) userList.get(i);
                        if (mhs.getNim().equals(nim)) {
                            userList.remove(i);
                            System.out.println("Mahasiswa berhasil dihapus.");
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }
}