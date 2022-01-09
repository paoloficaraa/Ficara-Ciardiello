
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
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private boolean running;
    private Thread thread;
    private Handler handler;
    private HUD hud;
    private Menu menu;
    private Person personaScelta; // persona da scegliere a inizio gioco
    private JScelta finestraScelta; // finestra per la scelta del personaggio
    private PersonChosen finestraPersona; //finestra scleta del personaggio (dopo averlo selezionato)
    private int turno;
    private Server server;
    private Client client;
    public Window window;

    public STATE gameState = STATE.Menu; //enumerazione che indentifica lo stato del gioco

    //costruttore del gioco
    public Game() {
        running = false;
        handler = new Handler();
        finestraScelta = new JScelta(this, handler);
        finestraPersona = new PersonChosen(this);
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        this.addMouseListener(finestraScelta);
        this.addMouseListener(finestraPersona);
        personaScelta = null;
        turno = -1;

        window = new Window(1280, 720, "Indovina chi?", this);

        hud = new HUD();
        server = new Server(6666, this);
        client = new Client(this);
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
            e.getMessage();
        }
    }

    @Override
    public void run() {
        while (running) {
            //finchè il gioco sta andando, mostra la grafica
            render();
        }
        stop();
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

            //combo visibile per la scelta della domanda
            window.getCmb().setVisible(true);

            //bottone invia visibile
            window.getBtn().setVisible(true);

            //creazione e associazione delle persone sia in grafica che nella lista
            MyFile file = new MyFile("src\\Persone\\filePersone.txt"); //persone già costruite dentro questo file di testo
            List<String> persone = file.leggi();
            for (String s : persone) {
                String[] temp = s.split(";");
                handler.addPerson(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Toolkit.getDefaultToolkit().getImage(temp[2]),
                        Boolean.parseBoolean(temp[3]), Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]), Boolean.parseBoolean(temp[6]),
                        Boolean.parseBoolean(temp[7]), Boolean.parseBoolean(temp[8]), Boolean.parseBoolean(temp[9]), temp[10], temp[11], temp[12]));
            }
        } else if (gameState == STATE.Menu) {
            menu.render(g); //grafica menù
        } else if (gameState == STATE.WindowChoice) {
            finestraScelta.render(g);   //grafica scelta del personaggio
        } else if (gameState == STATE.WindowChosen) {
            finestraPersona.render(g);  //grafica personaggio scelto
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

    public void setPersonaScelta(Person personaScelta) {
        this.personaScelta = personaScelta;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Server getServer() {
        return server;
    }

    public Client getClient() {
        return client;
    }

    public boolean isRunning() {
        return running;
    }
}
