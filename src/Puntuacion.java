
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andres
 */
public class Puntuacion extends Frame implements WindowListener, ActionListener {

    JTextArea b;
    JTextArea text = new JTextArea("aaaaaaa");

    public Puntuacion(String title) {

        setLayout(new BorderLayout());
        addWindowListener(this);
        b = new JTextArea("PUNTACION");
        text = new JTextArea(title);
        add(b,BorderLayout.NORTH);
        add(text,BorderLayout.WEST);
    }

    public void main(String title) {
        Puntuacion myWindow = new Puntuacion(title);
        myWindow.setSize(350, 100);
        myWindow.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        text.setText("a");
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

}
