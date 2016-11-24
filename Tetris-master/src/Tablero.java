
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.*;


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
    final int LADO = 28;// lado de los cuadrados

    String Tablero[][];
    SuperficieDeDibujo superficieDeDibujo;
    int anchoSDD, altoSDD, puntaje;// ancho y alto superficie de dibujo... Puntuacion
    Dupla posicion;
    Imagen imagen;
    Puntuacion myWindow;

    public Tablero(SuperficieDeDibujo superficieDeDibujo) {
        this.myWindow = new Puntuacion("");// inicia puntuacion y superficie de dibujo
        this.superficieDeDibujo = superficieDeDibujo;
        calcularPosicion();
        Tablero = new String[COLUMNAS][FILAS];//Crea una matriz con datos null
        casillasVacias();
    }

    public void casillasVacias() {// hace que cada posicion en la matriz quede vacia
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = "";
            }
        }
    }

    public void calcularPosicion() {
        anchoSDD = superficieDeDibujo.getWidth();
        altoSDD = superficieDeDibujo.getHeight();
        posicion = new Dupla((anchoSDD - COLUMNAS * LADO) / 4, (altoSDD - FILAS * LADO) / 2);//Calcula con la mitad para que quede en el centro y corrido a la derecha
    }

    public void dibujar(Graphics g) {
        for (int Y = 0; Y < FILAS; Y++) {
            for (int X = 0; X < COLUMNAS; X++) {
                Dupla posTemp = new Dupla(X * LADO + posicion.X, Y * LADO + posicion.Y);//Posicion en pixeles

                //dibujar casiilla
                if (Tablero[X][Y] == "") {

                    g.setColor(Color.BLACK);

                    if ((X + Y) % 2 == 0) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else {
                        g.setColor(Color.GRAY);
                    }

                    g.fillRect(posTemp.intX(), posTemp.intY(), LADO, LADO);

                    g.setColor(Color.BLACK);
                    g.drawRect(posTemp.intX(), posTemp.intY(), LADO, LADO);

                } else {
                    imagen.dibujarPeriferico(new Dupla(X, Y), g, Tablero[X][Y]);
                }

                //psicion y dimenciones de la casilla
                //dibujar posicion detro de la casilla
                g.setFont(new Font("verdana", Font.PLAIN, 9));

                //g.drawString(X + "," + Y, (int) posTemp.X, (int) posTemp.Y + 11);//Pone conrdenadas en la matris
            }
        }

    }

    public void borrarLineas() {
        int Y = FILAS - 1;

        while (Y >= 0) {
            int X = 0;

            while (X < COLUMNAS && !Tablero[X][Y].equals("")) {
                X++;
            }

            if (X == COLUMNAS) {
                puntaje += 10;
                bajarLineas(Y);
            } else {
                Y--;
            }

        }
        System.out.println("Puntaje = " + puntaje);
    }

    public void bajarLineas(int Y) {
        for (int X = 0; X < COLUMNAS; X++) {
            Tablero[X][Y] = "";
        }

        while (Y >= 0) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = Y == 0 ? "" : Tablero[X][Y - 1];
            }
            Y--;
        }
    }

    public void finDeJuego() {
        int X = COLUMNAS - 1;
        while (X >= 0) {
            int Y = 1;
            int Z = 0;
            while (Y >= 0 && !Tablero[X][Y].equals("")) {
                Z = 1;
                Y--;
            }
            X--;
            if (Z == 1) {

                String PuntajeL = String.valueOf(puntaje);
                X = -1;
                System.out.println("hoaaaaaa");
                myWindow.main(PuntajeL);
            }
        }
    }

    public String Obtener(int x, int y) {
        if (y >= 0) {
            return Tablero[x][y];
        }
        return "";
    }

}
