
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Client extends Thread {

    private String stringaDaInviare;
    private Socket socket;
    
    public Client(String stringaDaInviare, Socket socket) {
        this.stringaDaInviare = stringaDaInviare;
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            out.println(stringaDaInviare);
            /*String inputLine = in.readLine();
            System.out.println(inputLine);
            out.println("pluto");
            inputLine = in.readLine();
            System.out.println(inputLine);
            out.println("exit");
            inputLine = in.readLine();
            System.out.println(inputLine);*/

            socket.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
        }

        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
