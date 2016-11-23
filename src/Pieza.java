
import java.awt.Graphics;

public class Pieza implements Runnable {

    SuperficieDeDibujo superficieDeDibujo;
    Tablero tablero;
    Imagen imagen;
    Dupla posicion = new Dupla(5, 1);
    Tetrimino PA = Tetrimino.Aleatorio();
    Tetrimino Proximos[] = new Tetrimino[1];

    Thread Hilo = new Thread(this);
    boolean EstadoDelHilo = true;

    public Pieza(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        this.tablero = superficieDeDibujo.tablero;
        this.imagen = superficieDeDibujo.imagen;
        for (int i = 0; i < Proximos.length; i++) {
            Proximos[i] = Tetrimino.Aleatorio();
        }
        Hilo.start();
    }

    public void dibujar(Graphics g) {
        
        for (int i = 0; i < 4; i++) {
            imagen.dibujarPeriferico(new Dupla(posicion.X + PA.periferico[i].X, posicion.Y + PA.periferico[i].Y), g, PA.nombre);
        }
        for (int i = 0; i < Proximos.length; i++) {
            Dupla pos = new Dupla(15, 7);
            for (int j = 0; j < Proximos[i].periferico.length; j++) {
                double XReal = Proximos[i].periferico[j].X + pos.X;
                double YReal = Proximos[i].periferico[j].Y + pos.Y;
                imagen.dibujarPeriferico(new Dupla(XReal, YReal), g, Proximos[i].nombre);
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

    public void almacenarEnTablero() {
        for (int i = 0; i < PA.periferico.length; i++) {
            int columna = PA.periferico[i].intX() + posicion.intX(),
                    fila = PA.periferico[i].intY() + posicion.intY();
            String dato = PA.nombre;

            tablero.Tablero[columna][fila] = dato;
        }
    }

    public void girarDerecha() {
        PA.girarDerecha();
        if (MovimientoErroneo()) {
            PA.girarIzquierda();
        }
    }

    public void MoverDerecha() {
        posicion.moverDerecha();
        if (MovimientoErroneo()) {
            posicion.moverIzquierda();
        }
    }

    public void MoverIzquierda() {
        posicion.moverIzquierda();
        if (MovimientoErroneo()) {
            posicion.moverDerecha();
        }
    }

    public void MoverAbajo() {
        posicion.moverAbajo();
        if (MovimientoErroneo()) {
            posicion.moverArriba();
            System.out.println("Depositando pieza y reiniciando");
            almacenarEnTablero();
            Reiniciar();
            tablero.borrarLineas();
        }
    }

    public boolean MovimientoErroneo() {
        for (int i = 0; i < PA.periferico.length; i++) {
            double XReal = PA.periferico[i].X + posicion.X;
            double YReal = PA.periferico[i].Y + posicion.Y;
            if (XReal > tablero.COLUMNAS - 1 || XReal < 0) {
                return true;
            }
            if (YReal > tablero.FILAS - 1) {
                return true;
            }
            if (!tablero.Obtener((int) XReal, (int) YReal).equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                MoverAbajo();
                Thread.sleep(1000); //por ahora descansará 1 segundo
            }
        } catch (Exception e) {//Se ejecuta si error
            System.out.println("ERROR EN EL THREAD");
        }
           
    }
    public void PausarReanudar() {
        if (EstadoDelHilo) {
            Hilo.suspend();//pausa
        } else {
            Hilo.resume(); //reanuda
        }
        EstadoDelHilo = !EstadoDelHilo;
    }

}
