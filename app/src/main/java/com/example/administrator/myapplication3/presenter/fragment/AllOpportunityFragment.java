package com.example.administrator.myapplication3.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.model.entity.Opportunity;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.model.entity.Opportunity;

import com.example.administrator.myapplication3.presenter.activity.customer.CustomerDetailsActivity;
import com.example.administrator.myapplication3.presenter.activity.opportunity.OpportunityDetailsActivity;
import com.example.administrator.myapplication3.presenter.adapter.OpportunityAdapter;
import com.example.administrator.myapplication3.presenter.adapter.CustomerAdapter;
import com.example.administrator.myapplication3.presenter.adapter.OpportunityAdapter;

import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;


public class AllOpportunityFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Opportunity> list = new ArrayList<>();

    View rootView;
    OpportunityAdapter adapter;

    public AllOpportunityFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public AllOpportunityFragment newInstance(int sectionNumber) {
        AllOpportunityFragment fragment = new AllOpportunityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume(){
        super.onResume();
        OpportunityService cs = new OpportunityService(getContext());

        cs.getOpportunityList(new IUpdateListener<List<Opportunity>>() {
            @Override
            public void success(boolean isSuccess, List<Opportunity> data) {
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
            rootView = inflater.inflate(R.layout.fragment_allopportunity, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            OpportunityService cs = new OpportunityService(getContext());

            adapter = new OpportunityAdapter(getContext(),list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), OpportunityDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getOpportunityid() + "");
                    startActivity(intent);
                }
            });

            cs.getOpportunityList(new IUpdateListener<List<Opportunity>>() {
                @Override
                public void success(boolean isSuccess, List<Opportunity> data) {
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

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_allopportunity, container, false);
//
//        final ListView listView = (ListView) rootView.findViewById(R.id.listView);
//
//        OpportunityService os = new OpportunityService(getContext());
//
//        final OpportunityAdapter adapter = new OpportunityAdapter(getContext(),list);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), OpportunityDetailsActivity.class);
//                intent.putExtra("id", list.get(position).getOpportunityid() + "");
//                startActivity(intent);
//            }
//        });
//
//        os.getOpportunityList(new IUpdateListener<List<Opportunity>>() {
//            @Override
//            public void success(boolean isSuccess, List<Opportunity> data) {
//                list.clear();
//                list.addAll(data);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void fail(VolleyError error) {
//
//            }
//        });
//
//        return rootView;
//    }
}
