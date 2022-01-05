
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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
public class JScelta extends MouseAdapter{
    
    private Game game;
    private Handler handler;
    
    public JScelta(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }
    
    public void render(Graphics g){
        MyFile file = new MyFile("src\\Persone\\filePersone.txt"); //persone già costruite dentro questo file di testo
            List<String> persone = file.leggi();
            for (String s : persone) {
                String[] temp = s.split(";");
                    handler.addPerson(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Toolkit.getDefaultToolkit().getImage(temp[2]),
                            Boolean.parseBoolean(temp[3]), Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]), Boolean.parseBoolean(temp[6]),
                            Boolean.parseBoolean(temp[7]), Boolean.parseBoolean(temp[8]), Boolean.parseBoolean(temp[9]), temp[10], temp[11], temp[12]));
            }
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        int x = 50;
        int y = 70;
        
//        if(mouseOver(mx, my, 0, 0, 1280, 720)){
//            System.out.println("bella");
//        }

        for(int i = 1; i < handler.getListPeople().size(); i++, x+=150){
            if(i == 9 || i == 17){
                x = 50;
                y+= 200;
            }
            if(mouseOver(mx, my, x, y, 100, 180)){
                System.out.println("bella");
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
}
