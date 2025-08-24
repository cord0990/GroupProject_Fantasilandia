package org.GrupoINF;

public class HorariosAtraccion {
    private String horaInicio;
    private String horaFin;

    public HorariosAtraccion(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public String getHoraFin() {
        return this.horaFin;
    }

    public String toString() {
        return this.horaInicio + " - " + this.horaFin;
    }
}

