
import java.awt.Font;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author COMPAQ
 */
public class Tablero {

    final int COLUMNAS = 10;
    final int FILAS = 20;
    final int LADO = 28;

    String Tablero[][];
    SuperficieDeDibujo superficieDeDibujo;
    int anchoSDD, altoSDD;
    Dupla posicion;

    public Tablero(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        calcularPosicion();
        Tablero = new String[COLUMNAS][FILAS];
        casillasVacias();
    }

    public void casillasVacias() {
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = "";
            }
        }
    }

    public void calcularPosicion() {
        anchoSDD = superficieDeDibujo.getWidth();
        altoSDD = superficieDeDibujo.getHeight();
        posicion = new Dupla((anchoSDD - COLUMNAS * LADO) / 2, (altoSDD - FILAS * LADO) / 2);
    }

    public void dibujar(Graphics g) {
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Dupla posTemp = new Dupla(X * LADO + posicion.X, Y * LADO + posicion.Y);//Posicion en pixeles

                //dibujar casiilla
                g.drawRect((int) posTemp.X, (int) posTemp.Y, LADO, LADO);//psicion y dimenciones de la casilla

                //dibujar posicion detro de la casilla
                g.setFont(new Font("verdana", Font.PLAIN, 9));
                //g.drawString(X + "," + Y, (int) posTemp.X, (int) posTemp.Y + 11);//Pone conrdenadas en la matris
            }
        }

            
            
        
        
    }

}
