package design.springboot.zjj.entity;

public class Admin {
    private int aId;
    private String aName;
    private String key;

    public Admin(int aId, String aName, String key) {
        this.aId = aId;
        this.aName = aName;
        this.key = key;
    }

    public Admin() {
    }

    public Admin(String aName, String key) {
        this.aName = aName;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
