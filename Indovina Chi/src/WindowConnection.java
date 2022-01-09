
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class WindowConnection extends MouseAdapter {

    private Game game;

    public WindowConnection(Game game) {
        this.game = game;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (game.gameState == STATE.windowConnection) {
            int mx = e.getX();
            int my = e.getY();

            if (mouseOver(mx, my, 600, 413, 100, 40)) {     //se si preme il bottone Connetti si instaura la connessione
                game.getServer().start();
                
                try {
                    game.getClient().startConnection(game.window.getTxtIp().getText(), Integer.parseInt(game.window.getTxtPorta().getText()));
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
                
                game.gameState = STATE.WindowChoice;
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
        
        game.window.getTxtIp().setText("sono IP");
        game.window.getTxtPorta().setText("sono Porta");
        game.window.getTxtServer().setText("sono Server");

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 0, 30);
        Font fnt3 = new Font("arial", 0, 20);

        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawString("Connessione", 490, 100);

        g.setFont(fnt2);
        g.drawString("IP", 542, 220);
        game.window.getTxtIp().setVisible(true);
        
        g.drawString("Porta", 500, 320);
        game.window.getTxtPorta().setVisible(true);
        
        g.drawString("Porta Server", 405, 420);
        game.window.getTxtServer().setVisible(true);
        
        g.setFont(fnt3);
        g.drawString("Connetti", 613, 540);
        g.drawRect(600, 513, 100, 40);

    }
}
