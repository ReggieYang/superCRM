package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Followup implements ParseJSON{

    private int followupid;

    private int sourceid;

    private int sourcetype;

    private int followuptype;

    private String createtime;

    private int creatorid;

    private String content;

    private String followupremarks;

    public int getFollowupid() {
        return followupid;
    }

    public void setFollowupid(int followupid) {
        this.followupid = followupid;
    }

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(int sourcetype) {
        this.sourcetype = sourcetype;
    }

    public int getFollowuptype() {
        return followuptype;
    }

    public void setFollowuptype(int followuptype) {
        this.followuptype = followuptype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFollowupremarks() {
        return followupremarks;
    }

    public void setFollowupremarks(String followupremarks) {
        this.followupremarks = followupremarks;
    }

    @Override
    public void parse(JSONObject json) throws JSONException {
        JSONObject info = json.getJSONObject("0");
        followupid = info.getInt("followupid");
        sourceid = info.getInt("sourceid");
        sourcetype = info.getInt("sourceid");
        followuptype = info.getInt("followuptype");
        creatorid = info.getInt("creatorid");
        content = info.getString("content");
        followupremarks = info.getString("followupremarks");
        createtime = info.getString("createtime");


    }

    @Override
    public void parse(JSONObject json, int k) throws JSONException {

    }
}
