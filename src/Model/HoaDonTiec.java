/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author asus
 */
public class HoaDonTiec {
    private int MaTiec;
    private int MaNV;
    private int MaKH;
    private String TenKH;
    private int MaDatPhong;
    private String MaPhong;
    private Date NgayLap;
    private Date NgayToChuc;
    private int TinhTrang;
    private int SoKhach;
    private int TienCoc;
    private int TongTien;
    private String GhiChu;

    public HoaDonTiec() {
    }

    public int getMaTiec() {
        return MaTiec;
    }

    public void setMaTiec(int MaTiec) {
        this.MaTiec = MaTiec;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(int MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public Date getNgayToChuc() {
        return NgayToChuc;
    }

    public void setNgayToChuc(Date NgayToChuc) {
        this.NgayToChuc = NgayToChuc;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public int getSoKhach() {
        return SoKhach;
    }

    public void setSoKhach(int SoKhach) {
        this.SoKhach = SoKhach;
    }
    
    public int getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(int TienCoc) {
        this.TienCoc = TienCoc;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
