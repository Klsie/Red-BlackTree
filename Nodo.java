/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red.black;

/**
 *
 * @author Rodrigo Arana
 */
public class Nodo {
    
    public static Nodo root = null;

    Nodo izquierda, derecha;
    int data;
    boolean color;
    //rojo => true; black => false

    public Nodo(int data) {
        this.data = data;
        izquierda = derecha = null;
        color = true;
    }
    
    

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
    
    
    
}
