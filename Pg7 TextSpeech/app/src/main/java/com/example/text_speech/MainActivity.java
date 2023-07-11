package com.example.text_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtSpeak;
    Button btnSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSpeak = findViewById(R.id.editText);

        btnSpeak = findViewById(R.id.button);
        btnSpeak.setOnClickListener(this);

        textToSpeech = new TextToSpeech(getBaseContext(), status ->
        {
            if (status != TextToSpeech.ERROR)
                Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onClick(View v) {
        String text = txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}