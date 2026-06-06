/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Jadwal {
    private int idJadwal;
    private int idDokter;
    private String tanggal;
    private String jam;
    private String status;      // Menunggu, Selesai, Dibatalkan
    private int idHewan;        // Foreign key ke tabel hewan
    private String keluhan;     // Keluhan pemilik
    private String createdAt;   // Tanggal pembuatan jadwal

    public Jadwal() {
        // Set default status
        this.status = "Menunggu";
    }

    public Jadwal(int idJadwal, int idDokter, String tanggal, String jam, String status, int idHewan, String keluhan, String createdAt) {
        this.idJadwal = idJadwal;
        this.idDokter = idDokter;
        this.tanggal = tanggal;
        this.jam = jam;
        this.status = status;
        this.idHewan = idHewan;
        this.keluhan = keluhan;
        this.createdAt = createdAt;
    }

    // Getter dan Setter
    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(int idHewan) {
        this.idHewan = idHewan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
