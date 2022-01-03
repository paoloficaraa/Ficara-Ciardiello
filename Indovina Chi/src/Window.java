
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

        cmb = new JComboBox<String>();

        for (int i = 0; i < domande.size(); i++) {
            cmb.addItem(domande.get(i));
        }

        cmb.setSelectedIndex(0);
        cmb.setBounds(600, 15, 200, 32);
        cmb.setVisible(false);
        frame.add(cmb);

        btn = new JButton("INVIA");
        btn.setBounds(900, 15, 100, 32);
        btn.setVisible(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
