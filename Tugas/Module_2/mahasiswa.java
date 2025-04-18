class mahasiswa {
        private static final String nama = "   Alldisa";
        private static final String nim = "202410370110005";

        public static boolean login(String inputNama, String inputNim) {
            return inputNama.equals(nama) && inputNim.equals(nim);
        }

        public static void displayInfo() {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + nama);
            System.out.println("NIM : " + nim);
        }
}
