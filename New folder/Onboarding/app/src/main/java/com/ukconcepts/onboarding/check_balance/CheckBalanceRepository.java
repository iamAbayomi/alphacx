package com.ukconcepts.onboarding.check_balance;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ukconcepts.onboarding.model.AccountStatementModel;

import java.util.ArrayList;

/**
* Repository is a class that abstract multiple data sources
 * and acts as an API to the rest of the app for app data
 * All data operations and network operations are handled in
 * Repository
* */

/*The tasks to accomplish is to get the account statement
* from the account balance. So we get the result from the CheckBalanceAPICall
*  */
public class CheckBalanceRepository {

    private CheckBalanceAPICall checkBalanceAPICall;
    private MutableLiveData<ArrayList<AccountStatementModel>>
            accountStatementModelArrayList;
    private Context mContext;

    CheckBalanceRepository(Context context){
        this.mContext = context;
    }

    public MutableLiveData<ArrayList<AccountStatementModel>>
         getAccountStatement(CheckBalanceModel checkBalanceModel
    ){
        checkBalanceAPICall = new CheckBalanceAPICall(mContext, checkBalanceModel);
        checkBalanceAPICall.execute();

        return accountStatementModelArrayList;
    }

}
