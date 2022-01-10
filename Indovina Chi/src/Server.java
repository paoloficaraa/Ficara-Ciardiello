
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
//Classe che identifica la parte server del peer
public class Server extends Thread {

    private ServerSocket serverSocket;
    private int port;
    private Socket clientSocket;
    private Game game;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int port, Game game) {
        //this.socket = socket;
        this.port = port;
        this.game = game;
        clientSocket = null;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            //System.out.println(serverSocket.getLocalPort());
            clientSocket = serverSocket.accept();
            System.out.println("SERVER: I've accepted the connection");
            //System.out.println(clientSocket.getLocalPort());
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("accept");
            System.out.println("Server: I've sent the accept message");
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                out.println("received");

                String v[] = inputLine.split(";");
                int index = Integer.parseInt(v[0].replaceAll("\\P{Print}", ""));
                String domanda = v[1];

                if (index == 118) { //se la domanda dell'avversario è una domanda vincente
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, domanda, "Domanda", dialogButton);
                    if (dialogResult == 0) {
                        out.println("Y");
                    } else {
                        out.println("N");
                    }
                }

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, domanda, "Domanda", dialogButton);
                if (dialogResult == 0) {
                    out.println("Y");
                } else {
                    out.println("N");
                }
            }
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.exit(0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
