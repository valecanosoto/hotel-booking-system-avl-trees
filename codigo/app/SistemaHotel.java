package app;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import modelo.*;
import estructuras.ListaEnlazadaSimple;

/**
 * Clase encargada de habilitar la interfaz por consola.
 */
public class SistemaHotel {

    private GestorHoteles hoteles;
    private GestorHabitaciones habitaciones;
    private GestorUsuarios usuarios;
    private GestorReservas reservas;

    private Scanner scanner;

    public SistemaHotel() {
        hoteles = new GestorHoteles();
        habitaciones = new GestorHabitaciones();
        usuarios = new GestorUsuarios();
        reservas = new GestorReservas(habitaciones);

        InicializadorDatos.cargarHabitaciones(habitaciones);
        InicializadorDatos.cargarHoteles(hoteles);
        InicializadorDatos.cargarUsuarios(usuarios);
        InicializadorDatos.cargarReservas(reservas);

        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bienvenid@ al Sistema de Rerservas del Hotel María DB.");

        int opcion;
        boolean usuarioRegistrado = false;
        int idUsuarioActual = -1;

        do {
            System.out.println("\n¿Ya te has registrado antes?");
            System.out.println("1. Usuario nuevo");
            System.out.println("2. Usuario registrado");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    idUsuarioActual = registrarNuevoUsuario();
                    usuarioRegistrado = true;
                    break;
                case 2:
                    idUsuarioActual = loginUsuario();
                    if (idUsuarioActual != -1) usuarioRegistrado = true;
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (!usuarioRegistrado);

        menuPrincipal(idUsuarioActual);
    }

    private int registrarNuevoUsuario() {
        System.out.println("Registro de nuevo usuario:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String apPat = scanner.nextLine();
        System.out.print("Apellido materno: ");
        String apMat = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String tel = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Dirección*: ");
        String direccion = scanner.nextLine();

        int nuevoID = usuarios.registrarUsuario(nombre, apPat, apMat, email, tel, ciudad, direccion);

        System.out.println("Usuario registrado con éxito. ID asignado: " + nuevoID);
        return nuevoID;
    }

    private int loginUsuario() {
        System.out.print("Ingresa tu ID: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());
        Usuario claveUsuario = usuarios.buscarUsuario(idUsuario);

        if (claveUsuario == null) {
            System.out.println("Usuario no encontrado. Intenta de nuevo o regístrate.");
        } else {
            System.out.println("¡Hola de nuevo, " + claveUsuario.getNombreCompleto() + "!");
        }
        return idUsuario;
    }

    private void menuPrincipal(int idUsuario) {
        int opcion;
        do {
            System.out.println("\n--- Menú principal ---");
            System.out.println("1. Buscar hoteles");
            System.out.println("2. Buscar habitaciones");
            System.out.println("3. Realizar una reservación");            
            System.out.println("4. Consultar historial de reservas");
            System.out.println("5. Consultar total facturado");
            System.out.println("6. Salir");

            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    buscarHoteles();
                    break;
                case 2:
                    buscarHabitaciones();
                    break;
                case 3:
                    realizarReservacion(idUsuario);
                    break;
                case 4:
                    consultarHistorialReservas(idUsuario);
                    break;
                case 5:
                    consultarFacturado(idUsuario);
                    break;
                case 6:
                    System.out.println("Gracias por tu preferencia. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void buscarHoteles() {
        System.out.println("\nBuscar hoteles por:");
        System.out.println("1. Ciudad");
        System.out.println("2. Categoría");
        System.out.println("3. Nombre");
        System.out.print("Elige una opción: ");
        int op = Integer.parseInt(scanner.nextLine());

        switch (op) {
            case 1:
                System.out.print("Ingresa la ciudad: ");
                String ciudad = scanner.nextLine();
                hoteles.busquedaPorCiudad(ciudad);
                break;
            case 2:
                System.out.print("Ingresa la categoría (1-5 estrellas): ");
                int categoria = Integer.parseInt(scanner.nextLine());
                hoteles.busquedaPorCategoria(categoria);
                break;
            case 3:
                System.out.print("Ingresa el nombre: ");
                String nombre = scanner.nextLine();
                hoteles.busquedaPorNombre(nombre);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void buscarHabitaciones() {
        System.out.println("\nBuscar habitaciones por:");
        System.out.println("1. Rango de precios");
        System.out.println("2. Disponibilidad por fecha de llegada");
        System.out.print("Elige una opción: ");
        int op = Integer.parseInt(scanner.nextLine());

        switch (op) {
            case 1:
                System.out.print("Ingresa precio mínimo: ");
                double precioMin = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingresa precio máximo: ");
                double precioMax = Double.parseDouble(scanner.nextLine());
                busquedaPorPrecio(precioMin, precioMax);
                break;
            case 2:
                System.out.print("Ingresa fecha de llegada (YYYY-MM-DD): ");
                LocalDate fechaLlegada = LocalDate.parse(scanner.nextLine());
                busquedaPorDisponibilidad(fechaLlegada);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void busquedaPorPrecio(double precioMin, double precioMax) {

        ListaEnlazadaSimple<Habitacion> resultado = habitaciones.buscarPorRangoPrecio(precioMin, precioMax);

        if (resultado.size() > 0) {
            System.out.println("\nHabitaciones con precio entre $" + precioMin + " y $" + precioMax + ":\n");
            for (Habitacion h : resultado) {
                // Buscar el hotel en el árbol por IdHotel
                Hotel hotel = hoteles.buscarHotelID(h.getIdHotel());

                if (hotel != null) {
                    System.out.println(" - " + h + "\n");
                    System.out.println(hotel + "\n");
                }
            }
        } else {
            System.out.println("No se encontraron habitaciones dentro del rango especificado.");
        }
    }

    private void busquedaPorDisponibilidad(LocalDate fechaLlegada) {

        ListaEnlazadaSimple<Habitacion> resultado = habitaciones.buscarPorDisponibilidad(fechaLlegada);

        if (resultado.size() > 0) {
            System.out.println("\nHabitaciones disponibles para el día de tu llegada: " + fechaLlegada + "\n");
            for (Habitacion h : resultado) {
                // Buscar el hotel en el árbol por IdHotel
                Hotel hotel = hoteles.buscarHotelID(h.getIdHotel());

                if (hotel != null) {
                    System.out.println(" - " + h + "\n");
                    System.out.println(hotel + "\n");
                }
            }
        } else {
            System.out.println("No se encontraron habitaciones disponibles.");
        }
    }

    private void realizarReservacion(int idUsuario) {        
        try {
            // Solicitar ID de habitación
            System.out.print("Ingrese el ID de la habitación que desea reservar: ");
            int idHabitacion = Integer.parseInt(scanner.nextLine());

            // Solicitar fecha de inicio
            System.out.print("Ingrese la fecha de inicio de la reserva (AAAA-MM-DD): ");
            LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

            // Solicitar fecha de término
            System.out.print("Ingrese la fecha de término de la reserva (AAAA-MM-DD): ");
            LocalDate fechaTermino = LocalDate.parse(scanner.nextLine());

            // Validar que la fecha de término sea posterior a la de inicio
            if (!fechaTermino.isAfter(fechaInicio)) {
                System.out.println("La fecha de término debe ser posterior a la fecha de inicio.");
                return;
            }

            // Registrar la reserva
            boolean exito = reservas.registrarReserva(idUsuario, idHabitacion, fechaInicio, fechaTermino);
            if (!exito) {
                System.out.println("No se pudo completar la reserva.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido. Utilice AAAA-MM-DD.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada numérica inválida.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar registrar la reserva: " + e.getMessage());
        }
    }

    private void consultarHistorialReservas(int idUsuario) {
        reservas.consultarReservas(idUsuario);
        System.out.print("\n¿Desea cancelar alguna reserva activa? (Sí/No): \n");
        String opcion = scanner.nextLine().trim().toLowerCase();

        if (opcion.equals("si")) {
            System.out.print("Ingrese el ID de la reserva que desea cancelar: ");
            try {
                int idReserva = Integer.parseInt(scanner.nextLine());
                reservas.cancelarReserva(idReserva);
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Operación no procesada.");
            }
        }
    }
    
    private void consultarFacturado(int idUsuario) {
        System.out.println("Ingresa el periodo del que deseas obtener el total facturado.");
        System.out.print("Desde (AAAA-MM-DD): ");
        LocalDate desde = LocalDate.parse(scanner.nextLine());
        System.out.print("Hasta (AAAA-MM-DD): ");
        LocalDate hasta = LocalDate.parse(scanner.nextLine());
        reservas.calcularTotalFacturado(idUsuario, desde, hasta);
    }

    public static void main(String[] args) {
        SistemaHotel sistema = new SistemaHotel();
        sistema.iniciar();

        // sistema.habitaciones.imprimirPorFecha();
        // sistema.reservas.imprimirPorCliente();
        // System.out.println(sistema.usuarios.buscarUsuario(1).toString());
    }
}