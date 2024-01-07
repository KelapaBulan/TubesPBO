/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOKendaraan;
import DAO.Implementasi;
import Koneksi.koneksi_db;
import Model.kendaraan;
import Model.tabel_parkir;
import tubespbo.View.Tampilan;
import java.util.*;
import javax.swing.JOptionPane;
import tubespbo.test1.mobil;
import tubespbo.test1.motor;

/**
 *
 * @author asus
 */
public class ControllerTP {
    
    tubespbo.View.Tampilan frame;
    Implementasi impl;
    List<kendaraan> knd;
    
    public ControllerTP(tubespbo.View.Tampilan frame) {
        this.frame = frame;
        //this.implBarang = implBarang;
        impl = new DAOKendaraan();
        // this.lmb = lmb;
        knd = impl.getAll();
    }
    
    public void reset() {
        frame.getTfjenis().setText("");
        frame.getTftipe().setText("");
        frame.getTfjam().setText("");
    }
    
    public void isiTabel() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        knd = impl.getAll();

        //data dimasukkan ke tabel barang
        tabel_parkir tavel = new tabel_parkir(knd);
        frame.getjTable1().setModel(tavel);
    }

    public void isitextfield(int row) {
        frame.getTfno().setText(String.valueOf(knd.get(row).getNo()));
        frame.getTfjenis().setText(knd.get(row).getJenis());
        frame.getTftipe().setText(String.valueOf(knd.get(row).getTipe()));
        frame.getTfjam().setText(String.valueOf(knd.get(row).getJam()));
        
        
    }
    
    public void inserttabel() {
        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
        //bagian awal dan akhir sehingga fungsi ini 
        //sangat cocok untuk diterapkan pada proses input data-data
        if (!frame.getTfjenis().getText().trim().isEmpty() & !frame.getTfjenis().getText().trim().isEmpty()) {
            kendaraan mb = new kendaraan();
            mb.setJenis(frame.getTfjenis().getText());
            mb.setTipe(frame.getTftipe().getText());
            //knp dia double karena struktur data di table atribut Harga adalah double
            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double

            mb.setJam(Integer.valueOf(frame.getTfjam().getText()));
            //knp dia Interger karena struktur data di table Stok adalah Integer
            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer

            impl.insert(mb);
            
            if ("mobil".equals(frame.getTfjenis().getText())){
                mobil mobil = new mobil(frame.getTftipe().getText(), Integer.valueOf(frame.getTfjam().getText()));
                mobil.displayBiaya();
                mobil.cekKapasitas();
                //JOptionPane.showMessageDialog(null, "data disimpan");
            } else {
                motor motor = new motor(frame.getTftipe().getText(), Integer.valueOf(frame.getTfjam().getText()));
                motor.displayBiaya();
                motor.cekKapasitas();
            }

        } else {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");

        }
      
    }
    
    public void Delete() {
        if (!frame.getTfno().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka

            int no = Integer.parseInt(frame.getTfno().getText());
            if ("mobil".equals(frame.getTfjenis().getText())){
                mobil mobil = new mobil(frame.getTftipe().getText(), Integer.valueOf(frame.getTfjam().getText()));
                mobil.kurangKapasitas();
                //JOptionPane.showMessageDialog(null, "data disimpan");
            } else {
                motor motor = new motor(frame.getTftipe().getText(), Integer.valueOf(frame.getTfjam().getText()));
                motor.kurangKapasitas();
            }
            //ambil data dari frame textfield simpan ke var no
            impl.delete(no);

            JOptionPane.showMessageDialog(null, "data terdelete");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal didelete");

        }

    }
}
