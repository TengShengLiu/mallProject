package com.hwua.common.po;

import java.util.Date;

public class Product {
    private Integer pid;
    private String pName;
    private Integer cid;
    private Integer bid;
    private Integer selPrice;
    private Integer discount;
    private Integer purPrice;
    private Integer inventory;
    private String searchInfo;
    private String intro;
    private String comments;
    private Integer proStatus;
    private String url;
    private Date addDate;
    private Integer sellNumber;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", cid=" + cid +
                ", bid=" + bid +
                ", selPrice=" + selPrice +
                ", discount=" + discount +
                ", purPrice=" + purPrice +
                ", inventory=" + inventory +
                ", searchInfo='" + searchInfo + '\'' +
                ", intro='" + intro + '\'' +
                ", comments='" + comments + '\'' +
                ", proStatus=" + proStatus +
                ", url='" + url + '\'' +
                ", addDate=" + addDate +
                ", sellNumber=" + sellNumber +
                '}';
    }


    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getSelPrice() {
        return selPrice;
    }

    public void setSelPrice(Integer selPrice) {
        this.selPrice = selPrice;
    }

    public Integer getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(Integer purPrice) {
        this.purPrice = purPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(String searchInfo) {
        this.searchInfo = searchInfo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
    }
}
