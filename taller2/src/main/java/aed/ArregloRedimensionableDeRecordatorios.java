package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] arregloRecordatorios = new Recordatorio[0];

    public ArregloRedimensionableDeRecordatorios() {

    }

    public int longitud() {
        return arregloRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) { // preguntar si esta bien la implementacion
        Recordatorio[] arraySobrescribir = new Recordatorio[arregloRecordatorios.length + 1];
        for (int j = 0; j < arregloRecordatorios.length; j++) {
            arraySobrescribir[j] = arregloRecordatorios[j];
        }
        // agrego el ultimo elemento al arreglo
        arraySobrescribir[arraySobrescribir.length - 1] = i;
        arregloRecordatorios = arraySobrescribir;
    }

    public Recordatorio obtener(int i) {
        return arregloRecordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] arraySobrescribir = new Recordatorio[arregloRecordatorios.length - 1];
        for (int j = 0; j < arregloRecordatorios.length - 1; j++) {
            arraySobrescribir[j] = arregloRecordatorios[j];
        }
        // saco el ultimo elemento al arreglo
        arregloRecordatorios = arraySobrescribir;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] arraySobrescribir = new Recordatorio[arregloRecordatorios.length];
        if (indice >= arregloRecordatorios.length) { // por las dudas puse esto pero no se si es necesario
            return;
        }
        // primero copio el arreglo hasta la posicion indice
        for (int i = 0; i < indice; i++) {
            arraySobrescribir[i] = arregloRecordatorios[i];
        }
        // cambio el valor en el indice
        arraySobrescribir[indice] = valor;
        // sigo copiando (si es que hay algo mas para copiar)
        if (indice < arregloRecordatorios.length) {
            for (int i = indice + 1; i < arregloRecordatorios.length; i++) {
                arraySobrescribir[i] = arregloRecordatorios[i];
            }
        }
        arregloRecordatorios = arraySobrescribir;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.arregloRecordatorios = new Recordatorio[vector.arregloRecordatorios.length]; 
        for(int i = 0; i < vector.arregloRecordatorios.length; i++){
            this.arregloRecordatorios[i] = vector.arregloRecordatorios[i]; 
        }
        //la cantidad de operaciones new es del largo del arreglo (pues cada uno de sus elementos contiene uno) mas 1 que seria el de la primera linea del constructor
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios(this);
        return copia;
        //aca se le suma un new a la cuenta anterior
    }
}
