import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            admin admin = new admin();
            mahasiswa mahasiswa = new mahasiswa();

            System.out.println("===== SISTEM LOGIN =====");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Masukkan pilihan (1/2): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            if (pilihan == 1) {
                // Login Admin
                System.out.print("Masukkan username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String inputPassword = scanner.nextLine();

                if (admin.login(inputUsername, inputPassword)) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }

            } else if (pilihan == 2) {
                // Login Mahasiswa
                System.out.print("Masukkan Nama: ");
                String inputNama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = scanner.nextLine();

                if (mahasiswa.login(inputNama, inputNim)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }

            } else {
                System.out.println("Pilihan tidak valid.");
            }

            scanner.close();
        }
}
