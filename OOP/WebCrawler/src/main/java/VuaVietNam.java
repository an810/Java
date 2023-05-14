public class VuaVietNam
{
    private String vua;
    private String mieuHieu;
    private String thuyHieu;
    private String nienHieu;
    private String tenHuy;
    private String theThu;
    private String triVi;
    private String nullRepresentation = "Không rõ";

    public VuaVietNam(String vua, String mieuHieu, String thuyHieu, String nienHieu,
                      String tenHuy, String theThu, String triVi)
    {
        setVua(vua);
        setMieuHieu(mieuHieu);
        setThuyHieu(thuyHieu);
        setNienHieu(nienHieu);
        setTenHuy(tenHuy);
        setTheThu(theThu);
        setTriVi(triVi);
    }

    public String getTriVi()
    {
        return triVi;
    }

    public void setTriVi(String triVi)
    {
        this.triVi = triVi == "" ? nullRepresentation : triVi;
    }

    public String getTheThu()
    {
        return theThu;
    }

    public void setTheThu(String theThu)
    {
        this.theThu = theThu == "" ? nullRepresentation : theThu;
    }

    public String getTenHuy()
    {
        return tenHuy;
    }

    public void setTenHuy(String tenHuy)
    {
        this.tenHuy = tenHuy == "" ? nullRepresentation : tenHuy;
    }

    public String getNienHieu()
    {
        return nienHieu;
    }

    public void setNienHieu(String nienHieu)
    {
        this.nienHieu = nienHieu == "" ? nullRepresentation : nienHieu;
    }

    public String getThuyHieu()
    {
        return thuyHieu;
    }

    public void setThuyHieu(String thuyHieu)
    {
        this.thuyHieu = thuyHieu == "" ? nullRepresentation : thuyHieu;
    }

    public String getMieuHieu()
    {
        return mieuHieu;
    }

    public void setMieuHieu(String mieuHieu)
    {
        this.mieuHieu = mieuHieu == "" ? nullRepresentation : mieuHieu;
    }

    public String getVua()
    {
        return vua;
    }

    public void setVua(String vua)
    {
        this.vua = vua == "" ? nullRepresentation : vua;
    }

    @Override
    public String toString()
    {
        return "{ \"Vua\":\"" + this.vua + "\", "
                + "\"MieuHieu\":\"" + this.mieuHieu + "\", "
                + "\"ThuyHieu\":\"" + this.thuyHieu + "\", "
                + "\"NienHieu\":\"" + this.nienHieu + "\", "
                + "\"TenHuy\":\"" + this.tenHuy + "\", "
                + "\"TheThu\":\"" + this.theThu + "\", "
                + "\"TriVi\":\"" + this.triVi + "\" }" + "\n";
    }
}