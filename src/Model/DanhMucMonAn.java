package Model;

/**
 *
 * @author asus
 */
public class DanhMucMonAn {
    private int MaMonAn;
    private String TenMonAn;
    private int DonGia;

    public DanhMucMonAn() {
    }

    public DanhMucMonAn(int MaMonAn, String TenMonAn, int DonGia) {
        this.MaMonAn = MaMonAn;
        this.TenMonAn = TenMonAn;
        this.DonGia = DonGia;
    }

    

    public int getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(int MaMonAn) {
        this.MaMonAn = MaMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String TenMonAn) {
        this.TenMonAn = TenMonAn;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }  
}
