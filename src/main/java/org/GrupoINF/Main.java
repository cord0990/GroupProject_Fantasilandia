package org.GrupoINF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Reutilizamos un único BufferedReader para toda la app
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Fantasilandia parque = new Fantasilandia(); //Se cargan los datos iniciales
        int opcion;

        do {
            // == Menú principal Del Sistema ==
            System.out.println("\n====== MENU FANTASILANDIA ======");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Atracción");
            System.out.println("3. Mostrar Clientes");
            System.out.println("4. Mostrar Atracciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

            opcion = Integer.parseInt(br.readLine());

            System.out.print("Tilin");


            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = br.readLine().trim();
                    System.out.print("RUT: ");
                    String rut = br.readLine().trim();
                    System.out.print("ID Cliente: ");
                    String id = br.readLine().trim();
                    System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                    String fecha = br.readLine().trim();
                    parque.addCliente(new Cliente(nombre, rut, id, fecha));
                    System.out.println("✓ Cliente agregado.");
                    break;

                case 2:
                    System.out.println("\n--- Agregar Atracción ---");
                    System.out.print("Nombre atracción: ");
                    String nomAtr = br.readLine().trim();
                    System.out.print("Código atracción: ");
                    String codAtr = br.readLine().trim();
                    System.out.print("¿Está activa? (true/false): ");
                    boolean activa = Boolean.parseBoolean(br.readLine().trim());
                    System.out.print("Descripción: ");
                    String desc = br.readLine().trim();
                    parque.addAtraccion(new Atraccion(nomAtr, codAtr, activa, desc));
                    System.out.println("✓ Atracción correctamente agregada.");
                    break;

                case 3:
                    System.out.println("\n--- Listado de Clientes ---");
                    parque.mostrarClientes();
                    break;

                case 4:
                    System.out.println("\n--- Listado de Atracciones ---");
                    parque.mostrarAtracciones();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }
}
