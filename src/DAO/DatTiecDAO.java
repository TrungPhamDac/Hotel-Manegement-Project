/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.HoaDonTiec;
import Model.KhachHang;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class DatTiecDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemHoaDonTiec(HoaDonTiec HDT){
        String sql = "{CALL INSERT_DON_TIEC(?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, HDT.getMaPhong());
            cs.setInt(2, HDT.getMaNV());
            cs.setInt(3, HDT.getMaKH());
            cs.setString(4, HDT.getGhiChu());
            cs.setInt(5, HDT.getTinhTrang());
            cs.setInt(6, HDT.getTongTien());
            cs.setDate(7, new Date(HDT.getNgayLap().getTime()));
            cs.setInt(8, HDT.getTienCoc());
            cs.setDate(9, new Date(HDT.getNgayToChuc().getTime()));
            cs.setInt(10, HDT.getSoKhach());
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaHoaDonTiec(HoaDonTiec HDT){
        String sql = "{CALL UPDATE_DONTIEC(?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, HDT.getMaPhong());
            cs.setInt(2, HDT.getMaNV());
            cs.setInt(3, HDT.getMaKH());
            cs.setString(4, HDT.getGhiChu());
            cs.setInt(5, HDT.getTinhTrang());
            cs.setInt(6, HDT.getTongTien());
            cs.setInt(7, HDT.getTienCoc());
            cs.setDate(8, new Date(HDT.getNgayToChuc().getTime()));
            cs.setInt(9, HDT.getSoKhach());
            cs.setInt(10, HDT.getMaTiec());
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
    public boolean XoaHoaDonTiec(HoaDonTiec HDT){
        String sql =  "DELETE FROM HOADONTIEC WHERE MATIEC = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, HDT.getMaTiec());            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public ArrayList<HoaDonTiec> getListHDTiec(){
        ArrayList<HoaDonTiec> list = new ArrayList<>();
        String sql = "SELECT MATIEC, MAPHG, MAKH, THOIGIANDAT, NGAYNHANTIEC, TINHTRANG, SOKHACH, TIENTRATRUOC, THANHTIEN, MOTA FROM HOADONTIEC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonTiec HDT = new HoaDonTiec();
                HDT.setMaTiec(rs.getInt("MATIEC"));
                HDT.setMaPhong(rs.getString("MAPHG"));
                HDT.setMaKH(rs.getInt("MAKH"));
                HDT.setNgayLap(rs.getDate("THOIGIANDAT"));
                HDT.setNgayToChuc(rs.getDate("NGAYNHANTIEC"));
                HDT.setTinhTrang(rs.getInt("TINHTRANG"));
                HDT.setSoKhach(rs.getInt("SOKHACH"));
                HDT.setTienCoc(rs.getInt("TIENTRATRUOC"));
                HDT.setTongTien(rs.getInt("THANHTIEN"));
                HDT.setGhiChu(rs.getString("MOTA"));
                list.add(HDT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<KhachHang> TimKiemKhachHang(KhachHang khachhangInput){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, SDT FROM KHACHHANG WHERE UPPER(TENKH) LIKE ? AND UPPER(SDT) LIKE ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + khachhangInput.getTenKH().toUpperCase() + "%");
            ps.setString(2, "%" + khachhangInput.getSDT().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSDT(rs.getString("SDT"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public KhachHang getKHByMaKH(int MAKH){
        KhachHang kh = new KhachHang();
        String sql = "SELECT MAKH, TENKH, CCCD, GioiTinh, SDT FROM KHACHHANG WHERE MAKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MAKH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<HoaDonTiec> TimKiemHDT(HoaDonTiec HDT){
        ArrayList<HoaDonTiec> list = new ArrayList<>();
        String sql = "SELECT MATIEC, MANV, MAPHG, hdt.MAKH AS MAKH, MOTA, TINHTRANG, THANHTIEN, THOIGIANDAT, TIENTRATRUOC, NGAYNHANTIEC, SOKHACH "
                + " FROM HOADONTIEC hdt JOIN KHACHHANG kh ON hdt.MAKH=kh.MAKH  WHERE UPPER(MAPHG) LIKE ? AND UPPER(TENKH) LIKE ? AND TINHTRANG = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + HDT.getMaPhong().toUpperCase() + "%");
            ps.setString(2, "%" + HDT.getTenKH().toUpperCase() + "%");
            ps.setInt(3, HDT.getTinhTrang());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonTiec data = new HoaDonTiec();
                data.setMaTiec(rs.getInt("MATIEC"));
                data.setMaPhong(rs.getString("MAPHG"));
                data.setMaNV(rs.getInt("MANV"));
                data.setMaKH(rs.getInt("MAKH"));
                data.setGhiChu(rs.getString("MOTA"));
                data.setTinhTrang(rs.getInt("TINHTRANG"));
                data.setTongTien(rs.getInt("THANHTIEN"));
                data.setNgayToChuc(rs.getDate("NGAYNHANTIEC"));
                if (rs.getInt("SOKHACH") == 0){
                    data.setSoKhach(rs.getInt("SOKHACH"));
                }
                data.setTienCoc(rs.getInt("TIENTRATRUOC"));
                data.setNgayLap(rs.getDate("THOIGIANDAT"));
                list.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<String> getListMaPhg(){
        ArrayList<String> listMaPhg = new ArrayList<>();
        String sql = "SELECT MAPHG FROM PHONG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listMaPhg.add(rs.getString("MAPHG"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaPhg;
    }
    
    public ArrayList<String> getListMaPhgDangSD(){
        ArrayList<String> listMaPhg = new ArrayList<>();
        String sql = "SELECT MAPHG FROM PHONG WHERE TINHTRANG = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listMaPhg.add(rs.getString("MAPHG"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaPhg;
    }
    
    public boolean ktraMaPhong_KH(String maphg, int makh){
        String sql = "SELECT MAKH FROM PHIEUDATPHONG " 
                + " JOIN ( SELECT MADATPHONG, MAPHG FROM CHITIETDATPHONG WHERE MAPHG = ? ) b" 
                + " on PHIEUDATPHONG.MADATPHONG = b.MADATPHONG" 
                + " WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) AND TTNHANPHONG = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maphg);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (makh == rs.getInt("MAKH")){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
