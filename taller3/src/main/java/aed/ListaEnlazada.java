package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo cabeza;
    private Nodo cola;
    private int longitud;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public ListaEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;

    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {

        Nodo nodoAdelante = new Nodo(elem);
        if (this.cabeza == null) {
            this.cabeza = nodoAdelante;
            this.cola = nodoAdelante;
        } else {
            nodoAdelante.siguiente = this.cabeza;
            this.cabeza.anterior = nodoAdelante;
            this.cabeza = nodoAdelante;
        }
        this.longitud += 1;
    }

    public void agregarAtras(T elem) {

        Nodo nodoAtras = new Nodo(elem);
        if (this.cola == null) {
            this.cabeza = nodoAtras;
            this.cola = nodoAtras;
        } else { // esta un poco raro esto
            nodoAtras.anterior = this.cola;
            this.cola.siguiente = nodoAtras;
            this.cola = nodoAtras;
        }
        this.longitud += 1;

    }

    public T obtener(int i) {

        for (int j = 0; j < i; j++) { //recorro los nodos hasta el indice
            this.cabeza = this.cabeza.siguiente;
        }
        return this.cabeza.valor;
    }

    public void eliminar(int i) {
        for (int j = 0; j < i; j++) { 
            this.cabeza = this.cabeza.siguiente;
        }
        //eliminar
        //reagrupar nodos
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public boolean hayAnterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T anterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
