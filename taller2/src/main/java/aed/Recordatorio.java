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
        return "mensaje @ " + mensajeClase + " " + fechaClase + " " + horarioClase;
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        return true;
    }

}
