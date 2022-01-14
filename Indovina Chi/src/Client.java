
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
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
//classe che identifica la parte client del peer
public class Client /*extends Thread*/ {

    private Socket clientSocket;
    private Game game;
    private PrintWriter out;
    private BufferedReader in;

    public Client(Game game) {
        this.game = game;
    }

    public void startConnection(String ip, Integer port, Integer portServer) throws IOException {
        int sum = 0, sum2 = 0;

        if (ip.equals("localhost")) {
            clientSocket = new Socket(InetAddress.getByName(ip), port);

            if (port < portServer) {
                game.setTurno(true);
            } else {
                game.setTurno(false);
            }

        } else {
            clientSocket = new Socket(ip, port);
            String[] singleMyIp = InetAddress.getLocalHost().toString().split("/");
            String myIp = singleMyIp[1] + portServer.toString();
            String itsIp /*ho messo its perchè non voglio essere discriminatorio*/ = ip + port.toString();
            for (int i = 0; i < myIp.length(); i++) {
                sum += (int) myIp.charAt(i);
            }
            for (int i = 0; i < itsIp.length(); i++) {
                sum2 += (int) itsIp.charAt(i);
            }

            if (sum > sum2) {
                game.setTurno(true);
            } else {
                game.setTurno(false);
            }

        }
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
    //    public String getConfirmConnection() throws IOException {
    //        String resp = in.readLine();
    //        System.out.println("CLIENT: I've received message");
    //        return resp;
    //    }

    public void sendMessage(String msg) throws SocketException {
//        do {
        out.println(msg);
//        } while (getConfirmConnection() == "received");
        System.out.println("CLIENT: message sent successfully");

        String resp = "";
        try {
            resp = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] v = msg.split(";");
        int index = -1, count = 0;
        String indexSpecial = "", domanda = "";
        try {
            index = Integer.parseInt(v[0].replaceAll("\\P{Print}", ""));
            domanda = v[1];
        } catch (NumberFormatException ex) {
            indexSpecial = v[0];
        }

        if (resp.equals("Y")) { //se quello che viene ricevuto è sì
            if (index >= 8 && index <= 12) {
                String coloreCapelli = domanda.substring(13, domanda.length() - 2);
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (coloreCapelli.equals(game.getHandler().getListPeople().get(i).getColoreCapelli().substring(0, game.getHandler().getListPeople().get(i).getColoreCapelli().length() - 1)) == false) { //cerco chi non ha il colore dei capelli uguale e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index >= 13 && index <= 15) {
                String coloreOcchi = domanda.substring(13, domanda.length() - 2);
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (coloreOcchi.equals(game.getHandler().getListPeople().get(i).getColoreOcchi().substring(0, game.getHandler().getListPeople().get(i).getColoreOcchi().length() - 1)) == false) { //cerco chi non ha il colore degli occhi uguale e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 1) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getOcchiali()) { //cerco chi non ha gli occhiali e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 2) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getBarba()) { //cerco chi non ha la barba e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 3) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getCappello()) { //cerco chi non ha il cappello e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 4) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getBaffi()) { //cerco chi non ha i baffi e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 5) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getNasoGrande()) { //cerco chi non ha il naso grande e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 6) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getGuanceRosse()) { //cerco chi non ha le guance rosse e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 7) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getCapelli()) { //cerco chi non ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 16) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getGenere()) { //cerco chi non ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 17) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getGenere()) { //cerco chi non ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (indexSpecial != "") {
                int dialogButton = JOptionPane.showConfirmDialog(null, "HAI VINTO", "HAI VINTO", JOptionPane.OK_CANCEL_OPTION);
                if (dialogButton == JOptionPane.OK_OPTION) {
                    out.println("exit1");
                }
                try {
                    stopConnection();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                game.window.getBtn().setVisible(false);
                game.window.getCmb().setVisible(false);
                game.gameState = STATE.Menu;
                //oppure invece che ricominciare si può mettere un System.exit(0)
            }

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------      
        } else if (resp.equals("N")) { //se quello che viene ricevuto è no
            if (index >= 8 && index <= 12) {
                String coloreCapelli = domanda.substring(13, domanda.length() - 2);
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (coloreCapelli.equals(game.getHandler().getListPeople().get(i).getColoreCapelli().substring(0, game.getHandler().getListPeople().get(i).getColoreCapelli().length() - 1))) { //cerco chi ha il colore dei capelli uguale e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index >= 13 && index <= 15) {
                String coloreOcchi = domanda.substring(13, domanda.length() - 2);
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (coloreOcchi.equals(game.getHandler().getListPeople().get(i).getColoreOcchi().substring(0, game.getHandler().getListPeople().get(i).getColoreOcchi().length() - 1))) { //cerco chi ha il colore degli occhi uguale e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 1) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getOcchiali()) { //cerco chi ha gli occhiali e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 2) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getBarba()) { //cerco chi ha la barba e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 3) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getCappello()) { //cerco chi ha il cappello e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 4) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getBaffi()) { //cerco chi ha i baffi e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 5) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getNasoGrande()) { //cerco chi ha il naso grande e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 6) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getGuanceRosse()) { //cerco chi ha le guance rosse e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 7) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getCapelli()) { //cerco chi ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 16) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (!game.getHandler().getListPeople().get(i).getGenere()) { //cerco chi non ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (index == 17) {
                for (int i = 0; i < game.getHandler().getListPeople().size(); i++) {
                    if (game.getHandler().getListPeople().get(i).getGenere()) { //cerco chi non ha i capelli e cambio l'immagine
                        game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage(""));
                        if (i < 25) {
                            count++;
                        }
                    }
                }
            } else if (indexSpecial != "") {
                int dialogButton = JOptionPane.showConfirmDialog(null, "HAI PERSO", "HAI PERSO", JOptionPane.OK_CANCEL_OPTION);
                if (dialogButton == JOptionPane.OK_OPTION) {
                    out.println("exit2");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stopConnection();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                game.window.getBtn().setVisible(false);
                game.window.getCmb().setVisible(false);
                game.gameState = STATE.Menu;
                //oppure invece che ricominciare si può mettere un System.exit(0)
            }
        }
        game.getHud().increaseScore(count);
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
