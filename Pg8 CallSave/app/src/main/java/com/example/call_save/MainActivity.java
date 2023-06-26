package com.example.call_save;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    Button btnStar, btnHash, btnDel, btnCall, btnSave;
    EditText txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.button1);
        btnOne.setOnClickListener(this);

        btnTwo = findViewById(R.id.button2);
        btnTwo.setOnClickListener(this);

        btnThree = findViewById(R.id.button3);
        btnThree.setOnClickListener(this);

        btnFour = findViewById(R.id.button4);
        btnFour.setOnClickListener(this);

        btnFive = findViewById(R.id.button5);
        btnFive.setOnClickListener(this);

        btnSix = findViewById(R.id.button6);
        btnSix.setOnClickListener(this);

        btnSeven = findViewById(R.id.button7);
        btnSeven.setOnClickListener(this);

        btnEight = findViewById(R.id.button8);
        btnEight.setOnClickListener(this);

        btnNine = findViewById(R.id.button9);
        btnNine.setOnClickListener(this);

        btnZero = findViewById(R.id.button0);
        btnZero.setOnClickListener(this);

        btnStar = findViewById(R.id.button_star);
        btnStar.setOnClickListener(this);

        btnHash = findViewById(R.id.button_hash);
        btnHash.setOnClickListener(this);

        btnDel = findViewById(R.id.button_del);
        btnDel.setOnClickListener(this);

        btnCall = findViewById(R.id.button_call);
        btnCall.setOnClickListener(this);

        btnSave = findViewById(R.id.button_save);
        btnSave.setOnClickListener(this);

        txtPhoneNumber = findViewById(R.id.editText);
        txtPhoneNumber.setText("");
    }

    @Override
    public void onClick(View v) {

        if(v.equals(btnOne))
        {
            txtPhoneNumber.append("1");
        }
        else if(v.equals(btnTwo))
        {
            txtPhoneNumber.append("2");
        }
        else if(v.equals(btnThree))
        {
            txtPhoneNumber.append("3");
        }
        else if(v.equals(btnFour))
        {
            txtPhoneNumber.append("4");
        }
        else if(v.equals(btnFive))
        {
            txtPhoneNumber.append("5");
        }
        else if(v.equals(btnSix))
        {
            txtPhoneNumber.append("6");
        }
        else if(v.equals(btnSeven))
        {
            txtPhoneNumber.append("7");
        }
        else if(v.equals(btnEight))
        {
            txtPhoneNumber.append("8");
        }
        else if(v.equals(btnNine))
        {
            txtPhoneNumber.append("9");
        }
        else if(v.equals(btnZero))
        {
            txtPhoneNumber.append("0");
        }
        else if(v.equals(btnStar))
        {
            txtPhoneNumber.append("*");
        }
        else if(v.equals(btnHash))
        {
            txtPhoneNumber.append("#");
        }
        else if(v.equals(btnDel))
        {
            String data = txtPhoneNumber.getText().toString();
            if(data.length()>0)
            {
                txtPhoneNumber.setText(data.substring(0,data.length()-1));
            }
            else    txtPhoneNumber.setText("");
        }
        else if(v.equals(btnSave))
        {
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);

            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,txtPhoneNumber.getText().toString());
            startActivity(contactIntent);
        }
        else if(v.equals(btnCall))
        {
            String data = txtPhoneNumber.getText().toString();

            Intent it = new Intent(Intent.ACTION_CALL);
            it.setData(Uri.parse("tel:"+data));
            startActivity(it);
        }

    }
}