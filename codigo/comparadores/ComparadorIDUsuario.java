package comparadores;
import java.util.Comparator;

import modelo.Usuario;

/**
 * Comparador para ordenar usuarios por ID.
 */
public class ComparadorIDUsuario implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2) {
        return Integer.compare(u1.getId(), u2.getId());
    }
}