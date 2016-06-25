package com.example.administrator.myapplication3.presenter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.presenter.activity.business.BusinessActivity;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactActivity;
import com.example.administrator.myapplication3.presenter.activity.contract.ContractActivity;
import com.example.administrator.myapplication3.presenter.activity.customer.CustomerActivity;
import com.example.administrator.myapplication3.presenter.activity.opportunity.OpportunityActivity;
import com.example.administrator.myapplication3.presenter.activity.product.ProductActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//         String[] data = { "商机", "客户", "合同", "业务管理","联系人", "产品" };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                LoginActivity.this, android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        ImageButton button1 = (ImageButton) findViewById(R.id.button_customer);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.button_contact);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button3 = (ImageButton) findViewById(R.id.button_contract);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ContractActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button4 = (ImageButton) findViewById(R.id.button_opportunity);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, OpportunityActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button5 = (ImageButton) findViewById(R.id.button_product);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button6 = (ImageButton) findViewById(R.id.button_business);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, BusinessActivity.class);
                startActivity(intent);
            }
        });




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }

        return true;
    }






}
