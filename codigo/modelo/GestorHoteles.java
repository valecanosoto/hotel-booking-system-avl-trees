package modelo;

import comparadores.ComparadorCategoria;
import comparadores.ComparadorCiudad;
import comparadores.ComparadorIDHotel;
import comparadores.ComparadorNombre;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import estructuras.Nodo;

/**
 * Clase GestorHoteles:
 * Encapsula y organiza la gestión de hoteles usando árboles AVL para búsquedas eficientes.
 * Permite registrar nuevos hoteles y realizar búsquedas por nombre, ciudad y categoría.
 * Utiliza una estructura AVL por cada atributo para mantener el orden y eficiencia.
 */
public class GestorHoteles {
    // Árbol AVL para cada criterio de búsqueda (nombre, ciudad, categoría)
    private ArbolAVL<Hotel> arbolPorID;
    private ArbolAVL<Hotel> arbolPorNombre;
    private ArbolAVL<Hotel> arbolPorCiudad;
    private ArbolAVL<Hotel> arbolPorCategoria;

    // Contador de IDs únicos para nuevos hoteles
    private static int contadorHoteles = 1;

    /**
     * Constructor: inicializa los árboles con los comparadores correspondientes.
     */
    public GestorHoteles() {
        this.arbolPorID = new ArbolAVL<>(new ComparadorIDHotel());
        this.arbolPorNombre = new ArbolAVL<>(new ComparadorNombre());
        this.arbolPorCiudad = new ArbolAVL<>(new ComparadorCiudad());
        this.arbolPorCategoria = new ArbolAVL<>(new ComparadorCategoria());
    }

    /**
     * Registra un nuevo hotel en los cuatro árboles AVL.
     * Se asigna automáticamente un ID incremental.
     *
     * @param nombre     Nombre del hotel
     * @param ciudad     Ciudad donde se ubica el hotel
     * @param direccion  Dirección completa del hotel
     * @param telefono   Número telefónico del hotel
     * @param email      Correo electrónico del hotel
     * @param categoria  Categoría del hotel (1 a 5 estrellas)
     */
    public void registrarHotel(String nombre, String ciudad, String direccion,
                               String telefono, String email, int categoria) {
        Hotel nuevoHotel = new Hotel(contadorHoteles++, nombre, ciudad, direccion, telefono, email, categoria);

        arbolPorID.insertar(nuevoHotel);
        arbolPorNombre.insertar(nuevoHotel);
        arbolPorCiudad.insertar_repetido(nuevoHotel);
        arbolPorCategoria.insertar_repetido(nuevoHotel);
    }

    /**
     * Busca un hotel por su ID. Se asume que el ID es único.
     *
     * @param IdHotel ID del hotel
     * @return El objeto Hotel si se encuentra, o null en caso contrario
     */
    public Hotel buscarHotelID(int IdHotel) {
        Hotel clave = new Hotel(IdHotel, null, null, null, null, null, 0);
        Nodo<Hotel> nodo = arbolPorID.buscar(clave);
        return nodo != null ? nodo.getClave() : null;
    }

    /**
     * Imprime el resultado de una búsqueda por ID.
     *
     * @param IdHotel ID del hotel a buscar
     */
    public void busquedaPorID(int IdHotel) {
        Hotel hotel = buscarHotelID(IdHotel);
        if (hotel != null) {
            System.out.println("Hotel encontrado:");
            System.out.println();
            System.out.println(hotel);
        } else {
            System.out.println("No se encontró ningún hotel con el ID: " + IdHotel);
        }
    }

    /**
     * Busca un hotel por su nombre. Se asume que el nombre es único.
     *
     * @param nombre Nombre del hotel
     * @return El objeto Hotel si se encuentra, o null en caso contrario
     */
    public Hotel buscarHotelNombre(String nombre) {
        Hotel clave = new Hotel(0, nombre, null, null, null, null, 0);
        Nodo<Hotel> nodo = arbolPorNombre.buscar(clave);
        return nodo != null ? nodo.getClave() : null;
    }

