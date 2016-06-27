package com.example.administrator.myapplication3.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Followup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class FollowupAdapter  extends ArrayAdapter<Followup> {


    private List<Followup> objects;

    public FollowupAdapter(Context context, List<Followup> objects) {
        super(context, R.layout.item_followup, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        View view;
        Followup followup = objects.get(position);
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_followup, parent, false);
            holderView = new HolderView();
            holderView.content = (TextView)view.findViewById(R.id.content);
            holderView.createtime = (TextView)view.findViewById(R.id.createtime);
            holderView.creator = (TextView)view.findViewById(R.id.creator);
            view.setTag(holderView);
        }
        else{
            view = convertView;
            holderView = (HolderView) view.getTag();
        }



        holderView.createtime.setText(followup.getCreatetime());
        holderView.creator.setText(followup.getCreatorid()+"");
        holderView.content.setText(followup.getContent());

        System.out.println("createtorid:" + holderView.creator.getText().toString());

        return view;
    }



    class HolderView{
        TextView createtime;
        TextView creator;
        TextView content;
    }
}
