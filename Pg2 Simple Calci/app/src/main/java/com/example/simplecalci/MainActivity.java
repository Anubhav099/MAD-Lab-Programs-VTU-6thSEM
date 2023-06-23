package com.example.simplecalci;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero, Dot, Equal, Add, Sub, Div, Mul, Clear;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        One = (Button)findViewById(R.id.button_one);
        One.setOnClickListener(this);

        Two = (Button)findViewById(R.id.button_two);
        Two.setOnClickListener(this);

        Three = (Button)findViewById(R.id.button_three);
        Three.setOnClickListener(this);

        Four = (Button)findViewById(R.id.button_four);
        Four.setOnClickListener(this);

        Five = (Button)findViewById(R.id.button_five);
        Five.setOnClickListener(this);

        Six = (Button)findViewById(R.id.button_six);
        Six.setOnClickListener(this);

        Seven = (Button)findViewById(R.id.button_seven);
        Seven.setOnClickListener(this);

        Eight = (Button)findViewById(R.id.button_eight);
        Eight.setOnClickListener(this);

        Nine = (Button)findViewById(R.id.button_nine);
        Nine.setOnClickListener(this);

        Zero = (Button)findViewById(R.id.button_zero);
        Zero.setOnClickListener(this);

        Dot = (Button)findViewById(R.id.button_dot);
        Dot.setOnClickListener(this);

        Equal = (Button)findViewById(R.id.button_equal);
        Equal.setOnClickListener(this);

        Add = (Button)findViewById(R.id.button_add);
        Add.setOnClickListener(this);

        Sub = (Button)findViewById(R.id.button_sub);
        Sub.setOnClickListener(this);

        Mul = (Button)findViewById(R.id.button_mul);
        Mul.setOnClickListener(this);

        Div = (Button)findViewById(R.id.button_div);
        Div.setOnClickListener(this);

        Clear = (Button)findViewById(R.id.button_clear);
        Clear.setOnClickListener(this);

        result = (EditText)findViewById(R.id.txt_result);
        result.setText("");
    }

    public void onClick(View v)
    {
        if(v.equals(One))   result.append("1");
        if(v.equals(Two))   result.append("2");
        if(v.equals(Three))   result.append("3");
        if(v.equals(Four))   result.append("4");
        if(v.equals(Five))   result.append("5");
        if(v.equals(Six))   result.append("6");
        if(v.equals(Seven))   result.append("7");
        if(v.equals(Eight))   result.append("8");
        if(v.equals(Nine))   result.append("9");
        if(v.equals(Zero))   result.append("0");
        if(v.equals(Dot))   result.append(".");
        if(v.equals(Clear))   result.setText("");
        if(v.equals(Add))   result.append("+");
        if(v.equals(Mul))   result.append("*");
        if(v.equals(Div))   result.append("/");
        if(v.equals(Sub))   result.append("-");

        if(v.equals(Equal))
        {
            try{
                String data = result.getText().toString();

                if(data.contains("+")){
                    String[] ops = data.split(Pattern.quote("+"));
                    if(ops.length==2){
                        double op1 = Double.parseDouble(ops[0]);
                        double op2 = Double.parseDouble(ops[1]);
                        double res = op1 + op2;
                        result.setText(String.valueOf(res));
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("-")){
                    String[] ops = data.split("-");
                    if(ops.length==2){
                        double op1 = Double.parseDouble(ops[0]);
                        double op2 = Double.parseDouble(ops[1]);
                        double res = op1-op2;
                        result.setText(String.valueOf(res));
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("*")){
                    String[] ops = data.split(Pattern.quote("*"));
                    if(ops.length==2){
                        double op1 = Double.parseDouble(ops[0]);
                        double op2 = Double.parseDouble(ops[1]);
                        double res = op1*op2;
                        result.setText(String.valueOf(res));
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("/")){
                    String[] ops = data.split("/");
                    if(ops.length==2){
                        double op1 = Double.parseDouble(ops[0]);
                        double op2 = Double.parseDouble(ops[1]);
                        double res = op1/op2;
                        result.setText(String.valueOf(res));
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
            } catch(Exception e){
                Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
            }
        }
    }
}