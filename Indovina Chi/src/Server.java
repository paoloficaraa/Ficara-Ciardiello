
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
public class Server extends Thread {

    private ServerSocket socket;
    private Game game;

    public Server(ServerSocket socket, Game game) {
        this.socket = socket;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = socket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine = in.readLine();

            if (inputLine != null) {
                String v[] = inputLine.split(";");
                int index = Integer.parseInt(v[0]);
                String domanda = v[1];

                if (index >= 8 && index <= 12) {
                    String colore = domanda.substring(12, domanda.length() - 2);
                        if (colore != game.getPersonaScelta().getColoreCapelli()) {
                            out.println("N");
                        } else {
                            out.println("Y");
                        }
                        
                } else if (index >= 13 && index <= 15) {
                    String colore = domanda.substring(12, domanda.length() - 2);
                        if (colore != game.getPersonaScelta().getColoreCapelli()) {
                            out.println("N");
                        } else {
                            out.println("Y");
                        }
                        
                } else if(index == 1){
                    
                }
                out.println(inputLine.toUpperCase());
            }

            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
