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

    public boolean ThemKhachHang(KhachHang kh){       
        String sql = "INSERT INTO KHACHHANG(MaKH, TenKH, CCCD, SDT) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getCCCD());
            ps.setString(4, kh.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaKhachHang(KhachHang kh){
        String sql =  "DELETE FROM KHACHHANG WHERE MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaKhachHang(KhachHang kh){
        String sql = "UPDATE KHACHHANG SET TenKH = ?, CCCD = ?, SDT = ? WHERE MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(4, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getCCCD());
            ps.setString(3, kh.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean TimKiemKhachHang(KhachHang kh){
        String sql = "SELECT * FROM KHACHHANG WHERE MaKH = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            return ps.executeUpdate() > 0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, CCCD, SDT FROM KHACHHANG";
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
