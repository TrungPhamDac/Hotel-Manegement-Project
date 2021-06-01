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
    
    public ArrayList<ChiTietThongTinPhong> getListChiTietTTPhong(){
        ArrayList<ChiTietThongTinPhong> listTTPhong = new ArrayList<>();
        String sql = "SELECT P.MAPHG, LP.KIEUPHONG, LP.KIEUGIUONG, LP.DONGIA "
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
}
