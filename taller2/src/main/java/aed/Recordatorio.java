package aed;

public class Recordatorio {

    private String mensajeClase;
    private Horario horarioClase;
    private Fecha fechaClase;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        mensajeClase = mensaje;
        fechaClase = new Fecha(fecha);
        horarioClase = horario;
    }

    public Horario horario() {
        return horarioClase;
    }

    public Fecha fecha() {
        return new Fecha(fechaClase);
    }

    public String mensaje() {
        return mensajeClase;
    }

    @Override
    public String toString() {
        return mensajeClase + " @ " + fechaClase + " " + horarioClase;
    }

    @Override
    public boolean equals(Object otro) {

        boolean otroEsNull = (otro == null);
        boolean claseDist = otro.getClass() != this.getClass();
        if (otroEsNull || claseDist) {
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        // por lo que vimos en labo lo tengo q escribir asi:
        return mensajeClase == otroRecordatorio.mensajeClase
                && horarioClase.equals(otroRecordatorio.horarioClase)
                && fechaClase.equals(otroRecordatorio.fechaClase);
    }

}
