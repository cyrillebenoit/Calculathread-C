package com.company;

import java.io.*;
import java.net.*;

public class Client {

    private static Socket socket = null;
    private static Thread t1;

    public static void main(String[] args) {
        try {
            System.out.println("Demande de connexion");
            socket = new Socket("127.0.0.1",7777);
            System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté

            t1 = new Thread(new ServerInterface(socket));
            t1.start();
        } catch (IOException e) {
            System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
        }
    }

}
