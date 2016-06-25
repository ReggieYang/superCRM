package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Product implements ParseJSON{

    private int productid;

    private String productname;

    private String productsn;

    private double standardprice;

    private String salesunit;

    private double unitcost;

    private String classification;

    private String pitcure;

    private String introduction;

    private String productremarks;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductsn() {
        return productsn;
    }

    public void setProductsn(String productsn) {
        this.productsn = productsn;
    }

    public double getStandardprice() {
        return standardprice;
    }

    public void setStandardprice(double standardprice) {
        this.standardprice = standardprice;
    }

    public String getSalesunit() {
        return salesunit;
    }

    public void setSalesunit(String salesunit) {
        this.salesunit = salesunit;
    }

    public double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(double unitcost) {
        this.unitcost = unitcost;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getPitcure() {
        return pitcure;
    }

    public void setPitcure(String pitcure) {
        this.pitcure = pitcure;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProductremarks() {
        return productremarks;
    }

    public void setProductremarks(String productremarks) {
        this.productremarks = productremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        productid = info.getInt("productid");
        productname = info.getString("productname");
        productsn = info.getString("productsn");
        standardprice = info.getDouble("standardprice");
        salesunit = info.getString("salesunit");
        unitcost = info.getDouble("unitcost");
        classification = info.getString("classification");
        pitcure = info.getString("pitcure");
        introduction = info.getString("introduction");
        productremarks = info.getString("productremarks");

    }
}
