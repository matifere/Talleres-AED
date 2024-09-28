package aed;

public class Fecha {
    private int diaClase;
    private int mesClase;

    public Fecha(int dia, int mes) {
        diaClase = dia;
        mesClase = mes;
    }

    public Fecha(Fecha fecha) { //no se si me estoy mandando alguna cagada pero no le encuentro utilidad a esto
        // Implementar
    }

    public Integer dia() {
        return diaClase;
    }

    public Integer mes() { //estoy asumiendo que hay un requiere que no permite que el mes sea > 12
        return mesClase;
    }

    public String toString() {
        return diaClase +"/"+ mesClase;
    }

    @Override
    public boolean equals(Object otra) {
        boolean otraEsNull = (otra == null);
        boolean claseDist = otra.getClass() != this.getClass();
        if(otraEsNull || claseDist){
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        return diaClase == otraFecha.diaClase && mesClase == otraFecha.mesClase;
        
    }

    public void incrementarDia() {
        if (diasEnMes(mesClase) == diaClase) {
            diaClase = 1;
            if(mesClase < 12){
                mesClase +=1;
            }
            else{
                mesClase = 1;
            }
        }
        else{
            diaClase += 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
