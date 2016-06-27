package com.example.administrator.myapplication3.presenter.activity.contact;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.presenter.adapter.ContactAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactListActivity extends AppCompatActivity {

    private List<Contact> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();

    ContactAdapter adapter;


    @Override
    public void onResume(){
        super.onResume();
//        setContentView(R.layout.activity_Contact);
//        ListView listView = (ListView) findViewById(R.id.Contactlist);

        ContactService cs = new ContactService(getApplicationContext());

//        adapter = new ContactAdapter(getApplicationContext(),list);
//        listView.setAdapter(adapter);
//
//        setMap();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ContactActivity.this, AddContactActivity.class);
//                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
//                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
//                startActivity(intent);
//            }
//        });

        cs.getCustomerContactList(map, new IUpdateListener<List<Contact>>() {
            @Override
            public void success(boolean isSuccess, List<Contact> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("resume:" + list.get(0).getContactsname());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ListView listView = (ListView) findViewById(R.id.contactlist);

        ContactService cs = new ContactService(getApplicationContext());

        adapter = new ContactAdapter(getApplicationContext(),list);
        listView.setAdapter(adapter);

        setMap();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactListActivity.this, AddContactActivity.class);
                intent.putExtra("sourceid", getIntent().getStringExtra("sourceid"));
                intent.putExtra("sourcetype", getIntent().getStringExtra("sourcetype"));
                startActivity(intent);
            }
        });

        cs.getCustomerContactList(map, new IUpdateListener<List<Contact>>() {
            @Override
            public void success(boolean isSuccess, List<Contact> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                System.out.println("create:" + list.get(0).getContactsname());
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
