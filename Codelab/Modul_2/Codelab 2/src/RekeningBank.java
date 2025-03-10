public class  RekeningBank {
    private String noRekening;
    private String namaPemilik;
    private double saldo;

    // Constructor
    public RekeningBank(String noRekening, String namaPemilik, double saldo) {
        this.noRekening = noRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Method untuk menyetor uang
    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.printf("%s menyetor Rp%.2f. Saldo sekarang: Rp%.2f%n",
                namaPemilik, jumlah, saldo);
    }

    // Method untuk menarik uang
    public void tarik(double jumlah) {
        if (jumlah > saldo) {
            System.out.printf("%s menarik Rp%.2f. (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp%.2f%n",
                    namaPemilik, jumlah, saldo);
        } else {
            saldo -= jumlah;
            System.out.printf("%s menarik Rp%.2f. (Berhasil) Saldo sekarang: Rp%.2f%n",
                    namaPemilik, jumlah, saldo);
        }
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInformasi() {
        System.out.printf("Nomor Rekening: %s%n", noRekening);
        System.out.printf("Nama Pemilik: %s%n", namaPemilik);
        System.out.printf("Saldo: Rp%.2f%n", saldo);
    }
}


