package comparadores;
import java.util.Comparator;

import modelo.Reserva;

/**
 * Comparador para ordenar reservas por ID Habitación.
 */
public class ComparadorIDHabitacionR implements Comparator<Reserva> {
    @Override
    public int compare(Reserva r1, Reserva r2) {
        return Integer.compare(r1.getIdHabitacion(), r2.getIdHabitacion());
    }
}