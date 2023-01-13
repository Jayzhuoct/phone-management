package design.springboot.zjj.entity;

public class Type {
    private int pId;//手机id
    private String pName;//手机名称
    private String pModel;//手机型号
    private String pMemory;//手机内存
    private String pColour;//手机颜色
    private double pPrice;//手机价格

    public Type(String pName, String pModel, String pMemory, String pColour, double pPrice) {
        this.pName = pName;
        this.pModel = pModel;
        this.pMemory = pMemory;
        this.pColour = pColour;
        this.pPrice = pPrice;
    }

    public Type(int pId, String pName, String pModel, String pMemory, String pColour, double pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pModel = pModel;
        this.pMemory = pMemory;
        this.pColour = pColour;
        this.pPrice = pPrice;
    }

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pModel='" + pModel + '\'' +
                ", pMemory='" + pMemory + '\'' +
                ", pColour='" + pColour + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpModel() {
        return pModel;
    }

    public void setpModel(String pModel) {
        this.pModel = pModel;
    }

    public String getpMemory() {
        return pMemory;
    }

    public void setpMemory(String pMemory) {
        this.pMemory = pMemory;
    }

    public String getpColour() {
        return pColour;
    }

    public void setpColour(String pColour) {
        this.pColour = pColour;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }
}
