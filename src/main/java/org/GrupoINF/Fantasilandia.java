package org.GrupoINF;

//importamos librerias
import java.util.*;
import java.util.ArrayList;
import java.util.List;

//Clase principal que administrara nuestro paeque de atracciones.
public class Fantasilandia {
    // ====== Listas principales ======
    private List<Cliente> clientes = new ArrayList(); //Guardamos los clientes
    private List<Atraccion> atracciones = new ArrayList(); //Guardamos las atracciones

    //==Uso de mapas para una Busqueda Rapida== (SIA1.7)
    private Map<String, Cliente> clientesPorRut = new HashMap<>(); // Buscar cliente por RUT
    private Map<String, Atraccion> atrPorCodigo = new HashMap<>(); // Buscar atracción por su código
    private Map<String, DiasActivosAnuales> diasPorFecha = new HashMap<>(); // Guardar los días activos (con bloques y clientes)

    //====== Constructor con datos de ejemplo ====== (SIA1.4)
    public Fantasilandia() {
        //clientes iniciales
        Cliente c1 = new Cliente("Juan Perez", "12345678-9", "C001", "1990-05-10");
        Cliente c2 = new Cliente("Maria Soto", "98765432-1", "C002", "1995-11-22");
        addCliente(c1);
        addCliente(c2);

        //atracciones iniciales
        Atraccion a1 = new Atraccion("Montaña Rusa", ClasificacionConst.INFANTILES, "A001", true, "Atracción extrema con giros y caídas");
        Atraccion a2 = new Atraccion("Carrusel", ClasificacionConst.ADRENALINA, "B002", true, "Atracción infantil con caballitos");
        addAtraccion(a1);
        addAtraccion(a2);

        // Creamos un día activo y un bloque con un cliente inscrito para usar de ejemplo
        DiasActivosAnuales d = getODia("2025-08-24");
        BloqueDeAtraccion b = d.addBloque("B001", a1, new HorariosAtraccion("10:00", "11:00"));
        b.addCliente(c1);
    }

    // ====== Métodos para agregar ==============

    // Agregar cliente al sistema
    public void addCliente(Cliente c) {
        clientes.add(c);
        clientesPorRut.put(c.getRut(), c); // lo guardamos en el mapa para encontrar al Cliente por RUT
    }

    // Agregar atracción al sistema
    public void addAtraccion(Atraccion a) {
        atracciones.add(a);
        atrPorCodigo.put(a.getCodigoAtraccion(), a); // lo guardamos en el mapa para encontrar la atraccion por codigo.
    }
    //==========================================

    // ====== Métodos para mostrar =====================

    // Mostrar todos los clientes dentro del sistema.
    public void mostrarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for(Cliente c : clientes) {
            System.out.println(c); // Usa el toString() de Cliente
        }
    }
    // Muestra todas las atracciones dentro del Sistema
    public void mostrarAtracciones() {
        System.out.println("\n--- LISTA DE ATRACCIONES ---");

        for(Atraccion a : atracciones) {
            System.out.println(a); // Usa el toString() de Atraccion
        }
    }

    // ====== Buscar atracción (SIA1.6)======
    public Atraccion buscarAtraccion(String codigo) {
        return atrPorCodigo.get(codigo); // Buscar por código (más rápido con el mapa)
    }
    public Atraccion buscarAtraccion(int index) {
        // Buscar por número en la lista de atracciones
        if (index >= 0 && index < atracciones.size()) return atracciones.get(index);
        return null; // Si el índice no existe retornamos NULL
    }

    // ====== Manejo de días y bloques de Horario======
    public DiasActivosAnuales getODia(String fecha) {
        // Si el día no existe en el mapa, lo crea automáticamente
        return diasPorFecha.computeIfAbsent(fecha, DiasActivosAnuales::new);
    }

    public BloqueDeAtraccion getOCrearBloque(String fecha, String codBloque, Atraccion atr, HorariosAtraccion h) {
        // Busca el día y si no existe lo crea
        DiasActivosAnuales dia = getODia(fecha);

        // Busca el bloque dentro del día
        BloqueDeAtraccion b = dia.buscarBloque(codBloque);
        // Si no existía el bloque, lo crea
        if (b == null) b = dia.addBloque(codBloque, atr, h);
        return b;
    }

    // ====== Inscribir clientes en bloques De Horarios======
    public boolean agregarClienteABloquePorRut(String fecha, String codBloque, String rut) {
        Cliente c = clientesPorRut.get(rut); // buscamos el cliente
        if (c == null) return false; // si no existe el cliente
        DiasActivosAnuales dia = getODia(fecha); // obtenemos el día
        BloqueDeAtraccion b = dia.buscarBloque(codBloque); // buscamos el bloque
        if (b == null) return false; // si no existe el bloque
        b.addCliente(c); // Con esto agregamos al cliente dentro del bloque
        return true;
    }

    // ====== Listar clientes de un bloque De Horario======
    public void listarClientesDeBloque(String fecha, String codBloque) {
        DiasActivosAnuales dia = diasPorFecha.get(fecha); // buscamos el día
        //En caso que no exista el dia
        if (dia == null) {
            System.out.println("No existe día activo " + fecha);
            return;
        }

        // buscamos el bloque de Horario
        BloqueDeAtraccion b = dia.buscarBloque(codBloque);
        //En caso que no exita el bloque
        if (b == null) {
            System.out.println("No existe el bloque " + codBloque + " en " + fecha);
            return;
        }

        // Mostramos clientes inscritos dentro del bloque
        System.out.println("\nClientes del " + b);
        for (Cliente c : b.getClientesParticipantes()) System.out.println(" - " + c);
    }
}
