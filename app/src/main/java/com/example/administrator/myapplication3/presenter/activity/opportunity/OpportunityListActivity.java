package com.example.administrator.myapplication3.presenter.activity.opportunity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Opportunity;
import com.example.administrator.myapplication3.presenter.adapter.OpportunityAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpportunityListActivity extends AppCompatActivity {
    private List<Opportunity> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();

    OpportunityAdapter adapter;


    @Override
    public void onResume(){
        super.onResume();
//        setContentView(R.layout.activity_Opportunity);
//        ListView listView = (ListView) findViewById(R.id.Opportunitylist);

        OpportunityService cs = new OpportunityService(getApplicationContext());

//        adapter = new OpportunityAdapter(getApplicationContext(),list);
//        listView.setAdapter(adapter);
//
//        setMap();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(OpportunityActivity.this, AddOpportunityActivity.class);
//                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
//                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
//                startActivity(intent);
//            }
//        });

        cs.getCustomerOpportunityList(map, new IUpdateListener<List<Opportunity>>() {
            @Override
            public void success(boolean isSuccess, List<Opportunity> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("resume:" + list.get(0).getOpportunitytitle());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_list);
        ListView listView = (ListView) findViewById(R.id.opportunitylist);

        OpportunityService cs = new OpportunityService(getApplicationContext());

        adapter = new OpportunityAdapter(getApplicationContext(),list);
        listView.setAdapter(adapter);

        setMap();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpportunityListActivity.this, AddOpportunityActivity.class);
                intent.putExtra("customerid", getIntent().getStringExtra("customerid"));
                startActivity(intent);
            }
        });

        cs.getCustomerOpportunityList(map, new IUpdateListener<List<Opportunity>>() {
            @Override
            public void success(boolean isSuccess, List<Opportunity> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("create:" + list.get(0).getOpportunitytitle());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    public void setMap(){
        map.put("customerid", getIntent().getStringExtra("customerid"));
    }
}
