package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        // Membuat objek buku
        Buku nonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku fiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        // Menampilkan info buku
        nonFiksi.displayInfo();
        fiksi.displayInfo();
        System.out.println();

        // Membuat objek anggota
        Anggota wahyu = new Anggota("Wahyu Andika", "B075");
        Anggota ega = new Anggota("Ega Faiz", "A047");

        // Menampilkan info anggota
        wahyu.displayInfo();
        ega.displayInfo();
        System.out.println();

        // Peminjaman
        wahyu.pinjamBuku("Madilog");
        ega.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);
        System.out.println();

        // Pengembalian
        wahyu.kembalikanBuku("Madilog");
        ega.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}