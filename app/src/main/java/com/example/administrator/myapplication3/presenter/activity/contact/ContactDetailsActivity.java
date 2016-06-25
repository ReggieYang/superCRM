package com.example.administrator.myapplication3.presenter.activity.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactActivity;

import java.util.HashMap;
import java.util.Map;

public class ContactDetailsActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        System.out.println(id);

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setMap();
//                System.out.println(map.get("contactname").toString());
//
//
//                new ContactService(getApplicationContext()).modifyContact(map, 113);

                Intent intent = new Intent(ContactDetailsActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        final ContactService contactService = new ContactService(getApplicationContext());
        contactService.getContact(id, new IUpdateListener<Contact>() {
            @Override

            public void success(boolean isSuccess, Contact data) {

                (((TextView) findViewById(R.id.name))).setText(data.getContactsname());
                (((TextView) findViewById(R.id.customer))).setText(data.getCustomerid()+"");
                (((TextView) findViewById(R.id.gender))).setText(data.getContactsgender());
                (((TextView) findViewById(R.id.mobile))).setText(data.getContactsmobile());
                (((TextView) findViewById(R.id.tel))).setText(data.getContactstelephone());
                (((TextView) findViewById(R.id.email))).setText(data.getContactsemail());
                (((TextView) findViewById(R.id.address))).setText(data.getContactsaddress());
                (((TextView) findViewById(R.id.zipcode))).setText(data.getContactszipcode());
                (((TextView) findViewById(R.id.remark))).setText(data.getContactsremarks());
                (((TextView) findViewById(R.id.wechat))).setText(data.getContactswechat());
                (((TextView) findViewById(R.id.qq))).setText(data.getContactsqq());
                (((TextView) findViewById(R.id.wangwang))).setText(data.getContactswangwang());
                (((TextView) findViewById(R.id.id))).setText(data.getContactsid() + "");

            }

            @Override
            public void fail(VolleyError error) {

            }
        });
        
    }
}
