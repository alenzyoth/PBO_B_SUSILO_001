package com.praktikum.users;

import com.praktikum.Data.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {
    private String username;
    private String password;

    public Admin(String name, String id, String username, String password) {
        super(name, id);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin: " + name);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu Admin: ");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("3. Tambah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer

                switch (choice) {
                    case 1:
                        lihatSemuaLaporan();
                        break;
                    case 2:
                        tandaiBarangClaimed(scanner);
                        break;
                    case 3:
                        tambahMahasiswa(scanner);
                        break;
                    case 4:
                        hapusMahasiswa(scanner);
                        break;
                    case 0:
                        System.out.println("Logout...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                choice = -1; // Menandai input tidak valid agar loop tetap berjalan
            }
        } while (choice != 0);
    }


    private void lihatSemuaLaporan() {
        System.out.println("Semua Laporan Barang: ");
        if (Tugas.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }

        int index = 0;
        for (Item item : Tugas.reportedItems) {
            System.out.printf("%d. %s - %s - %s [%s]%n", index++, item.getItemName(), item.getDescription(), item.getLocation(), item.getStatus());
        }
    }

    private void tandaiBarangClaimed(Scanner scanner) {
        lihatSemuaLaporan();
        System.out.print("Masukkan indeks barang yang ingin ditandai: ");
        try {
            int idx = scanner.nextInt();
            scanner.nextLine();

            Item item = Tugas.reportedItems.get(idx);
            if (!"Claimed".equals(item.getStatus())) {
                item.setStatus("Claimed");
                System.out.println("Status barang diubah menjadi 'Claimed'.");
            } else {
                System.out.println("Barang sudah ditandai sebagai 'Claimed'.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid!");
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    private void tambahMahasiswa(Scanner scanner) {
        System.out.print("Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        Tugas.userList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void hapusMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();

        boolean removed = Tugas.userList.removeIf(user -> user instanceof Mahasiswa && user.id.equals(nim));
        if (removed) {
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}
