/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COMPAQ
 */
public class ControlPrincipal {

    private static SuperficieDeDibujo superdicieDeDibujo;
    private static Ventana ventana;
    private static int APS = 0;//Actualizacion por segundo
    private static int FPS = 0;//Fotogramas por segundo

    public static void main(String[] args) {
        crearVentana(950, 600, "Tetris");
        iterarBuclePrincipal();
    }

    public void iniciarJuego() {
    }
    
    public static void actualizar(){
        APS++;
        superdicieDeDibujo.dibujar();
    }
    
    public static void dibujar(){
        FPS++;
        
    }

    public static void crearVentana(int ancho, int alto, String Nombre) {
        superdicieDeDibujo = new SuperficieDeDibujo(ancho, alto);
        ventana = new Ventana(Nombre, superdicieDeDibujo);
    }

    public static void iterarBuclePrincipal() {//Hacer que los dibujosdel juegosean visibles
        final int NS_POR_SEGUNDO = 1000000000;//Nanosegundos
        final int APS_OBJETIVO = 60;//Actualiza 30 veces por segundo
        final int NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;//Actualiza imajenes 

        long tiempoDeReferenciaActualizacion = System.nanoTime();//Devuerve el momento en el que nos encontramos en nanosegundos
        long tiempoDeReferenciaContador = System.nanoTime();

        double delta = 0;
        double tiempoSinProcesar;

        while (true) {

            long tiempoInicial = System.nanoTime();
            tiempoSinProcesar = tiempoInicial - tiempoDeReferenciaActualizacion;//Tiempo trancurrido desde la referencia 
            tiempoDeReferenciaActualizacion = tiempoInicial;//Tiempo entre ciclo y ciclo
            delta += tiempoSinProcesar / NS_POR_ACTUALIZACION;//Indica el moento de actualizacion

            while (delta >= 1) {
                //Actualizar
                delta--;
                actualizar();
            }
            
            dibujar();

            if (System.nanoTime() - tiempoDeReferenciaContador >= NS_POR_ACTUALIZACION) {//Cada segundo se muestre letrero con actualizaciones por segundo y fotogramas por segundo
                System.out.println("APS = " + APS + "FPS = " + FPS);
                tiempoDeReferenciaContador = System.nanoTime();
                APS = 0;
                FPS = 0;
            }
        }

    }

}
