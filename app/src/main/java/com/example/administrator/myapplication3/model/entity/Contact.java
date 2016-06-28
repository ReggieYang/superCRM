package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Contact implements ParseJSON{

    private int contactsid;

    private int customerid;

    private String contactsname;

    private int contactsage;

    private String contactsgender;

    private String contactsmobile;

    private String contactstelephone;

    private String contactsemail;

    private String contactsaddress;

    private String contactszipcode;

    private String contactsqq;

    private String contactswechat;

    private String contactswangwang;

    private String contactsdeptname;

    private int contactsposition;

    private String contactsremarks;

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    private String customername;

    public int getContactsid() {
        return contactsid;
    }

    public void setContactsid(int contactsid) {
        this.contactsid = contactsid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname;
    }

    public int getContactsage() {
        return contactsage;
    }

    public void setContactsage(int contactsage) {
        this.contactsage = contactsage;
    }

    public String getContactsgender() {
        return contactsgender;
    }

    public void setContactsgender(String contactsgender) {
        this.contactsgender = contactsgender;
    }

    public String getContactsmobile() {
        return contactsmobile;
    }

    public void setContactsmobile(String contactsmobile) {
        this.contactsmobile = contactsmobile;
    }

    public String getContactstelephone() {
        return contactstelephone;
    }

    public void setContactstelephone(String contactstelephone) {
        this.contactstelephone = contactstelephone;
    }

    public String getContactsemail() {
        return contactsemail;
    }

    public void setContactsemail(String contactsemail) {
        this.contactsemail = contactsemail;
    }

    public String getContactsaddress() {
        return contactsaddress;
    }

    public void setContactsaddress(String contactsaddress) {
        this.contactsaddress = contactsaddress;
    }

    public String getContactszipcode() {
        return contactszipcode;
    }

    public void setContactszipcode(String contactszipcode) {
        this.contactszipcode = contactszipcode;
    }

    public String getContactsqq() {
        return contactsqq;
    }

    public void setContactsqq(String contactsqq) {
        this.contactsqq = contactsqq;
    }

    public String getContactswechat() {
        return contactswechat;
    }

    public void setContactswechat(String contactswechat) {
        this.contactswechat = contactswechat;
    }

    public String getContactswangwang() {
        return contactswangwang;
    }

    public void setContactswangwang(String contactswangwang) {
        this.contactswangwang = contactswangwang;
    }

    public String getContactsdeptname() {
        return contactsdeptname;
    }

    public void setContactsdeptname(String contactsdeptname) {
        this.contactsdeptname = contactsdeptname;
    }

    public int getContactsposition() {
        return contactsposition;
    }

    public void setContactsposition(int contactsposition) {
        this.contactsposition = contactsposition;
    }

    public String getContactsremarks() {
        return contactsremarks;
    }

    public void setContactsremarks(String contactsremarks) {
        this.contactsremarks = contactsremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        contactsid = info.getInt("contactsid");
        customerid = info.getInt("customerid");
        contactsname = info.getString("contactsname");
        contactsage = info.getInt("contactsage");
        contactsgender = info.getString("contactsgender");
        contactsmobile = info.getString("contactsmobile");
        contactstelephone = info.getString("contactstelephone");
        contactsemail = info.getString("contactsemail");
        contactsaddress = info.getString("contactsaddress");
        contactszipcode = info.getString("contactszipcode");
        contactsqq = info.getString("contactsqq");
        contactswechat = info.getString("contactswechat");
        contactswangwang = info.getString("contactswangwang");
        contactsdeptname = info.getString("contactsdeptname");
        contactsposition = info.getInt("contactsposition");
        contactsremarks = info.getString("contactsremarks");
    }

    @Override
    public void parse(JSONObject json, int k) throws JSONException {

    }
}
