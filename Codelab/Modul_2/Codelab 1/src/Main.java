//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Membuat objek hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyaw~~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Menampilkan informasi dari kedua objek
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}