public class DiTich2 {
    private String tenDiTich;
    private String diaDiem;
    private String hangMuc;
    private String ghiChu;
    private final String nullRepresentation = "Không rõ";

    public DiTich2(String tenDiTich, String diaDiem, String hangMuc, String ghiChu) {
        this.tenDiTich = tenDiTich;
        this.diaDiem = diaDiem;
        this.hangMuc = hangMuc;
        this.ghiChu = ghiChu;
    }

    public String getTenDiTich() {
        return tenDiTich;
    }

    public void setTenDiTich(String tenDiTich) {
        this.tenDiTich = tenDiTich == "" ? nullRepresentation : tenDiTich;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem == "" ? nullRepresentation : diaDiem;
    }

    public String getHangMuc() {
        return hangMuc;
    }

    public void setHangMuc(String hangMuc) {
        this.hangMuc = hangMuc == "" ? nullRepresentation : hangMuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu == "" ? nullRepresentation : ghiChu;
    }

    @Override
    public String toString()
    {
        return "\n{ \"DiTich\":\"" + this.tenDiTich + "\", "
                + "\n\"ViTri\":\"" + this.diaDiem + "\", "
                + "\n\"LoaiDiTich\":\"" + this.hangMuc + "\", "
                + "\n\"NamCongNhan\":\"" + this.ghiChu + "\" }" + "\n";
    }
}
