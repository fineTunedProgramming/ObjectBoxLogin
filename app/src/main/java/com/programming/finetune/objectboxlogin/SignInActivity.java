package com.programming.finetune.objectboxlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class SignInActivity extends AppCompatActivity {
    private EditText mUserName;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mUserName = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
    }

    public void onSignInClicked(View view){
        String userName = mUserName.getText().toString();
        String password = mPassword.getText().toString();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        if (user.isValidUsername()&&user.isValidPassword()){
            BoxStore boxStore = MyApplication.getApplication().getBoxStore();
            Box<User> userBox = boxStore.boxFor(User.class);

            //fetching all users with username "userName"
            List<User> fetchUsers = userBox.query().equal(User_.userName,user.getUserName()).build().find();

            if (!fetchUsers.isEmpty()){

                //Considering unique username
                User reqUser = fetchUsers.get(0);
                if (reqUser.getPassword().equals(password)){
                    //login success
                    goToBlog();

                }else{
                    viewMessage("Invalid login credentials");
                }
            }else{
                viewMessage("Invalid login credentials");
            }
        }else{
            viewMessage("Validation Failed");
        }
    }

    public void viewMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void goToBlog(){
        viewMessage("Login Succesful");
        startActivity(new Intent(SignInActivity.this,BlogActivity.class));
        finish();
    }
}
