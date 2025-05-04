import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main (String[] args) {
            Scanner scr = new Scanner(System.in);
            String AdminName_Real = "Loka";
            String AdminPass_Real = "Loka2005";
            String StudentName_Real = "Loka";
            String StudentPass_Real = "2005";

            System.out.println("Pilih Login\n1. Admin\n2. Mahasiswa");
            System.out.print("Masukan Pilihan : ");
            int pilihan = scr.nextInt();
            scr.nextLine();
            if (pilihan == 1) {
                System.out.print(" Masukan Username : ");
                String AdminName = scr.nextLine();
                System.out.print(" Masukan Password : ");
                String AdminPass = scr.nextLine();
                if (AdminName.equals(AdminName_Real) && AdminPass.equals(AdminPass_Real)) {
                    System.out.println("Login Admin Berhasil!");
                }else System.out.println("Login Gagal. Username Atau Password Salah!");

            } else if (pilihan == 2) {
                System.out.print(" Masukan Username : ");
                String StudentName = scr.nextLine();
                System.out.print(" Masukan NIM : ");
                String StudentPass = scr.nextLine();
                if (StudentName.equals(StudentName_Real) && StudentPass.equals(StudentPass_Real)) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    System.out.println("Nama : " + StudentName);
                    System.out.println("NIM : " + StudentPass);
                }else System.out.println("Login Gagal. Username Atau NIM Salah!");

            }else System.out.println("Pilihan Tidak Valid!");
        }
}