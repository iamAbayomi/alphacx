package com.ukconcepts.onboarding.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ukconcepts.onboarding.APICall;
import com.ukconcepts.onboarding.model.LoginDetails;
import com.ukconcepts.onboarding.views.HomeActivity;
import com.ukconcepts.onboarding.R;

public class SignInActivity extends AppCompatActivity {

    Button loginButton;
    private EditText userIdEditText;
    private EditText passwordEditText;

    public static String userID, password;

    private LoginDetails loginDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loginButton = findViewById(R.id.loginButton);
        userIdEditText = findViewById(R.id.userIdEditText);
        passwordEditText = findViewById(R.id.passwordEditText);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    userID = userIdEditText.getText().toString();
                    password = passwordEditText.getText().toString();

                    loginDetails = new LoginDetails(userID, password);

                     APICall apiCall = new APICall(SignInActivity.this, loginDetails);

                    goToHome();

               //     apiCall.execute();


            }
        });
    }


    public  void goToHome(){
        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
        startActivity(intent);

    }

}
