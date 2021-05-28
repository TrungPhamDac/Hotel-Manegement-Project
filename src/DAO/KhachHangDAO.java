package DAO;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class KhachHangDAO {
    Connection con = DataBaseConnection.getConnection();

    public boolean addListKhachHang(KhachHang kh){
        
        String sql = "INSERT INTO KHACHHANG(MaKH, TenKH, CCCD, SDT) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getCCCD());
            ps.setString(4, kh.getSDT());
            
//            int rs = ps.executeUpdate();
//            if(rs > 0){
//                return true;
//            }
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setSDT(rs.getString("SDT"));
                
                list.add(kh);
                
//                String MaKH = rs.getString(1);
//                String TenKH = rs.getString(2);
//                String CCCD = rs.getString(3);
//                String SDT = rs.getString(4);
//                
//                list.add(new KhachHang(MaKH,TenKH,CCCD,SDT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
