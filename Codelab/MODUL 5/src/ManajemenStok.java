import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    private ArrayList<Barang> daftarBarang;

    public ManajemenStok() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Scanner scanner) {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok awal: ");
        int stok = scanner.nextInt();
        scanner.nextLine(); // clear the buffer
        Barang barang = new Barang(nama, stok);
        daftarBarang.add(barang);
        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
    }

    public void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }
        System.out.println("--- Daftar Barang ---");
        for (Barang barang : daftarBarang) {
            System.out.println("Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
        }
        System.out.println("---------------------");
    }

    public void kurangiStok(Scanner scanner) {
        System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
        }
        System.out.print("Masukkan nomor indeks barang: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // clear the buffer

        if (index < 0 || index >= daftarBarang.size()) {
            System.out.println("Index tidak valid.");
            return;
        }

        Barang barang = daftarBarang.get(index);
        System.out.print("Masukkan jumlah stok yang akan diambil: ");
        int jumlahDiambil = scanner.nextInt();
        scanner.nextLine(); // clear the buffer

        try {
            if (jumlahDiambil > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
            }
            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Pengurangan stok berhasil. Sisa stok: " + barang.getStok());
        } catch (StokTidakCukupException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajemenStok manajemenStok = new ManajemenStok();
        int pilihan;

        do {
            System.out.println("====== Menu Manajemen Stok ======");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (pilihan) {
                case 1:
                    manajemenStok.tambahBarang(scanner);
                    break;
                case 2:
                    manajemenStok.tampilkanSemuaBarang();
                    break;
                case 3:
                    manajemenStok.kurangiStok(scanner);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
