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
import com.example.administrator.myapplication3.model.dao.service.ContractService;
import com.example.administrator.myapplication3.model.dao.service.ContractService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.entity.Contract;
import com.example.administrator.myapplication3.model.entity.Contract;
import com.example.administrator.myapplication3.presenter.activity.contract.ContractDetailsActivity;
import com.example.administrator.myapplication3.R;

import com.example.administrator.myapplication3.presenter.adapter.ContractAdapter;
import com.example.administrator.myapplication3.presenter.adapter.ContractAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyContractFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Contract> list = new ArrayList<>();

    public MyContractFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public MyContractFragment newInstance(int sectionNumber) {
        MyContractFragment fragment = new MyContractFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mycontract, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        ContractService cs = new ContractService(getContext());

        final ContractAdapter adapter = new ContractAdapter(getContext(),list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ContractDetailsActivity.class);
                intent.putExtra("id", list.get(position).getContractid() + "");
                startActivity(intent);

            }
        });

        cs.getContractList(new IUpdateListener<List<Contract>>() {
            @Override
            public void success(boolean isSuccess, List<Contract> data) {
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
