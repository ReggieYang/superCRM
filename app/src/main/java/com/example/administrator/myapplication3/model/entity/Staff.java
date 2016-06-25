package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Staff implements ParseJSON{



    private int staffid;

    private String userid;

    private String openid;

    private String name;

    private int departmentid;

    private int leaderflag;

    private String position;

    private int order;

    private String mobile;

    private String tel;

    private String gender;

    private String email;

    private String weixinid;

    private String avatar;

    private String extattr;

    private int staffstatus;

    private int enable;

    private String staffremarks;

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getLeaderflag() {
        return leaderflag;
    }

    public void setLeaderflag(int leaderflag) {
        this.leaderflag = leaderflag;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getExtattr() {
        return extattr;
    }

    public void setExtattr(String extattr) {
        this.extattr = extattr;
    }

    public int getStaffstatus() {
        return staffstatus;
    }

    public void setStaffstatus(int staffstatus) {
        this.staffstatus = staffstatus;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getStaffremarks() {
        return staffremarks;
    }

    public void setStaffremarks(String staffremarks) {
        this.staffremarks = staffremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        staffid = info.getInt("staffid");
        userid = info.getString("userid");
        openid = info.getString("openid");
        name = info.getString("name");
        departmentid = info.getInt("departmentid");
        leaderflag = info.getInt("leaderflag");
        position = info.getString("position");
        order = info.getInt("order");
        mobile = info.getString("mobile");
        tel = info.getString("tel");
        email = info.getString("email");
        gender = info.getString("gender");
        weixinid = info.getString("weixinid");
        avatar = info.getString("avatar");
        extattr = info.getString("extattr");
        staffstatus = info.getInt("staffstatus");
        enable = info.getInt("enable");
        staffremarks = info.getString("staffremarks");
    }
}
