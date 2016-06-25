package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Customer implements ParseJSON {

    private int customerid;

    private String customername;

    private String profile;

    private int customertype;

    private int customerstatus;

    private int regionid;

    private int parentcustomerid;

    private String customersource;

    private int size;

    private String telephone;

    private String email;

    private String website;

    private String address;

    private String zipcode;

    private int staffid;

    private String createdate;

    private String customerremarks;

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        customerid = info.getInt("customerid");
        customername = info.getString("customername");
        profile = info.getString("profile");
        customertype = info.getInt("customertype");
        customerstatus = info.getInt("customerstatus");
        regionid = info.getInt("regionid");
        parentcustomerid = info.getInt("parentcustomerid");
        customersource = info.getString("customersource");
        size = info.getInt("size");
        telephone = info.getString("telephone");
        email = info.getString("email");
        website = info.getString("website");
        address = info.getString("address");
        zipcode = info.getString("zipcode");
        staffid = info.getInt("staffid");
        createdate = info.getString("createdate");
        customerremarks = info.getString("customerremarks");
    }

    @Override
    public void parse(JSONObject json, int k) throws JSONException {
        JSONObject info = json.getJSONObject(k+"");
        customerid = info.getInt("customerid");
        customername = info.getString("customername");
        profile = info.getString("profile");
        customertype = info.getInt("customertype");
        customerstatus = info.getInt("customerstatus");
        regionid = info.getInt("regionid");
        parentcustomerid = info.getInt("parentcustomerid");
        customersource = info.getString("customersource");
        size = info.getInt("size");
        telephone = info.getString("telephone");
        email = info.getString("email");
        website = info.getString("website");
        address = info.getString("address");
        zipcode = info.getString("zipcode");
        staffid = info.getInt("staffid");
        createdate = info.getString("createdate");
        customerremarks = info.getString("customerremarks");
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getCustomertype() {
        return customertype;
    }

    public void setCustomertype(int customertype) {
        this.customertype = customertype;
    }

    public int getCustomerstatus() {
        return customerstatus;
    }

    public void setCustomerstatus(int customerstatus) {
        this.customerstatus = customerstatus;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public int getParentcustomerid() {
        return parentcustomerid;
    }

    public void setParentcustomerid(int parentcustomerid) {
        this.parentcustomerid = parentcustomerid;
    }

    public String getCustomersource() {
        return customersource;
    }

    public void setCustomersource(String customersource) {
        this.customersource = customersource;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCustomerremarks() {
        return customerremarks;
    }

    public void setCustomerremarks(String customerremarks) {
        this.customerremarks = customerremarks;
    }



    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }
}
