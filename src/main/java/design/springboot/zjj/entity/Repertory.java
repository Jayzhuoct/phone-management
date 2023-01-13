package design.springboot.zjj.entity;

public class Repertory {
    private String pName;//手机名称
    private String pModel;//手机型号
    private int pEnter;//手机进货量
    private int pOut;//手机出货量
    private int pStock;//手机库存量

    public Repertory() {
    }

    public Repertory(String pName, String pModel, int pEnter, int pOut, int pStock) {
        this.pName = pName;
        this.pModel = pModel;
        this.pEnter = pEnter;
        this.pOut = pOut;
        this.pStock = pStock;
    }

    @Override
    public String toString() {
        return "Repertory{" +
                "pName='" + pName + '\'' +
                ", pModel='" + pModel + '\'' +
                ", pEnter=" + pEnter +
                ", pOut=" + pOut +
                ", pStock=" + pStock +
                '}';
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

    public int getpEnter() {
        return pEnter;
    }

    public void setpEnter(int pEnter) {
        this.pEnter = pEnter;
    }

    public int getpOut() {
        return pOut;
    }

    public void setpOut(int pOut) {
        this.pOut = pOut;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }
}