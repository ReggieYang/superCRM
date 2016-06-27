package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Contract;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.model.entity.Contract;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ContractService {

    Context context;

    public ContractService(Context context) {
        this.context = context;
    }

    public List<Contract> getMockList(){
        ArrayList<Contract> list = new ArrayList<Contract>();
        Contract contract = new Contract();
        contract.setContracttitle("Signing KD");
        contract.setContractstatus(3);
        list.add(contract);
        list.add(contract);
        list.add(contract);
        return list;
    }

    public void addContract(Map<String, String> map){
//        Map<String, String> map= new HashMap<String, String>();
//        map.put("contractid", opprotunityid+"");
//        map.put("customerid", customerid + "");
//        map.put("staffid", staffid + "");
//        map.put("contracttitle", name);




        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contract_create_json"
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



    public void modifyContract(Map<String, String> map){
//        Map<String, String> map= new HashMap<String, String>();
//        map.put("contractid", opprotunityid+"");
//        map.put("customerid", customerid + "");
//        map.put("staffid", staffid + "");
//        map.put("contracttitle", name);


        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contract_modify_json"
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


    public void getContract(int id,final IUpdateListener<Contract> listener){
        final Contract contract = new Contract();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contract_query_json?contractid="+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            contract.parse(response);
                            listener.success(true, contract);

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


    public void getContractList2(final IUpdateListener<List<Contract>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        final ArrayList<Contract> list = new ArrayList<Contract>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contract_query_json?contractid=-1"
                , null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");
                            for(int i = 0;i < count;i++){
                                Contract contract = new Contract();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contract.setContractid(info.getInt("contractid"));
                                contract.setContracttitle(info.getString("contracttitle"));
                                contract.setContractstatus(-1);

                                if(!info.get("contractstatus").equals(null)){
                                    contract.setContractstatus(info.getInt("contractstatus"));
                                }

                                list.add(contract);
                                listener.success(true, list);
                            }



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

    public void getMyContractList(final IUpdateListener<List<Contract>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        map.put("staffid", "155");
        final ArrayList<Contract> list = new ArrayList<Contract>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contract_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");
                            for(int i = 0;i < count;i++){
                                Contract contract = new Contract();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contract.setContractid(info.getInt("contractid"));
                                contract.setContracttitle(info.getString("contracttitle"));
                                contract.setContractstatus(-1);

                                if(!info.get("contractstatus").equals(null)){
                                    contract.setContractstatus(info.getInt("contractstatus"));
                                }

                                list.add(contract);
                                listener.success(true, list);
                            }



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


    public void getContractList(final IUpdateListener<List<Contract>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        final ArrayList<Contract> list = new ArrayList<Contract>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contract_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");
                            for(int i = 0;i < count;i++){
                                Contract contract = new Contract();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contract.setContractid(info.getInt("contractid"));
                                contract.setContracttitle(info.getString("contracttitle"));
                                contract.setContractstatus(-1);

                                if(!info.get("contractstatus").equals(null)){
                                    contract.setContractstatus(info.getInt("contractstatus"));
                                }

                                list.add(contract);
                                listener.success(true, list);
                            }



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

    public void getCustomerOpportunityContractList(Map<String, String> map, final IUpdateListener<List<Contract>> listener){
        map.put("currentpage", "0");
        final ArrayList<Contract> list = new ArrayList<Contract>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contract_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");
                            for(int i = 0;i < count;i++){
                                Contract contract = new Contract();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contract.setContractid(info.getInt("contractid"));
                                contract.setContracttitle(info.getString("contracttitle"));
                                contract.setContractstatus(-1);

                                if(!info.get("contractstatus").equals(null)){
                                    contract.setContractstatus(info.getInt("contractstatus"));
                                }

                                list.add(contract);
                                listener.success(true, list);
                            }



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



}
