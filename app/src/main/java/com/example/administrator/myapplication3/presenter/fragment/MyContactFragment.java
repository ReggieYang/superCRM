package com.example.administrator.myapplication3.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication3.model.dao.service.ContactService;
import com.example.administrator.myapplication3.model.entity.Contact;
import com.example.administrator.myapplication3.presenter.activity.contact.ContactDetailsActivity;
import com.example.administrator.myapplication3.R;
import com.example.administrator.myapplication3.presenter.adapter.ContactAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyContactFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyContactFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Contact> list;

    public MyContactFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public MyContactFragment newInstance(int sectionNumber) {
        MyContactFragment fragment = new MyContactFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mycontact, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        list = new ContactService(getContext()).getMockList();
        ContactAdapter adapter = new ContactAdapter(getContext(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ContactDetailsActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
