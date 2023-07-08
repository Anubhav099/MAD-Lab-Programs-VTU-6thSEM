package com.example.xmlnjson;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnParseXml,btnParseJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParseXml = findViewById(R.id.button_xml);
        btnParseJson = findViewById(R.id.button_json);
        btnParseJson.setOnClickListener(this);
        btnParseXml.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent it=new Intent(this,ViewActivity.class);
        if(v.equals(btnParseJson))  it.putExtra("mode",1);
        else    it.putExtra("mode",2);
        startActivity(it);
    }
}