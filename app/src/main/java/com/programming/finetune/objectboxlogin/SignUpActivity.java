package com.programming.finetune.objectboxlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class SignUpActivity extends AppCompatActivity {

    private EditText mUserName;
    private EditText mMobile;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUserName = findViewById(R.id.username);
        mMobile = findViewById(R.id.mobile);
        mPassword = findViewById(R.id.password);
    }

    public void onSignUpClicked(View view){

        String userName = mUserName.getText().toString();
        String mobile = mMobile.getText().toString();
        String password = mPassword.getText().toString();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setMobNumber(mobile);

        if (user.isValidPassword()&&user.isValidUsername()){
            BoxStore boxStore = MyApplication.getApplication().getBoxStore();
            Box<User> userBox = boxStore.boxFor(User.class);
            userBox.put(user);
            viewMessage("User is created");
        }else{
            viewMessage("Validation failed,user is not created");
        }
    }

    public void viewMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void goToBlog(){

    }
}
