
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    
    public Menu(Game game){
        this.game = game;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(mouseOver(mx,my,490,150,300,80)){
            game.gameState = STATE.Game;
        }
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx + x < width){
            if(my > y && my + y < height)
                return true;    
        }
        return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        
        Font fnt = new Font("arial",1,50);
        Font fnt2 = new Font("arial",1,30);
        
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
