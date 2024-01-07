/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author asus
 */
public class tabel_parkir extends AbstractTableModel{
List <kendaraan> knd;

    public tabel_parkir(List<kendaraan> knd) {
        this.knd = knd;
    }

    @Override
    public int getRowCount() {
        return knd.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return knd.get(row).getNo();
            case 1:
                return knd.get(row).getJenis();
            case 2:
                return knd.get(row).getTipe();
            case 3:
                return knd.get(row).getJam();
            default:
                return null;
        } 
    }
    
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "no";//sesuaikan dengan atribut di table database
            case 1:
                return "jenis";//sesuaikan dengan atribut di table database
            case 2:
                return "tipe";//sesuaikan dengan atribut di table database
            case 3:
                return "jam";//sesuaikan dengan atribut di table database
            default:
                return null;
        }
        
        
        }
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    

