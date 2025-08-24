package org.GrupoINF;

public class Atraccion {
    private String nombre;
    private String codigoAtraccion;
    private boolean activa;
    private String descripcion;

    public Atraccion() {
    }

    public Atraccion(String nombre, String codigoAtraccion, boolean activa, String descripcion) {
        this.nombre = nombre;
        this.codigoAtraccion = codigoAtraccion;
        this.activa = activa;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAtraccion() {
        return this.codigoAtraccion;
    }

    public void setCodigoAtraccion(String codigoAtraccion) {
        this.codigoAtraccion = codigoAtraccion;
    }

    public boolean isActiva() {
        return this.activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return "Atracción: " + this.nombre + " | Código: " + this.codigoAtraccion + " | Activa: " + this.activa + " | " + this.descripcion;
    }
}

