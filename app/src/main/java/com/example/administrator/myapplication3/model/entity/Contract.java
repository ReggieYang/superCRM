package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Contract implements  ParseJSON{


    private int contractid;

    private String contracttitle;

    private int opportunityid;

    private int customerid;

    private double totalamount;

    private Date startdate;

    private Date enddate;

    private int contractstatus;

    private String contractnumber;

    private int contracttype;

    private String paymethod;

    private String clientcontractor;

    private String ourcontractor;

    private int staffid;

    private Date signingdate;

    private String attachment;

    private String contractremarks;

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    public String getContracttitle() {
        return contracttitle;
    }

    public void setContracttitle(String contracttitle) {
        this.contracttitle = contracttitle;
    }

    public int getOpportunityid() {
        return opportunityid;
    }

    public void setOpportunityid(int opportunityid) {
        this.opportunityid = opportunityid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getContractstatus() {
        return contractstatus;
    }

    public void setContractstatus(int contractstatus) {
        this.contractstatus = contractstatus;
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public int getContracttype() {
        return contracttype;
    }

    public void setContracttype(int contracttype) {
        this.contracttype = contracttype;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getClientcontractor() {
        return clientcontractor;
    }

    public void setClientcontractor(String clientcontractor) {
        this.clientcontractor = clientcontractor;
    }

    public String getOurcontractor() {
        return ourcontractor;
    }

    public void setOurcontractor(String ourcontractor) {
        this.ourcontractor = ourcontractor;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public Date getSigningdate() {
        return signingdate;
    }

    public void setSigningdate(Date signingdate) {
        this.signingdate = signingdate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getContractremarks() {
        return contractremarks;
    }

    public void setContractremarks(String contractremarks) {
        this.contractremarks = contractremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        contractid = info.getInt("contractid");
        contracttitle = info.getString("contracttitle");
        opportunityid = info.getInt("opportunityid");
        customerid = info.getInt("customerid");
        totalamount = info.getDouble("totalamount");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        try {
            startdate = sdf.parse(info.getString("startdate"));
            enddate = sdf.parse(info.getString("enddate"));
            signingdate = sdf.parse(info.getString("signingdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        contractstatus = info.getInt("contractstatus");
        contractnumber = info.getString("contractnumber");
        contracttype = info.getInt("contracttype");
        paymethod = info.getString("paymethod");
        clientcontractor = info.getString("clientcontractor");
        ourcontractor = info.getString("ourcontractor");
        staffid = info.getInt("staffid");
        attachment = info.getString("attachment");
        contractremarks = info.getString("contractremarks");
    }


}
