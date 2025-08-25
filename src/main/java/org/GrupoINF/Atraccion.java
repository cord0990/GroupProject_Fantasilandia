package org.GrupoINF;

//vemos que valores tendra la variable atraccion
public class Atraccion {

    // Atributos privados: solo accesibles dentro de la clase
    private String nombre;
    private String clasificacion;; //clasificacion del juego mecanico
    private String codigoAtraccion;
    private boolean activa;
    private String descripcion;


    // Constructor: sirve para inicializar los atributos de un objeto al crearlo
    public Atraccion(String nombre, String clasificacion,String codigoAtraccion, boolean activa,
                     String descripcion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.codigoAtraccion = codigoAtraccion;
        this.activa = activa;
        this.descripcion = descripcion;
    }

    //Leer o modificar el nombre juego mecanico
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    //Leer o modificar la clasificacion juego mecanico
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    //Leer o modificar el codigo juego mecanico
    public String getCodigoAtraccion() {
        return this.codigoAtraccion;
    }
    public void setCodigoAtraccion(String codigoAtraccion) {
        this.codigoAtraccion = codigoAtraccion;
    }

    //Leer o modificar el estado del juego mecanico
    public boolean isActiva() {
        return this.activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    //Leer o modificar la descripcion del juego mecanico
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Atracción: " + this.nombre +
                " | Clasificación: " + this.clasificacion +
                " | Código: " + this.codigoAtraccion +
                " | Activa: " + this.activa +
                " | " + this.descripcion;
    }
}