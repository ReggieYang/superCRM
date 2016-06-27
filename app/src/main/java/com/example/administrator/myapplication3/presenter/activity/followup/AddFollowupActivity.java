package com.example.administrator.myapplication3.presenter.activity.followup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.FollowupService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddFollowupActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_followup);

        String sourceid = getIntent().getStringExtra("sourceid");
        String sourcetype = getIntent().getStringExtra("sourcetype");

        ((TextView) findViewById(R.id.source)).setText(sourceid);
        ((TextView) findViewById(R.id.sourcetype)).setText(sourcetype);
        
        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FollowupService cs = new FollowupService(getApplicationContext());
                setMap();
                cs.addFollowup(map);
//                Intent intent = new Intent(AddFollowupActivity.this, FollowupActivity.class);
//                startActivity(intent);
                finish();
            }
        });


    }


    private void setMap(){
        map.put("sourceid", ((TextView) findViewById(R.id.source)).getText().toString());
        map.put("sourcetype", ((TextView) findViewById(R.id.sourcetype)).getText().toString());
        map.put("followuptype", ((TextView) findViewById(R.id.type)).getText().toString());
        map.put("content", ((TextView) findViewById(R.id.content)).getText().toString());
        map.put("followupremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("creatorid", ((TextView) findViewById(R.id.staff)).getText().toString());

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentdate = sdf.format(new Date());
        map.put("createdate", currentdate);
    }
}
