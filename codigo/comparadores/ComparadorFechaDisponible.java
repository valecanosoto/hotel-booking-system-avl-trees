package comparadores;
import java.util.Comparator;

import modelo.Habitacion;

/**
 * Comparador para ordenar habitaciones por fecha de disponibilidad.
 */
public class ComparadorFechaDisponible implements Comparator<Habitacion> {
    @Override
    public int compare(Habitacion h1, Habitacion h2) {
        return h1.getFechaDisponible().compareTo(h2.getFechaDisponible());
    }
}
