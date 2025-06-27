package modelo;
import java.time.LocalDate;

import comparadores.ComparadorIDHabitacionR;
import comparadores.ComparadorIDReserva;
import comparadores.ComparadorIDUsuarioR;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import estructuras.Nodo;

/**
 * Clase encargada de gestionar el registro y las búsquedas de reservas.
 */
public class GestorReservas {

    private GestorHabitaciones gestorHabitaciones;
    private ArbolAVL<Habitacion> arbolHabitacionesPorID;  // Árbol AVL de habitaciones ordenado por ID (para indexación)
    private ArbolAVL<Reserva> arbolReservasPorCliente;    // Árbol AVL de reservas ordenado por ID de cliente (para consultar historial de reservas)
    private ArbolAVL<Reserva> arbolReservasPorHabitacion; // Árbol AVL de reservas ordenado por ID de habitación (para verificar conflictos de disponibilidad)
    private ArbolAVL<Reserva> arbolReservasPorID;         // Árbol AVL de reservas ordenado por ID de reserva (para cancelar reservas)
    private static int contadorReservas = 1;     // Contador único para generar ID de reservas

    /**
     * Constructor que inicializa los árboles AVL requeridos con sus respectivos comparadores.
     */
    public GestorReservas(GestorHabitaciones gestorHabitaciones) {
        this.gestorHabitaciones = gestorHabitaciones;
        this.arbolHabitacionesPorID = gestorHabitaciones.getArbolPorID();

        this.arbolReservasPorCliente = new ArbolAVL<>(new ComparadorIDUsuarioR());
        this.arbolReservasPorHabitacion = new ArbolAVL<>(new ComparadorIDHabitacionR());
        this.arbolReservasPorID = new ArbolAVL<>(new ComparadorIDReserva());
    }

    /**
     * Verifica si una habitación está disponible para el rango [llegada, salida).
     * Se consulta el árbol de resevas ordenado por el ID Habitación.
     */
    private boolean estaDisponible(int idHabitacion, LocalDate llegada, LocalDate salida) {
        // Creamos una clave ficticia con solo el ID de la habitación
        Reserva clave = new Reserva(0, 0, idHabitacion, null, null, "", 0);
        ListaEnlazadaSimple<Reserva> reservas = arbolReservasPorHabitacion.buscar_repetidos(clave);

        // Si no hay reservas previas, se considera disponible
        if (reservas.estaVacia()) {
            return true;
        }

        for (Reserva r : reservas) {
            if (r.getEstadoReserva().equalsIgnoreCase("Confirmada")) {
                boolean conflicto = r.getFechaInicio().isBefore(salida) &&
                                    r.getFechaTermino().isAfter(llegada);
                if (conflicto) return false; // Hay conflicto de fechas
            }
        }

        return true; // Sin conflicto
    }
    
    /**
     * Registra una nueva reserva si la habitación está disponible.
     */
    public boolean registrarReserva(int idCliente, int idHabitacion, LocalDate fechaInicio, LocalDate fechaTermino) {
        // Buscar la habitación por ID
        Habitacion clave = new Habitacion(idHabitacion, 0, 0, "", 0, "", 0.0, "", null);
        Nodo<Habitacion> nodo = arbolHabitacionesPorID.buscar(clave);

        if (nodo == null) {
            System.out.println("No se encontró la habitación con ID: " + idHabitacion);
            return false;
        }

        Habitacion habitacion = nodo.getClave();

        // Verificar disponibilidad
        if (!estaDisponible(habitacion.getId(), fechaInicio, fechaTermino)) {
            System.out.println("La habitación no está disponible para esas fechas.");
            return false;
        }

        // Calcular importe total
        long noches = fechaInicio.until(fechaTermino).getDays();
        double importe = noches * habitacion.getPrecioNoche();

        // Crear nueva reserva
        int idReserva = contadorReservas++;
        Reserva nueva = new Reserva(
            idReserva, idCliente, habitacion.getId(),
            fechaInicio, fechaTermino, "Confirmada", importe
        );

        // Insertar en árboles de reservas
        arbolReservasPorCliente.insertar_repetido(nueva);
        arbolReservasPorHabitacion.insertar_repetido(nueva);
        arbolReservasPorID.insertar(nueva);

        // Actualizar disponibilidad de la habitación
        gestorHabitaciones.actualizarDisponibilidad(idHabitacion, "Ocupada", fechaTermino);

        System.out.println("Reserva registrada exitosamente con ID: " + idReserva);
        System.out.println("Te hemos enviado un correo con toda la información referente a tu reserva.");
        return true;
    }

    /**
     * Consulta todas las reservas realizadas por un cliente.
     */
    public void consultarReservas(int idCliente) {
        Reserva clave = new Reserva(0, idCliente, 0, null, null, "", 0.0);
        ListaEnlazadaSimple<Reserva> reservas = arbolReservasPorCliente.buscar_repetidos(clave);

        if (reservas.estaVacia()) {
            System.out.println("No se encontraron reservas para el cliente con ID " + idCliente + ".");
            return;
        }

        System.out.println("Reservas del cliente " + idCliente + ":\n");
        for (Reserva r : reservas) {
            System.out.println("- " + r);
        }
    }

