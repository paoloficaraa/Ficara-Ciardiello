
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
public class Person {

    private int x, y;
    private Image img;
    private Boolean occhiali, capelli, barba, baffi, nasoGrande, guanceRosse, cappello;
    private String coloreCapelli, coloreOcchi, nome;

    public Person(int x, int y, Image img, Boolean occhiali, Boolean capelli, Boolean barba, Boolean baffi, Boolean nasoGrande, Boolean guanceRosse, Boolean cappello,
            String coloreCapelli, String coloreOcchi, String nome) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.occhiali = occhiali;
        this.capelli = capelli;
        this.barba = barba;
        this.baffi = baffi;
        this.nasoGrande = nasoGrande;
        this.guanceRosse = guanceRosse;
        this.cappello = cappello;
        this.coloreCapelli = coloreCapelli;
        this.coloreOcchi = coloreOcchi;
        this.nome = nome;
    }

    //grafica degli oggetti
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, x, y, null);
    }

//----------------------GET-------------------------------    
    public Boolean getOcchiali() {
        return occhiali;
    }

    public Boolean getCapelli() {
        return capelli;
    }

    public Boolean getBarba() {
        return barba;
    }

    public Boolean getBaffi() {
        return baffi;
    }

    public Boolean getNasoGrande() {
        return nasoGrande;
    }

    public Boolean getGuanceRosse() {
        return guanceRosse;
    }

    public Boolean getCappello() {
        return cappello;
    }

    public String getColoreCapelli() {
        return coloreCapelli;
    }

    public String getColoreOcchi() {
        return coloreOcchi;
    }

    public String getNome() {
        return nome;
    }

    public Image getImg() {
        return img;
    }
//----------------------SET--------------------------------    

    public void setImg(Image img) {
        this.img = img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
