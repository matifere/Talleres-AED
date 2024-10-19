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
    // para el taller no estoy teniendo en cuenta casos donde se pidan elementos
    // fuera del rango de la lista

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
        if (longitud == 0) {
            cabeza = cola = nodoAdelante;
        } else {
            nodoAdelante.siguiente = cabeza;
            cabeza = nodoAdelante;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {

        Nodo nodoAtras = new Nodo(elem);
        if (longitud == 0) {
            cabeza = cola = nodoAtras;
        } else {
            cola.siguiente = nodoAtras;
            cola = nodoAtras;
        }
        longitud += 1;

    }

    public T obtener(int i) {

        Nodo actual = cabeza;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        if (i == 0) { // si es el primer elemento elimino la cabeza
            cabeza = cabeza.siguiente;

            if (longitud == 1) {
                cola = null;
            }
        } else {
            Nodo anterior = cabeza;
            // voy hasta el elemento en i
            for (int j = 0; j < i - 1; j++) {
                anterior = anterior.siguiente;
            }
            // lo elimino salteandolo
            anterior.siguiente = anterior.siguiente.siguiente;
            if (i == longitud - 1) {
                cola = anterior;
            }
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        // if (indice == 0) { // puede que esta linea no sea necesaria
        // cabeza.valor = elem;
        // if (longitud == 1) {
        // cola = null;
        // }
        // } else {
        Nodo anterior = cabeza;
        // voy hasta el elemento en i
        for (int j = 0; j < indice - 1; j++) {
            anterior = anterior.siguiente;
        }
        anterior.siguiente.valor = elem;
        if (indice == longitud - 1) {
            cola = anterior;
        }
        // }

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        // se copian los elementos de la lista pasada
        this.longitud = lista.longitud;
        if (lista.cabeza == null) {
            this.cabeza = this.cola = null;
        } else {
            this.cabeza = new Nodo(lista.cabeza.valor);

            Nodo nuevo = this.cabeza;
            Nodo otrNodo = lista.cabeza.siguiente;

            while (otrNodo != null) {
                nuevo.siguiente = new Nodo(otrNodo.valor);
                nuevo = nuevo.siguiente;
                otrNodo = otrNodo.siguiente;
            }
        }
    }

    @Override
    public String toString() {
        String listaDevolver = "[";
        Nodo actual = cabeza;
        for (int i = 0; i < longitud - 1; i++) {
            listaDevolver += actual.valor + ", ";
            actual = actual.siguiente;
        }
        listaDevolver += actual.valor;
        listaDevolver += "]";
        return listaDevolver;
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados
        private int indActual = -1;

        public boolean haySiguiente() {
            return indActual + 1 < longitud();
        }

        public boolean hayAnterior() {
            return indActual > -1;
        }

        public T siguiente() {
            indActual++;
            return obtener(indActual);
        }

        public T anterior() {
            // esto lo deduzco por los test pero parece que cuando va para atras primero se
            // come una iteracion
            // o sea si la lista es [1,2,3] y indice =1 tras ejecutar anterior, res = 2. y
            // si
            // lo ejecuto otra vez, res=1
            T devolver = obtener(indActual);
            if (hayAnterior()) {
                indActual--;
            }
            return devolver;
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
