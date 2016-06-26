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


    private void setMap(){
        map.put("contactsid", ((TextView) findViewById(R.id.id)).getText().toString());
        map.put("contactsname", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("contactsage", ((TextView) findViewById(R.id.age)).getText().toString());
        map.put("contactsgender", ((TextView) findViewById(R.id.gender)).getText().toString());
        map.put("contactsmobile", ((TextView) findViewById(R.id.mobile)).getText().toString());
        map.put("contactstelephone", ((TextView) findViewById(R.id.tel)).getText().toString());
        map.put("contactsemail", ((TextView) findViewById(R.id.email)).getText().toString());
        map.put("contactsaddress", ((TextView) findViewById(R.id.address)).getText().toString());
        map.put("contactszipcode", ((TextView) findViewById(R.id.zipcode)).getText().toString());
        map.put("contactsqq", ((TextView) findViewById(R.id.qq)).getText().toString());
        map.put("contactswechat", ((TextView) findViewById(R.id.wechat)).getText().toString());
        map.put("contactswangwang", ((TextView) findViewById(R.id.wangwang)).getText().toString());
        map.put("contactsdeptname", ((TextView) findViewById(R.id.department)).getText().toString());
        map.put("contactsposition", ((TextView) findViewById(R.id.position)).getText().toString());
        map.put("contactsremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("customerid", ((TextView) findViewById(R.id.customer)).getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));


        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMap();

                new ContactService(getApplicationContext()).modifyContact(map);
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
                (((TextView) findViewById(R.id.age))).setText(data.getContactsage()+"");
                (((TextView) findViewById(R.id.position))).setText(data.getContactsposition()+"");
                (((TextView) findViewById(R.id.department))).setText(data.getContactsdeptname());

            }

            @Override
            public void fail(VolleyError error) {

            }
        });
        
    }
}
