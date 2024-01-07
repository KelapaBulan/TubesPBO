/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.test1;

import javax.swing.JOptionPane;
import tubespbo.keuangan.biayaperjam;
import tubespbo.tempatparkir;

/**
 *
 * @author asus
 */
public class motor extends tempatparkir implements biayaperjam{
     private int biaya = 2000; 

    public motor(String jenis, int jamparkir) {
        super(jenis, jamparkir);
    }
    
     @Override
    public double hitungHarga(){
        double biayaparkir = 0;
        if (capacityControl() == false){
            System.out.println("parkir penuh");
        }else {
        
        if (null != getJenis())switch (getJenis()) {
            case "Motor":
                biayaparkir = (jamparkir * biaya);
                break;
            case "Motor Gede":
                biayaparkir = (jamparkir * biaya) + 2000;
                break;
            case "Sepeda":
                biayaparkir = (jamparkir * biaya) - 2000;
                break;
        }
        }
        return biayaparkir;
    }
    
    @Override
    public int hitungUkuran(){
        if (null == getJenis()){
            return ukuran = getUkuran() + 2;
        } else switch (getJenis()) {
             case "Motor Gede":
                 return ukuran = getUkuran() + 4;
             case "Sepeda":
                 return ukuran = getUkuran() + 1;
             default:
                 return ukuran = getUkuran() + 2;
         }
    }
    
    @Override
    public double untungBersih(){
        pendapatan = getPendapatan() + (hitungHarga() - (hitungHarga() * (EMPLOYEE_RATE)));
        return pendapatan;
    }
    
    public void cekKapasitas(){
        if (ukuran <= getKapasitas()){
            JOptionPane.showMessageDialog(null,"parkir tersedia dengan ukuran = " + hitungUkuran() + " current capacity = " + (getKapasitas() - ukuran));
            //System.out.println("parkir tersedia dengan ukuran = " + hitungUkuran() + " current capacity = " + (getKapasitas() - ukuran));
        } else {
            JOptionPane.showMessageDialog(null,"parkir penuh");
        }
    }
     public void displayBiaya(){
        JOptionPane.showMessageDialog(null,"Motor dengan jenis " + getJenis() + " parkir selama " + jamparkir + " jam dengan biaya " + hitungHarga());
        //System.out.println("Motor dengan jenis " + getJenis() + " parkir selama " + jamparkir + " jam dengan biaya " + hitungHarga());
        entitycount = getEntitycount() + 1;
        untungBersih();
    }
     
    public int kurangKapasitas(){
        if (null == getJenis()){
            return ukuran = getUkuran() - 2;
        } else switch (getJenis()) {
             case "Motor Gede":
                 return ukuran = getUkuran() - 4;
             case "Sepeda":
                 return ukuran = getUkuran() - 1;
             default:
                 return ukuran = getUkuran() - 2;
         }
    }
}
