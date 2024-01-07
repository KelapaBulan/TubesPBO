/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import tubespbo.keuangan.Keuangan;
import tubespbo.keuangan.BiayaOperasional;
import tubespbo.test1.motor;
import tubespbo.test1.mobil;

/**
 *
 * @author asus
 */
public class Tubespbo {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mobil obj1 = new mobil("City Car",2);
        obj1.displayBiaya();
        obj1.cekKapasitas();
        mobil obj2 = new mobil("Limousine",5);
        obj2.displayBiaya();
        obj2.cekKapasitas();
        motor obj3 = new motor("Motor",200);
        obj3.displayBiaya();
        obj3.cekKapasitas();
        motor obj6 = new motor("Sepeda",8);
        obj6.displayBiaya();
        obj6.cekKapasitas();
        mobil obj7 = new mobil("Truk",8);
        obj7.displayBiaya();
        obj7.cekKapasitas();
        mobil obj8 = new mobil("Mobil Sport",4);
        obj8.displayBiaya();
        obj8.cekKapasitas();
        motor obj9 = new motor("Motor Gede",8);
        obj9.displayBiaya();
        obj9.cekKapasitas();
        Keuangan obj4 = new Keuangan();
        obj4.displayProfit();
        BiayaOperasional obj5 = new BiayaOperasional();
        obj5.displayBiaya();
    }
    
}
