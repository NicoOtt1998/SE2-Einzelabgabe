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
            }

            public String addASCII (String mk){
                String mkString= String.valueOf(mk);
                String stringNEw="Nice";
                return stringNEw;

            }
        });
    }
}