/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author asus
 */
public class DatTiecDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemHoaDonTiec(){
        String sql = "INSERT INTO HOADONTIEC(MATIEC, MAKH, NGAYNHANTIEC";
        return false;
    }
    public int getMaTiec(){
        int temp = 0;
        String sql = "SELECT MAX(MATIEC) getMaTiec FROM HOADONTIEC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                if(rs == null){return 1;}
//                else{
//                    temp = rs.getInt("getMaTiec") + 1;
//                }
                temp = rs.getInt("getMaTiec") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
  
}
