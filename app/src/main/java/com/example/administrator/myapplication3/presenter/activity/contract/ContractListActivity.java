package com.example.administrator.myapplication3.presenter.activity.contract;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.ContractService;
import com.example.administrator.myapplication3.model.entity.Contract;
import com.example.administrator.myapplication3.presenter.activity.opportunity.OpportunityDetailsActivity;
import com.example.administrator.myapplication3.presenter.adapter.ContractAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractListActivity extends AppCompatActivity {

    private List<Contract> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();

    ContractAdapter adapter;
    private boolean isCustomer = false;
    private boolean isOpportunity = false;

    @Override
    public void onResume(){
        super.onResume();
//        setContentView(R.layout.activity_Contract);
//        ListView listView = (ListView) findViewById(R.id.Contractlist);

        ContractService cs = new ContractService(getApplicationContext());

//        adapter = new ContractAdapter(getApplicationContext(),list);
//        listView.setAdapter(adapter);
//
//        setMap();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ContractActivity.this, AddContractActivity.class);
//                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
//                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
//                startActivity(intent);
//            }
//        });

        cs.getCustomerOpportunityContractList(map, new IUpdateListener<List<Contract>>() {
            @Override
            public void success(boolean isSuccess, List<Contract> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("resume:" + list.get(0).getContracttitle());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("cid:"+getIntent().getStringExtra("customerid"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_list);
        ListView listView = (ListView) findViewById(R.id.contractlist);

        ContractService cs = new ContractService(getApplicationContext());

        adapter = new ContractAdapter(getApplicationContext(),list);
        listView.setAdapter(adapter);

        setMap();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContractListActivity.this, AddContractActivity.class);
                intent.putExtra("customerid", getIntent().getStringExtra("customerid"));
                intent.putExtra("opportunityid", getIntent().getStringExtra("opportunityid"));
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContractListActivity.this, ContractDetailsActivity.class);
                intent.putExtra("id", list.get(position).getContractid() + "");
                startActivity(intent);
            }
        });

        cs.getCustomerOpportunityContractList(map, new IUpdateListener<List<Contract>>() {
            @Override
            public void success(boolean isSuccess, List<Contract> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("create:" + list.get(0).getContracttitle());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    public void setMap(){


        if(getIntent().getStringExtra("customerid")!=null){
            map.put("customerid", getIntent().getStringExtra("customerid"));
            isCustomer = true;
            isOpportunity = false;
        }

        if(getIntent().getStringExtra("opportunityide")!=null){
            map.put("opportunityid", getIntent().getStringExtra("opportunityid"));
            isCustomer = false;
            isOpportunity = true;
        }

    }
}
