public class DiTich {
    private String diTich;
    private String viTri;
    private String loaiDiTich;
    private String namCongNhan;
    private final String nullRepresentation = "Không rõ";

    public DiTich(String diTich, String viTri, String loaiDiTich, String namCongNhan) {
        this.diTich = diTich;
        this.viTri = viTri;
        this.loaiDiTich = loaiDiTich;
        this.namCongNhan = namCongNhan;
    }

    public String getDiTich() {
        return diTich;
    }

    public void setDiTich(String diTich) {
        this.diTich = diTich == "" ? nullRepresentation : diTich;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri == "" ? nullRepresentation : viTri;
    }

    public String getLoaiDiTich() {
        return loaiDiTich;
    }

    public void setLoaiDiTich(String loaiDiTich) {
        this.loaiDiTich = loaiDiTich == "" ? nullRepresentation : loaiDiTich;
    }

    public String getNamCongNhan() {
        return namCongNhan;
    }

    public void setNamCongNhan(String namCongNhan) {
        this.namCongNhan = namCongNhan == "" ? nullRepresentation : namCongNhan;
    }
    @Override
    public String toString()
    {
        return "{ \"DiTich\":\"" + this.diTich + "\", "
                + "\"ViTri\":\"" + this.viTri + "\", "
                + "\"LoaiDiTich\":\"" + this.loaiDiTich + "\", "
                + "\"NamCongNhan\":\"" + this.namCongNhan + "\" }" + "\n";
    }
}
