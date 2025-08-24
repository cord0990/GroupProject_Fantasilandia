package org.GrupoINF;

import java.util.ArrayList;
import java.util.List;

public class DiasActivosAnuales {
    private String fecha;
    private List<BloqueDeAtraccion> bloques;

    public DiasActivosAnuales(String fecha) {
        this.fecha = fecha;
        this.bloques = new ArrayList();
    }

    public void addBloque(BloqueDeAtraccion bloque) {
        this.bloques.add(bloque);
    }

    public String toString() {
        String var10000 = this.fecha;
        return "Día activo: " + var10000 + " | Bloques: " + this.bloques.size();
    }
}
