package com.hwua.common.po;

public class OrderDetails {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private Integer count;
    private Integer price;

    public OrderDetails() {
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
