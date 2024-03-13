/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red.black;

import java.util.Random;
import static red.black.Nodo.root;

/**
 *
 * @author Rodrigo Arana
 */
public class Main {
    
    static Arbol nodo = new Arbol();
    static Random rand = new Random();
    
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            int numeroAleatorio = rand.nextInt(50) + 1;
            root = nodo.insert(root, numeroAleatorio);
            root.color = false;
        }
        
        System.out.println("Arbol");
        nodo.imprimirArbol(root);
        System.out.println("Preorder----------------------------");
        nodo.preOrden(root);
        System.out.println("PostOrder----------------------------");
        nodo.postOrden(root);
        System.out.println("Inorder----------------------------");
        nodo.inOrden(root);
    }
    
}
