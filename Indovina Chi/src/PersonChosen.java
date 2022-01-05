
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class PersonChosen extends MouseAdapter {

    private Game game;

    public PersonChosen(Game game) {
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (game.gameState == STATE.WindowChosen) {
            int mx = e.getX();
            int my = e.getY();

            if (mouseOver(mx, my, 543, 400, 200, 40)) {
                game.gameState = STATE.Game;
                game.getPersonaScelta().setX(20000);
                game.getPersonaScelta().setY(20000);
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
        game.getPersonaScelta().setX(590);
        game.getPersonaScelta().setY(200);

        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 1280, 720);

        //scritta "hai scelto"
        g.setColor(Color.black);
        Font fnt = new Font("arial", 1, 50);
        g.setFont(fnt);
        g.drawString("HAI SCELTO", 500, 150);

        //persona scelta
        game.getPersonaScelta().render(g);

        //bottone continua
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt2);
        g.drawRect(543, 400, 200, 40);
        g.drawString("Continua", 580, 430);
    }
}
