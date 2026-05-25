/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RekamMedisDAO;
import model.RekamMedis;
import view.RekamMedisView;

public class RekamMedisController {

    RekamMedisView view;
    RekamMedisDAO dao;

    public int idRekam;

    public RekamMedisController(RekamMedisView view) {
        this.view = view;
        dao = new RekamMedisDAO();
    }

    public void loadHewanToCombo() {
        view.cbHewan.removeAllItems(); 
        String[] daftarHewan = dao.getAllHewan(); 
        for (String hewan : daftarHewan) {
            view.cbHewan.addItem(hewan);
        }
    }

    public void simpanData() {
        RekamMedis rm = new RekamMedis();
        rm.setNamaHewan(view.cbHewan.getSelectedItem().toString());
        rm.setDiagnosa(view.txtDiagnosa.getText());
        rm.setTindakan(view.txtTindakan.getText());
        rm.setObat(view.txtObat.getText());
        dao.insert(rm);
        tampilData();
        resetForm();
    }

    public void editData() {
        RekamMedis rm = new RekamMedis();
        rm.setIdRekam(idRekam);
        rm.setNamaHewan(view.cbHewan.getSelectedItem().toString());
        rm.setDiagnosa(view.txtDiagnosa.getText());
        rm.setTindakan(view.txtTindakan.getText());
        rm.setObat(view.txtObat.getText());
        dao.update(rm);
        tampilData();
        resetForm();
    }

    public void hapusData() {
        dao.delete(idRekam);
        tampilData();
        resetForm();
    }

    public void tampilData() {
        view.tableRekam.setModel(dao.getData());
    }

    public void resetForm() {
        view.txtDiagnosa.setText("");
        view.txtTindakan.setText("");
        view.txtObat.setText("");
        if (view.cbHewan.getItemCount() > 0) {
            view.cbHewan.setSelectedIndex(0);
        }
    }
}