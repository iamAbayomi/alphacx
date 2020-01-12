package com.ukconcepts.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.ukconcepts.onboarding.model.LoginDetails;
import com.ukconcepts.onboarding.views.HomeActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICall extends AsyncTask<Void,Void,Void> {


    private String bufferdata = "";
    private String finaldata = "";
    private String smsResponse = "";



    private LoginDetails loginDetails;
    private WeakReference<Context> contextWeakReference;

    public APICall(Context context, LoginDetails loginDetails){
        this.contextWeakReference =  new WeakReference<>(context);

        this.loginDetails = loginDetails;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        URL url = null;
        HttpURLConnection httpURLConnection = null;

        String web_url = "http://api.greatnigeriaplc.com//?App=SMS&moduleid=LOGIN&DEVICE=" +
                "ANDROID&login_mobile=" + loginDetails.getUserId() + "&login_PIN="+ loginDetails.getPassword()+
                "&phone_imie=353515065206641&tnc=Y";

        try {
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
                // JSONObject result = jsonObject1.getJSONObject("result");
                finaldata = "data" + jsonObject1.get("data");
                           //+ "Status" + jsonObject1.get("status");
                smsResponse =""+ jsonObject1.get("status");


            }

            bufferedReader.close();
            inputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Context context = contextWeakReference.get();

       // Toast.makeText(context, finaldata + smsResponse, Toast.LENGTH_LONG).show();
      // Toast.makeText(context, loginDetails.getUserId() + " "+ loginDetails.getPassword(), Toast.LENGTH_LONG).show();

        if(smsResponse.equals("200")){
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        }
        else {
           Toast.makeText(context, "Wrong Email or Password", Toast.LENGTH_LONG).show();
        }

    }
}

