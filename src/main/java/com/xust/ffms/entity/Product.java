package com.xust.ffms.entity;

public class Product {
    private Integer id;
    private String name;
    private String level;
    private String remark;
    private String loss;

    public Product(Integer id, String name, String level, String remark, String loss) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.remark = remark;
        this.loss = loss;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                ", loss='" + loss + '\'' +
                '}';
    }
}
