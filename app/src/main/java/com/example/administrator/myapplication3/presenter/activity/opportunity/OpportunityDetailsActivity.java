package com.example.administrator.myapplication3.presenter.activity.opportunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Customer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpportunityDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_details);
        Intent intent = getIntent();

//      et.setText(intent.getStringExtra("name"));
        final Customer customer = new Customer();


        final CustomerService customerService = new CustomerService(getApplicationContext());
        customerService.getCustomer(106, new IUpdateListener<Customer>() {
            @Override
            public void success(boolean isSuccess, Customer data) {

                data.setAddress("NJU 1B222");
                data.setProfile("he is dangerous");
                data.setCustomersource("gqx");
                data.setCustomerremarks("just hahah");
                customerService.modifyCustomer(data, 113);
            }

            @Override
            public void fail(VolleyError error) {

            }
        });






//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/customer_query_json?customerid=104", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        System.out.println("here is the response");
//                        try {
//                            customer.parse(response);
//
//                            et.setText(customer.getCustomername());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//
//
//        Map<String, String> map= new HashMap<String, String>();
//        map.put("currentpage","0");
//
//
//        MyJsonRequest myJsonRequest = new MyJsonRequest("http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_staff_json"
//                , map,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//                        System.out.println("here is the response2");
//
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        System.out.println("here is the error");
//
//                    }
//                }
//        );
//
//
//        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
//        mQueue.add(jsonObjectRequest);
//        mQueue.add(myJsonRequest);


//        new Thread()
//        {
//            public void run()
//            {
//
//
//
//                String uriAPI = "http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_staff_json"; //这是我测试的本地,大家可以随意改
//        /*建立HTTPost对象*/
//                HttpPost httpRequest = new HttpPost(uriAPI);
//        /*
//         * NameValuePair实现请求参数的封装
//        */
//                List<NameValuePair> params = new ArrayList<NameValuePair>();
//                params.add(new BasicNameValuePair("departmentid", "3"));
//                params.add(new BasicNameValuePair("currentpage", "1"));
//                params.add(new BasicNameValuePair("search", ""));
//
//
//          /* 添加请求参数到请求对象*/
//                try {
//                    httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
//
//
//                    HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
//          /*若状态码为200 ok*/
//                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
//            /*读返回数据*/
//                        String strResult = EntityUtils.toString(httpResponse.getEntity());
//                        System.out.println(strResult);
//
//                    }
//
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                } catch (ClientProtocolException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        /*URL可以随意改*/



//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("currentpage", "0");
//
//        JsonObjectRequest newMissRequest = new JsonObjectRequest(
//                Request.Method.POST, "http://nqiwx.mooctest.net:8090/wexin.php/Api/Index/common_opportunity_json",
//                new JSONObject(params), new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject jsonobj) {
//                et.setText(jsonobj.toString());
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });

//        mQueue.add(newMissRequest);








    }
}
