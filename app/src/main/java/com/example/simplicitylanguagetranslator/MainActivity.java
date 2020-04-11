package com.example.simplicitylanguagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    EditText inputs;
    Button btn;

    public static String translate(String strs){
        String b[] = {
                "@", ";", "'", "$", "3", "_","&",
                "-", "8", "+", "(", ")", "?", "!",
                "9", "0", "1", "4", "#", "5", "7",
                ":", "2", String.valueOf('"'), "6", "*", "•", "~",
                "`", "|", "¥", "√", "π", "÷", "×",
                "¶", "∆"
        };
        String a[] = {
                "A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z", " ", "1",
                "2", "3", "4", "5", "6", "7", "8",
                "9", "0"
        };
        String st = "";

        String arrs[] = strs.split("");
        int count = 0;

        for (int x=0; x< arrs.length; x++){
            for (int i=0; i<b.length; i++){
                if (arrs[x].toUpperCase().equals(b[i])){
                    if (count == 0){
                        st += a[i].toUpperCase();
                        count = 1;
                        break;
                    }
                    else{
                        st += a[i].toLowerCase();
                        break;
                    }

                }
            }
        }

        return st;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.outputs);
        inputs = (EditText) findViewById(R.id.userinputs);
        btn = (Button) findViewById(R.id.bttn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText(translate(inputs.getText().toString()));
            }
        });
    }
}
