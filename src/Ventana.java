
import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COMPAQ
 */
public class Ventana extends JFrame{

    public Ventana(String nombre, SuperficieDeDibujo superficieDeDibujo) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar ventana
            this.setTitle(nombre);//Titulo de la ventana
            //this.setSize(600, 600);//Dimenciones de la ventana
            this.setResizable(false);//No permite cambiar las dimenciones de la ventana
            this.setLayout(new BorderLayout());//Crea un BorderLayout   
            this.add(superficieDeDibujo);
            this.pack();
            this.setLocationRelativeTo(null);//Centra la ventana en la pantalla
            this.setVisible(true);//Hace visible la ventana
    }
    
}
