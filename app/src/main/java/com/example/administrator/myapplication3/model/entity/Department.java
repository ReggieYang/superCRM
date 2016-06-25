package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Department implements ParseJSON{

    private int departmentid;

    private String departmentname;

    private int parentid;

    private int departmentorder;

    private int departmentstatus;

    private String departmentremarks;

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getDepartmentorder() {
        return departmentorder;
    }

    public void setDepartmentorder(int departmentorder) {
        this.departmentorder = departmentorder;
    }

    public int getDepartmentstatus() {
        return departmentstatus;
    }

    public void setDepartmentstatus(int departmentstatus) {
        this.departmentstatus = departmentstatus;
    }

    public String getDepartmentremarks() {
        return departmentremarks;
    }

    public void setDepartmentremarks(String departmentremarks) {
        this.departmentremarks = departmentremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {

        JSONObject info = json.getJSONObject("0");
        departmentid = info.getInt("departmentid");
        departmentname = info.getString("departmentname");
        parentid = info.getInt("parentid");
        departmentorder = info.getInt("departmentorder");
        departmentstatus = info.getInt("departmentstatus");
        departmentremarks = info.getString("departmentremarks");
    }

    @Override
    public void parse(JSONObject json, int k) throws JSONException {

    }
}
