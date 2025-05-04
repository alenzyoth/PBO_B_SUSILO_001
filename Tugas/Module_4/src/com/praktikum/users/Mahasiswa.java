//class Mahasiswa
package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;

//Kelas Mahasiswa mewarisi User dan mengimplementasikan MahasiswaActions.
public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String username) {
        super(username);
    }

    // Implementasi method login
    @Override
    public void login() {
        System.out.println("Mahasiswa " + username + " login berhasil.");
    }

    // Menampilkan menu khusus untuk Mahasiswa
    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    // Mahasiswa membuat laporan barang
    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();
        System.out.println("\n>> Laporan berhasil dikirim!");
        System.out.println("Nama: " + nama);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    // Melihat daftar laporan (fitur belum tersedia)
    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}