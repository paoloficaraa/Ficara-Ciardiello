
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
    private JTextField txtIp, txtPorta, txtServer;

    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

      MyFile file = new MyFile("datas/Domande/fileDomande.txt");
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

        //costruzione textBox per connesione
        txtIp = new JTextField();
        txtIp.setBounds(600, 195, 150, 30);
        txtIp.setVisible(false);
        frame.add(txtIp);

        txtPorta = new JTextField();
        txtPorta.setBounds(600, 295, 150, 30);
        txtPorta.setVisible(false);
        frame.add(txtPorta);

        txtServer = new JTextField();
        txtServer.setBounds(600, 325, 150, 30);
        txtServer.setVisible(false);
        frame.add(txtServer);

        //crazione bottone
        btn = new JButton("INVIA");
        btn.setBounds(900, 15, 100, 32);
        btn.setVisible(false);
        btn.addActionListener((ActionEvent e) -> {
            try {
                //System.out.println(cmb.getSelectedItem().toString());
                game.getClient().sendMessage(cmb.getSelectedItem().toString());
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.setTurno(!game.getTurno());
        });
        frame.add(btn);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    game.getClient().sendMessage("exit");
                } catch (NullPointerException ex) {
                    game.setRunning(false);
                } catch (SocketException ex) {
                    game.setRunning(false);
                }
            }
        });

        frame.add(game);
        frame.setVisible(true);
        frame.setFocusable(true);
        game.start();
    }

    public JTextField getTxtServer() {
        return txtServer;
    }

    public JTextField getTxtIp() {
        return txtIp;
    }

    public JTextField getTxtPorta() {
        return txtPorta;
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
