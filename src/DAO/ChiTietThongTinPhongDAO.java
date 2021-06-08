/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChiTietThongTinPhong;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class ChiTietThongTinPhongDAO {
   Connection con = DataBaseConnection.getConnection();
    public boolean ThemChiTietTTPhong(ChiTietThongTinPhong ttPhong){
       String sql = "INSERT INTO PHONG(MAPHG, MALOAIPHG, MoTa, TINHTRANG)"
               + "VALUES(?,"
               + "(SELECT MALOAIPHG FROM LOAIPHONG WHERE KIEUPHONG = ? AND KIEUGIUONG = ?),"
               + "?,1)";
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, ttPhong.getMaPhg());
           ps.setString(2, ttPhong.getKieuPhong());
           ps.setInt(3, ttPhong.getKieuGiuong());
           ps.setString(4, ttPhong.getMoTa());
//           ps.setInt(5, ttPhong.getDonGia());
           return ps.executeUpdate() > 0;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return false;
   }
   
    public boolean XoaChiTietTTPhong(ChiTietThongTinPhong ttPhong){
        String sql = "DELETE FROM PHONG WHERE MAPHONG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ttPhong.getMaPhg());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }       
        return false;
    }
    
    public boolean SuaChiTietTTPhong(ChiTietThongTinPhong ttPhongMoi, ChiTietThongTinPhong ttPhongCu){
        String sql = "UPDATE PHONG SET MAPHG = ?,"
                + "MALOAIPHG = (SELECT MALOAIPHG FROM LOAIPHONG WHERE KIEUPHONG = ? AND KIEUGIUONG = ?),"
                + "MOTA = ?, TINHTRANG = 1"
                + "WHERE MAPHG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ttPhongMoi.getMaPhg());
            ps.setString(2, ttPhongMoi.getKieuPhong());
            ps.setInt(3, ttPhongMoi.getKieuGiuong());
            ps.setString(4, ttPhongMoi.getMoTa());
            ps.setString(5, ttPhongCu.getMaPhg());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<ChiTietThongTinPhong> getListChiTietTTPhong(){
        ArrayList<ChiTietThongTinPhong> listTTPhong = new ArrayList<>();
        String sql = "SELECT P.MAPHG, P.MoTa, LP.KIEUPHONG, LP.KIEUGIUONG, LP.DONGIA "
                + "FROM PHONG P, LOAIPHONG LP WHERE P.MALOAIPHG = LP.MALOAIPHG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietThongTinPhong ttPhong = new ChiTietThongTinPhong();
                ttPhong.setMaPhg(rs.getString("MaPhg"));
                ttPhong.setKieuPhong(rs.getString("KieuPhong"));
                ttPhong.setKieuGiuong(rs.getInt("KieuGiuong"));
                ttPhong.setDonGia(rs.getInt("DonGia"));
                ttPhong.setMoTa(rs.getString("MoTa"));
                listTTPhong.add(ttPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTTPhong;
    }
        public ArrayList<ChiTietThongTinPhong> getListTTPhongTrong(String kieuPhong, int kieuGiuong, Date ngayNhan, Date ngayTra){
        ArrayList<ChiTietThongTinPhong> listTTPhong = new ArrayList<>();
        String sql = "SELECT P.MAPHG, P.MoTa, LP.KIEUPHONG, LP.KIEUGIUONG, LP.DONGIA "
                + "FROM PHONG P, LOAIPHONG LP "+
                "WHERE P.MALOAIPHG = LP.MALOAIPHG AND LP.KIEUPHONG Like ? AND LP.KIEUGIUONG = ? AND MAPHG IN (SELECT * FROM TABLE (GETAVAILABLEROOM(?,?)))";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+kieuPhong+"%");
            ps.setInt(2,kieuGiuong);
            ps.setDate(3, new Date(ngayNhan.getTime()));
            ps.setDate(4, new Date(ngayTra.getTime()));            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietThongTinPhong ttPhong = new ChiTietThongTinPhong();
                ttPhong.setMaPhg(rs.getString("MaPhg"));
                ttPhong.setKieuPhong(rs.getString("KieuPhong"));
                ttPhong.setKieuGiuong(rs.getInt("KieuGiuong"));
                ttPhong.setDonGia(rs.getInt("DonGia"));
                ttPhong.setMoTa(rs.getString("MoTa"));
                listTTPhong.add(ttPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTTPhong;
    }

    public ArrayList<ChiTietThongTinPhong> getKieuPhong(){
        ArrayList<ChiTietThongTinPhong> listKieuPhong = new ArrayList<>();
        String sql = "SELECT DISTINCT KIEUPHONG FROM LOAIPHONG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietThongTinPhong ttKieuPhong = new ChiTietThongTinPhong();
                ttKieuPhong.setKieuPhong(rs.getString("KieuPhong"));
                listKieuPhong.add(ttKieuPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuPhong;
    }
    
    public ArrayList<ChiTietThongTinPhong> getKieuGiuong(String KieuPhong){
        ArrayList<ChiTietThongTinPhong> listKieuGiuong = new ArrayList<>();
        String sql = "SELECT DISTINCT KIEUGIUONG FROM LOAIPHONG WHERE KIEUPHONG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KieuPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietThongTinPhong ttKieuGiuong = new ChiTietThongTinPhong();
                ttKieuGiuong.setKieuGiuong(rs.getInt("KieuGiuong"));
                listKieuGiuong.add(ttKieuGiuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuGiuong;
    }
    
    public ArrayList<ChiTietThongTinPhong> getListPhongDangSD(){
        ArrayList<ChiTietThongTinPhong> listMaPhg = new ArrayList<>();
        String sql = "SELECT MAPHG FROM PHONG WHERE TINHTRANG = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietThongTinPhong ttMaPhg = new ChiTietThongTinPhong();
                ttMaPhg.setMaPhg(rs.getString("MaPhg"));
                listMaPhg.add(ttMaPhg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaPhg;
    }
    public int GiaPhong(String KieuPhong, int KieuGiuong){
        int temp = 0;
        String sql = "SELECT DONGIA FROM LOAIPHONG WHERE KIEUPHONG = ? AND KIEUGIUONG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KieuPhong);
            ps.setInt(2, KieuGiuong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                temp = rs.getInt("DonGia");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
