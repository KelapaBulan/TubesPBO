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
public class mobil extends tempatparkir implements biayaperjam{
    private int biaya = 5000;

    public mobil(String jenis, int jamparkir) {
        super(jenis, jamparkir);
    }
    
    
    @Override
    public double hitungHarga(){
        double biayaparkir = 0;
        if (capacityControl() == false){
            System.out.println("parkir penuh");
        }else {
        
        if (null != getJenis())switch (getJenis()) {
            case "City Car":
                biayaparkir = (jamparkir * biaya);
                break;
            case "SUV":
                biayaparkir = (jamparkir * biaya) + 2000;
                break;
            case "Limousine":
                biayaparkir = (jamparkir * (biaya + 30000));
                break;
            case "Mobil Sport":
                biayaparkir = (jamparkir * (biaya + 20000));
                break;
            case "Truk":
                biayaparkir = (jamparkir * (biaya + 10000));
                 break;
            default:
                biayaparkir = (jamparkir * biaya);
                break;
        }
        }
        return biayaparkir;
    }
    
    @Override
    public int hitungUkuran(){
        if (null == getJenis()){
            ukuran = getUkuran() + 4;
        } else switch (getJenis()) {
            case "Limousine":
                ukuran = getUkuran() + 8;
                break;
            case "Truk":
                ukuran = getUkuran() + 16;
                break;
            default:
                ukuran = getUkuran() + 4;
                break;
        }
        return ukuran;
    }
    
    @Override
    public double untungBersih(){
        pendapatan = getPendapatan() + (hitungHarga() - (hitungHarga() * (EMPLOYEE_RATE)));
        return pendapatan;
    }
    
    public void displayBiaya(){
        JOptionPane.showMessageDialog(null,"Mobil dengan jenis " + getJenis() + " parkir selama " + jamparkir + " jam dengan biaya " + hitungHarga());
        //System.out.println("Mobil dengan jenis " + getJenis() + " parkir selama " + jamparkir + " jam dengan biaya " + hitungHarga());
        untungBersih();
        entitycount = getEntitycount() + 1;
    }
    
    public void cekKapasitas(){
        if (ukuran <= getKapasitas()){
            JOptionPane.showMessageDialog(null,"parkir tersedia dengan ukuran = " + hitungUkuran() + " current capacity = " + (getKapasitas() - ukuran));
            //System.out.println("parkir tersedia dengan ukuran = " + hitungUkuran() + " current capacity = " + (getKapasitas() - ukuran));
        } else {
            JOptionPane.showMessageDialog(null,"parkir penuh");
        }
    }
    
    public int kurangKapasitas(){
        if (null == getJenis()){
            ukuran = getUkuran() - 4;
        } else switch (getJenis()) {
            case "Limousine":
                ukuran = getUkuran() - 8;
                break;
            case "Truk":
                ukuran = getUkuran() - 16;
                break;
            default:
                ukuran = getUkuran() - 4;
                break;
        }
        return ukuran;
    }
    
    
}
