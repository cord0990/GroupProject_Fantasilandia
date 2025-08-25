package org.GrupoINF;

// Importamos librerías para leer datos desde el teclado
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//codigo Principal (MAIN)
public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Fantasilandia parque = new Fantasilandia(); //Se cargan los datos iniciales
        int opcion; // variable para guardar la opción que elija el usuario

        // Bucle principal del menú
        do {
            // == Menú principal Del Sistema ==
            System.out.println("\n====== MENU FANTASILANDIA ======");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Atracción");
            System.out.println("3. Mostrar Clientes");
            System.out.println("4. Mostrar Atracciones");
            System.out.println("5. Gestionar Bloques de Horario(Insertar/Listar de 2ª colección)");
            System.out.println("0. Salir");
            System.out.println("================================");
            System.out.print("\nSeleccione una opción: ");

            //Lectura de datos de entrada.
            opcion = Integer.parseInt(br.readLine());

            //Opciones dependiendo de la opcion seleccionada
            switch (opcion) {
                case 1:
                    // === Agregar un nuevo cliente ===
                    System.out.print("===Indicar los datos del nuevo Cliente===\n");
                    System.out.print("Nombre y apellidos: ");
                    String nombre = br.readLine().trim();

                    System.out.print("RUT (con digito verificador): ");
                    String rut = br.readLine().trim();

                    System.out.print("ID Cliente: ");
                    String id = br.readLine().trim();

                    System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                    String fecha = br.readLine().trim();

                    // Creamos el cliente y lo agregamos al parque
                    parque.addCliente(new Cliente(nombre, rut, id, fecha));
                    System.out.println("✓ Cliente agregado al sistema.");
                    break;

                case 2:
                    // === Agregar una atracción ===
                    System.out.println("\n=== Agregar Atracción ===");
                    System.out.print("Nombre atracción: ");
                    String nomAtr = br.readLine().trim();

                    // Pedimos clasificación de una atraccion usando un metodo especial
                    String clasificacion = leerClasificacion();

                    //Para la creacion de un ID unico para cada atraccion le agregaremos una letra inicial dependiendo de su Clasificacion anterior
                    String codNum = leerCodigoNumerico();
                    String codigoConPrefijo = prefijoDe(clasificacion) + formatearNumero(codNum); //para que el ID empieze con la letra de su categoria

                    System.out.print("¿Está activa? (true/false): ");
                    boolean activa = Boolean.parseBoolean(br.readLine().trim());

                    System.out.print("Descripción: ");
                    String desc = br.readLine().trim();

                    // Creamos la atracción y la agregamos al parque
                    parque.addAtraccion(new Atraccion(nomAtr, clasificacion, codigoConPrefijo, activa, desc));
                    System.out.println("✓ Atracción agregada al sistema. Código final: " + codigoConPrefijo);
                    break;

                case 3:
                    // Mostrar lista de clientes
                    parque.mostrarClientes();
                    break;

                case 4:
                    // Mostrar lista de atracciones
                    parque.mostrarAtracciones();
                    break;

                case 5:
                    // Gestionar los bloques de horario (submenú)
                    MenuBloques.gestionar(parque, br);
                    break;

                case 0:
                    // Salida del programa
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    // Si el usuario elige un número que no existe en el menú
                    System.out.println("Opción no válida.");

            }
        } while(opcion != 0);
    }

    // ==================== Helpers (Metodos de apoyo) para el CASE 2 ============================

    // Asigna un prefijo de letra según la clasificación de la atraccion a el ID unico de esta misma
    private static String prefijoDe(String clasificacion) {
        if (ClasificacionConst.INFANTILES.equals(clasificacion)) return "A";
        if (ClasificacionConst.ADRENALINA.equals(clasificacion)) return "B";
        if (ClasificacionConst.ACUATICOS.equals(clasificacion))  return "C";
        if (ClasificacionConst.FAMILIARES.equals(clasificacion)) return "D";
        return "X"; // valor por defecto si algo falla
    }

    // Menú para elegir clasificación de atracción
    private static String leerClasificacion() throws IOException {
        while (true) {
            System.out.println("\nSeleccione clasificación de la atracción:");
            System.out.println("1) Juegos infantiles");
            System.out.println("2) Juegos de adrenalina");
            System.out.println("3) Juegos acuáticos");
            System.out.println("4) Juegos familiares");
            System.out.print("Opción (1-4): ");

            String opcion = br.readLine().trim();
            switch (opcion) {
                case "1": return ClasificacionConst.INFANTILES;
                case "2": return ClasificacionConst.ADRENALINA;
                case "3": return ClasificacionConst.ACUATICOS;
                case "4": return ClasificacionConst.FAMILIARES;
                default:
                    System.out.println("✗ Opción inválida. Intenta nuevamente.");
            }
        }
    }
    // Pide un número para el código de la atracción
    private static String leerCodigoNumerico() throws IOException {
        while (true) {
            System.out.print("Ingresa un Código numérico para la atracción : ");
            String s = br.readLine().trim();
            if (s.matches("\\d+")) return s; // valida que sean solo números Los que se ingresen
            System.out.println("ERROR! Debe ingresar solo dígitos (0-9). Intente nuevamente.");
        }
    }

    //En la creacion del ID Convierte un número a formato de 3 dígitos (ej: 1 -> 001, 12 -> 012)
    private static String formatearNumero(String codNum) {
        int n = Integer.parseInt(codNum);
        return String.format("%03d", n); // lo normaliza a 3 dígitos: 001, 012, 123
    }

    //=================================Fin de los helpers=====================================================
}
