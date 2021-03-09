package com.example.se2einzelabgabej;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPConnection extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private DataOutputStream streamtoServer;
    private String message;
    private String serverAnswer="No answer";

    public TCPConnection(String message){
            this.message=message;
    }


    @Override
    public void run(){

        try {
            socket= new Socket("se2-isys.aau.at", 53212);
            reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            streamtoServer = new DataOutputStream(socket.getOutputStream());
            streamtoServer.writeBytes(message +"\n");
            serverAnswer= reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getServerAnswer(){
        return this.serverAnswer;
    }

}
