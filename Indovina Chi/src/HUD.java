
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
//classe che identifica l'hud del gioco
public class HUD {

    private int score;

    public HUD() {
        score = 0;
    }

    //grafica dell'hud
    public void render(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.white);
        g.drawString("Punteggio: " + score, 80, 35);
    }

    public void increaseScore(int quantità) {
        score += (quantità * quantità);
    }

}
