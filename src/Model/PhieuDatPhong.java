/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TNo1
 */
public class PhieuDatPhong {
    private int MaDatPhong;
    private KhachHang KhachHang;
    private Date NgayDat;
    private Date NgayNhan;
    private Date NgayTra;
    private int TTNhanPhong;
    private int TienTraTruoc;
    private ArrayList<String> DSPhong;
    private int TienPhong;

    public int getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(int TienPhong) {
        this.TienPhong = TienPhong;
    }
    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public ArrayList<String> getDSPhong() {
        return DSPhong;
    }

    public void setDSPhong(ArrayList<String> DSPhong) {
        this.DSPhong = DSPhong;
    }

    public int getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(int MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(KhachHang KhachHang) {
        this.KhachHang = KhachHang;
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
    public String getThongTinPhieuDatPhong()
    {
        String s = "<html>Mã đặt phòng: " + this.MaDatPhong + "<br>Tên khách hàng: " + this.KhachHang.getTenKH() 
                +"<br>Ngày nhận: " + new SimpleDateFormat("dd/mm/yyyy").format(this.getNgayNhan())
                +"<br>Ngày Trả: "+ new SimpleDateFormat("dd/mm/yyyy").format(this.getNgayTra()) 
                +"<br>Danh sách các phòng thuê: ";
        for (String maphg : this.DSPhong)
        {
            s += maphg + "    ";
        }
        s +="<br>TienPhong"+
                +this.TienPhong+"<html>";
        return s;
    }
}
