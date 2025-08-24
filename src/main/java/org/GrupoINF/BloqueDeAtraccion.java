package org.GrupoINF;

import java.util.ArrayList;
import java.util.List;

public class BloqueDeAtraccion {
    private String fecha;
    private String codigoBloque;
    private Atraccion atraccion;
    private HorariosAtraccion horario;
    private List<Cliente> clientesParticipantes;

    public BloqueDeAtraccion(String fecha, String codigoBloque, Atraccion atraccion, HorariosAtraccion horario) {
        this.fecha = fecha;
        this.codigoBloque = codigoBloque;
        this.atraccion = atraccion;
        this.horario = horario;
        this.clientesParticipantes = new ArrayList();
    }

    public void addCliente(Cliente c) {
        this.clientesParticipantes.add(c);
    }

    public String toString() {
        String var10000 = this.codigoBloque;
        return "Bloque " + var10000 + " [" + this.fecha + "] - " + this.atraccion.getNombre() + " | Horario: " + String.valueOf(this.horario) + " | Clientes: " + this.clientesParticipantes.size();
    }
}
