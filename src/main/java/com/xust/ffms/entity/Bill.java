package com.xust.ffms.entity;


import java.math.BigDecimal;


public class Bill {

    private Integer id;
    private String title;
    private String type;   //账单类型： 1 收入 2支出
    private Integer typeid;   //账单类型： 1 收入 2支出
    private BigDecimal money;
    private Integer userid;
    private String realname;
    private String remark;
    private Integer paywayid;
    private String payway;
    private String time;
    private String startTime;
    private String endTime;
    private String houseid;  //执行查询用户的houseid

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if("".equals(title.trim())) return;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        if("".equals(remark.trim())) return;
        this.remark = remark;
    }

    public Integer getPaywayid() {
        return paywayid;
    }

    public void setPaywayid(Integer paywayid) {
        this.paywayid = paywayid;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        if("".equals(realname.trim())) return;
        this.realname = realname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if("".equals(startTime.trim())) return;
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        if("".equals(endTime.trim())) return;;
        this.endTime = endTime;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public Bill(Integer id, String title, String type, Integer typeid, BigDecimal money, Integer userid, String realname, String remark, Integer paywayid, String payway, String time, String startTime, String endTime, String houseid) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.typeid = typeid;
        this.money = money;
        this.userid = userid;
        this.realname = realname;
        this.remark = remark;
        this.paywayid = paywayid;
        this.payway = payway;
        this.time = time;
        this.startTime = startTime;
        this.endTime = endTime;
        this.houseid = houseid;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", typeid='" + typeid + '\'' +
                ", money=" + money +
                ", userid=" + userid +
                ", realname='" + realname + '\'' +
                ", remark='" + remark + '\'' +
                ", paywayid='" + paywayid + '\'' +
                ", payway='" + payway + '\'' +
                ", time='" + time + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", houseid='" + houseid + '\'' +
                '}';




    }
}
