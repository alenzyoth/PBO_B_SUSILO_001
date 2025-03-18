// Kelas Main (Kelas Utama)//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
            // Membuat objek
            Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
            Musuh musuh = new Musuh("Viper", 200);

            // Menampilkan status awal kesehatan
            System.out.println("Status Awal Kesehatan:");
            System.out.println(pahlawan.getNama() + " Kesehatan: " + pahlawan.getKesehatan());
            System.out.println(musuh.getNama() + " Kesehatan: " + musuh.getKesehatan());

            // Simulasi pertarungan
            System.out.println("\nPertarungan Dimulai!");
            pahlawan.serang(musuh); // Brimstone menyerang Viper
            musuh.serang(pahlawan);  // Viper menyerang Brimstone
        }
}