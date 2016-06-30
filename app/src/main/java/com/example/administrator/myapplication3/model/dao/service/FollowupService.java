package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Contract;
import com.example.administrator.myapplication3.model.entity.Followup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/27.
 */
public class FollowupService {

    Context context;

    public FollowupService(Context context) {
        this.context = context;
    }


    public void accessAPI(Map<String, String> map, final IUpdateListener<List<Followup>> listener){
        map.put("currentpage", "0");
        System.out.println("access:"+map.get("sourceid"));
        final ArrayList<Followup> list = new ArrayList<Followup>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_followup_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");

                            for(int i = 0;i < count;i++){

                                JSONObject info = jsonObject.getJSONObject(i+"");
                                Followup followup = new Followup();
                                followup.setFollowupid(info.getInt("followupid"));
//                                followup.setFollowuptype(info.getInt("followuptype"));
                                followup.setContent(info.getString("content"));
//                                followup.setFollowupremarks(info.getString("followupremarks"));
                                followup.setCreatetime(info.getString("createtime"));
                                followup.setCreatorid(info.getInt("creatorid"));

                                list.add(followup);

                            }
                            System.out.println("listsize:"+list.size());
                            listener.success(true, list);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }
        );


        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);
    }


    public void getFollwup(int sourceid,int sourcetype, final IUpdateListener<List<Followup>> listener){
        Map<String, String> map = new HashMap<String, String>();
        map.put("sourceid",sourceid+"");
        map.put("sourcetype",sourcetype+"");
        accessAPI(map, listener);
    }


    public void addFollowup(Map<String, String> map){


        map.put("creatorid", "115");

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/followup_create_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                    }
                }
        );

        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);

    }


}
