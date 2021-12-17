
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ficara_paolo
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -240840600533728354L;
    private boolean running = false;
    private Thread thread;
    private Handler handler;
    private HUD hud;
    private Menu menu;

    public enum STATE {
        Menu,
        Game
    };

    public STATE gameState = STATE.Menu;

    public Game() {
        handler = new Handler();
        
        new Window(1280, 720, "Indovina chi?", this);
        
        hud = new HUD();
        menu = new Menu(this);
        if (gameState == STATE.Game) {
            handler.addObject(new Person(100, 100));
        }
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

    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
        } else if (gameState == STATE.Menu){
            menu.tick();
        }

    }

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
        } else if (gameState == STATE.Menu){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }

}
