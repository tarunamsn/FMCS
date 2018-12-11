package com.example.tarunamakkysatyan.fmcs;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTransFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTransFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam2;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    TextView expenses, total,income;
    FloatingActionButton btnAdd;
    ArrayList<Transaction> TransactionList= new ArrayList<>();
    public ListTransFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTransFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTransFragment newInstance(ArrayList<Transaction> param1, String param2) {
        ListTransFragment fragment = new ListTransFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            TransactionList = getArguments().getParcelableArrayList(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ViewFrag = inflater.inflate(R.layout.fragment_list_trans, container, false);
        int a=0;
        for (int i  =0;i<TransactionList.size();i++){
            Transaction temp = TransactionList.get(i);
            a += temp.money;
        }
        expenses = ViewFrag.findViewById(R.id.textView5);
        expenses.setText(("Rp. "+ (Integer) a).toString());
        income = ViewFrag.findViewById(R.id.textView4);
        income.setText("Rp. 0 ");
        int temp = 0-a;
        total = ViewFrag.findViewById(R.id.textView6);
        total.setText(("Rp. "+ (Integer) temp).toString());
        mRecyclerView = ViewFrag.findViewById(R.id.RecyclerView);
        mAdapter = new TransactionAdapter(ViewFrag.getContext(), TransactionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ViewFrag.getContext()));
        btnAdd = ViewFrag.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        return ViewFrag;
    }

    @Override
    public void onClick(View view) {
        Log.d("jancuk", ((Integer) view.getId()).toString());
        Intent pop = new Intent(view.getContext(), AddReq.class);
        startActivityForResult(pop,101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            TransactionList.add(new Transaction("Fried Rice","Food & Drink","21 February","22:59",true,16000));
        }
    }
}