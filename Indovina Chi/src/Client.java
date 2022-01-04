
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
    private Game game;

    public Client(String stringaDaInviare, Socket socket, Game game) {
        this.stringaDaInviare = stringaDaInviare;
        this.socket = socket;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            out.println(stringaDaInviare);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine = in.readLine();
            if (inputLine != null) {
                String[] v = inputLine.split(";");
                int index = Integer.parseInt(v[0]);
                String domanda = v[1];
                if (inputLine.equals("Y")) {
                    if (index >= 8 && index <= 12) {
                        String coloreCapelli = domanda.substring(12, domanda.length() - 2);
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!coloreCapelli.equals(p.getColoreCapelli())) {
                                //p.setImg();
                            }
                        }
                    } else if (index >= 13 && index <= 15) {
                        String coloreOcchi = domanda.substring(12, domanda.length() - 2);
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!coloreOcchi.equals(p.getColoreOcchi())) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 1) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getOcchiali()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 2) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getBarba()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 3) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getCappello()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 4) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getBaffi()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 5) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getNasoGrande()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 6) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getGuanceRosse()) {
                                //p.setImg();
                            }
                        }
                    } else if (index == 7) {
                        for (Person p : game.getHandler().getListPeople()) {
                            if (!p.getCapelli()) {
                                //p.setImg();
                            }
                        }
                    }
                }
            }
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
