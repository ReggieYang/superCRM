package com.example.administrator.myapplication3.presenter.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.CustomerService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.OpportunityService;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.model.entity.Customer;
import com.example.administrator.myapplication3.presenter.activity.customer.CustomerDetailsActivity;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.presenter.adapter.CustomerAdapter;
import com.example.administrator.myapplication3.presenter.adapter.CustomerAdapter;
import com.example.administrator.myapplication3.presenter.adapter.OpportunityAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/**
 * A placeholder fragment containing a simple view.
 */
public class AllCustomerFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Customer> list = new ArrayList<>();
    View rootView;
    CustomerAdapter adapter;
    public AllCustomerFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public AllCustomerFragment newInstance(int sectionNumber) {
        AllCustomerFragment fragment = new AllCustomerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume(){
        super.onResume();
        CustomerService cs = new CustomerService(getContext());

        cs.getCustomerList(new IUpdateListener<List<Customer>>() {
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
            rootView = inflater.inflate(R.layout.fragment_allcustomer, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            CustomerService cs = new CustomerService(getContext());

            adapter = new CustomerAdapter(getContext(),list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), CustomerDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getCustomerid() + "");
                    startActivity(intent);
                }
            });

            cs.getCustomerList(new IUpdateListener<List<Customer>>() {
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
        }

        return rootView;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_allcustomer, container, false);
//
//        final ListView listView = (ListView) rootView.findViewById(R.id.listView);
//
//        CustomerService cs = new CustomerService(getContext());
//
//        final CustomerAdapter adapter = new CustomerAdapter(getContext(),list);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), CustomerDetailsActivity.class);
//                intent.putExtra("id", list.get(position).getCustomerid() + "");
//                startActivity(intent);
//            }
//        });
//
//        cs.getCustomerList(new IUpdateListener<List<Customer>>() {
//            @Override
//            public void success(boolean isSuccess, List<Customer> data) {
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
