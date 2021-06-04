/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PhieuDatPhong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TNo1
 */
public class PhieuDatPhongDAO {
    Connection con = DataBaseConnection.getConnection();
    public int getCurrentMaDatPhong(){
        int result = -1;
        String sql = "SELECT MADATPHONG FROM PHIEUDATPHONG ORDER BY MADATPHONG DESC FETCH FIRST 1 ROW ONLY";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                result = rs.getInt("MADATPHONG");
                return result+1;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result+1;
    }
    public boolean ThemPhieuDatPhong(PhieuDatPhong pdp){      
        String sql = "INSERT INTO PHIEUDATPHONG(MADATPHONG, MAKH, NGAYNHAN, NGAYTRA, TTNHANPHONG, MANV,  TIENTRATRUOC) VALUES(?,?,?,?,0,1,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pdp.getMaDatPhong());
            ps.setInt(2, pdp.getMaKH());
            ps.setDate(3, new Date(pdp.getNgayNhan().getTime()));
            ps.setDate(4, new Date(pdp.getNgayTra().getTime()));
            ps.setInt(5, pdp.getTienTraTruoc());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean ThemChiTietDatPhong(int MaDatPhong, ArrayList<String> ListMaPHG){
        for (String maPHG : ListMaPHG)
        {
            String sql = "INSERT INTO CHITIETDATPHONG(MADATPHONG, MAPHG) VALUES(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, MaDatPhong);
                ps.setString(2, maPHG);
                if (ps.executeUpdate() <= 0){
                    return false;    
                }
            } catch (Exception e) {
                e.printStackTrace();        
            }            
        }
        return true;        
    }
    public boolean TaoPhieuDatPhong(PhieuDatPhong pdp, ArrayList<String> ListMaPHG)
    {
        if (this.ThemPhieuDatPhong(pdp))
        {
            if (this.ThemChiTietDatPhong(pdp.getMaDatPhong(), ListMaPHG))
            {
                return true;
            }
        }
        return false;
    }
}
