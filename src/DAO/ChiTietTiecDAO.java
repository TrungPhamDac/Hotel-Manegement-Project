/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChiTietTiec;
import Model.HoaDonTiec;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ChiTietTiecDAO {
    Connection con = DataBaseConnection.getConnection();
    public HoaDonTiec layThongTinTiec(int matiec){
        HoaDonTiec HDT = new HoaDonTiec();
        String sql = "SELECT MATIEC, MAPHG, MAKH, THOIGIANDAT, NGAYNHANTIEC, TINHTRANG, SOKHACH, TIENTRATRUOC, THANHTIEN, MOTA FROM HOADONTIEC WHERE MATIEC = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matiec);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HDT;
    }
    
    public ArrayList<ChiTietTiec> layDSChiTietTiec(int matiec){
        ArrayList<ChiTietTiec> DSChiTietTiec = new ArrayList<>();
        String sql = "SELECT MATIEC, ct.MAMONAN AS MAMONAN, TENMONAN, SOLUONG, DONGIAMONAN FROM CHITIETTIEC ct JOIN DANHMUCMONAN dm "
                + " ON ct.MAMONAN = dm.MAMONAN WHERE MATIEC = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matiec);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietTiec ctt = new ChiTietTiec();
                ctt.setMatiec(rs.getInt("MATIEC"));
                ctt.setMamonan(rs.getInt("MAMONAN"));
                ctt.setTenmonan(rs.getString("TENMONAN"));
                ctt.setSoluong(rs.getInt("SOLUONG"));
                ctt.setDongia(rs.getInt("DONGIAMONAN"));
                DSChiTietTiec.add(ctt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DSChiTietTiec;
    }
    
    public boolean ThemChiTietTiec(ChiTietTiec CTT){
        String sql = "INSERT INTO CHITIETTIEC(MATIEC, MAMONAN, SOLUONG, DONGIAMONAN) VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CTT.getMatiec());
            ps.setInt(2, CTT.getMamonan());
            ps.setInt(3, CTT.getSoluong());
            ps.setInt(4, CTT.getDongia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaChiTietTiec(ChiTietTiec CTT){
        String sql = "DELETE FROM CHITIETTIEC WHERE MATIEC = ? AND MAMONAN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CTT.getMatiec());
            ps.setInt(2, CTT.getMamonan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaChiTietTiec(ChiTietTiec CTT){
        String sql = "UPDATE CHITIETTIEC SET SOLUONG = ? WHERE MATIEC = ? AND MAMONAN = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CTT.getSoluong());
            ps.setInt(2, CTT.getMatiec());
            ps.setInt(3, CTT.getMamonan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
