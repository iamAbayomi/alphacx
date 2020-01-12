package com.ukconcepts.onboarding.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ukconcepts.onboarding.views.HomeActivity;
import com.ukconcepts.onboarding.R;

public class SignUpActivity extends AppCompatActivity {

    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.registerButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
