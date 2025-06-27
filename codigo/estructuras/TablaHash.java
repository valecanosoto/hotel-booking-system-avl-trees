package estructuras;
/**
 * Implementación de una tabla hash genérica con resolución de colisiones por encadenamiento,
 * utilizando listas enlazadas simples.
 *
 * @param <K> Tipo de las claves. Deben implementar correctamente el método hashCode().
 * @param <V> Tipo de los valores asociados a las claves.
 */
public class TablaHash<K, V> implements TDATablaHash<K, V> {

    /**
     * Clase interna que representa una entrada en la tabla hash, compuesta por una clave y su valor asociado.
     */
    private static class Entrada<K, V> {
        K clave;
        V valor;

        Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private final int CAPACIDAD_INICIAL = 16; // Tamaño inicial de la tabla (puede ajustarse)
    private TDALista<Entrada<K, V>>[] tabla;  // Arreglo de listas enlazadas simples para manejar colisiones
    private int size;                       // Número de elementos actualmente almacenados en la tabla
    private final double FACTOR_CARGA_MAX = 0.75; // Factor de carga que determina cuándo hacer rehash

    /**
     * Constructor que inicializa la tabla hash con la capacidad por defecto
     * y crea una lista enlazada vacía para cada posición del arreglo.
     *
     * Se suprime la advertencia de compilación por uso no seguro de genéricos,
     * ya que Java no permite crear directamente arreglos de tipos genéricos.
     */
    @SuppressWarnings("unchecked")
    public TablaHash() {
        tabla = new TDALista[CAPACIDAD_INICIAL];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = new ListaEnlazadaSimple<>();
        }
        size = 0;
    }

    /**
     * Función hash que transforma la clave en un índice dentro del rango del arreglo.
     * Se utiliza el hashCode de la clave, asegurando que sea positivo y dentro de los límites.
     *
     * @param clave La clave a convertir en índice.
     * @return Índice en el arreglo correspondiente a la clave.
     */
    private int hash(K clave) {
        return Math.abs(clave.hashCode()) % tabla.length;
    }

    /**
     * Inserta una clave y su valor asociado en la tabla hash. Si la clave ya existe, se actualiza su valor.
     * Si el factor de carga supera el máximo permitido, se realiza un rehash.
     *
     * @param clave Clave a insertar o actualizar.
     * @param valor Valor asociado a la clave.
     */
    @Override
    public void insertar(K clave, V valor) {
        int indice = hash(clave);
        TDALista<Entrada<K, V>> lista = tabla[indice];

        for (int i = 0; i < lista.size(); i++) {
            Entrada<K, V> entrada = lista.obtener(i);
            if (entrada.clave.equals(clave)) {
                entrada.valor = valor; // Reemplaza valor existente
                return;
            }
        }

        lista.insertar(lista.size(), new Entrada<>(clave, valor));
        size++;

        // Verifica si se requiere rehash
        if ((double) size / tabla.length > FACTOR_CARGA_MAX) {
            rehash();
        }
    }

    /**
     * Busca y devuelve el valor asociado a una clave.
     *
     * @param clave Clave a buscar.
     * @return Valor asociado a la clave, o null si no se encuentra.
     */
    @Override
    public V obtener(K clave) {
        int indice = hash(clave);
        TDALista<Entrada<K, V>> lista = tabla[indice];

        for (int i = 0; i < lista.size(); i++) {
            Entrada<K, V> entrada = lista.obtener(i);
            if (entrada.clave.equals(clave)) {
                return entrada.valor;
            }
        }

        return null;
    }

    /**
     * Elimina una entrada de la tabla hash según la clave dada.
     *
     * @param clave Clave de la entrada a eliminar.
     * @return Valor eliminado asociado a la clave, o null si no se encontró.
     */
    @Override
    public V eliminar(K clave) {
        int indice = hash(clave);
        TDALista<Entrada<K, V>> lista = tabla[indice];

        for (int i = 0; i < lista.size(); i++) {
            Entrada<K, V> entrada = lista.obtener(i);
            if (entrada.clave.equals(clave)) {
                V valor = entrada.valor;
                lista.eliminar(i);
                size--;
                return valor;
            }
        }

        return null;
    }

    /**
     * Duplica la capacidad del arreglo y reubica todas las entradas existentes
     * recalculando sus índices con la nueva capacidad.
     *
     * Se suprime la advertencia porque se usa un cast inseguro de genéricos,
     * necesario para crear un arreglo de listas genéricas.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        int nuevaCapacidad = tabla.length * 2;
        TDALista<Entrada<K, V>>[] nuevaTabla = new TDALista[nuevaCapacidad];

        for (int i = 0; i < nuevaCapacidad; i++) {
            nuevaTabla[i] = new ListaEnlazadaSimple<>();
        }

        // Reinsertar todas las entradas
        for (int i = 0; i < tabla.length; i++) {
            TDALista<Entrada<K, V>> lista = tabla[i];
            for (int j = 0; j < lista.size(); j++) {
                Entrada<K, V> entrada = lista.obtener(j);
                int nuevoIndice = Math.abs(entrada.clave.hashCode()) % nuevaCapacidad;
                nuevaTabla[nuevoIndice].insertar(nuevaTabla[nuevoIndice].size(), entrada);
            }
        }

        tabla = nuevaTabla; // Reemplaza la tabla anterior
    }

    /**
     * Verifica si una clave está presente en la tabla.
     *
     * @param clave Clave a buscar.
     * @return true si la clave existe, false en caso contrario.
     */
    @Override
    public boolean contieneClave(K clave) {
        return obtener(clave) != null;
    }

    /**
     * Indica si la tabla está vacía.
     *
     * @return true si no hay elementos, false en caso contrario.
     */
    @Override
    public boolean estaVacia() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos almacenados en la tabla.
     *
     * @return Cantidad de pares clave-valor presentes.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Elimina todos los elementos de la tabla sin cambiar su capacidad.
     */
    @Override
    public void vaciar() {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i].vaciar();
        }
        size = 0;
    }

    /**
     * Devuelve un iterable con todas las claves almacenadas en la tabla.
     *
     * @return Iterable de claves.
     */
    @Override
    public Iterable<K> claves() {
        ListaEnlazadaSimple<K> listaClaves = new ListaEnlazadaSimple<>();
        for (int i = 0; i < tabla.length; i++) {
            TDALista<Entrada<K, V>> lista = tabla[i];
            for (int j = 0; j < lista.size(); j++) {
                listaClaves.insertar(listaClaves.size(), lista.obtener(j).clave);
            }
        }
        return listaClaves;
    }

    /**
     * Devuelve un iterable con todos los valores almacenados en la tabla.
     *
     * @return Iterable de valores.
     */
    @Override
    public Iterable<V> valores() {
        ListaEnlazadaSimple<V> listaValores = new ListaEnlazadaSimple<>();
        for (int i = 0; i < tabla.length; i++) {
            TDALista<Entrada<K, V>> lista = tabla[i];
            for (int j = 0; j < lista.size(); j++) {
                listaValores.insertar(listaValores.size(), lista.obtener(j).valor);
            }
        }
        return listaValores;
    }
}