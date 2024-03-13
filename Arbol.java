/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red.black;

/**
 *
 * @author Rodrigo Arana
 */
public class Arbol {
    
    //Insercion en Arbol 
    
    public boolean isRed(Nodo myNodo){
        if(myNodo == null)
            return false;
        return (myNodo.color == true);
    }
    
   public Nodo insert(Nodo myNodo,int data){
       if(myNodo == null){
           return new Nodo(data);
       }
       if(data<myNodo.data){
           myNodo.izquierda=insert(myNodo.izquierda, data);
       }
       else if(data>myNodo.data){
           myNodo.derecha = insert(myNodo.derecha, data);
       }
       else{
           return myNodo;                   
       }
       
       //Caso1 cuando hijo derecho es rojo pero hijo izquierdo es negro, o no existe
       if(isRed(myNodo.derecha) && !isRed(myNodo.izquierda)){
           //Giramos a la izquierda para hacer una estructura valida
           myNodo = girarIzquierda(myNodo);
           //cambio de color el nodo hijo, siempre debe deser rojo
           cambioColor(myNodo, myNodo.izquierda);
       }
       //Caso2 cuando el hijo izquierdo y el nieto estan en rojo
       if(isRed(myNodo.izquierda) && isRed(myNodo.izquierda.izquierda)){
           //Giramos a la derecha el nodo actual para hacer una estructura valida
           myNodo = girarDerecha(myNodo);
           cambioColor(myNodo, myNodo.derecha);
       }
       //Caso3 Cuando los hijos derecha e izquierda estan en rojo
       if(isRed(myNodo.izquierda) && isRed(myNodo.derecha)){
           //Invertimos el color del nodo de su hijo izquierdo y derecho
           myNodo.color = !myNodo.color;
           
           //Cambiamos el color a negro 
           myNodo.izquierda.color = false;
           myNodo.derecha.color = false;
       }
       return myNodo;
   }
   
   //Cambio de Color en los Nodos
   public void cambioColor(Nodo nodo1,Nodo nodo2){
       boolean temporal = nodo1.color;
       nodo1.color = nodo2.color;
       nodo2.color = temporal;
   }
   
   //Giro Antihorario
   public Nodo girarIzquierda(Nodo myNodo){
       Nodo hijo = myNodo.derecha;
       Nodo hijoIzquierdo = hijo.izquierda;
       
       hijo.izquierda = myNodo;
       myNodo.derecha = hijoIzquierdo;
       return hijo;
   }
   //Giro Horario
   public Nodo girarDerecha(Nodo myNodo){
       Nodo hijo = myNodo.izquierda;
       Nodo hijoDerecho = hijo.derecha;
       
       hijo.derecha = myNodo;
       myNodo.izquierda = hijoDerecho;
       return hijo;
   }
   
   public int obtenerAltura(Nodo myNodo){
       if(myNodo == null)
           return 0;
       int izquierda = obtenerAltura(myNodo.izquierda);
       int derecha = obtenerAltura(myNodo.derecha);
       return Integer.max(izquierda, derecha)+1;
   }
   
   //Obtener Valores del Nivel del Arbol
   public void imprimirArbol(Nodo myNode){
       int altura = obtenerAltura(myNode);
       String[] levels = new String[altura];
       imprimirArbol(myNode,0,levels);
       for(int i=0;i<levels.length;i++){
           System.out.println(levels[i]+" Niveles "+i);
       }
   }
   //Imprimir Arbol
   public void imprimirArbol(Nodo myNode,int level, String[] levels){
       if(myNode!=null){
           levels[level]=myNode.getData()+ " " + (levels[level] != null ? levels[level] + " " : " ");
           imprimirArbol(myNode.derecha,level+1,levels);
           imprimirArbol(myNode.izquierda,level+1,levels);
       }
   }
   
   //Imprimir Preorden 
   public void preOrden(Nodo myNodo){
       if(myNodo != null){
           System.out.println(myNodo.getData());
           preOrden(myNodo.izquierda);
           preOrden(myNodo.derecha);
       }
   }
   
   //Imprimir en postOrden
   public void postOrden(Nodo myNodo){
       if(myNodo != null){
           
           postOrden(myNodo.izquierda);
           postOrden(myNodo.derecha);
           System.out.println(myNodo.getData());
       }
   }
   
   //Imprimir inOrden
   public void inOrden(Nodo myNodo){
       if(myNodo != null){
           inOrden(myNodo.izquierda);
           System.out.println(myNodo.getData());
           inOrden(myNodo.getDerecha());
       }
   }
}
