package com.praktikum.data;

public class Item {
    private String nama;
    private String lokasi;
    private String status;
    private String pelapor;

    public Item(String nama, String lokasi, String pelapor) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.status = "Reported";
        this.pelapor = pelapor;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getStatus() {
        return status;
    }

    public String getPelapor() {
        return pelapor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
