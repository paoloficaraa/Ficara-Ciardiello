
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ficara_paolo
 */
public class HUD {
    
    public int score = 0;
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(15, 15, 200, 32);
    }
    
}