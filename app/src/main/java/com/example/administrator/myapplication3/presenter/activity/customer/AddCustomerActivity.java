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

import java.util.ArrayList;
import java.util.List;

public class AddCustomerActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerService cs = new CustomerService(getApplicationContext());
                String name = ((TextView) findViewById(R.id.name)).getText().toString();
                int staffid = Integer.parseInt(((TextView) findViewById(R.id.staff)).getText().toString());
                Toast.makeText(getApplicationContext(), staffid+"", Toast.LENGTH_SHORT).show();
                cs.addCustomer(name, staffid);
                Intent intent = new Intent(AddCustomerActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });



//        Spinner type = (Spinner)findViewById(R.id.type);
//        list.add("重要客户");
//        list.add("一般客户");
//        list.add("低价值客户");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        type.setAdapter(adapter);
//
//        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
//            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                arg0.setVisibility(View.VISIBLE);
//            }
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
// //               myTextView.setText("NONE");
//                arg0.setVisibility(View.VISIBLE);
//            }
//        });
//        /*下拉菜单弹出的内容选项触屏事件处理*/
//        type.setOnTouchListener(new Spinner.OnTouchListener(){
//            public boolean onTouch(View v, MotionEvent event) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//        });
//        /*下拉菜单弹出的内容选项焦点改变事件处理*/
//        type.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
//            public void onFocusChange(View v, boolean hasFocus) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//
//        type = (Spinner)findViewById(R.id.status);
//        list.clear();
//        list.add("初访");
//        list.add("意向");
//        list.add("报价");
//        list.add("成交");
//        list.add("暂时搁置");
//
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        type.setAdapter(adapter);
//
//        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
//            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                arg0.setVisibility(View.VISIBLE);
//            }
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//                //               myTextView.setText("NONE");
//                arg0.setVisibility(View.VISIBLE);
//            }
//        });
//        /*下拉菜单弹出的内容选项触屏事件处理*/
//        type.setOnTouchListener(new Spinner.OnTouchListener(){
//            public boolean onTouch(View v, MotionEvent event) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//        });
//        /*下拉菜单弹出的内容选项焦点改变事件处理*/
//        type.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
//            public void onFocusChange(View v, boolean hasFocus) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//
    }

}
