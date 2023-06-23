package com.example.signlog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText usernameField;
    private EditText passwordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameField = findViewById(R.id.txt_username);
        passwordField = findViewById(R.id.txt_password);

        Button signUpButton = findViewById(R.id.btn_signup);
        signUpButton.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        String username, password;
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();

        if(validatePassword(password)){
            Bundle userBundle = new Bundle();
            userBundle.putString("userNameKey", username);
            userBundle.putString("passwordKey", password);
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtras(userBundle);
            startActivity(intent);
        }
        else Toast.makeText(this, "Enter Stronger Password.", Toast.LENGTH_SHORT).show();

    }

    public boolean validatePassword(String pw){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + "(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(pw);
        return m.matches();
    }
}