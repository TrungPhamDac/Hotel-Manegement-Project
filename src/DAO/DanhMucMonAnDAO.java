/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.DanhMucMonAn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class DanhMucMonAnDAO {
    Connection con = DataBaseConnection.getConnection();

    public boolean ThemMonAn(DanhMucMonAn MonAn){
        String sql = "INSERT INTO DANHMUCMONAN(TenMonAn, DonGia) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, MonAn.getMaMonAn());
            ps.setString(1, MonAn.getTenMonAn());
            ps.setInt(2, MonAn.getDonGia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        
    public boolean XoaMonAn(DanhMucMonAn MonAn){
        String sql = "UPDATE DANHMUCMONAN SET ACTIVE = 0 WHERE MaMonAn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MonAn.getMaMonAn());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        
    public boolean SuaMonAn(DanhMucMonAn MonAn){
        String sql = "UPDATE DANHMUCMONAN SET TenMonAn = ?, DonGia = ? WHERE MaMonAn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MonAn.getTenMonAn());
            ps.setInt(2, MonAn.getDonGia());
            ps.setInt(3, MonAn.getMaMonAn());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
        
    public ArrayList<DanhMucMonAn> getListMonAn(){
        ArrayList<DanhMucMonAn> listMonAn = new ArrayList<>();
        String sql = "SELECT MAMONAN, TENMONAN, DONGIA FROM DANHMUCMONAN WHERE ACTIVE = 1 ORDER BY MAMONAN";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DanhMucMonAn MonAn = new DanhMucMonAn();
                MonAn.setMaMonAn(rs.getInt("MaMonAn"));
                MonAn.setTenMonAn(rs.getString("TenMonAn"));
                MonAn.setDonGia(rs.getInt("DonGia"));               
                listMonAn.add(MonAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMonAn;
    }      
    
    public ArrayList<String> getTenMonAn(){
        ArrayList<String> listTenMonAn = new ArrayList<>();
        String sql = "SELECT TENMONAN FROM DANHMUCMONAN WHERE ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listTenMonAn.add(rs.getString("TenMonAn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTenMonAn;
    }
    
    public int getMaMonAn(String TenMonAn){
        int temp = 0;
        String sql = "SELECT MAMONAN FROM DANHMUCMONAN WHERE TENMONAN = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenMonAn);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                temp = rs.getInt("MaMonAn");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    
    public int getDonGiaMonAn(String TenMonAn){
        int temp = 0;
        String sql = "SELECT DONGIA FROM DANHMUCMONAN WHERE TENMONAN = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, TenMonAn);
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
