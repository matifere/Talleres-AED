package aed;

public class Agenda {

    private Fecha fechaActualAgenda;
    private ArregloRedimensionableDeRecordatorios vector;

    public Agenda(Fecha fechaActual) {
        this.fechaActualAgenda = fechaActual;
        vector = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        vector.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String resultado = fechaActualAgenda.toString().concat("\n").concat("=====\n");
        for (int i = 0; i < vector.longitud(); i++) {

            if (vector.obtener(i).fecha().equals(fechaActualAgenda)) {
                String concatenar = vector.obtener(i).toString() + "\n";
                resultado = resultado.concat(concatenar);
            }

        }
        return resultado;
    }

    public void incrementarDia() {
        fechaActualAgenda.incrementarDia();
    }

    public Fecha fechaActual() {
        return fechaActualAgenda;
    }

}
