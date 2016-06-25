package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Opportunity;
import com.example.administrator.myapplication3.model.entity.Opportunity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class OpportunityService {


    Context context;

    public OpportunityService(Context context) {
        this.context = context;
    }

    public List<Opportunity> getMockList(){
        ArrayList<Opportunity> list = new ArrayList<Opportunity>();
        Opportunity opportunity = new Opportunity();
        opportunity.setOpportunitytitle("南京大学");
        opportunity.setOpportunitystatus(1);
        list.add(opportunity);
        list.add(opportunity);
        list.add(opportunity);
        Opportunity opportunity2 = new Opportunity();
        opportunity2.setOpportunitystatus(5);
        opportunity2.setOpportunitytitle("加州大学洛杉矶分校");
        list.add(opportunity2);
        list.add(opportunity2);
        list.add(opportunity2);
        list.add(opportunity2);
        list.add(opportunity2);
        return list;
    }


    public List<Opportunity> getMockList2(){
        ArrayList<Opportunity> list = new ArrayList<Opportunity>();
        Opportunity opportunity = new Opportunity();
        opportunity.setOpportunitytitle("南京大学");
        opportunity.setOpportunitystatus(1);
        list.add(opportunity);
        Opportunity opportunity2 = new Opportunity();
        opportunity2.setOpportunitystatus(5);
        opportunity2.setOpportunitytitle("加州大学洛杉矶分校");
        list.add(opportunity2);
        list.add(opportunity2);
        return list;
    }


    public void addOpportunity(String name, int opportunityid, int staffid){

        Map<String, String> map= new HashMap<String, String>();
        map.put("opportunitytitle", name);
        map.put("opportunityid", opportunityid + "");
        map.put("staffid", staffid + "");


        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/opportunity_create_json"
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


    public void getOpportunity(int id,final IUpdateListener<Opportunity> listener){
        final Opportunity opportunity = new Opportunity();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/opportunity_query_json?opportunityid="+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            opportunity.parse(response);
                            listener.success(true, opportunity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);

    }
    
//    public void modifyOpportunity(Opportunity opportunity, int staffid, int customerid){
//
//        Map<String, String> map= new HashMap<String, String>();
//        map.put("customerid", customerid);
//        map.put("opportunityid", opportunity.getOpportunityid()+"");
//        map.put("opportunitytitle", opportunity.getOpportunitytitle());
//        map.put("profile", opportunity.getProfile());
//        map.put("opportunitytype", opportunity.getOpportunitytype()+"");
//        map.put("opportunitystatus", opportunity.getOpportunitystatus()+"");
//        map.put("regionid", opportunity.getRegionid()+"");
//        map.put("parentopportunityid", opportunity.getParentopportunityid()+"");
//        map.put("opportunitysource", opportunity.getOpportunitysource());
//        map.put("size", opportunity.getSize()+"");
//        map.put("telephone", opportunity.getTelephone());
//        map.put("email", opportunity.getEmail());
//        map.put("website", opportunity.getWebsite());
//        map.put("address", opportunity.getAddress());
//        map.put("zipcode", opportunity.getZipcode());
//        map.put("staffid", staffid + "");
//        map.put("opportunityremarks", opportunity.getOpportunityremarks());
//
//        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/opportunity_modify_json"
//                , map,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        System.out.print(volleyError);
//                    }
//                }
//        );
//
//        RequestQueue mQueue = Volley.newRequestQueue(context);
//        mQueue.add(jsonObjectRequest);
//
//    }


}
