package com.example.se2einzelabgabej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        btnSend.setOnClickListener(v -> {
            try {
                TCPConnection connection= new TCPConnection(inputField.getText().toString());
                connection.start();
                connection.join();
                messageForUser.setText(connection.getServerAnswer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        btnCalculate.setOnClickListener(v -> {
            Calculator c= new Calculator();
            messageForUser.setText(c.makeNewString(inputField.getText().toString()));
        });


    }
}