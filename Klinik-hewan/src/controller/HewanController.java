/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.HewanDAO;
import model.Hewan;
import view.HewanView;

public class HewanController {

    HewanView view;
    HewanDAO dao;

    public int idHewan;

    public HewanController(HewanView view) {

        this.view = view;
        dao = new HewanDAO();
    }

public void simpanData() {

    try {

        if (view.txtNama.getText().isEmpty()
                || view.txtJenis.getText().isEmpty()
                || view.txtUmur.getText().isEmpty()
                || view.txtPemilik.getText().isEmpty()) {

            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Semua field harus diisi!"
            );

            return;
        }

        Hewan h = new Hewan();

        h.setNamaHewan(view.txtNama.getText());
        h.setJenis(view.txtJenis.getText());
        h.setUmur(Integer.parseInt(view.txtUmur.getText()));
        h.setPemilik(view.txtPemilik.getText());

        dao.insert(h);

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Data berhasil ditambah"
        );

        tampilData();
        resetForm();

    } catch (NumberFormatException e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Umur harus angka!"
        );

    } catch (Exception e) {

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error : " + e.getMessage()
        );
    }
}

    public void editData() {

        Hewan h = new Hewan();

        h.setIdHewan(idHewan);
        h.setNamaHewan(view.txtNama.getText());
        h.setJenis(view.txtJenis.getText());
        h.setUmur(Integer.parseInt(view.txtUmur.getText()));
        h.setPemilik(view.txtPemilik.getText());

        dao.update(h);

        tampilData();
        resetForm();
    }

 
    public void hapusData() {

        dao.delete(idHewan);

        tampilData();
        resetForm();
    }


    public void tampilData() {

        view.tableHewan.setModel(dao.getData());
    }


    public void resetForm() {

        view.txtNama.setText("");
        view.txtJenis.setText("");
        view.txtUmur.setText("");
        view.txtPemilik.setText("");
    }
}