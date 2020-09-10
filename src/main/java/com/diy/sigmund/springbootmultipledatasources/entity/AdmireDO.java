package com.diy.sigmund.springbootmultipledatasources.entity;

import java.util.Date;

/**
 * @author ylm-sigmund
 * @since 2020/8/9 10:38
 */
public class AdmireDO {
    private Integer admireid;

    private String truename;

    private String tel;

    private String sex;

    private Date birth;

    private String job;

    private Double income;

    private String marital;

    private Integer flower;

    private String image;

    public Integer getAdmireid() {
        return admireid;
    }

    public void setAdmireid(Integer admireid) {
        this.admireid = admireid;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital == null ? null : marital.trim();
    }

    public Integer getFlower() {
        return flower;
    }

    public void setFlower(Integer flower) {
        this.flower = flower;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}