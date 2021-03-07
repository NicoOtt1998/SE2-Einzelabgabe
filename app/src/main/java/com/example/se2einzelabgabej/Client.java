package com.example.se2einzelabgabej;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private DataOutputStream streamToServer;
    private BufferedReader serverAnsware;

    private BufferedWriter writer;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Client(){
        try{
            reader=new BufferedReader(new InputStreamReader(System.in));
            socket= new Socket("se2-isys.aau.at",53212);
            streamToServer= new DataOutputStream(socket.getOutputStream());
            serverAnsware = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }


    }

    private void makerequest(){

    }



}
