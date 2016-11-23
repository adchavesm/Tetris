/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Tetrimino {

    Dupla periferico[];
    String nombre;

    public Tetrimino(Dupla periferico0, Dupla periferico1, Dupla periferico2, Dupla periferico3, String nombre) {
        periferico = new Dupla[4];
        periferico[0] = periferico0;
        periferico[1] = periferico1;
        periferico[2] = periferico2;
        periferico[3] = periferico3;
        this.nombre = nombre;
    }

    public static Tetrimino consultar(String nombre) {
        //consultar Nombre (Devuelve el mapa de las posiciones)
        switch (nombre) {
            case "Z":
                return new Tetrimino(new Dupla(0, 0), new Dupla(-1, -1), new Dupla(0, -1), new Dupla(1, 0), "Z");
            case "S":
                return new Tetrimino(new Dupla(0, 0), new Dupla(-1, 0), new Dupla(0, -1), new Dupla(1, -1), "S");
            case "J":
                return new Tetrimino(new Dupla(0, 0), new Dupla(-1, -1), new Dupla(-1, 0), new Dupla(1, 0), "J");
            case "L":
                return new Tetrimino(new Dupla(0, 0), new Dupla(-1, 0), new Dupla(1, -1), new Dupla(1, 0), "L");
            case "T":
                return new Tetrimino(new Dupla(0, 0), new Dupla(0, -1), new Dupla(-1, 0), new Dupla(1, 0), "T");
            case "O":
                return new Tetrimino(new Dupla(0, 0), new Dupla(0, -1), new Dupla(1, -1), new Dupla(1, 0), "O");
            case "I":
                return new Tetrimino(new Dupla(0, 0), new Dupla(-1, 0), new Dupla(1, 0), new Dupla(2, 0), "I");
        }
        //Tetrimino vacio (predeterminado)
        return new Tetrimino(new Dupla(0, 0), new Dupla(0, 0), new Dupla(0, 0), new Dupla(0, 0), "");
    }

}
