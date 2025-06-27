package estructuras;

/**
 * Interfaz que define el comportamiento de un árbol binario.
 * @param <T> Tipo de datos que almacenará el árbol.
 */
public interface TDABinaryTree<T> {

    /**
     * Verifica si un nodo es una hoja (no tiene hijos).
     * @param nodo Nodo a verificar.
     * @return `true` si es hoja, `false` en caso contrario.
     */
    boolean esHoja(Nodo<T> nodo);

    /**
     * Verifica si un nodo es la raíz del árbol.
     * @param nodo Nodo a verificar.
     * @return `true` si es raíz, `false` en caso contrario.
     */
    boolean esRaiz(Nodo<T> nodo);

    /**
     * Devuelve el nodo raíz del árbol.
     * @return El nodo raíz del árbol.
     */
    Nodo<T> getRaiz();

    /**
     * Verifica si un nodo tiene un hijo izquierdo.
     * @param nodo Nodo a verificar.
     * @return `true` si tiene hijo izquierdo, `false` en caso contrario.
     */
    boolean tieneHijoIzq(Nodo<T> nodo);

    /**
     * Verifica si un nodo tiene un hijo derecho.
     * @param nodo Nodo a verificar.
     * @return `true` si tiene hijo derecho, `false` en caso contrario.
     */
    boolean tieneHijoDer(Nodo<T> nodo);

    /**
     * Calcula la altura del árbol (desde la raíz).
     * @return La altura del árbol.
     */
    int altura();

    /**
     * Calcula la profundidad de un nodo específico en el árbol.
     * @param nodo Nodo a verificar.
     * @return La profundidad del nodo.
     */
    int profundidad(Nodo<T> nodo);

    /**
     * Calcula el peso de un nodo (número de nodos en el subárbol).
     * @param nodo Nodo a verificar.
     * @return El peso del nodo.
     */
    int peso(Nodo<T> nodo);

    /**
     * Crea un árbol vacío, inicializando su raíz a null.
     * @return La raíz del árbol vacío.
     */
    Nodo<T> crearArbolVacio();
}
