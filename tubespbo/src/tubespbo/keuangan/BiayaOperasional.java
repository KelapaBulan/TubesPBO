/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.keuangan;

import tubespbo.tempatparkir;

/**
 *
 * @author asus
 */
public class BiayaOperasional {
    public double gaji;
    public final double perawatan;

    public BiayaOperasional() {
        this.perawatan = 100000;
    }
    
    public double gajiKaryawan(){
        gaji = tempatparkir.entitycount * 1000;
        return gaji;
    }
    
    public double hitungBiayaOper(){
        tempatparkir.pendapatan = tempatparkir.pendapatan - (gajiKaryawan() + perawatan);
        return tempatparkir.pendapatan;
    }
    
    public void displayBiaya(){
        System.out.println("Dengan biaya gaji karyawan sebesar : " + gajiKaryawan() + " dan biaya perawatan sebesar " + perawatan + 
                 " maka pendapatan bersih manjadi : " + hitungBiayaOper());
    }
}
