package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.model.entity.Contact;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ContactService {

    Context context;

    public ContactService(Context context) {
        this.context = context;
    }

    public List<Contact> getMockList(){
        ArrayList<Contact> list = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setContactsname("Kevin Durant");
        contact.setCustomerid(1);
        list.add(contact);
        list.add(contact);
        list.add(contact);
        return list;
    }


    public void addContact(Map<String, String> map){

//        Map<String, String> map= new HashMap<String, String>();
//        map.put("contactsname", name);
//        map.put("contactid", contactid + "");

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contact_create_json"
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


    public void getContact(int id,final IUpdateListener<Contact> listener){
        final Contact contact = new Contact();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contact_query_json?contactid="+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            contact.parse(response);
                            listener.success(true, contact);

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


    public void getContactList(final IUpdateListener<List<Contact>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        final ArrayList<Contact> list = new ArrayList<Contact>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contacts_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");

                            for(int i = 0;i < count;i++){
                                Contact contact = new Contact();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contact.setContactsid(info.getInt("contactsid"));
                                contact.setContactsname(info.getString("contactsname"));
                                contact.setCustomerid(info.getInt("customerid"));
                                list.add(contact);
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


    public void getCustomerContactList(Map<String, String> map, final IUpdateListener<List<Contact>> listener){
        map.put("currentpage", "0");
        final ArrayList<Contact> list = new ArrayList<Contact>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contacts_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");

                            for(int i = 0;i < count;i++){
                                Contact contact = new Contact();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contact.setContactsid(info.getInt("contactsid"));
                                contact.setContactsname(info.getString("contactsname"));
                                contact.setCustomerid(info.getInt("customerid"));
                                list.add(contact);
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


    public void getMyContactList(final IUpdateListener<List<Contact>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        map.put("staffid", "155");
        final ArrayList<Contact> list = new ArrayList<Contact>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_contacts_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");

                            for(int i = 0;i < count;i++){
                                Contact contact = new Contact();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                contact.setContactsid(info.getInt("contactsid"));
                                contact.setContactsname(info.getString("contactsname"));
                                contact.setCustomerid(info.getInt("customerid"));
                                list.add(contact);
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


    public void modifyContact(Map<String, String> map){

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/contact_modify_json"
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
