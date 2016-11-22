
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
    Dupla posicion =  new Dupla(3,10);
    Tetrimino Z = Tetrimino.consultar("Z");

    public Pieza(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        this.tablero = superficieDeDibujo.tablero;
        this.imagen = superficieDeDibujo.imagen;

    }

    public void dibujar(Graphics g) {

        for (int i = 0; i < 4; i++) {
            imagen.dibujarPeriferico(new Dupla(posicion.X + Z.periferico[i].X, posicion.Y + Z.periferico[i].Y), g);
        }
        

    }

}
