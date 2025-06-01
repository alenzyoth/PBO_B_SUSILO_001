package com.praktikum.users;

import com.praktikum.data.Item;
import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends User {
    private String nim;
    private List<Item> laporanSaya;

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
        this.laporanSaya = new ArrayList<>();
    }

    public String getNim() {
        return nim;
    }

    public List<Item> getLaporanSaya() {
        return laporanSaya;
    }

    public void tambahLaporan(Item item) {
        laporanSaya.add(item);
    }
}
