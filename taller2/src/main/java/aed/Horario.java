package aed;

public class Horario {

    private int horaClase;
    private int minutosClase;

    public Horario(int hora, int minutos) {
        horaClase = hora;
        minutosClase = minutos;
    }

    public int hora() {
        return horaClase;
    }

    public int minutos() {
        return minutosClase;
    }

    @Override
    public String toString() {
        return horaClase + ":" +minutosClase;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDist = otro.getClass() != this.getClass();
        if(otroEsNull || claseDist){
            return false;
        }
        Horario otroHorario = (Horario) otro;
        return horaClase == otroHorario.horaClase && minutosClase == otroHorario.minutosClase;
        
        
    }

}
