package comparadores;
import java.util.Comparator;

import modelo.Hotel;

/**
 * Comparador para ordenar hoteles por ID.
 */
public class ComparadorIDHotel implements Comparator<Hotel> {
    @Override
    public int compare(Hotel h1, Hotel h2) {
        return Integer.compare(h1.getId(), h2.getId());
    }
}