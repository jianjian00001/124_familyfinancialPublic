package com.xust.ffms.entity;


public class Debt {
    private Integer id;
    private Integer userid;
    private String houseid;
    private String name;
    private Float residue;
    private Float curperiod;
    private String realname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getResidue() {
        return residue;
    }

    public void setResidue(Float residue) {
        this.residue = residue;
    }

    public Float getCurperiod() {
        return curperiod;
    }

    public void setCurperiod(Float curperiod) {
        this.curperiod = curperiod;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Debt(Integer id, Integer userid, String houseid, String name, Float residue, Float curperiod) {
        this.id = id;
        this.userid = userid;
        this.houseid = houseid;
        this.name = name;
        this.residue = residue;
        this.curperiod = curperiod;
    }

    public Debt() {
    }
}
