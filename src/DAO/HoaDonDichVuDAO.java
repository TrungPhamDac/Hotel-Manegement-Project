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
        String sql = "INSERT INTO CHITIETDONDV(MAHDDV, MADV, SOLUONG, NGAYSD)"
                + "VALUES((SELECT MAHDDV FROM HOADONDV WHERE MADATPHONG = "
                + "(SELECT MADATPHONG FROM LUUTRU WHERE MAPHG = ?)),"
                + "(SELECT MADV FROM DANHMUCDICHVU WHERE TENDV = ?),?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, HDDV.getMaPHG());
            ps.setString(2, HDDV.getTenDV());
            ps.setInt(3, HDDV.getSoLuong());
            ps.setDate(4, (Date) HDDV.getNgaySD());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<HoaDonDichVu> getListChiTietHDDV(){
        ArrayList<HoaDonDichVu> listChiTietHDDV = new ArrayList<>();
        String sql = "SELECT ";
        return listChiTietHDDV;
    }
}
