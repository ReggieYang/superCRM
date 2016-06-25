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


    /**
     * 从服务器取图片
     *http://bbs.3gstdy.com
     * @param url
     * @return
     */
    public static Bitmap getHttpBitmap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {

            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setConnectTimeout(0);
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork()
//                .penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
//                .penaltyLog().penaltyDeath().build());

        final ImageView imageView = (ImageView) findViewById(R.id.productpicture);
//        Bitmap bitmap =  getHttpBitmap("http://img4.duitang.com/uploads/item/201407/08/20140708101547_c8MAA.jpeg");
//        image1.setImageBitmap(bitmap);



        ImageRequest imageRequest = new ImageRequest(
                "http://img4.duitang.com/uploads/item/201407/08/20140708101547_c8MAA.jpeg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.drawable.busbtn);
            }
        });

        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        mQueue.add(imageRequest);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        System.out.println(id);

        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setMap();
//                System.out.println(map.get("productname").toString());
//
//
//                new ProductService(getApplicationContext()).modifyProduct(map, 113);

                Intent intent = new Intent(ProductDetailsActivity.this, ProductActivity.class);
                startActivity(intent);
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
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
        
    }
}
