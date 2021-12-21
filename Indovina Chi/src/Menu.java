
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
 * @author ficara_paolo
 */
public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //bottone gioca
        if (mouseOver(mx, my, 490, 150, 300, 80)) {
            game.gameState = STATE.Game;
            handler.addObject(new Person(100, 100));
        }
        
        //bottone aiuto
        if(mouseOver(mx, my, 490, 300, 300, 80))
            JOptionPane.showMessageDialog(null, "Il pulsante 'gioca' permette di iniziare a giocare invece il pulsante 'esci' chiude la finestra");
        
        //bottone esci
        if(mouseOver(mx, my, 490, 450, 300, 80)){
            System.exit(0);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawString("Menù", 580, 100);

        g.setFont(fnt2);
        g.drawRect(490, 150, 300, 80);
        g.drawString("Gioca", 600, 200);

        g.drawRect(490, 300, 300, 80);
        g.drawString("Aiuto", 605, 350);

        g.drawRect(490, 450, 300, 80);
        g.drawString("Esci", 610, 500);

    }
}
