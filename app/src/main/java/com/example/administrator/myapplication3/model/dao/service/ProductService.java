package com.example.administrator.myapplication3.model.dao.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.entity.Product;
import com.example.administrator.myapplication3.model.entity.Product;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ProductService {
    Context context;

    public ProductService(Context context) {
        this.context = context;
    }

    public List<Product> getMockList(){
        ArrayList<Product> list = new ArrayList<Product>();
        Product product = new Product();
        product.setClassification("Basketball");
        product.setProductname("Nike");
        list.add(product);
        list.add(product);
        list.add(product);
        return list;
    }

    public void addProduct(String name){

        Map<String, String> map= new HashMap<String, String>();
        map.put("productname", name);

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/product_create_json"
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

    public void getProduct(int id,final IUpdateListener<Product> listener){
        final Product product = new Product();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/Product_query_json?productid="+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            product.parse(response);
                            listener.success(true, product);

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


    public void modifyProduct(Product product){

        Map<String, String> map= new HashMap<String, String>();
        map.put("productname", product.getProductname());
        map.put("productid", product.getProductid()+"");
        map.put("productsn", product.getProductsn());
        map.put("standardprice", product.getStandardprice()+"");
        map.put("salesunit", product.getSalesunit());
        map.put("unitcost", product.getUnitcost()+"");
        map.put("classification", product.getClassification());
        map.put("picture", product.getPitcure());
        map.put("introduction", product.getIntroduction());
        map.put("productremarks", product.getProductremarks());

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/product_modify_json"
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


    public void getProductList(final IUpdateListener<List<Product>> listener){
        Map<String, String> map= new HashMap<String, String>();
        map.put("currentpage", "0");
        final ArrayList<Product> list = new ArrayList<Product>();

        MyJsonRequest jsonObjectRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_product_json"
                , map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            int count = jsonObject.getInt("recordcount");

                            for(int i = 0;i < count;i++){
                                Product product = new Product();
                                JSONObject info = jsonObject.getJSONObject(i+"");
                                product.setProductid(info.getInt("productid"));
                                product.setClassification(info.getString("classification"));
                                product.setProductname(info.getString("productname"));

                                list.add(product);
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
                        System.out.println("errorforvolley");
                    }
                }
        );


        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(jsonObjectRequest);

    }



}
