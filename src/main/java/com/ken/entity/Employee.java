package com.ken.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by it on 08/04/2017.
 */
public class Employee implements Serializable{
    private int id;
    private Department department;
    private Position position;

    //@NotBlank
    @javax.validation.constraints.NotBlank
    private String employeeName;

    @javax.validation.constraints.NotBlank(message = "卡号不能为空")
    @Pattern(regexp = "^\\d{10}$",message = "卡号应该为10位数字")
    private String cardId;
    private String address;
    private String postCode;
    private String tel;

    @javax.validation.constraints.NotBlank(message = "请输入手机")
    @Pattern(regexp = "^[0-9]{11}$",message = "手机号码不正确")
    private String phone;
    private String qq;

    @javax.validation.constraints.Email(message = "请输入正确的电邮地址")
    @javax.validation.constraints.NotBlank(message = "电邮不能为空")
    private String email;
    private Integer sex;
    private String party;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String race;
    private String education;
    private String specialty;
    private String hobby;
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
