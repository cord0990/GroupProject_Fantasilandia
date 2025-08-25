package org.GrupoINF;

// Clase que representa el horario de inicio a fin de una atracción.
public class HorariosAtraccion {
    // ====== Atributos ======
    private String horaInicio; // Hora en que comienzo
    private String horaFin;//Hora de finalizacion

    // ====== Constructor ======
    // Al Crear un Bloque de horario, debemos darle la hora de inicio y fin
    public HorariosAtraccion(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // ====== Métodos Getter ======
    // Devuelven la hora de inicio y fin
    // Como El horario no se cambia , no usaremos Setters.

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public String getHoraFin() {
        return this.horaFin;
    }

    // ====== Imprimir datos ======
    public String toString() {
        return this.horaInicio + " - " + this.horaFin;
    }
}

