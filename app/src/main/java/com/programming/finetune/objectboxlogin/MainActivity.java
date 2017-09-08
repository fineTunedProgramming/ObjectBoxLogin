package com.programming.finetune.objectboxlogin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignInClicked(View view){
        openActivity(SignInActivity.class);
    }

    public void onSignUpClicked(View view){
        openActivity(SignUpActivity.class);
    }

    public void openActivity(Class activity){
        startActivity(new Intent(MainActivity.this,activity));
    }
}
