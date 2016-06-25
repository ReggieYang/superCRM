package com.example.administrator.myapplication3.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class ProductAdapter extends ArrayAdapter<Product> {
    private List<Product> objects;

    public ProductAdapter(Context context, List<Product> objects) {
        super(context, R.layout.item_common_listview, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        View view;
        Product product = objects.get(position);
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

        holderView.name.setText(product.getProductname());
        holderView.status.setText(product.getClassification());

        return view;
    }


    class HolderView{
        TextView name;
        TextView status;
    }

}
