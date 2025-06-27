package comparadores;
import java.util.Comparator;

import modelo.Reserva;

/**
 * Comparador para ordenar reservas por ID Usuario.
 */
public class ComparadorIDUsuarioR implements Comparator<Reserva> {
    @Override
    public int compare(Reserva r1, Reserva r2) {
        return Integer.compare(r1.getIdCliente(), r2.getIdCliente());
    }
}