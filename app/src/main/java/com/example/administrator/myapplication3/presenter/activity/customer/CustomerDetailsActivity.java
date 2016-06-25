package com.example.administrator.myapplication3.presenter.activity.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Customer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);


        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        System.out.println(id);

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDetailsActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });

        final CustomerService customerService = new CustomerService(getApplicationContext());
        customerService.getCustomer(id, new IUpdateListener<Customer>() {
            @Override

            public void success(boolean isSuccess, Customer data) {

                (((TextView) findViewById(R.id.name))).setText(data.getCustomername());
                (((TextView) findViewById(R.id.profile))).setText(data.getProfile());
                (((TextView) findViewById(R.id.region))).setText(data.getRegionid() + "");
                (((TextView) findViewById(R.id.parentcustomer))).setText(data.getParentcustomerid() + "");
                (((TextView) findViewById(R.id.source))).setText(data.getCustomersource());
                (((TextView) findViewById(R.id.company))).setText(data.getSize() + "");
                (((TextView) findViewById(R.id.tel))).setText(data.getTelephone());
                (((TextView) findViewById(R.id.email))).setText(data.getEmail());
                (((TextView) findViewById(R.id.website))).setText(data.getWebsite());
                (((TextView) findViewById(R.id.address))).setText(data.getAddress());
                (((TextView) findViewById(R.id.zipcode))).setText(data.getZipcode());
                (((TextView) findViewById(R.id.comment))).setText(data.getCustomerremarks());
                (((TextView) findViewById(R.id.staff))).setText(data.getStaffid()+"");

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                (((TextView) findViewById(R.id.date))).setText(sdf.format(data.getCreatedate()));
                setSpinner(data.getCustomertype(), data.getCustomerstatus());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });

    }


    private void setSpinner(int ctype, int cstatus){

        ArrayList<String> list = new ArrayList<String>();
        Spinner type = (Spinner)findViewById(R.id.type);
        list.add("重要客户");
        list.add("一般客户");
        list.add("低价值客户");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        type.setAdapter(adapter);

        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //               myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        type.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        type.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });


        type.setSelection(ctype-1);

        Spinner status = (Spinner)findViewById(R.id.status);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("初访");
        list2.add("意向");
        list2.add("报价");
        list2.add("成交");
        list2.add("暂时搁置");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        status.setAdapter(adapter2);

        status.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //               myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        status.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        status.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        status.setSelection(cstatus-1);
    }
}
