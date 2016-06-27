package com.example.administrator.myapplication3.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.ProductService;
import com.example.administrator.myapplication3.model.entity.Product;
import com.example.administrator.myapplication3.presenter.activity.product.ProductDetailsActivity;
import com.example.administrator.myapplication3.presenter.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyProductFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Product> list = new ArrayList<Product>();


    ProductAdapter adapter;
    View rootView;

    public MyProductFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public MyProductFragment newInstance(int sectionNumber) {
        MyProductFragment fragment = new MyProductFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume(){
        super.onResume();
        ProductService cs = new ProductService(getContext());

        cs.getProductList(new IUpdateListener<List<Product>>() {
            @Override
            public void success(boolean isSuccess, List<Product> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void fail(VolleyError error) {

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            System.out.println("yangkaimao");
            rootView = inflater.inflate(R.layout.fragment_myproduct, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listView);

            ProductService cs = new ProductService(getContext());

            adapter = new ProductAdapter(getContext(),list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getProductid() + "");
                    startActivity(intent);
                }
            });


            cs.getProductList(new IUpdateListener<List<Product>>() {
                @Override
                public void success(boolean isSuccess, List<Product> data) {
                    list.clear();
                    list.addAll(data);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void fail(VolleyError error) {

                }
            });
        }



        return rootView;
    }
}
