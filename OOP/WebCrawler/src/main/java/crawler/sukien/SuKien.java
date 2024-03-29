package crawler.sukien;

import java.util.*;

public class SuKien {
    private String ten;
    private String thoiGian;
    private String diaDiem;
    private String ketQua;
    private ArrayList<String> nhanVatLichSu;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public ArrayList<String> getNhanVatLichSu() {
        return nhanVatLichSu;
    }

    public void setNhanVatLichSu(ArrayList<String> nhanVatLichSu) {
        this.nhanVatLichSu = nhanVatLichSu;
    }

    @Override
    public String toString() {
        return "\n{ \"\"Tên:\"" + this.ten + "\", "
                + "\n\"Thời gian\":\"" + this.thoiGian + "\", "
                + "\n\"Địa điểm\":\"" + this.diaDiem + "\", "
                + "\n\"Kết quả\":\"" + this.ketQua + "\", "
                + "\n\"Các nhân vật lịch sử\":\"" + this.nhanVatLichSu + "\" }" + "\n";
    }
//    public void display(){
//        System.out.println("Tên: " + this.ten);
//        System.out.println("Thời gian: " + this.thoiGian);
//        System.out.println("Địa điểm: " + this.diaDiem);
//        System.out.println("Kết quả: " + this.ketQua);
//        System.out.println("Các nhân vật lịch sử: " + this.nhanVatLichSu);
//    }

}