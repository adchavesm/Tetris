
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COMPAQ
 */
public class SuperficieDeDibujo extends Canvas{
    
    private BufferStrategy buffer; //Clase para cargar bien las imajenes
    private Graphics g;//Clase para dibujar
    Imagen imagen;
    Tablero tablero;
    Pieza pieza;

    public SuperficieDeDibujo(int ancho, int alto) {//Area de dibujo
        setSize(ancho, alto);
        tablero = new Tablero(this);
        imagen = new Imagen(this);
        pieza = new Pieza(this);
    }
    
    public void dibujar(){
        buffer = getBufferStrategy();
        
        if(buffer == null){
            createBufferStrategy(2);//Crea buffer si esta vacio
            return;
        }
        
        g = buffer.getDrawGraphics();//g dibuje en el buffer
        
        //Aca se dibuja todo lo necesario
        
        tablero.dibujar(g);
        pieza.dibujar(g);
        
        g.dispose();//Desecha en contenido de g
        buffer.show();//Muestra el buffer
    }
    
}
