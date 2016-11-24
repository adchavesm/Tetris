
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
        b = new JTextArea("   TU   PUNTACION:");
        text = new JTextArea(title+"     ");
        add(b,BorderLayout.WEST);
        add(text,BorderLayout.EAST);
    }

    public void main(String title) {
        Puntuacion myWindow = new Puntuacion(title);
        myWindow.setTitle("PUNTUACION");
        myWindow.setLocation(500, 300);
        myWindow.setSize(300, 80);
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
