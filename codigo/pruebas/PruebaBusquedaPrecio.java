
import java.util.Scanner;

import comparadores.ComparadorIDHotel;
import comparadores.ComparadorPrecio;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import estructuras.Nodo;
import modelo.Habitacion;
import modelo.Hotel;

public class PruebaBusquedaPrecio {

    public static void main(String[] args) {
        ArbolAVL<Habitacion> arbolHabitaciones = new ArbolAVL<>(new ComparadorPrecio());
        ArbolAVL<Hotel> arbolHoteles = new ArbolAVL<>(new ComparadorIDHotel());

        // Cargar datos
        cargarHoteles(arbolHoteles);
        cargarHabitaciones(arbolHabitaciones);

        // Entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el precio mínimo por noche: ");
        double precioMin = scanner.nextDouble();
        System.out.print("Ingrese el precio máximo por noche: ");
        double precioMax = scanner.nextDouble();

        // Crear claves ficticias con precios límite para la búsqueda
        Habitacion claveDesde = new Habitacion(0, 0, 0, "", 0, "", precioMin, "", null);
        Habitacion claveHasta = new Habitacion(0, 0, 0, "", 0, "", precioMax, "", null);

        // Buscar habitaciones en el rango de precios
        ListaEnlazadaSimple<Habitacion> resultado = arbolHabitaciones.buscarPorRango(claveDesde, claveHasta);

        if (resultado != null && resultado.size() > 0) {
            System.out.println("\nHabitaciones con precio entre $" + precioMin + " y $" + precioMax + ":\n");
            for (int i = 0; i < resultado.size(); i++) {
                Habitacion h = resultado.obtener(i);
                // Buscar el hotel en el árbol por idHotel
                Hotel hotelClave = new Hotel(h.getIdHotel(), null, null, null, null, null, 0);
                Nodo<Hotel> nodoHotel = arbolHoteles.buscar(hotelClave);

                if (nodoHotel != null) {
                    Hotel hotel = nodoHotel.getClave();
                    System.out.println(hotel);
                    System.out.println(" - " + h + "\n");
                }
            }
        } else {
            System.out.println("No se encontraron habitaciones dentro del rango especificado.");
        }

        scanner.close();
    }

    public static void cargarHoteles(ArbolAVL<Hotel> arbol) {
        arbol.insertar(new Hotel(1, "Hotel María DB Plaza Central", "Ciudad de México", "Av. Juárez 100", "7053624331", "plaza@hotel.com", 3));
        arbol.insertar(new Hotel(2, "Hotel María DB Vista al Mar", "Cancún", "Zona Hotelera", "7521938741", "vista@hotel.com", 4));
    }

    public static void cargarHabitaciones(ArbolAVL<Habitacion> arbol) {
        arbol.insertar_repetido(new Habitacion(1, 1, 101, "Doble", 2, "TV, Aire Acondicionado", 900.00, "Disponible", null));
        arbol.insertar_repetido(new Habitacion(2, 1, 102, "Suite", 4, "TV, Jacuzzi", 1500.00, "Disponible", null));
        arbol.insertar_repetido(new Habitacion(3, 2, 201, "Individual", 1, "TV", 700.00, "Disponible", null));
        arbol.insertar_repetido(new Habitacion(4, 2, 202, "Suite", 3, "TV, Vista al mar", 2000.00, "Disponible", null));
    }
}
