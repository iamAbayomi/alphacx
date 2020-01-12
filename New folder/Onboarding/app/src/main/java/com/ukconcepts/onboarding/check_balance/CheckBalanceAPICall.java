package com.ukconcepts.onboarding.check_balance;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.ukconcepts.onboarding.model.AccountStatementModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckBalanceAPICall  extends AsyncTask<Void,Void, ArrayList<AccountStatementModel>> {
    private CheckBalanceModel checkBalanceModel;
    private WeakReference<Context> contextWeakReference;

    private String bufferdata = "";
    private String finaldata = "";
    private String smsResponse = "";

    private String balance="";
    public static   ArrayList<AccountStatementModel> accountStatementModelArrayList;

    AccountStatementModel accModel;


    String date = "";
    String pinno = "";
    String premium = "";

    private AccountStamtentResponse stamtentResponse;

    //Constructor
    public CheckBalanceAPICall(Context context, CheckBalanceModel checkBalanceModel ){
        this.contextWeakReference =  new WeakReference<>(context);
        this.checkBalanceModel = checkBalanceModel;
      //  accModel = new AccountStatementModel();
        accountStatementModelArrayList = new ArrayList<>();
    }

    @Override
    protected ArrayList<AccountStatementModel> doInBackground(Void... voids) {
        URL url = null;
        HttpURLConnection httpURLConnection = null;

        String web_url = " http://api.greatnigeriaplc.com//?App=SMS&moduleid=CHECKBALANCE" +
                "&DEVICE=ANDROID&AccountNo=" +checkBalanceModel.getAccountNo()  +"&phone_imie=353515065206641&tnc=Y";

        try{
            url = new URL(web_url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                bufferdata = bufferdata + line;
            }

            JSONObject jsonObject = new JSONObject(bufferdata);
            JSONArray jsonArray = jsonObject.getJSONArray("result");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                //JSONObject result = jsonObject1.getJSONObject("result");
                finaldata = "data" + jsonObject1.get("data");

                JSONArray jsonData = jsonObject1.getJSONArray("data");

                for(int j = 0; j < jsonData.length(); j++){
                    JSONObject jsonObject2 =jsonData.getJSONObject(j);
/*

                    accModel.setDATE("" + jsonObject2.get("DATE"));
                    accModel.setPINNO("" + jsonObject2.get("PINNO"));
                    accModel.setPREMIUM("" + jsonObject2.get("PREMIUM"));

                    accountStatementModelArrayList.add(j,accModel);
*/
                    date = "" + jsonObject2.get("DATE");
                    pinno = "" + jsonObject2.get("PINNO");
                    premium = "" + jsonObject2.get("PREMIUM");

                    balance ="" + jsonObject2.get("PINNO");

                  //  accountNumberTextView.setText(date);

                    accountStatementModelArrayList.add(new AccountStatementModel(date,pinno,
                            premium));


                }
                //+ "Status" + jsonObject1.get("status");
                smsResponse =""+ jsonObject1.get("status");
                //checkBalanceModel.setAccountBalance();
            }

            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountStatementModelArrayList;
    }


    @Override
    protected void onPostExecute(ArrayList<AccountStatementModel> accountList) {
        super.onPostExecute(accountList);
        Context context = contextWeakReference.get();

        Toast.makeText(context,
                balance, Toast.LENGTH_LONG).show();


        if(smsResponse.equals("200")){
           Toast.makeText(context, finaldata , Toast.LENGTH_LONG).show();
            //  CheckBalanceViewModel.balance.setValue(balance);
           CheckBalanceFragment.accountNoBalance = balance;
           CheckBalanceFragment.accountStatementModelArrayList = accountStatementModelArrayList;

          // CheckBalanceFragment.accountStatementModelArrayList.

        }

    }
}
