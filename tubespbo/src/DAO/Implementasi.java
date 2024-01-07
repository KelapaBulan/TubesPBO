/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Model.kendaraan;

/**
 *
 * @author asus
 */
public interface Implementasi {
     public void insert(kendaraan mb);

    public void delete(int no);
    public void update(kendaraan mb);

    public List<kendaraan> getAll();//dapatkan semua data

    public List<kendaraan> getCarinama(String nama);//mendapatkan data nama
    
}
