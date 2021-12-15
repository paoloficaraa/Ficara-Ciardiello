
import java.awt.Canvas;

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
    
    public Game(){
        new Window(1280, 720, "Indovina chi?", this);
    }
    
    public synchronized void start(){
        
    }
    
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0
            }
        }
        stoop();
    }
    public static void main(String[] args) {
        new Game();
    }
    
}
