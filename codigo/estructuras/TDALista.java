package estructuras;
import java.util.Iterator;

/**
 * Interfaz para la estructura de datos de una lista enlazada simple.
 * @param <T> Tipo de elementos almacenados en la lista.
 */
public interface TDALista<T> extends Iterable<T> {

    /**
     * Inserta un nuevo elemento en una posición específica de la lista.
     * @param indice Posición donde se insertará el elemento.
     * @param elemento Elemento a insertar.
     * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido.
     */
    void insertar(int indice, T elemento) throws IndexOutOfBoundsException;

    /**
     * Elimina un elemento en una posición específica y lo devuelve.
     * @param indice Posición del elemento a eliminar.
     * @return Elemento eliminado.
     * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido.
     */
    T eliminar(int indice) throws IndexOutOfBoundsException;

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    void vaciar();

    /**
     * Obtiene un elemento en una posición específica de la lista.
     * @param indice Posición del elemento a obtener.
     * @return Elemento en la posición dada.
     * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido.
     */
    T obtener(int indice) throws IndexOutOfBoundsException;

    /**
     * Verifica si un elemento está presente en la lista.
     * @param elemento Elemento a buscar en la lista.
     * @return `true` si el elemento está en la lista, `false` en caso contrario.
     */
    boolean contiene(T elemento);

    /**
     * Verifica si la lista está vacía.
     * @return `true` si la lista no contiene elementos, `false` en caso contrario.
     */
    boolean estaVacia();

    /**
     * Obtiene el tamaño de la lista.
     * @return Número de elementos en la lista.
     */
    int size();

    /**
     * Devuelve un iterador para recorrer la lista.
     * @return Iterador de elementos.
     */
    @Override
    Iterator<T> iterator();
}
