
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    //ColorRGB color = ColorRGB.Blanco;
    //Color color = Color.WHITE;

    public SuperficieDeDibujo(int ancho, int alto) {//Area de dibujo
        setSize(ancho, alto);
        tablero = new Tablero(this);
        imagen = new Imagen(this);
        pieza = new Pieza(this);
        CapturarTeclas();
        setFocusable(true);
    }
    
    
    
    public void dibujar(){
        buffer = getBufferStrategy();
        
        if(buffer == null){
            createBufferStrategy(2);//Crea buffer si esta vacio
            return;
        }
        
        g = buffer.getDrawGraphics();//g dibuje en el buffer
        
        //Aca se dibuja todo lo necesario
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        
        tablero.dibujar(g);
        pieza.dibujar(g);
        
        
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //g.setColor(Color.BLACK);
        
        
        
        g.dispose();//Desecha en contenido de g
        buffer.show();//Muestra el buffer
    }
    
    public void CapturarTeclas(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {//cuando se preciona una tecla
                if(ke.getKeyCode()==KeyEvent.VK_RIGHT){//Derecha
                    pieza.posicion.moverDerecha();
                    return;
                }else if(ke.getKeyCode()==KeyEvent.VK_LEFT){//Izquierda
                    pieza.posicion.moverIzquierda();
                    return;
                }else if(ke.getKeyCode()==KeyEvent.VK_DOWN){//Abajo
                    pieza.posicion.moverAbajo();
                    return;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {//en que momento se suelta una tecla
            }
        });
    }
    
}
