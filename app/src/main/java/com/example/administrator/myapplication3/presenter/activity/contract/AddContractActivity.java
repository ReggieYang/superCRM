package com.example.administrator.myapplication3.presenter.activity.contract;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ContractService;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddContractActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public Calendar calendar;
    private Button startdate;
    private Button starttime;
    private Button enddate;
    private Button endtime;
    private Button sidate;
    private Button sitime;
    public final static int DATE_PICKER=9527;
    public final static int TIME_PICKER=9528;
    public DatePickerDialog mDatePickerDialog;
    public TimePickerDialog mTimePickerDialog;
    public DatePickerDialog mDatePickerDialog2;
    public TimePickerDialog mTimePickerDialog2;
    public DatePickerDialog mDatePickerDialog3;
    public TimePickerDialog mTimePickerDialog3;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener2;
    private DatePickerDialog.OnDateSetListener mDateSetListener3;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener3;
    public boolean isCreatePickerDialog=true;
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contract);

        init();
        setSpinner(1);


        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContractService cs = new ContractService(getApplicationContext());
                setMap();
                cs.addContract(map);
//                Intent intent = new Intent(AddContractActivity.this, ContractActivity.class);
//                startActivity(intent);
                finish();
            }
        });
        

    }


    private void setMap(){
        map.put("contracttitle", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("customerid", ((TextView) findViewById(R.id.customer)).getText().toString());
        map.put("opportunityid", ((TextView) findViewById(R.id.opportunity)).getText().toString());
        map.put("totalamount", ((TextView) findViewById(R.id.amount)).getText().toString());
        map.put("contractnumber", ((TextView) findViewById(R.id.number)).getText().toString());
        map.put("contracttype", ((TextView) findViewById(R.id.type)).getText().toString());
        map.put("paymethod", ((TextView) findViewById(R.id.paymethod)).getText().toString());
        map.put("clientcontractor", ((TextView) findViewById(R.id.clientcontractor)).getText().toString());
        map.put("ourcontractor", ((TextView) findViewById(R.id.ourcontractor)).getText().toString());
        map.put("staffid", ((TextView) findViewById(R.id.staff)).getText().toString());
        map.put("attachment", ((TextView) findViewById(R.id.attachment)).getText().toString());
        map.put("contractremarks", ((TextView) findViewById(R.id.remark)).getText().toString());

        map.put("contractstatus", ((Spinner) findViewById(R.id.status)).getSelectedItemPosition() + 1 + "");
        String sd = ((Button) findViewById(R.id.startdate)).getText().toString() + " " + ((Button) findViewById(R.id.starttime)).getText().toString();
        String ed = ((Button) findViewById(R.id.enddate)).getText().toString() + " " + ((Button) findViewById(R.id.endtime)).getText().toString();
        String sid = ((Button) findViewById(R.id.sidate)).getText().toString() + " " + ((Button) findViewById(R.id.sitime)).getText().toString();
        map.put("startdate", sd);
        map.put("enddate", ed);
        map.put("signingdate", sid);
    }

    private void init(){
        startdate =(Button) findViewById(R.id.startdate);
        startdate.setOnClickListener(new OnClickListenerImpl());
        getCurrentTime();
        startdate.setText(year + "-" + (month + 1) + "-" + day);

        starttime =(Button) findViewById(R.id.starttime);
        starttime.setOnClickListener(new OnClickListenerImpl());
        starttime.setText(hour + ":" + minute + ":00");

        enddate =(Button) findViewById(R.id.enddate);
        enddate.setOnClickListener(new OnClickListenerImpl());
        getCurrentTime();
        enddate.setText(year + "-" + (month + 1) + "-" + day);

        endtime =(Button) findViewById(R.id.endtime);
        endtime.setOnClickListener(new OnClickListenerImpl());
        endtime.setText(hour + ":" + minute + ":00");

        sidate =(Button) findViewById(R.id.sidate);
        sidate.setOnClickListener(new OnClickListenerImpl());
        getCurrentTime();
        sidate.setText(year + "-" + (month + 1) + "-" + day);

        sitime =(Button) findViewById(R.id.sitime);
        sitime.setOnClickListener(new OnClickListenerImpl());
        sitime.setText(hour + ":" + minute + ":00");


        //监听DatePicker的set按钮
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear,int dayOfMonth) {
                startdate.setText(year2 + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                year = year2;
                month = monthOfYear+1;
                day = dayOfMonth;

            }
        };

        //监听TimePicker的set按钮
        mTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute2) {
                starttime.setText(hourOfDay + ":" + minute2 + ":00");
                hour = hourOfDay;
                minute = minute2;

            }
        };


        //监听DatePicker的set按钮
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear,int dayOfMonth) {
                enddate.setText(year2 + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                year = year2;
                month = monthOfYear+1;
                day = dayOfMonth;

            }
        };

        //监听TimePicker的set按钮
        mTimeSetListener2 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute2) {
                endtime.setText(hourOfDay + ":" + minute2 + ":00");
                hour = hourOfDay;
                minute = minute2;

            }
        };


        mDateSetListener3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear,int dayOfMonth) {
                sidate.setText(year2 + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                year = year2;
                month = monthOfYear+1;
                day = dayOfMonth;

            }
        };

        //监听TimePicker的set按钮
        mTimeSetListener3 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute2) {
                sitime.setText(hourOfDay + ":" + minute2 + ":00");
                hour = hourOfDay;
                minute = minute2;

            }
        };


    }


    private class OnClickListenerImpl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.startdate:
                    showDialog(DATE_PICKER);
                    break;
                case R.id.starttime:
                    showDialog(TIME_PICKER);
                    break;
                case R.id.enddate:
                    showDialog(0);
                    break;
                case R.id.endtime:
                    showDialog(1);
                    break;
                case R.id.sidate:
                    showDialog(2);
                    break;
                case R.id.sitime:
                    showDialog(3);
                    break;
                default:
                    break;
            }
        }
    }




    @Override
    protected Dialog onCreateDialog(int id) {
        getCurrentTime();
        switch (id) {
            case DATE_PICKER:
                mDatePickerDialog=new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, mDateSetListener, year, month, day);
                return mDatePickerDialog;
            case TIME_PICKER:
                mTimePickerDialog=new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mTimeSetListener, hour, minute, true);
                return mTimePickerDialog;
            case 0:
                mDatePickerDialog2=new DatePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mDateSetListener2, year, month, day);
                return mDatePickerDialog2;
            case 1:
                mTimePickerDialog2=new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mTimeSetListener2, hour, minute, true);
                return mTimePickerDialog2;
            case 2:
                mDatePickerDialog3=new DatePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mDateSetListener3, year, month, day);
                return mDatePickerDialog3;
            case 3:
                mTimePickerDialog3=new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mTimeSetListener3, hour, minute, true);
                return mTimePickerDialog3;
            default:
                break;
        }
        return super.onCreateDialog(id);
    }

    //覆写Activty的onPrepareDialog(int id, Dialog dialog)方法
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        if (!isCreatePickerDialog) {
            getCurrentTime();
            switch (id) {
                case DATE_PICKER:
                    String ed = startdate.getText().toString();
                    String eds[] = ed.split("-");
                    year = Integer.parseInt(eds[0]);
                    month = Integer.parseInt(eds[1]);
                    day = Integer.parseInt(eds[2]);
                    mDatePickerDialog.updateDate(year, month-1, day);
                    break;
                case TIME_PICKER:
                    ed = starttime.getText().toString();
                    eds = ed.split(":");
                    hour = Integer.parseInt(eds[0]);
                    minute = Integer.parseInt(eds[1]);
                    mTimePickerDialog.updateTime(hour, minute);
                    break;
                case 0:
                    ed = enddate.getText().toString();
                    eds = ed.split("-");
                    year = Integer.parseInt(eds[0]);
                    month = Integer.parseInt(eds[1]);
                    day = Integer.parseInt(eds[2]);
                    mDatePickerDialog2.updateDate(year, month-1, day);
                    break;
                case 1:
                    ed = endtime.getText().toString();
                    eds = ed.split(":");
                    hour = Integer.parseInt(eds[0]);
                    minute = Integer.parseInt(eds[1]);
                    mTimePickerDialog2.updateTime(hour, minute);
                    break;
                case 2:
                    ed = sidate.getText().toString();
                    eds = ed.split("-");
                    year = Integer.parseInt(eds[0]);
                    month = Integer.parseInt(eds[1]);
                    day = Integer.parseInt(eds[2]);
                    mDatePickerDialog3.updateDate(year, month-1, day);
                    break;
                case 3:
                    ed = sitime.getText().toString();
                    eds = ed.split(":");
                    hour = Integer.parseInt(eds[0]);
                    minute = Integer.parseInt(eds[1]);
                    mTimePickerDialog3.updateTime(hour, minute);
                    break;
                default:
                    break;
            }
        }
        isCreatePickerDialog = false;
    }

    private void getCurrentTime(){
        //设置时间为中国
        calendar = Calendar.getInstance(Locale.CHINA);
        //获取日期
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

    }

    private void setSpinner(int cstatus){
        Spinner status = (Spinner)findViewById(R.id.status);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("未开始");
        list2.add("执行中");
        list2.add("成功结束");
        list2.add("意外终止");

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
        status.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        status.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        status.setSelection(cstatus - 1);
    }


}
    
