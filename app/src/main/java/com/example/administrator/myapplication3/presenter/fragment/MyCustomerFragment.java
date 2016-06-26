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
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.presenter.activity.customer.CustomerDetailsActivity;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.presenter.adapter.CustomerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyCustomerFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Customer> list = new ArrayList<>();

    public MyCustomerFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public MyCustomerFragment newInstance(int sectionNumber) {
        MyCustomerFragment fragment = new MyCustomerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_allcustomer, container, false);

        final ListView listView = (ListView) rootView.findViewById(R.id.listView);

        CustomerService cs = new CustomerService(getContext());

        final CustomerAdapter adapter = new CustomerAdapter(getContext(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CustomerDetailsActivity.class);
                intent.putExtra("id", list.get(position).getCustomerid() + "");
                startActivity(intent);
            }
        });

        cs.getMyCustomerList(new IUpdateListener<List<Customer>>() {
            @Override
            public void success(boolean isSuccess, List<Customer> data) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void fail(VolleyError error) {

            }
        });

        return rootView;
    }
}
