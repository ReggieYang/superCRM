package com.example.administrator.myapplication3.presenter.activity.opportunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.net.MyJsonRequest;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Opportunity;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpportunityDetailsActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_details);

//        int id = Integer.parseInt(getIntent().getStringExtra("id"));

        int id = 159;


        Button button = (Button)findViewById(R.id.modify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMap();

 //               new OpportunityService(getApplicationContext()).modifyOpportunity(map, 113);

                Intent intent = new Intent(OpportunityDetailsActivity.this, OpportunityActivity.class);
                startActivity(intent);
            }
        });

        final OpportunityService customerService = new OpportunityService(getApplicationContext());
        customerService.getOpportunity(id, new IUpdateListener<Opportunity>() {
            @Override

            public void success(boolean isSuccess, Opportunity data) {

                (((TextView) findViewById(R.id.name))).setText(data.getOpportunitytitle());
                (((TextView) findViewById(R.id.customer))).setText(data.getCustomerid());
                (((TextView) findViewById(R.id.amount))).setText(data.getEstimatedamount() + "");
                (((TextView) findViewById(R.id.success))).setText(data.getSuccessrate() + "");
                (((TextView) findViewById(R.id.signingdate))).setText(data.getExpecteddate());
                (((TextView) findViewById(R.id.channel))).setText(data.getChannel());
                (((TextView) findViewById(R.id.type))).setText(data.getBusinesstype());
                (((TextView) findViewById(R.id.acquisitiondate))).setText(data.getAcquisitiondate());
                (((TextView) findViewById(R.id.source))).setText(data.getOpportunitiessource());
                (((TextView) findViewById(R.id.remark))).setText(data.getOpportunityremarks());
                (((TextView) findViewById(R.id.staffid))).setText(data.getStaffid() + "");
                (((TextView) findViewById(R.id.id))).setText(data.getOpportunityid() + "");

                setSpinner(data.getOpportunitystatus());
            }

            @Override
            public void fail(VolleyError error) {

            }
        });





    }

    private void setSpinner(int cstatus){
        Spinner status = (Spinner)findViewById(R.id.status);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("初步洽谈");
        list2.add("需求确定");
        list2.add("方案报价");
        list2.add("谈判合同");
        list2.add("赢单");
        list2.add("输单");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        status.setAdapter(adapter2);

        status.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //               myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        status.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        status.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        status.setSelection(cstatus-1);
    }


    private void setMap(){
        map.put("opportunitytitle", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("opportunityid", ((TextView) findViewById(R.id.id)).getText().toString());
        map.put("customerid", ((TextView) findViewById(R.id.customer)).getText().toString());
        map.put("estimatedamount", ((TextView) findViewById(R.id.amount)).getText().toString());
        map.put("successrate", ((TextView) findViewById(R.id.success)).getText().toString());
        map.put("expecteddate", ((TextView) findViewById(R.id.signingdate)).getText().toString());
        map.put("opportunitystatus", ((TextView) findViewById(R.id.status)).getText().toString());
        map.put("channel", ((TextView) findViewById(R.id.channel)).getText().toString());
        map.put("businesstype", ((TextView) findViewById(R.id.type)).getText().toString());
        map.put("acquisitiondate", ((TextView) findViewById(R.id.acquisitiondate)).getText().toString());
        map.put("opportunitiessource", ((TextView) findViewById(R.id.source)).getText().toString());
        map.put("opportunityremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("staffid", "113");
    }
}
