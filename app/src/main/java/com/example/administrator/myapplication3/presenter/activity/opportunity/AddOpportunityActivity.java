package com.example.administrator.myapplication3.presenter.activity.opportunity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddOpportunityActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<String, String>();
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public Calendar calendar;
    private Button mDatePickerButton;
    private Button mTimePickerButton;
    private Button acdate;
    private Button actime;
    public final static int DATE_PICKER=9527;
    public final static int TIME_PICKER=9528;
    public DatePickerDialog mDatePickerDialog;
    public TimePickerDialog mTimePickerDialog;
    public DatePickerDialog mDatePickerDialog2;
    public TimePickerDialog mTimePickerDialog2;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private DatePickerDialog.OnDateSetListener acdateListener;
    private TimePickerDialog.OnTimeSetListener actimeListener;
    public boolean isCreatePickerDialog=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_opportunity);
        init();

        setSpinner(1);

        Button button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpportunityService os = new OpportunityService(getApplicationContext());
                setMap();
                os.addOpportunity(map);
                Intent intent = new Intent(AddOpportunityActivity.this, OpportunityActivity.class);
                startActivity(intent);
            }
        });
        
        
    }

    private void setMap(){
        map.put("opportunitytitle", ((TextView) findViewById(R.id.name)).getText().toString());
        map.put("customerid", ((TextView) findViewById(R.id.customer)).getText().toString());
        map.put("estimatedamount", ((TextView) findViewById(R.id.amount)).getText().toString());
        map.put("successrate", ((TextView) findViewById(R.id.success)).getText().toString());
        map.put("channel", ((TextView) findViewById(R.id.channel)).getText().toString());
        map.put("businesstype", ((TextView) findViewById(R.id.type)).getText().toString());
        map.put("opportunitiessource", ((TextView) findViewById(R.id.source)).getText().toString());
        map.put("opportunityremarks", ((TextView) findViewById(R.id.remark)).getText().toString());
        map.put("staffid", ((TextView) findViewById(R.id.staffid)).getText().toString()+"");
        map.put("opportunitystatus", ((Spinner) findViewById(R.id.status)).getSelectedItemPosition() + 1 + "");
        String exdate = ((Button) findViewById(R.id.datePickButton)).getText().toString() + " " + ((Button) findViewById(R.id.timePickButton)).getText().toString();
        String acdate = ((Button) findViewById(R.id.acdate)).getText().toString() + " " + ((Button) findViewById(R.id.actime)).getText().toString();
        map.put("acquisitiondate", acdate);
        map.put("expecteddate", exdate);
    }
    
    private void init(){
        mDatePickerButton=(Button) findViewById(R.id.datePickButton);
        mDatePickerButton.setOnClickListener(new OnClickListenerImpl());
        getCurrentTime();
        mDatePickerButton.setText(year + "-" + (month + 1) + "-" + day);

        mTimePickerButton=(Button) findViewById(R.id.timePickButton);
        mTimePickerButton.setOnClickListener(new OnClickListenerImpl());
        mTimePickerButton.setText( hour + ":" + minute + ":00");

        acdate=(Button) findViewById(R.id.acdate);
        acdate.setOnClickListener(new OnClickListenerImpl());
        getCurrentTime();
        acdate.setText(year + "-" + (month + 1) + "-" + day);

        actime=(Button) findViewById(R.id.actime);
        actime.setOnClickListener(new OnClickListenerImpl());
        actime.setText( hour + ":" + minute + ":00");


        //监听DatePicker的set按钮
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear,int dayOfMonth) {
                mDatePickerButton.setText(year2 + "-" + (monthOfYear+1) + "-" + dayOfMonth);
                year = year2;
                month = monthOfYear+1;
                day = dayOfMonth;
                System.out.println("---> 设置后: year="+year2+", month="+monthOfYear+",day="+dayOfMonth);
            }
        };

        //监听TimePicker的set按钮
        mTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute2) {
                mTimePickerButton.setText(hourOfDay + ":" + minute2 + ":00");
                hour = hourOfDay;
                minute = minute2;
                System.out.println("---> 设置后: hour="+hourOfDay+",minute="+minute2);
            }
        };


        //监听DatePicker的set按钮
        acdateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear,int dayOfMonth) {
                acdate.setText(year2 + "-" + (monthOfYear+1) + "-" + dayOfMonth);
                year = year2;
                month = monthOfYear+1;
                day = dayOfMonth;
                System.out.println("---> 设置后: year="+year2+", month="+monthOfYear+",day="+dayOfMonth);
            }
        };

        //监听TimePicker的set按钮
        actimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute2) {
                actime.setText(hourOfDay + ":" + minute2 + ":00");
                hour = hourOfDay;
                minute = minute2;
                System.out.println("---> 设置后: hour="+hourOfDay+",minute="+minute2);
            }
        };


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
        status.setOnTouchListener(new Spinner.OnTouchListener() {
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


    private class OnClickListenerImpl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.datePickButton:
                    showDialog(DATE_PICKER);
                    break;
                case R.id.timePickButton:
                    showDialog(TIME_PICKER);
                    break;
                case R.id.acdate:
                    showDialog(0);
                    break;
                case R.id.actime:
                    showDialog(1);
                    break;
                default:
                    break;
            }
        }
    }




    @Override
    protected Dialog onCreateDialog(int id) {
        System.out.println("---> onCreateDialog()");
        getCurrentTime();
        switch (id) {
            case DATE_PICKER:
                mDatePickerDialog=new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, mDateSetListener, year, month, day);
                return mDatePickerDialog;
            case TIME_PICKER:
                mTimePickerDialog=new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, mTimeSetListener, hour, minute, true);
                return mTimePickerDialog;
            case 0:
                mDatePickerDialog2=new DatePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, acdateListener, year, month, day);
                return mDatePickerDialog2;
            case 1:
                mTimePickerDialog2=new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, actimeListener, hour, minute, true);
                return mTimePickerDialog2;
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
                    String ed = mDatePickerButton.getText().toString();
                    String eds[] = ed.split("-");
                    year = Integer.parseInt(eds[0]);
                    month = Integer.parseInt(eds[1]);
                    day = Integer.parseInt(eds[2]);
                    mDatePickerDialog.updateDate(year, month-1, day);
                    break;
                case TIME_PICKER:
                    ed = mTimePickerButton.getText().toString();
                    eds = ed.split(":");
                    hour = Integer.parseInt(eds[0]);
                    minute = Integer.parseInt(eds[1]);
                    mTimePickerDialog.updateTime(hour, minute);
                    break;
                case 0:
                    ed = acdate.getText().toString();
                    eds = ed.split("-");
                    year = Integer.parseInt(eds[0]);
                    month = Integer.parseInt(eds[1]);
                    day = Integer.parseInt(eds[2]);
                    mDatePickerDialog2.updateDate(year, month-1, day);
                    break;
                case 1:
                    ed = actime.getText().toString();
                    eds = ed.split(":");
                    hour = Integer.parseInt(eds[0]);
                    minute = Integer.parseInt(eds[1]);
                    mTimePickerDialog2.updateTime(hour, minute);
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
        System.out.println("-----> 获取当前时间 year="+year+",month="+month+",day="+day+",hour="+hour+",minute="+minute);
    }



}
