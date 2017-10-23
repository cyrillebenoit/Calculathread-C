package com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ServerInterface implements Runnable {

    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Thread t3, t4;

    public ServerInterface(Socket s){
        socket = s;
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            Thread t4 = new Thread(new Emission(out));
            t4.start();
            Thread t3 = new Thread(new Reception(in));
            t3.start();



        } catch (IOException e) {
            System.err.println("La calculatrice distante s'est déconnecté !");
        }
    }

}
