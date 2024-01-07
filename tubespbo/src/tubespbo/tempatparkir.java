/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author asus
 */
public abstract class tempatparkir {
    private String jenis;
    private int kapasitas = 100;

    /**
     *
     */
    public static int ukuran;
    protected int jamparkir;
    private int biaya;
    public static double pendapatan;
    public static int entitycount;

    public tempatparkir(String jenis,int jamparkir) {
        this.jamparkir = jamparkir;
        this.jenis = jenis;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getJenis() {
        return jenis;
    }

    public static int getUkuran() {
        return ukuran;
    }

    public static double getPendapatan() {
        return pendapatan;
    }

    public static int getEntitycount() {
        return entitycount;
    }
    
    
    
    public abstract double hitungHarga();
    
    public abstract int hitungUkuran();
    
    public abstract double untungBersih();
    
    public boolean capacityControl(){
        return ukuran <= kapasitas;
    }
    
    public void cekKapasitas(){
        if (ukuran <= kapasitas){
            System.out.println("parkir tersedia dengan ukuran = " + (kapasitas - ukuran));
        } else {
            System.out.println("parkir penuh");
        }
    }
    
    public abstract void displayBiaya();
    
}
