
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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
public class JScelta extends MouseAdapter {

    private Game game;
    private Handler handler;

    public JScelta(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (game.gameState == STATE.WindowChoice) {
            int mx = e.getX();
            int my = e.getY();
            int x = 50;
            int y = 70;

            for (int i = 1; i < handler.getListPeople().size(); i++, x += 150) {
                if (i == 9 || i == 17) {
                    x = 50;
                    y += 200;
                }
                if (mouseOver(mx, my, x, y, 100, 180)) {
                    game.setPersonaScelta(handler.getListPeople().get(i - 1));
                    game.gameState = STATE.WindowChosen;
                }
            }
        }
    }

    //metodo privato che dice se il puntatore del mouse è sopra una determinata area
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        Font fnt = new Font("arial", 1, 40);
        g.setFont(fnt);
        g.drawString("SCEGLI IL PERSONAGGIO", 375, 50);

        if (game.getPersonaScelta() != null) {
            game.getPersonaScelta().setX(20000);
            game.getPersonaScelta().setY(20000);
        }

        MyFile file = new MyFile("src\\Persone\\filePersone.txt"); //persone già costruite dentro questo file di testo
        List<String> persone = file.leggi();
        for (String s : persone) {
            String[] temp = s.split(";");
            handler.addPerson(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Toolkit.getDefaultToolkit().getImage(temp[2]),
                    Boolean.parseBoolean(temp[3]), Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]), Boolean.parseBoolean(temp[6]),
                    Boolean.parseBoolean(temp[7]), Boolean.parseBoolean(temp[8]), Boolean.parseBoolean(temp[9]), temp[10], temp[11], temp[12], Boolean.parseBoolean(temp[13])));
        }

    }
}
