
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.List;
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

    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        String[] domande = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
        cmb = new JComboBox<String>(domande);
        cmb.setSelectedIndex(0);
        cmb.setBounds(600, 15, 200, 32);
        cmb.setVisible(false);
        frame.add(cmb);

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
}
