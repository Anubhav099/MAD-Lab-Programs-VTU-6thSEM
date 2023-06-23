package com.example.signlog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signInButton;
    private EditText usernameField;
    private EditText passwordField;

    private String username;
    private String password;
    private int attempts = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.login_username);
        passwordField = findViewById(R.id.login_password);
        signInButton = findViewById(R.id.btn_login);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("userNameKey");
        password = bundle.getString("passwordKey");

        signInButton.setOnClickListener(this);


    }

    public void onClick(View v) {
        String enteredUsername = usernameField.getText().toString();
        String enteredPassword = passwordField.getText().toString();
        attempts++;
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            makeToast("Successful Login!");
        } else {
            if (attempts <= 2) {
                makeToast("Incorrect login credentials");
            } else {
                makeToast("Failed Login Attempts");
                signInButton.setEnabled(false);
            }
        }
    }
    private void makeToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