    /**
     * Imprime el resultado de una búsqueda por nombre.
     *
     * @param nombre Nombre del hotel a buscar
     */
    public void busquedaPorNombre(String nombre) {
        Hotel hotel = buscarHotelNombre(nombre);
        if (hotel != null) {
            System.out.println("Hotel encontrado:");
            System.out.println();
            System.out.println(hotel);
        } else {
            System.out.println("No se encontró ningún hotel con el nombre: " + nombre);
        }
    }

    /**
     * Busca hoteles por ciudad.
     * Puede haber múltiples coincidencias, devueltas como una lista enlazada.
     *
     * @param ciudad Nombre de la ciudad
     * @return ListaEnlazadaSimple de objetos Hotel encontrados
     */
    public ListaEnlazadaSimple<Hotel> buscarHotelesCiudad(String ciudad) {
        Hotel clave = new Hotel(0, null, ciudad, null, null, null, 0);
        return arbolPorCiudad.buscar_repetidos(clave);
    }

    /**
     * Imprime los hoteles encontrados en una ciudad dada.
     *
     * @param ciudad Nombre de la ciudad
     */
    public void busquedaPorCiudad(String ciudad) {
        ListaEnlazadaSimple<Hotel> resultados = buscarHotelesCiudad(ciudad);
        if (resultados.size() > 0) {
            System.out.println("Hoteles encontrados en la ciudad \"" + ciudad + "\":");
            System.out.println();
            for (Hotel resultado : resultados) {
                System.out.println(resultado.toString());
                System.out.println();
            }
        } else {
            System.out.println("No se encontraron hoteles en la ciudad \"" + ciudad + "\".");
        }
    }

    /**
     * Busca hoteles por categoría (número de estrellas).
     *
     * @param categoria Valor entre 1 y 5
     * @return ListaEnlazadaSimple con los hoteles de esa categoría
     */
    public ListaEnlazadaSimple<Hotel> buscarHotelesCategoria(int categoria) {
        Hotel clave = new Hotel(0, null, null, null, null, null, categoria);
        return arbolPorCategoria.buscar_repetidos(clave);
    }

    /**
     * Imprime los hoteles que tienen la categoría especificada.
     *
     * @param categoria Número de estrellas del hotel
     */
    public void busquedaPorCategoria(int categoria) {
        ListaEnlazadaSimple<Hotel> resultados = buscarHotelesCategoria(categoria);
        if (resultados.size() > 0) {
            System.out.println("Hoteles encontrados de \"" + categoria + " estrellas\":");
            System.out.println();
            for (Hotel resultado : resultados) {
                System.out.println(resultado.toString());
                System.out.println();
            }
        } else {
            System.out.println("No se encontraron hoteles de \"" + categoria + " estrellas\".");
        }
    }

    /**
     * Imprime la estructura completa del árbol por nombre.
     */
    public void imprimirPorID() {
        System.out.println("Árbol de hoteles por ID:");
        arbolPorID.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por nombre.
     */
    public void imprimirPorNombre() {
        System.out.println("Árbol de hoteles por nombre:");
        arbolPorNombre.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por ciudad.
     */
    public void imprimirPorCiudad() {
        System.out.println("Árbol de hoteles por ciudad:");
        arbolPorCiudad.imprimirArbol();
    }

    /**
     * Imprime la estructura completa del árbol por categoría.
     */
    public void imprimirPorCategoria() {
        System.out.println("Árbol de hoteles por categoría:");
        arbolPorCategoria.imprimirArbol();
    }

    /**
     * Devuelve el árbol de hoteles ordenados por ID.
     * @return Árbol AVL por ID.
     */
    public ArbolAVL<Hotel> getArbolPorID() {
        return arbolPorID;
    }

    /**
     * Devuelve el árbol de hoteles ordenados por Nombre.
     * @return Árbol AVL por Nombre.
     */
    public ArbolAVL<Hotel> getArbolPorNombre() {
        return arbolPorNombre;
    }

    /**
     * Devuelve el árbol de hoteles ordenado por Categoría.
     * @return Árbol AVL por Categoría.
     */
    public ArbolAVL<Hotel> getArbolPorCategoria() {
        return arbolPorCategoria;
    }

    /**
     * Devuelve el árbol de hoteles por Ciudad.
     * @return Árbol AVL por Ciudad.
     */
    public ArbolAVL<Hotel> getArbolPorCiudad() {
        return arbolPorCiudad;
    }
}