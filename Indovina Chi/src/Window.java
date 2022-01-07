
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ficara_paolo
 */
//classe della finestra
public class Window extends Canvas {

    private JFrame frame;
    private JComboBox cmb;
    private JButton btn;
    private Client c;

    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        MyFile file = new MyFile("src\\Domande\\fileDomande.txt");
        List<String> domande = file.leggi();

        //costruzione comboBox
        cmb = new JComboBox<String>();
        for (int i = 0; i < domande.size(); i++) {
            cmb.addItem(domande.get(i));
        }
        cmb.setSelectedIndex(0);
        cmb.setBounds(600, 15, 200, 32);
        cmb.setVisible(false);
        frame.add(cmb);

        //crazione bottone
        btn = new JButton("INVIA");
        btn.setBounds(900, 15, 100, 32);
        btn.setVisible(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.start();
                try {
                    c.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.add(btn);
        
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JComboBox getCmb() {
        return cmb;
    }

    public JButton getBtn() {
        return btn;
    }
}
