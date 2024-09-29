package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] listaRecordatorios = new Recordatorio[0];

    public ArregloRedimensionableDeRecordatorios() {

    }

    public int longitud() {
        return listaRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) { // preguntar si esta bien la implementacion
        Recordatorio[] arraySobrescribir = new Recordatorio[listaRecordatorios.length + 1];
        for (int j = 0; j < listaRecordatorios.length; j++) {
            arraySobrescribir[j] = listaRecordatorios[j];
        }
        // agrego el ultimo elemento al arreglo
        arraySobrescribir[arraySobrescribir.length - 1] = i;
        listaRecordatorios = arraySobrescribir;
    }

    public Recordatorio obtener(int i) {
        return listaRecordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] arraySobrescribir = new Recordatorio[listaRecordatorios.length - 1];
        for (int j = 0; j < listaRecordatorios.length - 1; j++) {
            arraySobrescribir[j] = listaRecordatorios[j];
        }
        // saco el ultimo elemento al arreglo
        listaRecordatorios = arraySobrescribir;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] arraySobrescribir = new Recordatorio[listaRecordatorios.length];
        if (indice >= listaRecordatorios.length) { // por las dudas puse esto pero no se si es necesario
            return;
        }
        // primero copio el arreglo hasta la posicion indice
        for (int i = 0; i < indice; i++) {
            arraySobrescribir[i] = listaRecordatorios[i];
        }
        // cambio el valor en el indice
        arraySobrescribir[indice] = valor;
        // sigo copiando (si es que hay algo mas para copiar)
        if (indice < listaRecordatorios.length) {
            for (int i = indice + 1; i < listaRecordatorios.length; i++) {
                arraySobrescribir[i] = listaRecordatorios[i];
            }
        }
        listaRecordatorios = arraySobrescribir;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
