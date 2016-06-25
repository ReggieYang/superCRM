package com.example.administrator.myapplication3.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Opportunity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/21.
 */
public class OpportunityAdapter extends ArrayAdapter<Opportunity>{

    private List<Opportunity> objects;

    public OpportunityAdapter(Context context, List<Opportunity> objects) {
        super(context, R.layout.item_common_listview, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        View view;
        Opportunity opportunity = objects.get(position);
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_common_listview, parent, false);
            holderView = new HolderView();
            holderView.status = (TextView)view.findViewById(R.id.status);
            holderView.name = (TextView)view.findViewById(R.id.name);
            view.setTag(holderView);
        }
        else{
            view = convertView;
            holderView = (HolderView) view.getTag();
        }

        holderView.name.setText(opportunity.getOpportunitytitle());
        holderView.status.setText(parseStatus(opportunity.getOpportunitystatus()));

        return view;
    }


    private String parseStatus(int st){
        switch (st){
            case 1:
                return "初步洽谈";

            case 2:
                return "需求确定";

            case 3:
                return "方案报价";

            case 4:
                return "谈判合同";

            case 5:
                return "赢单";

            case 6:
                return "输单";

            default:
                return "未知";

        }
    }


    class HolderView{
        TextView name;
        TextView status;
    }

}
