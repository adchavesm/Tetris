
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
public class Pieza {

    SuperficieDeDibujo superficieDeDibujo;
    Tablero tablero;
    Imagen imagen;
    Dupla posicion = new Dupla(3, 1);
    Tetrimino PA = Tetrimino.Aleatorio();
    Tetrimino Proximos[] = new Tetrimino[7];


    public Pieza(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        this.tablero = superficieDeDibujo.tablero;
        this.imagen = superficieDeDibujo.imagen;
        for (int i = 0; i < Proximos.length; i++) {
            Proximos[i] = Tetrimino.Aleatorio();

        }

    }

    public void dibujar(Graphics g) {

        for (int i = 0; i < 4; i++) {
            imagen.dibujarPeriferico(new Dupla(posicion.X + PA.periferico[i].X, posicion.Y + PA.periferico[i].Y), g, PA.nombre);
        }
        
        for (int i = 0; i < Proximos.length; i++) {
            Dupla pos = new  Dupla (12, 5);
            for (int j = 0; j < Proximos[i].periferico.length; j++) {
                double XReal = Proximos[0].periferico[j].X+pos.X;
                double YReal = Proximos[0].periferico[j].Y+pos.Y;
                imagen.dibujarPeriferico(new Dupla(XReal, YReal), g, Proximos[0].nombre);
            }
            
        }
    }

    public void Reiniciar() {
        posicion = new Dupla(4, 0);
        PA = Proximos[0];
        for (int i = 0; i < Proximos.length - 1; i++) {
            Proximos[i] = Proximos[i + 1];
        }
        Proximos[Proximos.length - 1] = Tetrimino.Aleatorio();
    }

    public void MoverDerecha() {
        posicion.moverDerecha();
        if (MoimientoErroneo()) {
            posicion.moverIzquierda();
        }
    }

    public void MoverIzquierda() {
        posicion.moverIzquierda();
        if (MoimientoErroneo()) {
            posicion.moverDerecha();
        }
    }

    public void MoverAbajo() {
        posicion.moverAbajo();
        if (MoimientoErroneo()) {
            posicion.moverArriba();
            Reiniciar();
        }
    }

    public boolean MoimientoErroneo() {
        for (int i = 0; i < PA.periferico.length; i++) {
            double XReal = PA.periferico[i].X + posicion.X;
            double YReal = PA.periferico[i].Y + posicion.Y;
            if (XReal > tablero.COLUMNAS - 1 || XReal < 0) {
                return true;
            }
            if (YReal > tablero.FILAS - 1) {
                return true;
            }

        }
        return false;
    }

}
