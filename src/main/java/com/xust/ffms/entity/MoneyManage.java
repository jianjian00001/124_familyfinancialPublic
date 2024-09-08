package com.xust.ffms.entity;

public class MoneyManage {

    private Integer id;
    private Float money;
    private Integer userid;
    private String name;
    private String rate;
    private String houseid;  //执行查询用户的houseid
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public MoneyManage() {
    }

    public MoneyManage(Integer id, Float money, Integer userid, String name, String rate, String houseid) {
        this.id = id;
        this.money = money;
        this.userid = userid;
        this.name = name;
        this.rate = rate;
        this.houseid = houseid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }
}
