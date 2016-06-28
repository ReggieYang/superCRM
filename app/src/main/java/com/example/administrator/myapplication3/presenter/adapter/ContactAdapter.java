package com.example.administrator.myapplication3.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Contact;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {
    private List<Contact> objects;

    public ContactAdapter(Context context, List<Contact> objects) {
        super(context, R.layout.item_common_listview, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        View view;
        Contact contact = objects.get(position);
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

        holderView.name.setText(contact.getContactsname());
        holderView.status.setText(contact.getCustomername());

        return view;
    }


//    private String parseStatus(int st){
//        switch (st){
//            case 1:
//                return "初访";
//
//            case 2:
//                return "意向";
//
//            case 3:
//                return "报价";
//
//            case 4:
//                return "成交";
//
//            case 5:
//                return "暂时搁置";
//
//            default:
//                return "未知";
//
//        }
//    }


    class HolderView{
        TextView name;
        TextView status;
    }

}
