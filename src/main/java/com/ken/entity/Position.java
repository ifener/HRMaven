package com.ken.entity;

import java.io.Serializable;

/**
 * Created by it on 08/04/2017.
 */
public class Position implements Serializable{
    private int id;
    private String positionName;
    private String remark;

    public Position() {
    }

    public Position(int id, String positionName, String remark) {
        this.id = id;
        this.positionName = positionName;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
