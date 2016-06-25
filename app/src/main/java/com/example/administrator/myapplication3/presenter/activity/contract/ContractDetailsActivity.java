package com.example.administrator.myapplication3.presenter.activity.contract;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ContractService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Contract;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContractDetailsActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_details);


        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        System.out.println(id);

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setMap();
//                System.out.println(map.get("contractname").toString());
//
//
//                new ContractService(getApplicationContext()).modifyContract(map, 113);

                Intent intent = new Intent(ContractDetailsActivity.this, ContractActivity.class);
                startActivity(intent);
            }
        });

        final ContractService contractService = new ContractService(getApplicationContext());
        contractService.getContract(id, new IUpdateListener<Contract>() {
            @Override

            public void success(boolean isSuccess, Contract data) {

                (((TextView) findViewById(R.id.name))).setText(data.getContracttitle());
                (((TextView) findViewById(R.id.opportunity))).setText(data.getOpportunityid() + "");
                (((TextView) findViewById(R.id.customer))).setText(data.getCustomerid() + "");
                (((TextView) findViewById(R.id.amount))).setText(data.getTotalamount() + "");
                (((TextView) findViewById(R.id.startdate))).setText(data.getStartdate());
                (((TextView) findViewById(R.id.enddate))).setText(data.getEnddate());
                (((TextView) findViewById(R.id.type))).setText(data.getContracttype() + "");
                (((TextView) findViewById(R.id.paymethod))).setText(data.getPaymethod());
                (((TextView) findViewById(R.id.clientcontractor))).setText(data.getClientcontractor());
                (((TextView) findViewById(R.id.ourcontractor))).setText(data.getOurcontractor());
                (((TextView) findViewById(R.id.staff))).setText(data.getStaffid() + "");
                (((TextView) findViewById(R.id.signingdate))).setText(data.getSigningdate());
                (((TextView) findViewById(R.id.attachment))).setText(data.getAttachment());
                (((TextView) findViewById(R.id.remark))).setText(data.getContractremarks());
                (((TextView) findViewById(R.id.id))).setText(data.getContractid() + "");
                setSpinner(data.getContractstatus());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });



    }


    private void setSpinner(int cstatus){
        Spinner status = (Spinner)findViewById(R.id.status);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("未开始");
        list2.add("执行中");
        list2.add("成功结束");
        list2.add("意外终止");

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
        status.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        status.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        status.setSelection(cstatus - 1);
    }
}
