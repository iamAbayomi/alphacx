package com.ukconcepts.onboarding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.ukconcepts.onboarding.R;
import com.ukconcepts.onboarding.model.AccountStatementModel;

import java.util.ArrayList;

public class AccountStatementAdapter extends Adapter<AccountStatementAdapter.AccountStatementViewHolder> {

    private LayoutInflater mInflater;
    Context mContext;
    private ArrayList<AccountStatementModel> accountStatementModelArrayList;



    public AccountStatementAdapter(Context context, ArrayList<AccountStatementModel>
                                   accountStatementModelArrayList){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.accountStatementModelArrayList = accountStatementModelArrayList;

    }


    @NonNull
    @Override
    public AccountStatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.account_statement_list_view,
                  parent, false);

        return new AccountStatementViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountStatementViewHolder holder, int position) {
        AccountStatementModel currentAccountStatement = accountStatementModelArrayList
               .get(position);
        holder.bindTo(currentAccountStatement);
    }


    @Override
    public int getItemCount() {

        //return 5;
        return accountStatementModelArrayList.size();
    }


    class AccountStatementViewHolder extends RecyclerView.ViewHolder{

        private TextView date;
        private TextView pinno;
        private TextView premimun;
       // private TextView ;


        public AccountStatementViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_id);
            pinno = itemView.findViewById(R.id.pinno_id);
            premimun = itemView.findViewById(R.id.premium_id);

        }


        public void bindTo(AccountStatementModel currentAccountStatement) {

            date.setText(currentAccountStatement.getDATE());
            pinno.setText(currentAccountStatement.getPINNO());
            premimun.setText(currentAccountStatement.getPREMIUM());
        }
    }
}
