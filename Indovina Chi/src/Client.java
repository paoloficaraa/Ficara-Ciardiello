
import java.awt.Toolkit;
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

//classe che identifica la parte client del peer
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
                if (inputLine.equals("Y")) { //se quello che viene mandato è sì
                    if (index >= 8 && index <= 12) {
                        String coloreCapelli = domanda.substring(12, domanda.length() - 2);
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!coloreCapelli.equals(game.getHandler().getListPeople().get(i).getColoreCapelli())) { //cerco chi non ha il colore dei capelli uguale e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index >= 13 && index <= 15) {
                        String coloreOcchi = domanda.substring(12, domanda.length() - 2);
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!coloreOcchi.equals(game.getHandler().getListPeople().get(i).getColoreOcchi())) { //cerco chi non ha il colore degli occhi uguale e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 1) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getOcchiali()) { //cerco chi non ha gli occhiali e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 2) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getBarba()) { //cerco chi non ha la barba e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 3) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getCappello()) { //cerco chi non ha il cappello e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 4) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getBaffi()) { //cerco chi non ha i baffi e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 5) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getNasoGrande()) { //cerco chi non ha il naso grande e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 6) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getGuanceRosse()) { //cerco chi non ha le guance rosse e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 7) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (!game.getHandler().getListPeople().get(i).getCapelli()) { //cerco chi non ha i capelli e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    }
                } else if (inputLine.equals("N")) { //se quello che viene mandato è no
                    if (index >= 8 && index <= 12) {
                        String coloreCapelli = domanda.substring(12, domanda.length() - 2);
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (coloreCapelli.equals(game.getHandler().getListPeople().get(i).getColoreCapelli())) { //cerco chi ha il colore dei capelli uguale e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index >= 13 && index <= 15) {
                        String coloreOcchi = domanda.substring(12, domanda.length() - 2);
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (coloreOcchi.equals(game.getHandler().getListPeople().get(i).getColoreOcchi())) { //cerco chi ha il colore degli occhi uguale e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 1) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getOcchiali()) { //cerco chi ha gli occhiali e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 2) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getBarba()) { //cerco chi ha la barba e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 3) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getCappello()) { //cerco chi ha il cappello e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 4) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getBaffi()) { //cerco chi ha i baffi e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 5) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getNasoGrande()) { //cerco chi ha il naso grande e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 6) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getGuanceRosse()) { //cerco chi ha le guance rosse e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
                            }
                        }
                    } else if (index == 7) {
                        for (int i = 0; i < game.getHandler().getListPeople().size();i++) {
                            if (game.getHandler().getListPeople().get(i).getCapelli()) { //cerco chi ha i capelli e cambio l'immagine
                                game.getHandler().getListPeople().get(i).setImg(Toolkit.getDefaultToolkit().getImage("src\\images\\imagesWithX\\Inkedimg" + i + 1 + ".jpg"));
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
