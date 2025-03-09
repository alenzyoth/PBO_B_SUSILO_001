import java.time.LocalDate;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
            // Membuat Scanner untuk membaca input dari pengguna
            Scanner scanner = new Scanner(System.in);

            // Meminta input nama
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();

            // Meminta input jenis kelamin
            System.out.print("Masukkan jenis kelamin (P/L): ");
            char jenisKelamin = scanner.next().charAt(0);

            // Meminta input tahun lahir
            System.out.print("Masukkan tahun lahir: ");
            int tahunLahir = scanner.nextInt();

            // Menutup Scanner setelah selesai digunakan
            scanner.close();

            // Mendapatkan tahun saat ini
            int tahunSekarang = LocalDate.now().getYear();

            // Menghitung umur
            int umur = tahunSekarang - tahunLahir;

            // Menentukan jenis kelamin
            String jenisKelaminStr;
            if (jenisKelamin == 'L' || jenisKelamin == 'l') {
                jenisKelaminStr = "Laki-laki";
            } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
                jenisKelaminStr = "Perempuan";
            } else {
                jenisKelaminStr = "Tidak diketahui";
            }

            // Menampilkan hasil
            System.out.println("\nData Diri:");
            System.out.println("Nama           : " + nama);
            System.out.println("Jenis Kelamin  : " + jenisKelaminStr);
            System.out.println("Umur           : " + umur + " tahun");
        }
}