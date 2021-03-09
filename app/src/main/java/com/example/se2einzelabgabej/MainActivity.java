package com.example.se2einzelabgabej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend= findViewById(R.id.buttonSend);
        Button btnCalculate= findViewById(R.id.buttonCalculate);
        EditText inputField=findViewById(R.id.editTextNumber);
        TextView messageForUser= findViewById(R.id.textView);





        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mk= inputField.getText().toString();
                try {
                    TCPConnection connection= new TCPConnection(mk);
                    connection.start();
                    connection.join();
                    messageForUser.setText(connection.getServerAnswer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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