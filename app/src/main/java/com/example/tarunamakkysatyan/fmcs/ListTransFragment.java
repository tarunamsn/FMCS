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
import android.widget.Toast;

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
        int a=0, b=0;
        Transaction temp;
        for (int i  =0;i<TransactionList.size();i++){
             temp= TransactionList.get(i);
            if (TransactionList.get(i).expenses== true){
                a += temp.money;
            }else {
                b += temp.money;
            }
        }
        expenses = ViewFrag.findViewById(R.id.textView5);
        expenses.setText(("Rp. "+ (Integer) a).toString());
        income = ViewFrag.findViewById(R.id.textView4);
        income.setText("Rp. "+ ((Integer) b).toString());
        int tot = b-a;
        total = ViewFrag.findViewById(R.id.textView6);
        total.setText(("Rp. "+ (Integer) tot).toString());
        mRecyclerView = ViewFrag.findViewById(R.id.RecyclerView);
        mAdapter = new TransactionAdapter(ViewFrag.getContext(), TransactionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ViewFrag.getContext()));
        btnAdd = ViewFrag.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             * Callback method to be invoked when the RecyclerView has been scrolled. This will be
             * called after the scroll has completed.
             * <p>
             * This callback will also be called if visible item range changes after a layout
             * calculation. In that case, dx and dy will be 0.
             *
             * @param recyclerView The RecyclerView which scrolled.
             * @param dx           The amount of horizontal scroll.
             * @param dy           The amount of vertical scroll.
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && btnAdd.getVisibility() == View.VISIBLE) {
                    btnAdd.hide();
                } else if (dy < 0 && btnAdd.getVisibility() != View.VISIBLE) {
                    btnAdd.show();
                }
            }
        });
        return ViewFrag;
    }

    @Override
    public void onClick(View view) {
        Intent pop = new Intent(view.getContext(), AddReq.class);
        startActivityForResult(pop,101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            Log.d("request code : ", ((Integer) requestCode).toString());
            String date, hour, content, category;
            int amount =0;
            Bundle bundle = data.getExtras();
            date = bundle.getString("date");
            hour = bundle.getString("hour");
            content = bundle.getString("content");
            category = bundle.getString("category");
            boolean expenses = bundle.getBoolean("expenses");
            amount = Integer.parseInt(bundle.getString("amount"));
            TransactionList.add(new Transaction(content,category,date,hour,expenses,amount));
            mAdapter.notifyDataSetChanged();
        }catch (NumberFormatException e){
            String msg = "Field must not be empty!";
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }catch (NullPointerException e){

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        int a=0, b=0;
        Transaction temp;
        for (int i  =0;i<TransactionList.size();i++){
            temp= TransactionList.get(i);
            if (TransactionList.get(i).expenses== true){
                a += temp.money;
            }else if (TransactionList.get(i).expenses == false){
                b += temp.money;
            }
        }
        expenses.setText(("Rp. "+ (Integer) a).toString());
        income.setText("Rp. "+ ((Integer) b).toString());
        int tot = b-a;
        total.setText(("Rp. "+ (Integer) tot).toString());
    }
}