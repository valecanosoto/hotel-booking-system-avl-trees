package comparadores;
import java.text.Normalizer;
import java.util.Comparator;

import modelo.Hotel;

/**
 * Comparador para ordenar hoteles por ciudad.
 */
public class ComparadorCiudad implements Comparator<Hotel> {
    @Override
    public int compare(Hotel h1, Hotel h2) {
        String n1 = normalizar(h1.getCiudad());
        String n2 = normalizar(h2.getCiudad());
        return n1.compareTo(n2);
    }

    private String normalizar(String s) {
        if (s == null) return "";
        s = Normalizer.normalize(s.toLowerCase(), Normalizer.Form.NFD);
        return s.replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); // Quita acentos
    }
}