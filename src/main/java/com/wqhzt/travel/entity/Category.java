package com.wqhzt.travel.entity;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/13 16:50
 */
public class Category {
    private int cid;
    private String cname;


    public Category() {
    }

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    /**
     * 获取
     * @return cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String toString() {
        return "Category{cid = " + cid + ", cname = " + cname + "}";
    }
}
