package com.ukconcepts.onboarding.check_balance;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckBalanceViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private CheckBalanceAPICall checkBalanceAPICall;
    public static  MutableLiveData<String>  balance;

    public CheckBalanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }


    public MutableLiveData<String> getAccountNumber(Context context,
                CheckBalanceModel checkBalanceModel ){
        checkBalanceAPICall = new CheckBalanceAPICall(context, checkBalanceModel);
        checkBalanceAPICall.execute();

        return balance;
    }

}