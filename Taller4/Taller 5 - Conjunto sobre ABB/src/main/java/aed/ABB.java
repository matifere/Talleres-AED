package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int largo;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private T valor;
        private Nodo menor;
        private Nodo mayor;

        // Crear Constructor del nodo

        Nodo(T valor) {
            this.valor = valor;
            this.menor = null;
            this.mayor = null;
        }

    }

    public ABB() {
        this.raiz = null;
        this.largo = 0;
    }

    public int cardinal() {
        return largo;
    }

    public T minimo() {
        if (largo == 0) {
            return null;
        }
        return null;
    }

    public T maximo() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    // empecemos por aca
    public void insertar(T elem) {

        //como no deberian haber elementos repetidos le pregunto si pertenece
        if (pertenece(elem)) {
            return;
        }

        Nodo insertar = new Nodo(elem);
        
        if (cardinal() == 0) { // si el arbol esta vacio entonces se pone el primer elemento
            raiz = insertar;
        } else {
            Nodo actual = raiz;
            boolean terminar = false;
            while (!terminar) {
                int comparacion = actual.valor.compareTo(elem); // si actual > elem -> n > 0
                if (comparacion > 0) { // si el valor actual es mayor que el elemento a insertar
                    if (actual.menor == null) {
                        actual.menor = insertar;
                        terminar = true;
                    } else {
                        actual = actual.menor;
                    }
                } else {
                    if (actual.mayor == null) {
                        actual.mayor = insertar;
                        terminar = true;
                    } else {
                        actual = actual.mayor;
                    }
                }
            }

        }
        largo++;
    }

    public boolean pertenece(T elem) {
        Nodo elementoAcomparar = new Nodo(elem);
        if (cardinal() == 0) { // si el arbol esta vacio entonces se pone el primer elemento
            return elem == null;
        } else {

            //primero chequeo la raiz
            if (raiz.valor == elementoAcomparar.valor) {
                return true;
            }

            Nodo actual = raiz;
            boolean terminar = false;
            int contador = 0;
            while (!terminar) {
                int comparacion = actual.valor.compareTo(elem); // si actual > elem -> n > 0
                if (comparacion > 0) { // si el valor actual es mayor que el elemento a insertar
                    if (actual.menor != null) {
                        if (actual.menor.valor == elementoAcomparar.valor) {
                            return true;
                        } else {
                            actual = actual.menor;
                            
                        }
                    }

                } else {
                    if (actual.mayor != null) {
                        if (actual.mayor.valor == elementoAcomparar.valor) {
                            return true;
                        } else {
                            actual = actual.mayor;
                            
                        }
                    }

                }
                if (contador == cardinal()) {
                    return false;
                }
                contador++;
            }
            // nunca llega a este return pero me estaba marcando un error por no ponerlo
            return false;
        }
    }

    public void eliminar(T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
