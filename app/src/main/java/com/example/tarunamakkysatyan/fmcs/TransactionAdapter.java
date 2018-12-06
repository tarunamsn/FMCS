package com.example.tarunamakkysatyan.fmcs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>{

    LayoutInflater mInflater;
    ArrayList<Transaction> TransactionArrayList;
    Context _context;
    Transaction current;

    public TransactionAdapter(Context _context, ArrayList<Transaction> TransactionArrayList ) {
        this.mInflater = LayoutInflater.from(_context);
        this.TransactionArrayList= TransactionArrayList;
        this._context = _context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.transaction_card,viewGroup,false);
        return new TransactionViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder transactionViewHolder, int i) {
        current = TransactionArrayList.get(i);
        transactionViewHolder.txtHour.setText(current.date);
        transactionViewHolder.txtDate.setText(current.hour);
        transactionViewHolder.txtName.setText(current.name);
        transactionViewHolder.txtCategory.setText(current.category);
        transactionViewHolder.txtMoney.setText("Rp. "+ ((Integer) current.money).toString());
    }

    @Override
    public int getItemCount() {
        return TransactionArrayList.size();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder{
        TextView txtHour, txtDate, txtCategory,txtName, txtMoney;
        TransactionAdapter mAdapter;
        public TransactionViewHolder(@NonNull View itemView, TransactionAdapter transactionAdapter) {
            super(itemView);
            txtHour = itemView.findViewById(R.id.txtHour);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtName = itemView.findViewById(R.id.txtName);
            txtMoney = itemView.findViewById(R.id.txtMoney);
            this.mAdapter = transactionAdapter;
        }
    }

}