    /**
     * Calcula el total facturado (importe acumulado) para un cliente en un rango de fechas,
     * e imprime las reservas incluidas.
     * 
     * @param idCliente El ID del cliente.
     * @param desde Fecha de inicio del periodo (inclusive).
     * @param hasta Fecha de fin del periodo (exclusive).
     * @return El importe total facturado.
     */
    public void calcularTotalFacturado(int idCliente, LocalDate desde, LocalDate hasta) {
        Reserva clave = new Reserva(0, idCliente, 0, null, null, "", 0.0);
        ListaEnlazadaSimple<Reserva> reservas = arbolReservasPorCliente.buscar_repetidos(clave);

        double total = 0.0;
        boolean hayReservas = false;

        System.out.println("Reservas confirmadas del cliente " + idCliente +
                        " entre " + desde + " y " + hasta + ":");

        for (Reserva r : reservas) {
            if (r.getEstadoReserva().equalsIgnoreCase("Confirmada")) {
                LocalDate inicio = r.getFechaInicio();

                if ((inicio.isEqual(desde) || inicio.isAfter(desde)) && inicio.isBefore(hasta)) {
                    System.out.println(r);
                    total += r.getImporteTotal();
                    hayReservas = true;
                }
            }
        }

        if (!hayReservas) {
            System.out.println("No se encontraron reservas confirmadas en el periodo indicado.");
        }

        System.out.printf("Total facturado en el periodo: $%.2f\n", total);
    }

    /**
     * Cancela una reserva dada su ID.
     * Marca la reserva como cancelada y libera la habitación si corresponde.
     */
    public void cancelarReserva(int idReserva) {
        // Crear una clave con el ID de la reserva a cancelar
        Reserva clave = new Reserva(idReserva, 0, 0, null, null, "", 0.0);
        Nodo<Reserva> nodo = arbolReservasPorID.buscar(clave);

        if (nodo == null) {
            System.out.println("No se encontró una reserva con ID " + idReserva + ".");
        }

        Reserva reserva = nodo.getClave();

        // Verificar que la reserva no haya iniciado aún
        if (!reserva.getFechaInicio().isAfter(LocalDate.now())) {
            System.out.println("La reserva no puede ser cancelada porque finalizó o inicia hoy.");
            return;
        }

        reserva.setEstadoReserva("Cancelada");

        // Liberar habitación
        gestorHabitaciones.actualizarDisponibilidad(reserva.getIdHabitacion(), "Disponible", LocalDate.now());

        System.out.println("Reserva con ID " + idReserva + " cancelada correctamente.");
    }

    /**
     * Carga una nueva reserva en el incializador de datos.
     */
    public void cargarReserva(int idCliente, int idHabitacion, LocalDate fechaInicio, LocalDate fechaTermino) {

        Habitacion clave = new Habitacion(idHabitacion, 0, 0, "", 0, "", 0.0, "", null);
        Nodo<Habitacion> nodo = arbolHabitacionesPorID.buscar(clave);
        Habitacion habitacion = nodo.getClave();

        long noches = fechaInicio.until(fechaTermino).getDays(); // Obtiene el número de noches
        double importe = noches * habitacion.getPrecioNoche(); // Calcula el importe total de la reserva

        Reserva nueva = new Reserva(contadorReservas++, idCliente, habitacion.getId(),
                    fechaInicio, fechaTermino, "Confirmada", importe);

        arbolReservasPorCliente.insertar_repetido(nueva);
        arbolReservasPorHabitacion.insertar_repetido(nueva);
        arbolReservasPorID.insertar(nueva);

        gestorHabitaciones.actualizarDisponibilidad(habitacion.getId(), "Ocupada", fechaTermino);
    }

    /**
     * Imprime la estructura completa del árbol por IDs.
     */
    public void imprimirPorID() {
        System.out.println("Árbol de reservas por ID:");
        arbolReservasPorID.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por ID Cliente.
     */
    public void imprimirPorCliente() {
        System.out.println("Árbol de reservas por ID Cliente:");
        arbolReservasPorCliente.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por ID Habitación.
     */
    public void imprimirPorHabitacion() {
        System.out.println("Árbol de reservas por ID Habitación:");
        arbolReservasPorHabitacion.imprimirArbol();
    }

    // Getters
    public ArbolAVL<Reserva> getArbolReservasID() {
        return arbolReservasPorID;
    }
    
    public ArbolAVL<Reserva> getArbolReservasPorCliente() {
        return arbolReservasPorCliente;
    }

    public ArbolAVL<Reserva> getArbolReservasPorHabitacion() {
        return arbolReservasPorHabitacion;
    }
}