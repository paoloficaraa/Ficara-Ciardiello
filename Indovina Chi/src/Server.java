
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

                if (index >= 8 && index <= 12) {    //se la domanda che ci viene fatta riguarda il colore dei capelli
                    String colore = domanda.substring(12, domanda.length() - 2);
                        if (colore != game.getPersonaScelta().getColoreCapelli()) {
                            out.println("N");
                        } else {
                            out.println("Y");
                        }
                        
                } else if (index >= 13 && index <= 15) {    //se la domanda che ci viene fatta riguarda il colore degli occhi
                    String colore = domanda.substring(12, domanda.length() - 2);
                        if (colore != game.getPersonaScelta().getColoreOcchi()) {
                            out.println("N");
                        } else {
                            out.println("Y");
                        }
                        
                } else if(index == 1){
                    if(game.getPersonaScelta().getOcchiali()){
                        out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 2){
                    if(game.getPersonaScelta().getBarba()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 3){
                    if(game.getPersonaScelta().getCappello()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 4){
                    if(game.getPersonaScelta().getBaffi()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 5){
                    if(game.getPersonaScelta().getNasoGrande()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 6){
                    if(game.getPersonaScelta().getGuanceRosse()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
                } else if(index == 7){
                    if(game.getPersonaScelta().getCapelli()){
                         out.println("Y");
                    } else {
                        out.println("N");
                    }
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
