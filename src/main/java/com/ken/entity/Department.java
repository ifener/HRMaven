package com.ken.entity;

import java.io.Serializable;

/**
 * Created by it on 08/04/2017.
 */
public class Department implements Serializable {
    private Integer id;
    private String departmentName;
    private String remark;

    public Department() {
    }

    public Department(Integer id, String departmentName, String remark) {
        this.id = id;
        this.departmentName = departmentName;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
