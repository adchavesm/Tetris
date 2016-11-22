
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
public class Imagen {

    SuperficieDeDibujo superficieDeDibujo;
    Dupla posicioDelTablero;
    int lado;

    public Imagen(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        posicioDelTablero = superficieDeDibujo.tablero.posicion;
        lado = superficieDeDibujo.tablero.LADO;
    }

    public Dupla calcularPosicion(Dupla pos) {
        int X = (int) (pos.X * lado + posicioDelTablero.X);
        int Y = (int) (pos.Y * lado + posicioDelTablero.Y);
        return new Dupla (X,Y);
    }

    public void dibujarPeriferico(Dupla pos, Graphics g) {//Dibuja dentro del buffer
        g.fillRect((int)calcularPosicion(pos).X, (int)calcularPosicion(pos).Y, lado, lado);
    }
}
