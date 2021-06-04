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

/**
 *
 * @author asus
 */
public class ChiTietThongTinPhongDAO {
   Connection con = DataBaseConnection.getConnection();
    
   public boolean ThemChiTietTTPhong(ChiTietThongTinPhong ttPhong){
       String sql = "INSERT INTO PHONG(MAPHG, MALOAIPHG, MOTA, TINHTRANG)"
               + "VALUES(?,"
               + "(SELECT MALOAIPHG FROM LOAIPHONG WHERE KIEUPHONG = ? AND KIEUGIUONG = ?),"
               + "?,1)";
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, ttPhong.getMaPhg());
           ps.setString(2, ttPhong.getKieuPhong());
           ps.setInt(3, ttPhong.getKieuGiuong());
           ps.setInt(4, ttPhong.getDonGia());
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
    
    public ArrayList<ChiTietThongTinPhong> getKieuGiuong(){
        ArrayList<ChiTietThongTinPhong> listKieuGiuong = new ArrayList<>();
        String sql = "SELECT DISTINCT KIEUGIUONG FROM LOAIPHONG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
//    public int GiaPhong(ChiTietThongTinPhong ttPhong){
//        String sql = "SELECT DONGIA FROM LOAIPHONG WHERE KIEUPHONG = ? AND KIEUGIUONG = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, ttPhong.getKieuPhong());
//            ps.setInt(2, ttPhong.getKieuGiuong());
//            ResultSet rs = ps.executeQuery();
//            ttPhong.setDonGia(rs.getInt("DonGia"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ttPhong.getDonGia();
//    }
}
