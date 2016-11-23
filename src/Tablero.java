
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
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
    Imagen imagen;

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
        int Y = FILAS - 1, lineas = 0;

        while (Y >= 0) {
            int X = 0;

            while (X < COLUMNAS && !Tablero[X][Y].equals("")) {
                X++;
            }

            if (X == COLUMNAS) {
                lineas++;
                bajarLineas(Y);
            } else {
                Y--;
            }

        }
        //Aqui aumentaran las lineas para el puntaje
        System.out.println("Lineas = " + lineas);
    }

    public void bajarLineas(int Y) {
        for (int X = 0; X < COLUMNAS; X++) {
            Tablero[X][Y] = "";
        }

        while (Y >= 0) {
            for (int X = 0; X < COLUMNAS; X++) {
                Tablero[X][Y] = Y==0?"":Tablero[X][Y-1];
            }
            Y--;
        }
    }

    public String Obtener(int x,int y){
        if(y>=0){
           return Tablero[x][y]; 
        }   
        return "";
    }                    
        
    }


