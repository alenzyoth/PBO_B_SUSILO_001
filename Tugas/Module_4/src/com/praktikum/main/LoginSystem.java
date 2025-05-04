//Class Main LoginsySystem
package com.praktikum.main;

import java.util.Scanner;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

//Kelas utama untuk menjalankan sistem login berbasis role.
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;

        System.out.println("==== Sistem Login ====");
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan role (admin/mahasiswa): ");
        String role = scanner.nextLine();

        // Membuat objek berdasarkan role
        if (role.equalsIgnoreCase("admin")) {
            user = new Admin(username);
        } else if (role.equalsIgnoreCase("mahasiswa")) {
            user = new Mahasiswa(username);
        } else {
            System.out.println("Role tidak dikenali.");
            return;
        }

        user.login();
        user.displayAppMenu(); // Polymorphism digunakan di sini
    }
}