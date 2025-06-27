package modelo;
import java.time.LocalDate;

import comparadores.ComparadorFechaDisponible;
import comparadores.ComparadorIDHabitacionH;
import comparadores.ComparadorPrecio;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import estructuras.Nodo;

/**
 * Clase encargada de gestionar el registro y las búsquedas de habitaciones.
 */
public class GestorHabitaciones {
    private ArbolAVL<Habitacion> arbolPorPrecio;
    private ArbolAVL<Habitacion> arbolPorFecha;
    private ArbolAVL<Habitacion> arbolPorID;
    private int contadorHabitaciones;

    /**
     * Constructor que inicializa los árboles AVL con sus respectivos comparadores.
     */
    public GestorHabitaciones() {
        this.arbolPorPrecio = new ArbolAVL<>(new ComparadorPrecio());
        this.arbolPorFecha = new ArbolAVL<>(new ComparadorFechaDisponible());
        this.arbolPorID = new ArbolAVL<>(new ComparadorIDHabitacionH());
        this.contadorHabitaciones = 1;
    }

    /**
     * Registra una nueva habitación en el sistema y la inserta en los tres árboles.
     * @param idHotel ID del hotel al que pertenece la habitación.
     * @param numero Número de habitación.
     * @param tipo Tipo de habitación (ej. Individual, Doble, Suite).
     * @param capacidad Capacidad máxima.
     * @param amenidades Lista de amenidades separadas por coma.
     * @param precioNoche Precio por noche.
     * @param disponibilidad Estado de disponibilidad actual.
     */
    public void registrarHabitacion(int idHotel, int numero, String tipo, int capacidad, String amenidades,
                                    double precioNoche, String disponibilidad) {
        Habitacion nueva = new Habitacion(contadorHabitaciones++, idHotel, numero, tipo, capacidad,
                                          amenidades, precioNoche, disponibilidad, LocalDate.now());
        arbolPorPrecio.insertar_repetido(nueva);
        arbolPorFecha.insertar_repetido(nueva);
        arbolPorID.insertar(nueva);
    }

    /**
     * Busca habitaciones cuyo precio esté dentro del rango especificado.
     * @param precioMin Precio mínimo.
     * @param precioMax Precio máximo.
     * @return Lista de habitaciones encontradas en el rango de precios.
     */
    public ListaEnlazadaSimple<Habitacion> buscarPorRangoPrecio(double precioMin, double precioMax) {
        Habitacion desde = new Habitacion(0, 0, 0, "", 0, "", precioMin, "", null);
        Habitacion hasta = new Habitacion(0, 0, 0, "", 0, "", precioMax, "", null);
        return arbolPorPrecio.buscarPorRango(desde, hasta);
    }

    /**
     * Busca habitaciones cuya fecha de disponibilidad sea menor o igual a la fecha de llegada.
     * @param fechaLlegada Fecha solicitada de llegada.
     * @return Lista de habitaciones candidatas disponibles desde esa fecha.
     */
    public ListaEnlazadaSimple<Habitacion> buscarPorDisponibilidad(LocalDate fechaLlegada) {
        Habitacion desde = new Habitacion(0, 0, 0, "", 0, "", 0, "", LocalDate.of(2025, 1, 1)); // Clave de habitación que funciona como límite inferior para la búsqueda.
        Habitacion hasta = new Habitacion(0, 0, 0, "", 0, "", 0, "", fechaLlegada); // Clave de habitación que funciona como límite superior para la búsqueda.
        return arbolPorFecha.buscarPorRango(desde, hasta);
    }

    /**
     * Actualiza la disponibilidad de una habitación, sincronizando todos los árboles.
     */
    public void actualizarDisponibilidad(int idHabitacion, String nuevoEstado, LocalDate nuevaFechaDisponible) {
        Habitacion clave = new Habitacion(idHabitacion, 0, 0, "", 0, "", 0.0, "", null);
        Nodo<Habitacion> nodo = arbolPorID.buscar(clave);

        if (nodo != null) {
            Habitacion h = nodo.getClave();

            arbolPorFecha.eliminar(h); // Eliminar del árbol cuya construcción depende del campo a modificar.

            // Actualizar datos
            h.setDisponibilidad(nuevoEstado);
            h.setFechaDisponible(nuevaFechaDisponible);

            arbolPorFecha.insertar_repetido(h); // Reinsertar con los nuevos valores
        }
    }

    /**
     * Imprime la estructura completa del árbol por IDs.
     */
    public void imprimirPorID() {
        System.out.println("Árbol de habitaciones por ID:");
        arbolPorID.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por FechaDisponible.
     */
    public void imprimirPorFecha() {
        System.out.println("Árbol de habitaciones por Fecha de disponibilidad:");
        arbolPorFecha.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por PrecioNoche.
     */
    public void imprimirPorPrecio() {
        System.out.println("Árbol de habitaciones por Precio por noche:");
        arbolPorPrecio.imprimirArbol();
    }

    /**
     * Devuelve el árbol AVL de habitaciones ordenadas por ID.
     * @return Árbol AVL por ID.
     */
    public ArbolAVL<Habitacion> getArbolPorID() {
        return arbolPorID;
    }

    /**
     * Devuelve el árbol de habitaciones ordenado por fecha (por ejemplo, para búsquedas de disponibilidad).
     * @return Árbol AVL por fecha disponible.
     */
    public ArbolAVL<Habitacion> getArbolPorFecha() {
        return arbolPorFecha;
    }

    /**
     * Devuelve el árbol de habitaciones por precio.
     * @return Árbol AVL por precio.
     */
    public ArbolAVL<Habitacion> getArbolPorPrecio() {
        return arbolPorPrecio;
    }
}