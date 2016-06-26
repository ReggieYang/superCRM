package com.example.administrator.myapplication3.presenter.activity.product;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ProductService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Product;
import com.example.administrator.myapplication3.presenter.activity.product.ProductActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ProductDetailsActivity extends AppCompatActivity {


    private Map<String, String> map = new HashMap<String, String>();

    private void setMap(){
        map.put("productname", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("productsn", ((TextView) findViewById(R.id.sn)).getText().toString());
        map.put("standardprice", ((TextView) findViewById(R.id.price)).getText().toString());
        map.put("salesunit", ((TextView) findViewById(R.id.unit)).getText().toString());
        map.put("unitcost", ((TextView) findViewById(R.id.cost)).getText().toString());
        map.put("classification", ((TextView) findViewById(R.id.classification)).getText().toString());
        map.put("introduction", ((TextView) findViewById(R.id.introduction)).getText().toString());
        map.put("productremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("productid", ((TextView) findViewById(R.id.id)).getText().toString());
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        final ImageView imageView = (ImageView) findViewById(R.id.productpicture);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMap();
                new ProductService(getApplicationContext()).modifyProduct(map);
//                Intent intent = new Intent(ProductDetailsActivity.this, ProductActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        final ProductService productService = new ProductService(getApplicationContext());
        productService.getProduct(id, new IUpdateListener<Product>() {
            @Override

            public void success(boolean isSuccess, Product data) {

                (((TextView) findViewById(R.id.name))).setText(data.getProductname());
                (((TextView) findViewById(R.id.sn))).setText(data.getProductsn());
                (((TextView) findViewById(R.id.price))).setText(data.getStandardprice() + "");
                (((TextView) findViewById(R.id.unit))).setText(data.getSalesunit());
                (((TextView) findViewById(R.id.cost))).setText(data.getUnitcost() + "");
                (((TextView) findViewById(R.id.classification))).setText(data.getClassification());
                (((TextView) findViewById(R.id.remark))).setText(data.getProductremarks());
                (((TextView) findViewById(R.id.introduction))).setText(data.getIntroduction());
                (((TextView) findViewById(R.id.id))).setText(data.getProductid() + "");


                ImageRequest imageRequest = new ImageRequest(
                        data.getPitcure(),
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                imageView.setImageBitmap(response);
                            }
                        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
                mQueue.add(imageRequest);

            }

            @Override
            public void fail(VolleyError error) {

            }
        });
        
    }
}
