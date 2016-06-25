package com.example.administrator.myapplication3.model.dao.service;

import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface IUpdateListener<T> {
    void success(boolean isSuccess, T data);
    void fail(VolleyError error);

}
