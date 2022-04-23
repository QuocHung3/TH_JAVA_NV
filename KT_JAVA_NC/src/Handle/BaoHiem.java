package Handle;

/**
 *
 * @author Quốc Hùng
 */
public class BaoHiem {
    String maBH,hoTen,password,SDT,soCCD,ngaySinh,gioiTinh;

    public BaoHiem() {
    }

    public BaoHiem(String maBH, String hoTen, String password, String SDT, String soCCD, String ngaySinh, String gioiTinh) {
        this.maBH = maBH;
        this.hoTen = hoTen;
        this.password = password;
        this.SDT = SDT;
        this.soCCD = soCCD;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSoCCD() {
        return soCCD;
    }

    public void setSoCCD(String soCCD) {
        this.soCCD = soCCD;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    
}
