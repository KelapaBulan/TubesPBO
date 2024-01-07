/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Koneksi.koneksi_db;
import Model.kendaraan;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
/*
Prepared statements adalah sebuah fitur yang disediakan MySQL
(dan juga beberapa aplikasi database lainnya), 
dimana kita bisa mengirim query (perintah) 
secara terpisah antara query inti dengan “data” dari query. 
Tujuannya, 
agar query menjadi lebih aman dan cepat 
(jika perintah yang sama akan digunakan beberapa kali).

 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author S510
 */
public class DAOKendaraan implements Implementasi{
    Connection connection;
    final String insert = "INSERT INTO tempatparkir(jenis,tipe,jam)VALUES(?,?,?)";
    final String delete = "DELETE FROM tempatparkir WHERE no=?";
    final String update = "UPDATE tempatparkir Set jenis=?,tipe=?,jam=? WHERE no=?";
    final String select = "SELECT *FROM tempatparkir";
    final String carinama = "SELECT *FROM tempatparkir WHERE jenis like ?";
    
    //harus disambungkan ke koneksi_db atau koneksikan ke database
    //kita harus bikin konstruktor untuk koneksi ini
    public DAOKendaraan() {
    // this.connection = connection;
        connection=koneksi_db.connection();
    }
    
    @Override
    public void insert(kendaraan mb) {
        PreparedStatement statement = null;
      
        try {
                 //memasukkan perintah yng ada tanda tanya
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getJenis());
            statement.setString(2, mb.getTipe());
            statement.setInt(3, mb.getJam());
            statement.executeUpdate();
            //ResultSet rs = statement.executeUpdate();
            //while (rs.next()) {
               // mb.setNo(rs.getInt(1));
           // }
        } catch (SQLException ex) {
           ex.printStackTrace();
           // System.out.println("test"+ex);
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }

    @Override
    public void delete(int no) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, no);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();

            }

        }
    }

    @Override
    public void update(kendaraan mb) {
        //final String update = "UPDATE table barang Set nama=?,harga=?,stok=? WHERE no=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);//update datanya dari form
            statement.setString(1, mb.getJenis());
            statement.setString(2, mb.getTipe());
            statement.setInt(3, mb.getJam());
            statement.setInt(4, mb.getNo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<kendaraan> getAll() {
        //memasukkan data ke dalam array list
        List<kendaraan>knd=null;
        
       
        try {
             knd=new ArrayList<kendaraan>();
             Statement st = connection.createStatement();
             ResultSet rs=st.executeQuery(select);
             while(rs.next()){
                 /*
                 mengambil data dari table di database
                 */
                 //=======================================================
                 //mod_barang dalah tempat penyimpanan data sementara
                 //simpan data ke model
                 kendaraan mb=new kendaraan();
                 mb.setNo(rs.getInt("no"));
                 mb.setJenis(rs.getString("jenis"));
                 mb.setTipe(rs.getString("Tipe"));
                 mb.setJam(rs.getInt("jam"));
                 //setelah di getall data tersebut harus
                //ditampilkan ke dlm list
                 knd.add(mb);
                 
             
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return knd;
                
    }

    @Override
    public List<kendaraan> getCarinama(String nama) {
        List<kendaraan>lmb=null;
        try {
            lmb=new ArrayList<kendaraan>();
            PreparedStatement st=connection.prepareStatement(carinama);
            st.setString(1,"%"+ nama+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {    
                kendaraan mb=new kendaraan();
                mb.setNo(rs.getInt("no"));
                mb.setJenis(rs.getString("nama"));
                mb.setTipe(rs.getString("harga"));
                mb.setJam(rs.getInt("stok"));  
                //setelah dicari data tersebut harus
                //ditampilkan ke dlm list
                lmb.add(mb);
                
            }  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lmb;
    }
}
