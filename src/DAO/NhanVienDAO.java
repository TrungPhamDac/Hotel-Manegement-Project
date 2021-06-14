package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class NhanVienDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public int getCurrentMaNV(){
        int result = -1;
        String sql = "SELECT MANV_SEQ.NEXTVAL AS VAL FROM DUAL ";
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
    public boolean ThemNhanVien(NhanVien nv){      
        String sql = "INSERT INTO NhanVien(TenNV, CCCD, NgaySinh, SDT, GioiTinh, NgayVL, ChucVu) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, nv.getMaNV());
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getCCCD());
            ps.setDate(3, new Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getSDT());           
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new Date(nv.getNgayVaoLam().getTime()));   
            ps.setString(7, nv.getChucVu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaNhanVien(NhanVien nv){
        String sql = "UPDATE NHANVIEN SET TENNV = ?, CCCD = ?, NGAYSINH = ?, SDT = ?, GIOITINH = ?, NGAYVL = ?, CHUCVU = ? WHERE MANV = ?";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getCCCD());
            ps.setDate(3, new Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getSDT());           
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new Date(nv.getNgayVaoLam().getTime()));   
            ps.setString(7, nv.getChucVu());
            ps.setInt(8, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaNhanVien(NhanVien nv){
        String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT MANV, TENNV, CCCD, NGAYSINH, SDT, GIOITINH, NGAYVL, CHUCVU  FROM NHANVIEN";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){           
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgayVaoLam(rs.getDate("NgayVL"));
                nv.setChucVu(rs.getString("ChucVu"));
                
                list.add(nv);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
