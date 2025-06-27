package comparadores;
import java.util.Comparator;

import modelo.Habitacion;

/**
 * Comparador para ordenar habitaciones por precio.
 */
public class ComparadorPrecio implements Comparator<Habitacion> {
    @Override
    public int compare(Habitacion h1, Habitacion h2) {
        return Double.compare(h1.getPrecioNoche(), h2.getPrecioNoche());
    }
}