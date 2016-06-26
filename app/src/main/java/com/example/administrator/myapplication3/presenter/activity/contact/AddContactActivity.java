package com.example.administrator.myapplication3.presenter.activity.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ContactService;


import java.util.HashMap;
import java.util.Map;

public class AddContactActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactService cs = new ContactService(getApplicationContext());
                setMap();
                cs.addContact(map);
                Intent intent = new Intent(AddContactActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
    }
    
    private void setMap(){
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
}
