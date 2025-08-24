package org.GrupoINF;

class Cliente {
    private String nombre;
    private String rut;
    private String idCliente;
    private String fechaNacimiento;

    public Cliente() {
    }

    public Cliente(String nombre, String rut, String idCliente, String fechaNacimiento) {
        this.nombre = nombre;
        this.rut = rut;
        this.idCliente = idCliente;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString() {
        return "Cliente: " + this.nombre + " | RUT: " + this.rut + " | ID: " + this.idCliente + " | Nacimiento: " + this.fechaNacimiento;
    }
}
