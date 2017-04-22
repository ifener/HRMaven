package com.ken.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by it on 08/04/2017.
 */
public class User implements Serializable {
    private int id;
    private String loginName;
    private String password;
    private Integer userStatus;
    private Date createDate;
    private String userName;

    public User() {
    }

    public User(int id, String loginName, String password, Integer status, Date createDate, String userName) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.userStatus = status;
        this.createDate = createDate;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer status) {
        this.userStatus = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
