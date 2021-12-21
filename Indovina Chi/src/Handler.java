
import java.awt.Graphics;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ficara_paolo
 */

//Classe gestore che gestisce ogni oggetto del gioco
public class Handler {
    
    LinkedList<GameObject> listObject = new LinkedList<GameObject>();
    
    public void tick(){
        for(GameObject object:listObject){
            GameObject temp = object;
            temp.tick();
        }
    }
    
    public void render(Graphics g){
        for(GameObject object:listObject){
            GameObject temp = object;
            temp.render(g);
        }
    }
    
    public void addObject(GameObject object){
        listObject.add(object);
    }
    
    public void removeObject(GameObject object){
        listObject.remove(object);
    }
    
}
