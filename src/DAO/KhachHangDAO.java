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
    public int getCurrentMaKH(){
        int result = -1;
        String sql = "SELECT MAKH_SEQ.NEXTVAL AS VAL FROM DUAL ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                result = rs.getInt("VAL");
                return result;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    public boolean ThemKhachHang(KhachHang kh){       
        String sql = "INSERT INTO KHACHHANG(TenKH, CCCD, GioiTinh, SDT) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getCCCD());
            ps.setString(3, kh.getGioiTinh());
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
            ps.setInt(1, kh.getMaKH());            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaKhachHang(KhachHang kh){
        String sql = "UPDATE KHACHHANG SET TenKH = ?, CCCD = ?, GioiTinh = ?, SDT = ? WHERE MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(5, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getCCCD());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
//    public boolean TimKiemKhachHang(KhachHang kh){
//        String sql = "SELECT * FROM KHACHHANG WHERE MaKH = ?";
//        try{
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, kh.getMaKH());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
    public ArrayList<KhachHang> getFilterListKhachHang(KhachHang khachhangInput){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, CCCD, GioiTinh, SDT FROM KHACHHANG WHERE UPPER(TENKH) LIKE ? AND UPPER(CCCD) LIKE ? AND UPPER(SDT) LIKE ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ khachhangInput.getTenKH().toUpperCase()+"%");
            ps.setString(2, "%" + khachhangInput.getCCCD().toUpperCase() + "%");
            ps.setString(3, "%" + khachhangInput.getSDT().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, CCCD, GioiTinh, SDT FROM KHACHHANG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
