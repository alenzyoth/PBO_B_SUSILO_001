package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // nama jadi username, nim jadi password
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public void reportItem(ArrayList<Item> reportedItems, Scanner scanner) {
        System.out.print("Nama Barang: ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String desc = scanner.nextLine();
        System.out.print("Lokasi: ");
        String location = scanner.nextLine();

        Item item = new Item(name, desc, location);
        reportedItems.add(item);
        System.out.println("Barang berhasil dilaporkan.");
    }

    @Override
    public void viewReportedItems(ArrayList<Item> reportedItems) {
        if (reportedItems.isEmpty()) {
            System.out.println("Belum ada Laporan barang.");
            return;
        }

        boolean found = false;
        for (Item item : reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(item.getItemName() + " - " + item.getDescription() + " - " + item.getLocation());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada item dengan status Reported.");
        }
    }
}