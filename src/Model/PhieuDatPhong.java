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
    private int TienDV;
    private int TienTiec;
    private int TienThanhToan;

    public int getTienDV() {
        return TienDV;
    }

    public void setTienDV(int TienDV) {
        this.TienDV = TienDV;
    }

    public int getTienTiec() {
        return TienTiec;
    }

    public void setTienTiec(int TienTiec) {
        this.TienTiec = TienTiec;
    }

    public int getTienThanhToan() {
        return TienThanhToan;
    }

    public void setTienThanhToan(int TienThanhToan) {
        this.TienThanhToan = TienThanhToan;
    }
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
    public String getStringDSPhong()
    {
        String s = "";
        for (String maphg : this.DSPhong)
        {
            s += maphg + " ";
        }
        s+="";
        return s;
    }
    public String getThongTinPhieuDatPhong()
    {
        String s = "<html>M?? ?????t ph??ng: " + this.MaDatPhong + "<br>T??n kh??ch h??ng: " + this.KhachHang.getTenKH() 
                +"<br>Ng??y nh???n: " + new SimpleDateFormat("dd/MM/yyyy").format(this.getNgayNhan())
                +"<br>Ng??y Tr???: "+ new SimpleDateFormat("dd/MM/yyyy").format(this.getNgayTra()) 
                +"<br>Danh s??ch c??c ph??ng thu??: ";
        for (String maphg : this.DSPhong)
        {
            s += maphg + "    ";
        }
        s +="<br>Ti???n tr??? tr?????c: "+ String.format("%,d", this.TienTraTruoc)
                +"<br>Ti???n ph??ng: "+ String.format("%,d", this.TienPhong)
                +"<br>Ti???n d???ch v???: "+ String.format("%,d",this.TienDV)
                +"<br>Ti???n ti???c: "+ String.format("%,d", this.TienTiec) 
                +"<br><b>S??? ti???n c???n thanh to??n: "+String.format("%,d", this.TienThanhToan)+"<b><html>";
        return s;
    }
}
