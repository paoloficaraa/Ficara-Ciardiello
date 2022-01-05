
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

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
    
    public PersonChosen(Game game){
        this.game = game;
    }
    
    public void render(Graphics g){
        game.getPersonaScelta().setX(590);
        game.getPersonaScelta().setY(270);
        game.getPersonaScelta().render(g);
    }
}
