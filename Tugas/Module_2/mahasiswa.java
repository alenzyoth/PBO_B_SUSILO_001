
// Kelas Mahasiswa
class Mahasiswa {
    private final String nama = "Susilo Adi";
    private final String nim = "202410370110001";

    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(nama) && inputNim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}
