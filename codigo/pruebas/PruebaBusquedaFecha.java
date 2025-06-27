
import java.time.LocalDate;
import java.util.Scanner;

import comparadores.ComparadorFechaDisponible;
import comparadores.ComparadorIDHabitacionR;
import comparadores.ComparadorIDHotel;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import estructuras.Nodo;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;

public class PruebaBusquedaFecha {

    public static void main(String[] args) {
        ArbolAVL<Habitacion> arbolHabitaciones = new ArbolAVL<>(new ComparadorFechaDisponible());
        ArbolAVL<Reserva> arbolReservas = new ArbolAVL<>(new ComparadorIDHabitacionR());
        ArbolAVL<Hotel> arbolHoteles = new ArbolAVL<>(new ComparadorIDHotel());

        cargarHabitaciones(arbolHabitaciones);
        cargarReservas(arbolReservas);
        cargarHoteles(arbolHoteles);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese fecha de llegada (AAAA-MM-DD):");
        LocalDate fechaLlegada = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese fecha de salida (AAAA-MM-DD):");
        LocalDate fechaSalida = LocalDate.parse(scanner.nextLine());

        // Buscar habitaciones con fechaDisponible <= fechaLlegada
        Habitacion desde = new Habitacion(0, 0, 0, "", 0, "", 0, "", LocalDate.of(1900, 1, 1)); // fecha mínima
        Habitacion hasta = new Habitacion(0, 0, 0, "", 0, "", 0, "", fechaLlegada);

        ListaEnlazadaSimple<Habitacion> candidatas = arbolHabitaciones.buscarPorRango(desde, hasta);

        ListaEnlazadaSimple<Habitacion> disponibles = new ListaEnlazadaSimple<>();

        for (Habitacion h : candidatas) {
            if (estaDisponible(h, fechaLlegada, fechaSalida, arbolReservas)) {
                disponibles.insertar(disponibles.size(), h);
            }
        }

        if (!disponibles.estaVacia()) {
            System.out.println("\nHabitaciones disponibles del " + fechaLlegada + " al " + fechaSalida + ":\n");
        
            for (Habitacion h : disponibles) {
                // Buscar el hotel por ID
                Hotel hotelClave = new Hotel(h.getIdHotel(), null, null, null, null, null, 0);
                Nodo<Hotel> nodoHotel = arbolHoteles.buscar(hotelClave);
        
                if (nodoHotel != null) {
                    Hotel hotel = nodoHotel.getClave();
                    System.out.println(hotel);
                    System.out.println(" - " + h + "\n");
                } else {
                    System.out.println("No hay habitaciones disponibles en el rango solicitado.");
                }
            }
        scanner.close();
        }
    }

    // Verifica si una habitación está libre en un rango de fechas
    public static boolean estaDisponible(Habitacion h, LocalDate llegada, LocalDate salida, ArbolAVL<Reserva> arbolReservas) {
        Reserva clave = new Reserva(0, 0, h.getId(), null, null, "", 0);
        ListaEnlazadaSimple<Reserva> reservas = arbolReservas.buscar_repetidos(clave);

        for (Reserva r : reservas) {
            if (r.getEstadoReserva().equalsIgnoreCase("Confirmada")) {
                if (r.getFechaInicio().isBefore(salida) && r.getFechaTermino().isAfter(llegada)) {
                    return false; // Hay conflicto de fechas
                }
            }
        }

        return true; // No hay reservas que se crucen
    }

    public static void cargarHabitaciones(ArbolAVL<Habitacion> arbol) {
        arbol.insertar_repetido(new Habitacion(1, 1, 101, "Doble", 2, "TV, Aire Acondicionado", 900.00, "Disponible", LocalDate.of(2025, 5, 1)));
        arbol.insertar_repetido(new Habitacion(2, 1, 102, "Suite", 4, "TV, Jacuzzi", 1500.00, "Disponible", LocalDate.of(2025, 5, 3)));
        arbol.insertar_repetido(new Habitacion(3, 2, 201, "Individual", 1, "TV", 700.00, "Disponible", LocalDate.of(2025, 5, 1)));
    }

    public static void cargarReservas(ArbolAVL<Reserva> arbol) {
        arbol.insertar_repetido(new Reserva(1, 100, 1, LocalDate.of(2025, 5, 2), LocalDate.of(2025, 5, 5), "Confirmada", 2700));
        arbol.insertar_repetido(new Reserva(2, 101, 2, LocalDate.of(2025, 5, 5), LocalDate.of(2025, 5, 7), "Confirmada", 3000));
        arbol.insertar_repetido(new Reserva(3, 102, 3, LocalDate.of(2025, 5, 3), LocalDate.of(2025, 5, 6), "Cancelada", 0));
    }

    public static void cargarHoteles(ArbolAVL<Hotel> arbol) {
        arbol.insertar(new Hotel(1, "Hotel María DB Plaza Central", "Ciudad de México", "Av. Juárez 100", "7053624331", "plaza@hotel.com", 3));
        arbol.insertar(new Hotel(2, "Hotel María DB Vista al Mar", "Cancún", "Zona Hotelera", "7521938741", "vista@hotel.com", 4));
    }
}
