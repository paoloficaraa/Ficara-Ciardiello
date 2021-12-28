
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ficara_paolo
 */
//classe che descrive ogni bottone della persona
public class Person extends GameObject {

    public Person(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.black);
        //g.fillRect(x, y, 32, 32);
        //Image image = Toolkit.getDefaultToolkit().getImage("src\\images\\img1.jpg");
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(img, x, y, null);
    }

}
