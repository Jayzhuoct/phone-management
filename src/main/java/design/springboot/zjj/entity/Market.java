package design.springboot.zjj.entity;

public class Market {
    private String pName;//手机名称
    private String pModel;//手机型号
    private double pBid;//手机进价
    private double pPrice;//手机售价
    private int pSales;//手机销量

    public Market() {
    }

    public Market(String pName, String pModel, double pBid, double pPrice, int pSales) {
        this.pName = pName;
        this.pModel = pModel;
        this.pBid = pBid;
        this.pPrice = pPrice;
        this.pSales = pSales;
    }

    @Override
    public String toString() {
        return "Market{" +
                "pName='" + pName + '\'' +
                ", pModel='" + pModel + '\'' +
                ", pBid=" + pBid +
                ", pPrice=" + pPrice +
                ", pSales=" + pSales +
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

    public double getpBid() {
        return pBid;
    }

    public void setpBid(double pBid) {
        this.pBid = pBid;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpSales() {
        return pSales;
    }

    public void setpSales(int pSales) {
        this.pSales = pSales;
    }
}
