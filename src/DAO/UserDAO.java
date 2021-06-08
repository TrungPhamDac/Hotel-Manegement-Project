/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author TNo1
 */
public class UserDAO {
    Connection conn;
    public UserDAO(){
        conn =DataBaseConnection.getConnection();
    }
    public User validateUser(User user){
        String sql = "SElECT TENDANGNHAP, MATKHAU, MANV, QUYEN FROM NHANVIEN WHERE TENDANGNHAP = ? AND MATKHAU = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next())
            {
                User returnUser = new User();
                returnUser.setUsername(rs.getString("TENDANGNHAP"));
                returnUser.setPassword("THISISENCRYPTED");
                returnUser.setRole(rs.getString("QUYEN"));
                returnUser.setMaNV(rs.getInt("MANV"));
                return returnUser;
            }
            else return null;
        }
        catch(Exception event){
            event.printStackTrace();
        }
        return null;
    }
}
