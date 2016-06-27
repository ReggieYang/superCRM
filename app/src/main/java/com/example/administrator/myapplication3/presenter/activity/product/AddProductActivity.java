package com.example.administrator.myapplication3.presenter.activity.product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ProductService;

import java.util.HashMap;
import java.util.Map;


public class AddProductActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductService ps = new ProductService(getApplicationContext());
                setMap();
                ps.addProduct(map);
//                Intent intent = new Intent(AddProductActivity.this, ProductActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }


    private void setMap(){
        map.put("productname", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("productsn", ((TextView) findViewById(R.id.sn)).getText().toString());
        map.put("standardprice", ((TextView) findViewById(R.id.price)).getText().toString());
        map.put("salesunit", ((TextView) findViewById(R.id.unit)).getText().toString());
        map.put("unitcost", ((TextView) findViewById(R.id.cost)).getText().toString());
        map.put("classification", ((TextView) findViewById(R.id.classification)).getText().toString());
        map.put("introduction", ((TextView) findViewById(R.id.introduction)).getText().toString());
        map.put("productremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("picture", ((TextView) findViewById(R.id.picture)).getText().toString());

    }
}
