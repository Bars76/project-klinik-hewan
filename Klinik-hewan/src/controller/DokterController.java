/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DokterDAO;
import model.Dokter;
import view.DokterView;

public class DokterController {

    DokterView view;
    DokterDAO dao;

    public int idDokter;

    public DokterController(DokterView view) {

        this.view = view;
        dao = new DokterDAO();
    }

    public void simpanData() {

        try {

            Dokter d = new Dokter();

            d.setNama(view.txtNama.getText());
            d.setSpesialis(view.txtSpesialis.getText());
            d.setNoHp(view.txtNoHp.getText());

            dao.insert(d);

            tampilData();
            resetForm();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void editData() {

        Dokter d = new Dokter();

        d.setIdDokter(idDokter);
        d.setNama(view.txtNama.getText());
        d.setSpesialis(view.txtSpesialis.getText());
        d.setNoHp(view.txtNoHp.getText());

        dao.update(d);

        tampilData();
        resetForm();
    }

    public void hapusData() {

        dao.delete(idDokter);

        tampilData();
        resetForm();
    }

    public void tampilData() {

        view.tableDokter.setModel(dao.getData());
    }

    public void resetForm() {

        view.txtNama.setText("");
        view.txtSpesialis.setText("");
        view.txtNoHp.setText("");
    }
}
