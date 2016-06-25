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

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.ProductService;
import com.example.administrator.myapplication3.model.entity.Product;
import com.example.administrator.myapplication3.presenter.activity.product.ProductDetailsActivity;
import com.example.administrator.myapplication3.presenter.adapter.ProductAdapter;

import java.util.List;


public class MyProductFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Product> list;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_allproduct, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
//        String[] data={"M4A1","篮球"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);

        list = new ProductService(getContext()).getMockList();
        ProductAdapter adapter = new ProductAdapter(getContext(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ProductDetailsActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
