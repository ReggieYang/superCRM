package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/29.
 */
public class Opportunity implements ParseJSON{

    public int getOpportunityid() {
        return opportunityid;
    }

    public void setOpportunityid(int opportunityid) {
        this.opportunityid = opportunityid;
    }

    public String getOpportunitytitle() {
        return opportunitytitle;
    }

    public void setOpportunitytitle(String opportunitytitle) {
        this.opportunitytitle = opportunitytitle;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public double getEstimatedamount() {
        return estimatedamount;
    }

    public void setEstimatedamount(double estimatedamount) {
        this.estimatedamount = estimatedamount;
    }

    public int getSuccessrate() {
        return successrate;
    }

    public void setSuccessrate(int successrate) {
        this.successrate = successrate;
    }

    public Date getExpecteddate() {
        return expecteddate;
    }

    public void setExpecteddate(Date expecteddate) {
        this.expecteddate = expecteddate;
    }

    public int getOpportunitystatus() {
        return opportunitystatus;
    }

    public void setOpportunitystatus(int opportunitystatus) {
        this.opportunitystatus = opportunitystatus;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(int businesstype) {
        this.businesstype = businesstype;
    }

    public Date getAcquisitiondate() {
        return acquisitiondate;
    }

    public void setAcquisitiondate(Date acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }

    public String getOpportunitiessource() {
        return opportunitiessource;
    }

    public void setOpportunitiessource(String opportunitiessource) {
        this.opportunitiessource = opportunitiessource;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getOpportunityremarks() {
        return opportunityremarks;
    }

    public void setOpportunityremarks(String opportunityremarks) {
        this.opportunityremarks = opportunityremarks;
    }

    private int opportunityid;

    private String opportunitytitle;

    private int customerid;

    private double estimatedamount;

    private int successrate;

    private Date expecteddate;

    private int opportunitystatus;

    private String channel;

    private int businesstype;

    private Date acquisitiondate;

    private String opportunitiessource;

    private int staffid;

    private String opportunityremarks;


    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        opportunityid = info.getInt("opportuntiyid");
        opportunitytitle = info.getString("opportunitytitle");
        customerid = info.getInt("customerid");
        estimatedamount = info.getDouble("estimatedamount");
        successrate = info.getInt("successrate");

        opportunitystatus = info.getInt("opportunitystatus");
        channel = info.getString("channel");
        businesstype = info.getInt("businesstype");
        opportunitiessource = info.getString("opportunitiessource");
        staffid = info.getInt("staffid");
        opportunityremarks = info.getString("opportunityremarks");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        String dstr = info.getString("createdate");
        try {
            expecteddate = sdf.parse(info.getString("expecteddate"));
            acquisitiondate = sdf.parse("acquisitiondate");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
