package com.example.se2einzelabgabej;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalc = findViewById(R.id.button2);
        Button btnSendtoServer = findViewById(R.id.button);

        btnSendtoServer.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Client client = new Client();
                EditText inputField=findViewById(R.id.editTextNumber);
                String mk= inputField.getText().toString();
                try {
                   String serverasware= client.makerequest(mk);
                    TextView messageForClient= findViewById(R.id.textView);
                    messageForClient.setText(serverasware);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputField=findViewById(R.id.editTextNumber);
                String mk= inputField.getText().toString();
                mk=addASCII(mk);
                TextView messageForClient= findViewById(R.id.textView);
                messageForClient.setText(mk);
            }
            //a,b,c,d,e,f,g,h,i,j
            //1,2,3,4,5,6,7,8,9,0
            public String addASCII (String mk){
                String stringNEw="";
                for(int i=0;  i<mk.length();i++){
                    char c = mk.charAt(i);
                    if(i%2 != 0){
                        int ascii= c;
                        if(c==48){
                            ascii+=58;
                        }
                        else{
                            ascii+=48;
                        }
                        c= (char) ascii;
                    }
                    stringNEw+=c;
                }
                return stringNEw;
            }
        });


    }
}