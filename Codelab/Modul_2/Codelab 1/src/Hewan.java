public class Hewan { // Kelas Hewan
        private String nama;
        private String jenis;
        private String suara;

        // Constructor
        public Hewan(String nama, String jenis, String suara) {
            this.nama = nama;
            this.jenis = jenis;
            this.suara = suara;
        }

        // Metode untuk mencetak informasi hewan
        public void tampilkanInfo() {
            System.out.println("Nama: " + nama);
            System.out.println("Jenis: " + jenis);
            System.out.println("Suara: " + suara);
            System.out.println(); // Tambahkan baris kosong untuk pemisah
        }
    }