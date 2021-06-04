/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author TNo1
 */
public class PhieuDatPhong {
    private int MaDatPhong;
    private int MaKH;
    private Date NgayNhan;
    private Date NgayTra;
    private int TTNhanPhong;
    private int TienTraTruoc;

    public int getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(int MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(Date NgayNhan) {
        this.NgayNhan = NgayNhan;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public int getTTNhanPhong() {
        return TTNhanPhong;
    }

    public void setTTNhanPhong(int TTNhanPhong) {
        this.TTNhanPhong = TTNhanPhong;
    }

    public int getTienTraTruoc() {
        return TienTraTruoc;
    }

    public void setTienTraTruoc(int TienTraTruoc) {
        this.TienTraTruoc = TienTraTruoc;
    }
    
}
