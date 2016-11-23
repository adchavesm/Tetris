/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Dupla {

    double X;
    double Y;

    public Dupla(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public void sustituir(double a, double b) {
        X = a;
        Y = b;
    }

    public int intX() {
        return (int) X;
    }

    public int intY() {
        return (int) Y;
    }

    public void Adicionar(Dupla dupla) {
        X += dupla.X;
        Y += dupla.Y;
    }

    public void moverDerecha() {//Mueve un espacio a la derecha
        X++;
    }

    public void moverIzquierda() {//Mueve un espacio a la izquierda
        X--;
    }

    public void moverAbajo() {//Mueve un espacio hacia abajo
        Y++;
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

}
