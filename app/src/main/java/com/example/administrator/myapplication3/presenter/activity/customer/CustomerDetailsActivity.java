package com.example.administrator.myapplication3.presenter.activity.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.FollowupService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.model.entity.Followup;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactDetailsActivity;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactListActivity;
import com.example.administrator.myapplication3.presenter.activity.contract.ContractListActivity;
import com.example.administrator.myapplication3.presenter.activity.followup.FollowupActivity;
import com.example.administrator.myapplication3.presenter.activity.opportunity.OpportunityListActivity;
import com.example.administrator.myapplication3.presenter.adapter.FollowupAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDetailsActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMap();

                new CustomerService(getApplicationContext()).modifyCustomer(map);

                finish();
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
                (((TextView) findViewById(R.id.remark))).setText(data.getCustomerremarks());
                (((TextView) findViewById(R.id.staff))).setText(data.getStaffid()+"");
                (((TextView) findViewById(R.id.date))).setText(data.getCreatedate()+"");
                (((TextView) findViewById(R.id.id))).setText(data.getCustomerid()+"");

                setSpinner(data.getCustomertype(), data.getCustomerstatus());

                FollowupService cs = new FollowupService(getApplicationContext());




                cs.getFollwup(327, 1, new IUpdateListener<List<Followup>>() {
                    @Override
                    public void success(boolean isSuccess, List<Followup> data) {

                    }

                    @Override
                    public void fail(VolleyError error) {

                    }
                });

            }

            @Override
            public void fail(VolleyError error) {

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.followup:
                Intent intent = new Intent(CustomerDetailsActivity.this, FollowupActivity.class);
                intent.putExtra("sourceid", ((TextView) findViewById(R.id.id)).getText().toString());
                intent.putExtra("sourcetype", "1");
                startActivity(intent);
                return true;
            case R.id.contact:
                intent = new Intent(CustomerDetailsActivity.this, ContactListActivity.class);
                intent.putExtra("customerid", ((TextView) findViewById(R.id.id)).getText().toString());
                startActivity(intent);
                return true;
            case R.id.opportunity:
                intent = new Intent(CustomerDetailsActivity.this, OpportunityListActivity.class);
                intent.putExtra("customerid", ((TextView) findViewById(R.id.id)).getText().toString());
                startActivity(intent);
                return true;
            case R.id.contract:
                intent = new Intent(CustomerDetailsActivity.this, ContractListActivity.class);
                intent.putExtra("customerid", ((TextView) findViewById(R.id.id)).getText().toString());
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setMap(){
        map.put("customername", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("customerid", ((TextView) findViewById(R.id.id)).getText().toString());
        map.put("staffid", ((TextView) findViewById(R.id.staff)).getText().toString());
        map.put("profile", ((TextView) findViewById(R.id.profile)).getText().toString());
        map.put("regionid", ((TextView) findViewById(R.id.region)).getText().toString());
        map.put("parentcustomerid", ((TextView) findViewById(R.id.parentcustomer)).getText().toString());
        map.put("customersource", ((TextView) findViewById(R.id.source)).getText().toString());
        map.put("size", ((TextView) findViewById(R.id.company)).getText().toString());
        map.put("telephone", ((TextView) findViewById(R.id.tel)).getText().toString());
//        map.put("email", ((TextView) findViewById(R.id.email)).getText().toString());
        map.put("website", ((TextView) findViewById(R.id.website)).getText().toString());
        map.put("address", ((TextView) findViewById(R.id.address)).getText().toString());
        map.put("zipcode", ((TextView) findViewById(R.id.zipcode)).getText().toString());
        map.put("customerremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("customertype", ((Spinner) findViewById(R.id.type)).getSelectedItemPosition()+1+"");
        map.put("customerstatus", ((Spinner) findViewById(R.id.status)).getSelectedItemPosition()+1+"");
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
