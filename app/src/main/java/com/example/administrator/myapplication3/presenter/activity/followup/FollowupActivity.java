package com.example.administrator.myapplication3.presenter.activity.followup;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.FollowupService;
import com.example.administrator.myapplication3.model.entity.Followup;
import com.example.administrator.myapplication3.presenter.activity.customer.AddCustomerActivity;
import com.example.administrator.myapplication3.presenter.adapter.FollowupAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowupActivity extends AppCompatActivity {

    private List<Followup> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();

    FollowupAdapter adapter;


    @Override
    public void onResume(){
        super.onResume();
//        setContentView(R.layout.activity_followup);
//        ListView listView = (ListView) findViewById(R.id.followuplist);

        FollowupService cs = new FollowupService(getApplicationContext());

//        adapter = new FollowupAdapter(getApplicationContext(),list);
//        listView.setAdapter(adapter);
//
//        setMap();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FollowupActivity.this, AddFollowupActivity.class);
//                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
//                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
//                startActivity(intent);
//            }
//        });

        cs.accessAPI(map, new IUpdateListener<List<Followup>>() {
            @Override
            public void success(boolean isSuccess, List<Followup> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("resume:"+list.size());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_followup);
            ListView listView = (ListView) findViewById(R.id.followuplist);

            FollowupService cs = new FollowupService(getApplicationContext());

            adapter = new FollowupAdapter(getApplicationContext(),list);
            listView.setAdapter(adapter);

            setMap();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FollowupActivity.this, AddFollowupActivity.class);
                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
                startActivity(intent);
            }
        });

            cs.accessAPI(map, new IUpdateListener<List<Followup>>() {
                @Override
                public void success(boolean isSuccess, List<Followup> data) {
                    list.clear();
                    list.addAll(data);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void fail(VolleyError error) {

                }
            });
        }

    public void setMap(){
        System.out.println("sourceid:"+getIntent().getStringExtra("sourceid"));
        map.put("sourceid", getIntent().getStringExtra("sourceid"));
        map.put("sourcetype", getIntent().getStringExtra("sourcetype"));
    }


    //    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_followup);
//    }


//    @Override
//    public void onResume(){
//        super.onResume();
//        FollowupService cs = new FollowupService(getApplicationContext());
//
//        cs.getFollwup(1 , 1, new IUpdateListener<List<Followup>>() {
//            @Override
//            public void success(boolean isSuccess, List<Followup> data) {
//                list.clear();
//                list.addAll(data);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void fail(VolleyError error) {
//
//            }
//        });
//    }

//    }
}
