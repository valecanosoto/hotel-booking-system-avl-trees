package comparadores;
import java.util.Comparator;

import modelo.Hotel;

/**
 * Comparador para ordenar hoteles por Categoría.
 */
public class ComparadorCategoria implements Comparator<Hotel> {
    @Override
    public int compare(Hotel h1, Hotel h2) {
        return Integer.compare(h1.getCategoria(), h2.getCategoria());
    }
}