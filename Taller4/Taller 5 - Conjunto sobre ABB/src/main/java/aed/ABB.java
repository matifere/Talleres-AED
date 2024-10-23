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
        Nodo actual = raiz;
        while (true) {
            if (actual.menor == null) {
                return actual.valor;
            }
            actual = actual.menor;
        }

    }

    public T maximo() {
        if (largo == 0) {
            return null;
        }
        Nodo actual = raiz;
        while (true) {
            if (actual.mayor == null) {
                return actual.valor;
            }
            actual = actual.mayor;
        }
    }

    // empecemos por aca
    public void insertar(T elem) {

        // como no deberian haber elementos repetidos le pregunto si pertenece
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

            // primero chequeo la raiz
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
        // descarto casos donde el elemento no se encuentre, el arbol sea vacio o el
        // elem sea null
        if (!pertenece(elem) || cardinal() == 0 || elem == null) {
            return;
        }

        Nodo actual = raiz;
        Nodo padre = null;
        boolean esIzq = false;

        // obtengo la refe al nodo
        while (actual != null && !actual.valor.equals(elem)) {
            padre = actual;
            if (elem.compareTo(actual.valor) < 0) {
                esIzq = true;
                actual = actual.menor;
            } else {
                esIzq = false;
                actual = actual.mayor;
            }
        }

        // caso1, el nodo no tiene hijos
        if (actual.menor == null && actual.mayor == null) {
            if (actual == raiz) {
                raiz = null;
            } else if (esIzq) {
                padre.menor = null;
            } else {
                padre.mayor = null;
            }
        }
        // caso2 el nodo tiene un hijo (izq o der, no ambos)
        else if (actual.mayor == null) {
            if (actual == raiz) {
                raiz = actual.menor;
            } else if (esIzq) {
                padre.menor = actual.menor;
            } else {
                padre.mayor = actual.menor;
            }
        } else if (actual.menor == null) {
            if (actual == raiz) {
                raiz = actual.mayor;
            } else if (esIzq) {
                padre.menor = actual.mayor;
            } else {
                padre.mayor = actual.mayor;
            }
        }
        // caso 3 el nodo tiene dos hijos
        else {
            Nodo sucesor = actual.mayor;
            Nodo sucesorPadre = actual;
            // reemplazo los valores por la diagonal
            while (sucesor.menor != null) {
                sucesorPadre = sucesor;
                sucesor = sucesor.menor;
            }

            actual.valor = sucesor.valor;

            if (sucesorPadre != actual) {
                sucesorPadre.menor = sucesor.mayor;
            } else {
                sucesorPadre.mayor = sucesor.mayor;
            }
        }

        largo--;
    }

    public String toString() {

        // para este punto intente usar minimo y eliminar pero no logre el resultado (se
        // sobreescribia el abb actual y generaba problemas)
        // como no puedo crear funciones auxiliares opte por este codigo

        String devolver = "{";
        Nodo actual = raiz;
        boolean primero = true;

        if (actual != null) {

            Nodo nodo = raiz;
            Nodo siguiente;

            while (nodo != null) {
                // si no hay nodos menores entonces este nodo es el menor

                if (nodo.menor == null) {
                    if (!primero) {
                        devolver += ",";
                    }

                    devolver += nodo.valor;
                    primero = false;
                    nodo = nodo.mayor;
                } else {

                    siguiente = nodo.menor;

                    while (siguiente.mayor != null && siguiente.mayor != nodo) {
                        siguiente = siguiente.mayor;
                    }

                    if (siguiente.mayor == null) {
                        siguiente.mayor = nodo;
                        nodo = nodo.menor;
                    } else {
                        siguiente.mayor = null;
                        if (!primero) {
                            devolver += ",";
                        }
                        devolver += nodo.valor;
                        primero = false;
                        nodo = nodo.mayor;
                    }
                }
            }
        }

        devolver += "}";
        return devolver;
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
