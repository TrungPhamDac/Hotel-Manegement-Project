/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.ThongTinPhong;
import Model.HoaDonDichVu;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author asus
 */
public class HoaDonDichVuDAO {
    Connection con = DataBaseConnection.getConnection();
    public boolean ThemDichVuPhong(HoaDonDichVu HDDV){
        String sql = "EXEC INSERT_DON_DV(?,(SELECT MADV FROM DANHMUCDICHVU WHERE TENDV = ?),?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, HDDV.getMaPHG());
            ps.setString(2, HDDV.getTenDV());
            ps.setInt(3, HDDV.getSoLuong());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaDichVuPhong(HoaDonDichVu HDDV){
        String sql = "EXEC DELETE_DON_DV(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, HDDV.getMaPHG());
            ps.setString(2, HDDV.getTenDV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaDichVuPhong(HoaDonDichVu HDDV){
        return false;
    }
    
    public ArrayList<HoaDonDichVu> getListChiTietHDDV(String MaPhong){
        ArrayList<HoaDonDichVu> listChiTietHDDV = new ArrayList<>();
        String sql = "EXEC GET_LIST_DONDV(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDichVu hddv = new HoaDonDichVu();
                hddv.setTenDV(rs.getString("TenDV"));
                hddv.setNgaySD(rs.getDate("ThoiGianDat"));
                hddv.setSoLuong(rs.getInt("SoLuong"));
                hddv.setDonGia(rs.getInt("DonGia"));
                listChiTietHDDV.add(hddv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietHDDV;
    }
}
