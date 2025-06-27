package comparadores;
import java.util.Comparator;

import modelo.Habitacion;

/**
 * Comparador para ordenar habitaciones por ID.
 */
public class ComparadorIDHabitacionH implements Comparator<Habitacion> {
    @Override
    public int compare(Habitacion ha1, Habitacion ha2) {
        return Integer.compare(ha1.getId(), ha2.getId());
    }
}