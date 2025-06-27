package estructuras;
/**
 * Interfaz para una tabla hash genérica con resolución de colisiones.
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores.
 */
public interface TDATablaHash<K, V> {

    /**
     * Inserta un par clave-valor en la tabla hash. Si la clave ya existe, reemplaza el valor.
     * @param clave Clave del elemento.
     * @param valor Valor asociado a la clave.
     */
    void insertar(K clave, V valor);

    /**
     * Obtiene el valor asociado a una clave dada.
     * @param clave Clave que se desea buscar.
     * @return Valor asociado, o null si no se encuentra la clave.
     */
    V obtener(K clave);

    /**
     * Elimina la entrada con la clave dada de la tabla hash.
     * @param clave Clave del elemento a eliminar.
     * @return Valor eliminado, o null si no se encontró.
     */
    V eliminar(K clave);

    /**
     * Verifica si la tabla contiene una clave dada.
     * @param clave Clave a buscar.
     * @return true si existe, false si no.
     */
    boolean contieneClave(K clave);

    /**
     * Devuelve el número total de elementos en la tabla.
     * @return Tamaño actual.
     */
    int size();

    /**
     * Indica si la tabla está vacía.
     * @return true si no contiene elementos, false si contiene al menos uno.
     */
    boolean estaVacia();

    /**
     * Elimina todos los elementos de la tabla.
     */
    void vaciar();

    /**
     * Devuelve un iterable con todas las claves presentes en la tabla.
     * @return Iterable de claves.
     */
    Iterable<K> claves();

    /**
     * Devuelve un iterable con todos los valores presentes en la tabla.
     * @return Iterable de valores.
     */
    Iterable<V> valores();
}