package com.example.administrator.myapplication3.presenter.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.entity.Customer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCustomerActivity extends AppCompatActivity {


    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        setSpinner(1,1);

        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerService cs = new CustomerService(getApplicationContext());
                setMap();
                cs.addCustomer(map);
//                Intent intent = new Intent(AddCustomerActivity.this, CustomerActivity.class);
//                startActivity(intent);
                finish();
            }
        });


    }


    private void setMap(){
        map.put("customername", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("profile", ((TextView) findViewById(R.id.profile)).getText().toString());
        map.put("regionid", ((TextView) findViewById(R.id.region)).getText().toString());
        map.put("parentcustomerid", ((TextView) findViewById(R.id.parentcustomer)).getText().toString());
        map.put("customersource", ((TextView) findViewById(R.id.source)).getText().toString());
        map.put("size", ((TextView) findViewById(R.id.company)).getText().toString());
        map.put("telephone", ((TextView) findViewById(R.id.tel)).getText().toString());
        map.put("email", ((TextView) findViewById(R.id.email)).getText().toString());
        map.put("website", ((TextView) findViewById(R.id.website)).getText().toString());
        map.put("address", ((TextView) findViewById(R.id.address)).getText().toString());
        map.put("zipcode", ((TextView) findViewById(R.id.zipcode)).getText().toString());
        map.put("customerremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("staffid", ((TextView) findViewById(R.id.staff)).getText().toString());
        map.put("customertype", ((Spinner) findViewById(R.id.type)).getSelectedItemPosition()+1+"");
        map.put("customerstatus", ((Spinner) findViewById(R.id.status)).getSelectedItemPosition()+1+"");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentdate = sdf.format(new Date());
        map.put("createdate", currentdate);
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
