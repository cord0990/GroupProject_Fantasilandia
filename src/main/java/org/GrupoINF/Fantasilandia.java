package org.GrupoINF;

import java.util.ArrayList;
import java.util.List;

public class Fantasilandia {
    private List<Cliente> clientes = new ArrayList();
    private List<Atraccion> atracciones = new ArrayList();

    public Fantasilandia() {
        this.clientes.add(new Cliente("Juan Perez", "12345678-9", "C001", "1990-05-10"));
        this.clientes.add(new Cliente("Maria Soto", "98765432-1", "C002", "1995-11-22"));
        this.atracciones.add(new Atraccion("Montaña Rusa", "A001", true, "Atracción extrema con giros y caídas"));
        this.atracciones.add(new Atraccion("Carrusel", "A002", true, "Atracción infantil con caballitos"));
    }

    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void addAtraccion(Atraccion a) {
        this.atracciones.add(a);
    }

    public void mostrarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");

        for(Cliente c : this.clientes) {
            System.out.println(c);
        }

    }

    public void mostrarAtracciones() {
        System.out.println("\n--- LISTA DE ATRACCIONES ---");

        for(Atraccion a : this.atracciones) {
            System.out.println(a);
        }

    }
}
