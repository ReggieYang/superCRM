package com.example.administrator.myapplication3.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface ParseJSON {
    void parse(JSONObject json) throws JSONException;

    void parse(JSONObject json, int k) throws JSONException;
}
