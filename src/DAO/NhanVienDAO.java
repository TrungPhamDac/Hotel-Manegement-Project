package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class NhanVienDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemNhanVien(NhanVien nv){
        
        String sql = "INSERT INTO NhanVien(MaNV, TenNV, CCCD, NgaySinh, SDT, GioiTinh, NgayVaoLam, ChucVu) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getCCCD());
            ps.setDate(4, (Date) nv.getNgaySinh());
            ps.setString(5, nv.getSDT());           
            ps.setString(6, nv.getGioiTinh());
            ps.setDate(7, (Date) nv.getNgayVaoLam());
            ps.setString(8, nv.getChucVu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){           
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
                nv.setChucVu(rs.getString("ChucVu"));
                
                list.add(nv);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
