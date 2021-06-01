/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.DanhMucDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class DanhMucDichVuDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemDichVu(DanhMucDichVu DichVu){
        String sql = "INSERT INTO DANHMUCDICHVU( TenDV, DonGia) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, DichVu.getTenDV());
            ps.setInt(2, DichVu.getDonGia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaDichVu(DanhMucDichVu DichVu){
        String sql = "DELETE FROM DANHMUCDICHVU WHERE MaDV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, DichVu.getMaDV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaDichVu(DanhMucDichVu DichVu){
        String sql = "UPDATE DANHMUCDICHVU SET TenDV = ?, DonGia = ? WHERE MaDV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, DichVu.getTenDV());
            ps.setInt(2, DichVu.getDonGia());
            ps.setString(3, DichVu.getMaDV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<DanhMucDichVu> getListDichVu(){
        ArrayList<DanhMucDichVu> listDichVu = new ArrayList<>();
        String sql = "SELECT MADV, TENDV, DONGIA FROM DANHMUCDICHVU";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DanhMucDichVu DichVu = new DanhMucDichVu();
                DichVu.setMaDV(rs.getString("MaDV"));
                DichVu.setTenDV(rs.getString("TenDV"));
                DichVu.setDonGia(rs.getInt("DonGia"));
                listDichVu.add(DichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDichVu;
    }
}
