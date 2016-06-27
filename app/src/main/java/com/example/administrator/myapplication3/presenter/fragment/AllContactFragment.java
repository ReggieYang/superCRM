package com.example.administrator.myapplication3.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.dao.service.IUpdateListener;
import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.dao.service.ProductService;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.model.entity.Product;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactDetailsActivity;
import com.example.administrator.myapplication3.R;

import com.example.administrator.myapplication3.presenter.activity.product.ProductDetailsActivity;
import com.example.administrator.myapplication3.presenter.adapter.ContactAdapter;
import com.example.administrator.myapplication3.presenter.adapter.ContactAdapter;
import com.example.administrator.myapplication3.presenter.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;


public class AllContactFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private List<Contact> list = new ArrayList<>();
    ContactAdapter adapter;
    View rootView;
    
    
    public AllContactFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public AllContactFragment newInstance(int sectionNumber) {
        AllContactFragment fragment = new AllContactFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume(){
        super.onResume();
        ContactService cs = new ContactService(getContext());

        cs.getContactList(new IUpdateListener<List<Contact>>() {
            @Override
            public void success(boolean isSuccess, List<Contact> data) {
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
            rootView = inflater.inflate(R.layout.fragment_allcontact, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            ContactService cs = new ContactService(getContext());

            adapter = new ContactAdapter(getContext(),list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), ContactDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getContactsid() + "");
                    startActivity(intent);
                }
            });

            cs.getContactList(new IUpdateListener<List<Contact>>() {
                @Override
                public void success(boolean isSuccess, List<Contact> data) {
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
