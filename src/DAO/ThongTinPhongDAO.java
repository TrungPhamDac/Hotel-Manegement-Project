/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ThongTinPhong;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class ThongTinPhongDAO {
   Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemChiTietTTPhong(ThongTinPhong ttPhong){
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
   
    public boolean XoaChiTietTTPhong(ThongTinPhong ttPhong){
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
    
    public boolean SuaChiTietTTPhong(ThongTinPhong ttPhongMoi, ThongTinPhong ttPhongCu){
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
    
    public ArrayList<ThongTinPhong> getListChiTietTTPhong(){
        ArrayList<ThongTinPhong> listTTPhong = new ArrayList<>();
        String sql = "SELECT P.MAPHG, P.MoTa, LP.KIEUPHONG, LP.KIEUGIUONG, LP.DONGIA "
                + "FROM PHONG P, LOAIPHONG LP WHERE P.MALOAIPHG = LP.MALOAIPHG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinPhong ttPhong = new ThongTinPhong();
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
    

    public ArrayList<ThongTinPhong> getListTTPhongTrong(String kieuPhong, int kieuGiuong, Date ngayNhan, Date ngayTra){
        ArrayList<ThongTinPhong> listTTPhong = new ArrayList<>();
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
                ThongTinPhong ttPhong = new ThongTinPhong();
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

    public ArrayList<ThongTinPhong> getKieuPhong(){
        ArrayList<ThongTinPhong> listKieuPhong = new ArrayList<>();
        String sql = "SELECT DISTINCT KIEUPHONG FROM LOAIPHONG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinPhong ttKieuPhong = new ThongTinPhong();
                ttKieuPhong.setKieuPhong(rs.getString("KieuPhong"));
                listKieuPhong.add(ttKieuPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuPhong;
    }
    
    public ArrayList<ThongTinPhong> getKieuGiuong(String KieuPhong){
        ArrayList<ThongTinPhong> listKieuGiuong = new ArrayList<>();
        String sql = "SELECT DISTINCT KIEUGIUONG FROM LOAIPHONG WHERE KIEUPHONG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KieuPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinPhong ttKieuGiuong = new ThongTinPhong();
                ttKieuGiuong.setKieuGiuong(rs.getInt("KieuGiuong"));
                listKieuGiuong.add(ttKieuGiuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuGiuong;
    }
    
    public ArrayList<ThongTinPhong> getListPhongDangSD(){
        ArrayList<ThongTinPhong> listMaPhg = new ArrayList<>();
        String sql = "SELECT MAPHG FROM PHONG WHERE TINHTRANG = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinPhong ttMaPhg = new ThongTinPhong();
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