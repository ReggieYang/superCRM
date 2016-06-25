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

import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.presenter.activity.opportunity.OpportunityDetailsActivity;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.model.entity.Opportunity;
import com.example.administrator.myapplication3.presenter.adapter.OpportunityAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyOpportunityFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Opportunity> list = new ArrayList<>();

    public MyOpportunityFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public MyOpportunityFragment newInstance(int sectionNumber) {
        MyOpportunityFragment fragment = new MyOpportunityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_myopportunity, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        OpportunityService os = new OpportunityService(getContext());
        list = os.getMockList2();

        OpportunityAdapter adapter = new OpportunityAdapter(getContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(getActivity(),OpportunityDetailsActivity.class);
                startActivity(intent);
            }
        });
//        final String[] data={"军火商机","大王"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String name = data[(int)id];
//                Intent intent = new Intent(getActivity(),OpportunityDetailsActivity.class);
//
//                startActivity(intent);
//            }
//        });
        return rootView;
    }
}
