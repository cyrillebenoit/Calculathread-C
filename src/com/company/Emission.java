package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

    private PrintWriter out;
    private String login = null, message = null;
    private Scanner sc = null;

    public Emission(PrintWriter out) {
        this.out = out;

    }


    public void run() {
        sc = new Scanner(System.in);
        while(true){
            message = sc.nextLine();
            out.println(message);
            out.flush();
        }
    }
}
