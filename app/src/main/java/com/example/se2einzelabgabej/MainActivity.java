package com.example.se2einzelabgabej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalc = findViewById(R.id.button2);
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputField=findViewById(R.id.editTextNumber);
                String mk= inputField.getText().toString();
                mk=addASCII(mk);
                TextView messageForClient= findViewById(R.id.textView);
                messageForClient.setText(mk);
            }

            public String addASCII (String mk){
                String stringNEw="";
                for(int i=0;  i<mk.length();i++){
                    char c = mk.charAt(i);
                    if(i%2 != 0){

                    }
                    stringNEw+=c;
                }
                return stringNEw;
            }
        });
    }
}