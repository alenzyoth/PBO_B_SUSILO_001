//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
            // Membuat dua objek akun
           RekeningBank akun1 = new RekeningBank("202310370311129", "Adi", 500000);
            RekeningBank akun2 = new RekeningBank("202310370311307", "Ana", 1000000);

            // Menampilkan informasi awal kedua rekening
            akun1.tampilkanInformasi();
            akun2.tampilkanInformasi();

            // Penyetroran uang
            akun1.setor(200000); // Adi setor
            akun2.setor(500000); // Ana setor

            // Penarikan uang
            akun1.tarik(800000); // Adi tarik
            akun2.tarik(300000); // Ana tarik

            // Menampilkan informasi rekening setelah transaksi
            akun1.tampilkanInformasi();
            akun2.tampilkanInformasi();
        }
    }
