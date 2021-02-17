package com.wqhzt.travel.entity;

import java.util.Date;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/12 21:41
 */
public class Route {
    private int rid;
    private String rname;
    private double price;
    private String routeIntroduce;
    private int rflag;
    private String rdate;
    private int isThemeTour;
    private int count;
    private int cid;
    private String rimage;
    private int sid;
    private String sourceld;


    public Route() {
    }

    public Route(int rid, String rname, double price, String routeIntroduce, int rflag, String rdate, int isThemeTour, int count, int cid, String rimage, int sid, String sourceld) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isThemeTour = isThemeTour;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceld = sourceld;
    }

    /**
     * 获取
     * @return rid
     */
    public int getRid() {
        return rid;
    }

    /**
     * 设置
     * @param rid
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    /**
     * 获取
     * @return rname
     */
    public String getRname() {
        return rname;
    }

    /**
     * 设置
     * @param rname
     */
    public void setRname(String rname) {
        this.rname = rname;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return routeIntroduce
     */
    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    /**
     * 设置
     * @param routeIntroduce
     */
    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }

    /**
     * 获取
     * @return rflag
     */
    public int getRflag() {
        return rflag;
    }

    /**
     * 设置
     * @param rflag
     */
    public void setRflag(int rflag) {
        this.rflag = rflag;
    }

    /**
     * 获取
     * @return rdate
     */
    public String getRdate() {
        return rdate;
    }

    /**
     * 设置
     * @param rdate
     */
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    /**
     * 获取
     * @return isThemeTour
     */
    public int getIsThemeTour() {
        return isThemeTour;
    }

    /**
     * 设置
     * @param isThemeTour
     */
    public void setIsThemeTour(int isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
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
     * @return rimage
     */
    public String getRimage() {
        return rimage;
    }

    /**
     * 设置
     * @param rimage
     */
    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    /**
     * 获取
     * @return sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * 设置
     * @param sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * 获取
     * @return sourceld
     */
    public String getSourceld() {
        return sourceld;
    }

    /**
     * 设置
     * @param sourceld
     */
    public void setSourceld(String sourceld) {
        this.sourceld = sourceld;
    }

    public String toString() {
        return "Route{rid = " + rid + ", rname = " + rname + ", price = " + price + ", routeIntroduce = " + routeIntroduce + ", rflag = " + rflag + ", rdate = " + rdate + ", isThemeTour = " + isThemeTour + ", count = " + count + ", cid = " + cid + ", rimage = " + rimage + ", sid = " + sid + ", sourceld = " + sourceld + "}";
    }
}
