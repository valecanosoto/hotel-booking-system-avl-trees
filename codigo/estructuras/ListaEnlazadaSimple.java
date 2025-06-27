package estructuras;
import java.util.Iterator;

/**
 * Implementación de una lista enlazada simple basada en la interfaz `TDALista`.
 * @param <T> Tipo de los elementos almacenados en la lista.
 */
public class ListaEnlazadaSimple<T> implements TDALista<T> {
    /**
     * Clase interna que representa un nodo de la lista.
     */
    private class Nodo {
        public T elemento;  // Elemento almacenado en el nodo.
        public Nodo siguiente; // Referencia al siguiente nodo.

        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    /**
     * Clase interna para la iteración sobre la lista.
     */
    private class IteradorLista implements Iterator<T> {
        private Nodo actual;

        public IteradorLista(Nodo cabeza) {
            this.actual = new Nodo(null);
            this.actual.siguiente = cabeza;
        }

        @Override
        public boolean hasNext() {
            return actual.siguiente != null;
        }

        @Override
        public T next() {
            actual = actual.siguiente;
            return actual.elemento;
        }
    }

    private Nodo cabeza;
    private Nodo cola;
    private int size;

    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    @Override
    public void insertar(int indice, T elemento) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        Nodo nuevo = new Nodo(elemento);

        if (size == 0) {
            cabeza = cola = nuevo;
        } else if (indice == 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else if (indice == size) {
            cola.siguiente = nuevo;
            cola = nuevo;
        } else {
            Nodo iterador = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                iterador = iterador.siguiente;
            }
            nuevo.siguiente = iterador.siguiente;
            iterador.siguiente = nuevo;
        }
        size++;
    }

    @Override
    public T eliminar(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        T eliminado;

        if (size == 1) {
            eliminado = cabeza.elemento;
            vaciar();
            return eliminado;
        }

        if (indice == 0) {
            eliminado = cabeza.elemento;
            cabeza = cabeza.siguiente;
            size--;
            return eliminado;
        }

        if (indice == size - 1) {
            Nodo iterador = cabeza;
            while (iterador.siguiente.siguiente != null) {
                iterador = iterador.siguiente;
            }
            eliminado = cola.elemento;
            cola = iterador;
            cola.siguiente = null;
            size--;
            return eliminado;
        }

        Nodo iterador = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            iterador = iterador.siguiente;
        }
        eliminado = iterador.siguiente.elemento;
        iterador.siguiente = iterador.siguiente.siguiente;
        size--;
        return eliminado;
    }

    @Override
    public void vaciar() {
        cabeza = cola = null;
        size = 0;
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        Nodo iterador = cabeza;
        for (int i = 0; i < indice; i++) {
            iterador = iterador.siguiente;
        }
        return iterador.elemento;
    }

    @Override
    public boolean contiene(T elemento) {
        Nodo iterador = cabeza;
        while (iterador != null) {
            if (iterador.elemento.equals(elemento)) {
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean estaVacia() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista(cabeza);
    }

    /**
     * Imprime todos los elementos de la lista enlazada en una sola línea.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Iterator<T> it = iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}