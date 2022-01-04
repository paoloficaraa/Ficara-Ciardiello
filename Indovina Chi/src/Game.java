
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.util.List;
import javax.swing.JComboBox;
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
//classe che descrive il gioco
public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread thread;
    private Handler handler;
    private HUD hud;
    private Menu menu;
    private Person personaScelta;
    public Window window;

    public STATE gameState = STATE.Menu;

    //costruttore del gioco
    public Game() {
        handler = new Handler();
        menu = new Menu(this, handler);
        this.addMouseListener(menu);

        window = new Window(1280, 720, "Indovina chi?", this);

        hud = new HUD();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo che identifica il framerate del gioco e associa ad ogni frame una determinata immagine
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //ogni tick del gioco scandito e aggiornato
    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        }

    }

    //aggiornamento grafica
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 1280, 720);

        handler.render(g);

        if (gameState == STATE.Game) {
            hud.render(g);

            window.getCmb().setVisible(true);

            window.getBtn().setVisible(true);

            MyFile file = new MyFile("src\\Persone\\filePersone.txt");
            List<String> persone = file.leggi();
            for (String s : persone) {
                String[] temp = s.split(";");
                //try {
                    handler.addPerson(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Toolkit.getDefaultToolkit().getImage(temp[2]),
                            Boolean.parseBoolean(temp[3]), Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]), Boolean.parseBoolean(temp[6]),
                            Boolean.parseBoolean(temp[7]), Boolean.parseBoolean(temp[8]), Boolean.parseBoolean(temp[9]), temp[10], temp[11], temp[12]));
                //} catch (ArrayIndexOutOfBoundsException e) {
                //    System.out.println(s.toString());
                //}
            }

        } else if (gameState == STATE.Menu) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }

    public Handler getHandler() {
        return handler;
    }

    public Person getPersonaScelta() {
        return personaScelta;
    }
}
