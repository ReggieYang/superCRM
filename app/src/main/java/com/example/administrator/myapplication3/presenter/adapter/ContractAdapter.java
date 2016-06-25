package com.example.administrator.myapplication3.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Contract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class ContractAdapter extends ArrayAdapter<Contract>{


    private List<Contract> objects;

    public ContractAdapter(Context context, List<Contract> objects) {
        super(context, R.layout.item_common_listview, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        View view;
        Contract contract = objects.get(position);
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

        holderView.name.setText(contract.getContracttitle());
        holderView.status.setText(parseStatus(contract.getContractstatus()));

        return view;
    }


    private String parseStatus(int st){
        switch (st){
            case 1:
                return "未开始";

            case 2:
                return "执行中";

            case 3:
                return "成功结束";

            case 4:
                return "意外终止";

            case 5:
                return "未知";

            default:
                return "未知";

        }
    }


    class HolderView{
        TextView name;
        TextView status;
    }
    
}
