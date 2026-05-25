/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import abstractclass.Manusia;

public class Dokter extends Manusia {

    private int idDokter;
    private String spesialis;
    private String noHp;

    public Dokter() {
        super("");
    }

    public Dokter(String nama, int idDokter, String spesialis, String noHp) {

        super(nama);

        this.idDokter = idDokter;
        this.spesialis = spesialis;
        this.noHp = noHp;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public void tampilInfo() {

        System.out.println("Nama Dokter : " + nama);
    }
}
