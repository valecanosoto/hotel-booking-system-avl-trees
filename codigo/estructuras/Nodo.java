package estructuras;

/**
 * Clase que representa un nodo en un árbol binario.
 * @param <T> Tipo de datos que almacena el nodo.
 */
public class Nodo<T> {
    T clave;           // Valor almacenado en el nodo
    Nodo<T> padre;     // Padre
    Nodo<T> hijoIzq;   // Hijo izquierdo
    Nodo<T> hijoDer;   // Hijo derecho
    ListaEnlazadaSimple<T> repetidos;

    // Constructor para crear un nodo por clave
    public Nodo(T clave) {
        this.clave = clave;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.padre   = null;
        this.repetidos = new ListaEnlazadaSimple<>();
    }

    // Métodos getter y setter
    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public Nodo<T> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<T> padre) {
        this.padre = padre;
    }

    public Nodo<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo<T> hijoDer) {
        this.hijoDer = hijoDer;
    }

    public ListaEnlazadaSimple<T> getRepetidos() {
        return repetidos;
    }
}