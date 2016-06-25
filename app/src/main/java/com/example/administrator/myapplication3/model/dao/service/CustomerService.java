package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Customer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/22.
 */
public class CustomerService {

    Context context;

    public CustomerService(Context context) {
        this.context = context;
    }


    public List<Customer> getMockList(){
        Customer customer = new Customer();
        customer.setCustomername("Reggie Yang");
        customer.setCustomerstatus(3);
        customer.setCustomerid(125);
        ArrayList<Customer> list = new ArrayList<Customer>();
        list.add(customer);
        list.add(customer);
        list.add(customer);
        list.add(customer);
        list.add(customer);
        list.add(customer);
        return list;
    }


    public List<Customer> getMockList2(){
        Customer customer = new Customer();
        customer.setCustomername("James Harden");
        customer.setCustomerstatus(3);
        customer.setCustomerid(325);
        ArrayList<Customer> list = new ArrayList<Customer>();
        list.add(customer);
        list.add(customer);
        list.add(customer);

        return list;
    }


    public void getCustomerList(final IUpdateListener<List<Customer>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");

        System.out.println("get customer list");
        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_customer_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        System.out.println("wowworked");
                        System.out.println("wow"+jsonObject.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("errorforvolley");
                    }
                }
        );

        System.out.println("after customer list");

        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);

    }

    public void getCustomer(int id,final IUpdateListener<Customer> listener){
        final Customer customer = new Customer();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/customer_query_json?customerid="+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            customer.parse(response);
                            listener.success(true, customer);

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

    public void addCustomer(String name, int staffid){

        Map<String, String> map= new HashMap<String, String>();
        map.put("customername", name);
        map.put("staffid", staffid+"");


        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/customer_create_json"
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


    public void modifyCustomer(Customer customer, int staffid){

        Map<String, String> map= new HashMap<String, String>();
        map.put("customerid", customer.getCustomerid()+"");
        map.put("customername", customer.getCustomername());
        map.put("profile", customer.getProfile());
        map.put("customertype", customer.getCustomertype()+"");
        map.put("customerstatus", customer.getCustomerstatus()+"");
        map.put("regionid", customer.getRegionid()+"");
        map.put("parentcustomerid", customer.getParentcustomerid()+"");
        map.put("customersource", customer.getCustomersource());
        map.put("size", customer.getSize()+"");
        map.put("telephone", customer.getTelephone());
        map.put("email", customer.getEmail());
        map.put("website", customer.getWebsite());
        map.put("address", customer.getAddress());
        map.put("zipcode", customer.getZipcode());
        map.put("staffid", staffid + "");
        map.put("customerremarks", customer.getCustomerremarks());

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/customer_modify_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.print(volleyError);
                    }
                }
        );

        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);

    }


}
