package com.ukconcepts.onboarding.check_balance;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ukconcepts.onboarding.R;
import com.ukconcepts.onboarding.adapter.AccountStatementAdapter;
import com.ukconcepts.onboarding.model.AccountStatementModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBalanceFragment extends Fragment {

    private EditText accountNoEditText;
    private CardView button;
    private TextView accountNumberTextView;

    //Model for the data of CheckBalance
    private CheckBalanceModel checkBalanceModel;

    private String accountNo;
    public static String accountNoBalance = "";

    //RecyclerView Variables
    private RecyclerView recyclerView;
    private AccountStatementAdapter accountStatementAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static ArrayList<AccountStatementModel> accountStatementModelArrayList;



    public CheckBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_balance, container, false);

        accountNoEditText = view.findViewById(R.id.accountEditText);
        button = view.findViewById(R.id.check_acc_no_btn);
        accountNumberTextView = view.findViewById(R.id.accountBalanceTextView);

        //Initializing RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
       //Initializing LinearLayoutManager
        layoutManager = new LinearLayoutManager(
                getActivity().getApplicationContext());
        //setting LayoutManger
        recyclerView.setLayoutManager(layoutManager);

        button.setOnClickListener( new View.OnClickListener(){
         @Override
          public void onClick(View v) {
            accountNo = accountNoEditText.getText().toString();
            checkBalanceModel = new CheckBalanceModel(accountNo);

            CheckBalanceAPICall checkBalanceAPICall = new
                 CheckBalanceAPICall(getActivity().getApplicationContext(), checkBalanceModel);

            checkBalanceAPICall.execute();
            accountNumberTextView.setText(accountNoBalance);

            accountStatementModelArrayList = CheckBalanceAPICall.accountStatementModelArrayList;

            accountStatementAdapter = new AccountStatementAdapter(getActivity(), accountStatementModelArrayList);
            recyclerView.setAdapter(accountStatementAdapter);

            }
        });
        return view;






    }

}
