/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus
 */
public class ChiTietThongTinPhong {
     private String MaPhg;
    private String KieuPhong;
    private int KieuGiuong;
    private int DonGia;

    public ChiTietThongTinPhong() {
    }

    public String getMaPhg() {
        return MaPhg;
    }

    public void setMaPhg(String MaPhg) {
        this.MaPhg = MaPhg;
    }

    public String getKieuPhong() {
        return KieuPhong;
    }

    public void setKieuPhong(String KieuPhong) {
        this.KieuPhong = KieuPhong;
    }

    public int getKieuGiuong() {
        return KieuGiuong;
    }

    public void setKieuGiuong(int KieuGiuong) {
        this.KieuGiuong = KieuGiuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
}
