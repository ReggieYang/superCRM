package com.example.administrator.myapplication3.presenter.activity.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication3.R;

import java.util.HashMap;
import java.util.Map;

public class ProductDetailsActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
    }
}
