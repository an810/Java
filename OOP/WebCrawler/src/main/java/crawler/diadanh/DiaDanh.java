package crawler.diadanh;

import java.util.Set;

public class DiaDanh {
    private String tenDiaDanh;
    private String code;
    private String description;
    private Set<String> nhanVatLienQuan;

    public DiaDanh() {

    }

//    public DiaDanh(String tenDiaDanh, String description, ArrayList<String> nhanVatLienQuan) {
//        this.tenDiaDanh = tenDiaDanh;
//        this.description = description;
//        this.nhanVatLienQuan = nhanVatLienQuan;
//    }

    public String getTenDiaDanh() {
        return tenDiaDanh;
    }

    public void setTenDiaDanh(String tenDiaDanh) {
        this.tenDiaDanh = tenDiaDanh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void setNhanVatLienQuan(Set<String> nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan;
    }

    @Override
    public String toString() {
        return "\n{ \"Dia danh\":\"" + this.tenDiaDanh + "\", "
                + "\n\"code\":\"" + this.code + "\", "
                + "\n\"Mieu ta\":\"" + this.description + "\", "
                + "\n\"Nhan vat lien quan\":\"" + this.nhanVatLienQuan + "\" }" + "\n";
    }


}
