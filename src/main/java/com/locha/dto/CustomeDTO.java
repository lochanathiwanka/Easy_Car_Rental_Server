package com.locha.dto;

public class CustomeDTO {
    private String rid;
    private String cid;
    private String driver;
    private int qty;

    public CustomeDTO() {
    }

    public CustomeDTO(String rid, String cid, String driver, int qty) {
        this.rid = rid;
        this.cid = cid;
        this.driver = driver;
        this.qty = qty;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
