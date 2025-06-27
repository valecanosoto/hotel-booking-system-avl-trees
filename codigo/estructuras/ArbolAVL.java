package estructuras;
import java.util.Comparator;

import modelo.Hotel;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;

// Clase ArbolAVL que implementa TDABinaryTree
public class ArbolAVL<T> implements TDABinaryTree<T> {

    private Nodo<T> raiz;
    private Comparator<T> comparator;

    // Constructor sin comparador: usa Comparable
    public ArbolAVL() {
        this.comparator = null;
        this.raiz = null;
    }

    // Constructor con comparador personalizado
    public ArbolAVL(Comparator<T> comparator) {
        this.comparator = comparator;
        this.raiz = null;
    }
    
    /**
     * Compara dos elementos del tipo genérico T utilizando un comparador personalizado si está disponible,
     * o mediante la interfaz {@code Comparable} si los elementos la implementan.
     *
     * @param a el primer elemento a comparar
     * @param b el segundo elemento a comparar
     * @return un valor negativo si {@code a < b}, cero si {@code a == b}, o un valor positivo si {@code a > b}
     * @throws IllegalStateException si no se ha proporcionado un comparador y los elementos no implementan {@code Comparable}
     */
    @SuppressWarnings("unchecked")
    private int comparar(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b); // Recurre al método `compare` definido en el comparador personalizado.
        } else if (a instanceof Comparable && b instanceof Comparable) { // Verifica si el objeto realmente implementa Comparable.
            return ((Comparable<T>) a).compareTo(b); // Permite hacer la comparación si T lo implementa.
        } else {
            throw new IllegalStateException("No se proporcionó un comparador y el tipo no implementa Comparable.");
        }
    }


    /**
     * Método que devuelve la altura del árbol.
     * 
     * @return La altura del árbol.
     */
    @Override
    public int altura() {
        return calcularAltura(this.raiz);
    }

    /**
     * Método que devuelve la altura de un nodo del árbol.
     * 
     * @param valor Clave del nodo.
     * @return La altura del en el árbol.
    */
    public int alturaNodo(T valor) {
        Nodo<T> nodo = buscar(valor); // Buscar el nodo por su valor de clave
        if (nodo != null) {
            return calcularAltura(nodo);
        }
        return -1; // Si el nodo no se encuentra, devuelve -1
    }

    /**
     * Método auxiliar para calcular la altura de un nodo de manera recursiva.
     * 
     * @param nodo Nodo cuya altura se va a calcular.
     * @return La altura del nodo.
     */
    private int calcularAltura(Nodo<T> nodo) {
        if (nodo == null) return -1; // Si el nodo es nulo, la altura es -1
        int altIzq = calcularAltura(nodo.hijoIzq); // Calcular la altura del hijo izquierdo
        int altDer = calcularAltura(nodo.hijoDer); // Calcular la altura del hijo derecho
        return 1 + Math.max(altIzq, altDer); // La altura es 1 más la mayor altura de los hijos
    }

    /**
     * Método que calcula el factor de balance de un nodo.
     * 
     * @param nodo Nodo para el que se calcula el factor de balance.
     * @return El factor de balance.
     */
    private int factorBalance(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return calcularAltura(nodo.getHijoDer()) - calcularAltura(nodo.getHijoIzq());
    }

    /**
     * Rotación simple a la izquierda.
     * 
     * @param nodo Nodo a rotar.
     * @return El nuevo nodo raíz después de la rotación.
     */
    private Nodo<T> rotarIzquierda(Nodo<T> nodo) {
        if (nodo == null || nodo.getHijoDer() == null) return null; // Si el nodo no se encuentra en el árbol o su hijo derecho es nulo, entonces no se realiza la rotación.

        Nodo<T> nuevoRaiz = nodo.getHijoDer();
        nodo.setHijoDer(nuevoRaiz.getHijoIzq()); // Se cambia la referencia del hijo izquierdo del hijo derecho del nodo al nuevo hijo derecho

        if (nuevoRaiz.getHijoIzq() != null) {
            nuevoRaiz.getHijoIzq().padre = nodo; // Si el hijo izquierdo del hijo derecho es no nulo, entonces su padre será el nodo
        }

        nuevoRaiz.padre = nodo.padre; // Se cambia la referencia del padre del hijo derecho al padre del nodo

        if (nodo.padre == null) {
            raiz = nuevoRaiz; // Si el padre es nulo, entonces el hijo derecho se convierte en la nueva raíz
        } else if (nodo == nodo.padre.getHijoIzq()) {
            nodo.padre.setHijoIzq(nuevoRaiz); // Si el nodo era el hijo izquierdo de su padre, el hijo derecho del nodo es el nuevo hijo izquierdo del padre
        } else {
            nodo.padre.setHijoDer(nuevoRaiz); // Si el nodo era el hijo derecho de su padre, el hijo derecho del nodo es el nuevo hijo derecho del padre
        }

        nuevoRaiz.setHijoIzq(nodo); // El nodo se convierte en el nuevo hijo izquierdo de su hijo derecho
        nodo.padre = nuevoRaiz; // El hijo derecho del nodo se convierte en su padre

        return nuevoRaiz; // Devuelve el hijo derecho con sus respectivas referencias actualizadas tras la rotación
    }

    /**
     * Rotación simple a la derecha.
     * 
     * @param nodo Nodo a rotar.
     * @return El nuevo nodo raíz después de la rotación.
     */
    private Nodo<T> rotarDerecha(Nodo<T> nodo) {
        if (nodo == null || nodo.getHijoIzq() == null) return null; // Si el nodo no se encuentra en el árbol o su hijo izquierdo es nulo, entonces no se realiza la rotación.
        
        Nodo<T> nuevoRaiz = nodo.getHijoIzq();
        nodo.setHijoIzq(nuevoRaiz.getHijoDer()); // Se cambia la referencia del hijo derecho del hijo izquierdo del nodo al nuevo hijo izquierdo

        if (nuevoRaiz.getHijoDer() != null) {
            nuevoRaiz.getHijoDer().padre = nodo; // Si el hijo derecho del hijo izquierdo es no nulo, entonces su padre será el nodo
        }

        nuevoRaiz.padre = nodo.padre; // Se cambia la referencia del padre del hijo izquierdo al padre del nodo

        if (nodo.padre == null) {
            raiz = nuevoRaiz; // Si el padre es nulo, entonces el hijo izquierdo se convierte en la nueva raíz
        } else if (nodo == nodo.padre.getHijoIzq()) {
            nodo.padre.setHijoIzq(nuevoRaiz); // Si el nodo era el hijo izquierdo de su padre, el hijo izquierdo del nodo es el nuevo hijo izquierdo del padre
        } else {
            nodo.padre.setHijoDer(nuevoRaiz); // Si el nodo era el hijo derecho de su padre, el hijo izquierdo del nodo es el nuevo hijo derecho del padre
        }

        nuevoRaiz.setHijoDer(nodo); // El nodo se convierte en el nuevo hijo derecho de su hijo izquierdo
        nodo.padre = nuevoRaiz; // El hijo izquierdo del nodo se convierte en su padre

        return nuevoRaiz; // Devuelve el hijo izquierdo con sus respectivas referencias actualizadas tras la rotación
    }

    /**
     * Método que balancea un nodo, realizando las rotaciones necesarias para mantener el equilibrio del árbol.
     * 
     * @param nodo Nodo que se va a balancear.
     * @return El nodo balanceado.
     */
    private Nodo<T> balancear(Nodo<T> nodo) {
        int fb = factorBalance(nodo);
        
        if (fb < -1) { // Desbalance a la izquierda
            if (factorBalance(nodo.getHijoIzq()) > 0) { // Desbalance a la derecha en el subárbol izquierdo
                nodo.setHijoIzq(rotarIzquierda(nodo.getHijoIzq()));
            }
            return rotarDerecha(nodo);
        } else if (fb > 1) { // Desbalance a la derecha
            if (factorBalance(nodo.getHijoDer()) < 0) { // Desbalance a la izquierda en el subárbol derecho
                nodo.setHijoDer(rotarDerecha(nodo.getHijoDer()));
            }
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    /**
     * Método para insertar un valor en el árbol AVL.
     * 
     * @param clave El valor que se va a insertar.
     */
    public void insertar(T clave) {
        raiz = insertar(raiz, clave);
    }

    /**
     * Método auxiliar recursivo para insertar un valor en el árbol AVL.
     * 
     * @param nodo Nodo actual en el que se realiza la inserción.
     * @param valor El valor que se va a insertar.
     * @return El nodo actualizado después de la inserción.
     */
    private Nodo<T> insertar(Nodo<T> nodo, T clave) {
        if (nodo == null) {
            return new Nodo<>(clave);
        }
        int cmp = comparar(clave, nodo.getClave());

        // Paso 1: Realizar una inserción normal en un árbol binario de búsqueda
        if (cmp < 0) { // La clave a insertar es menor a la clave del nodo actual
            nodo.setHijoIzq(insertar(nodo.getHijoIzq(), clave)); // La inserción se realiza en el subárbol izquierdo
            nodo.getHijoIzq().padre = nodo;
        } else if (cmp > 0) { // La clave a insertar es mayor a la clave del nodo actual
            nodo.setHijoDer(insertar(nodo.getHijoDer(), clave)); // La inserción se realiza en el subárbol derecho
            nodo.getHijoDer().padre = nodo;
        } else {
            return nodo; // No se permiten claves duplicadas
        }

        return balancear(nodo); // Paso 2: Balancear el árbol
    }

    /**
     * Método para insertar nodos con claves repetidas.
     * 
     * @param repetido La Clave que se va a insertar.
     */
    public void insertar_repetido(T repetido) {
        Nodo<T> nodoRepetido = buscar(raiz, repetido); // Verifica si ya existe algún nodo en el árbol con la misma clave.
        if (nodoRepetido != null) {
            nodoRepetido.repetidos.insertar(0, repetido); // Inserta la clave en la lista de repetidos del nodo existente con la misma clave.
        } else {
            raiz = insertar(raiz, repetido);
        }
    }
    
    /**
     * Método para buscar una clave en el árbol.
     * 
     * @param clave El valor que se va a buscar.
     * @return El nodo que contiene el valor buscado.
     */
    public Nodo<T> buscar(T clave) {
        return buscar(raiz, clave);
    }

    /**
     * Método auxiliar recursivo para buscar un valor en el árbol.
     * 
     * @param nodo Nodo actual donde se realiza la búsqueda.
     * @param clave El valor que se va a buscar.
     * @return El nodo que contiene el valor buscado.
     */
    private Nodo<T> buscar(Nodo<T> nodo, T clave) {
        if (nodo == null) return null;
        int cmp = comparar(clave, nodo.getClave());

        if (cmp == 0) return nodo;

        if (cmp < 0) {
            return buscar(nodo.getHijoIzq(), clave);
        } else {
            return buscar(nodo.getHijoDer(), clave);
        }
    }

    /**
     * Método para buscar y mostrar todos los elementos con cierto valor de atributo para la clave.
     * 
     * @param clave Valor del que sea desea obtener todas la claves repetidas.
     * @return ListaEnlazadaSimple que contiene todas las claves repetidas.
    */
    public ListaEnlazadaSimple<T> buscar_repetidos(T clave) {
        Nodo<T> nodo = buscar(raiz, clave);
        ListaEnlazadaSimple<T> resultado = new ListaEnlazadaSimple<>();
        if (nodo != null) {
            resultado.insertar(0, nodo.clave); // Incluye el nodo raíz
            for (T repetido : nodo.getRepetidos()) {
                resultado.insertar(resultado.size(), repetido);
            }
        }
        return resultado;
    }

    /**
     * Realiza una búsqueda de elementos en el árbol AVL cuyos valores estén dentro del rango especificado.
     * Incluye elementos repetidos almacenados en los nodos con claves iguales.
     * 
     * @param desde Valor inferior del rango (inclusive).
     * @param hasta Valor superior del rango (inclusive).
     * @return Una lista enlazada con todos los elementos en el árbol cuya clave esté entre "desde" y "hasta".
     */
    public ListaEnlazadaSimple<T> buscarPorRango(T desde, T hasta) {
        ListaEnlazadaSimple<T> resultados = new ListaEnlazadaSimple<>();
        buscarPorRango(this.raiz, desde, hasta, resultados);
        return resultados;
    }

    /**
     * Método auxiliar recursivo que recorre el árbol en orden y agrega a la lista los elementos
     * que están dentro del rango especificado, incluyendo repetidos.
     *
     * @param nodo        Nodo actual del árbol.
     * @param desde       Límite inferior del rango.
     * @param hasta       Límite superior del rango.
     * @param resultados  Lista acumuladora de los elementos dentro del rango.
     */
    private void buscarPorRango(Nodo<T> nodo, T desde, T hasta, ListaEnlazadaSimple<T> resultados) {
        if (nodo == null) return;

        if (comparar(nodo.clave, desde) > 0) { // Si la clave actual es mayor que el límite inferior, se continúa la búsqueda en el subárbol izquierdo.
            buscarPorRango(nodo.getHijoIzq(), desde, hasta, resultados);
        }

        if (comparar(nodo.clave, desde) >= 0 && comparar(nodo.clave, hasta) <= 0) {  // Si la clave actual está dentro del rango indicado.
            // Agrega la clave principal del nodo
            resultados.insertar(resultados.size(), nodo.clave);
            // Agrega también todos los elementos repetidos
            for (T repetido : nodo.getRepetidos()) {
                resultados.insertar(resultados.size(), repetido);
            }
        }

        if (comparar(nodo.clave, hasta) < 0) {  // Si la clave actual es menor que el límite superior, se continúa la búsqueda en el subárbol derecho.
            buscarPorRango(nodo.getHijoDer(), desde, hasta, resultados);
        }
    }

    /**
     * Elimina un nodo con la clave especificada del árbol AVL.
     * Si el nodo tiene elementos repetidos, se promueve uno de ellos en lugar de eliminar el nodo completo.
     * Si no tiene repetidos, se procede con la eliminación estándar y balanceo del árbol.
     *
     * @param clave La clave del nodo que se desea eliminar.
     */
    public void eliminar(T clave) {
        raiz = eliminar(raiz, clave);
    }

    /**
     * Método auxiliar recursivo que elimina un nodo del árbol AVL.
     * Maneja la promoción de claves repetidas si existen en el nodo.
     *
     * @param nodo  Nodo actual del recorrido.
     * @param clave Clave a eliminar.
     * @return El nuevo subárbol balanceado.
     */
    private Nodo<T> eliminar(Nodo<T> nodo, T clave) {
        if (nodo == null) return null;

        int cmp = comparar(clave, nodo.getClave());

        if (cmp < 0) {
            nodo.setHijoIzq(eliminar(nodo.getHijoIzq(), clave));
        } else if (cmp > 0) {
            nodo.setHijoDer(eliminar(nodo.getHijoDer(), clave));
        } else { // Se encontró el nodo a eliminar
            // Caso especial: si tiene elementos repetidos, se promueve uno en lugar de eliminar
            if (nodo.getRepetidos().size() > 0) {
                T nuevaClave = nodo.getRepetidos().obtener(0);  // Tomamos el primer repetido
                nodo.getRepetidos().eliminar(0);                // Lo eliminamos de la lista
                nodo.clave = nuevaClave;                               // Lo promovemos como nueva clave
                return balancear(nodo);                                // Rebalanceamos y devolvemos el mismo nodo
            }

            // Eliminación estándar cuando no hay repetidos:
            // Caso 1: solo hijo derecho
            if (nodo.getHijoIzq() == null) {
                Nodo<T> hijoDer = nodo.getHijoDer();
                if (hijoDer != null) hijoDer.padre = nodo.padre;
                return hijoDer;
            }

            // Caso 2: solo hijo izquierdo
            if (nodo.getHijoDer() == null) {
                Nodo<T> hijoIzq = nodo.getHijoIzq();
                if (hijoIzq != null) hijoIzq.padre = nodo.padre;
                return hijoIzq;
            }

            // Caso 3: dos hijos — buscar sucesor inorden
            Nodo<T> sucesor = obtenerSucesor(nodo.getHijoDer());

            // Sustituir clave y lista de repetidos
            nodo.clave = sucesor.clave;
            nodo.repetidos = sucesor.repetidos;

            // Eliminar el sucesor recursivamente (ya fue promovido)
            nodo.setHijoDer(eliminar(nodo.getHijoDer(), sucesor.clave));
        }

        return balancear(nodo);
    }

    /**
     * Devuelve el sucesor del nodo dado, es decir, el nodo con la menor clave en su subárbol izquierdo.
     *
     * @param nodo Nodo desde el que se busca el sucesor.
     * @return El sucesor correspondiente.
     */
    private Nodo<T> obtenerSucesor(Nodo<T> nodo) {
        while (nodo.getHijoIzq() != null) {
            nodo = nodo.getHijoIzq();
        }
        return nodo;
    }

    /**
     * Método para imprimir la estructura completa de un árbol mostrando primero todos los subárboles izquierdos.
     */
    public void imprimirArbol() {
        imprimir_nodosRec(raiz, 0, "Raíz");
    }
    
    // Método auxiliar recursivo para imprimir los árboles subyacentes
    private void imprimir_nodosRec(Nodo<T> nodo, int profundidad, String posicion) {
        if (nodo == null) return;
    
        String ind = "     ".repeat(profundidad);
        
        if (nodo.clave instanceof Hotel hotel) { // Si T es Hotel
            String linea_clave = ind + "[" + posicion + "] Nombre: " + hotel.getNombre();
            System.out.println(linea_clave);
            int esp = linea_clave.indexOf("N"); // Indentación para que 'Categoría: ...' se imprima justo debajo de 'Nombre: ...'
            String ind_nombres = " ".repeat(esp);
            System.out.println(ind_nombres + "Categoría: " + hotel.getCategoria() + " estrellas");
            System.out.println(ind_nombres + "Dirección: " + hotel.getDireccion());
            System.out.println(ind_nombres + "Ciudad: " + hotel.getCiudad());
            System.out.println(ind_nombres + "Teléfono: " + hotel.getTelefono());
            System.out.println(ind_nombres + "Email: " + hotel.getEmail());
            System.out.println();

            if (!nodo.getRepetidos().estaVacia()) {
                for (T repetido : nodo.getRepetidos()) {
                    if (repetido instanceof Hotel h)
                        hotel = h;
                        System.out.println(ind_nombres + "Nombre: " + hotel.getNombre());
                        System.out.println(ind_nombres + "Categoría: " + hotel.getCategoria() + " estrellas");
                        System.out.println(ind_nombres + "Dirección: " + hotel.getDireccion());
                        System.out.println(ind_nombres + "Ciudad: " + hotel.getCiudad());
                        System.out.println(ind_nombres + "Teléfono: " + hotel.getTelefono());
                        System.out.println(ind_nombres + "Email: " + hotel.getEmail());
                        System.out.println();
                }
            }
        
        } else if (nodo.clave instanceof Reserva reserva) { // Si T es Reserva
            String linea_clave = ind + "[" + posicion + "] ID Reserva: " + reserva.getIdReserva();
            System.out.println(linea_clave);
            int esp = linea_clave.indexOf("ID"); // Indentación para que 'ID Cliente: ...' se imprima justo debajo de 'ID Reserva: ...'
            String ind_nombres = " ".repeat(esp);
            System.out.println(ind_nombres + "ID Cliente: " + reserva.getIdCliente());
            System.out.println(ind_nombres + "ID Habitación: " + reserva.getIdHabitacion());
            System.out.println(ind_nombres + "Check-in: " + reserva.getFechaInicio());
            System.out.println(ind_nombres + "Chech-out: " + reserva.getFechaTermino());
            System.out.println(ind_nombres + "Estado: " + reserva.getEstadoReserva());
            System.out.println(ind_nombres + "Importe: " + reserva.getImporteTotal());
            System.out.println();

            if (!nodo.getRepetidos().estaVacia()) {
                for (T repetido : nodo.getRepetidos()) {
                    if (repetido instanceof Reserva r)
                        reserva = r;
                        System.out.println(ind_nombres + "ID Reserva: " + reserva.getIdReserva());
                        System.out.println(ind_nombres + "ID Cliente: " + reserva.getIdCliente());
                        System.out.println(ind_nombres + "ID Habitación: " + reserva.getIdHabitacion());
                        System.out.println(ind_nombres + "Check-in: " + reserva.getFechaInicio());
                        System.out.println(ind_nombres + "Chech-out: " + reserva.getFechaTermino());
                        System.out.println(ind_nombres + "Estado: " + reserva.getEstadoReserva());
                        System.out.println(ind_nombres + "Importe: " + reserva.getImporteTotal());
                        System.out.println();
                }
            }
        } else if (nodo.clave instanceof Habitacion habitacion) { // Si T es Habitacion
            String linea_clave = ind + "[" + posicion + "] ID Habitación: " + habitacion.getId();
            System.out.println(linea_clave);
            int esp = linea_clave.indexOf("ID"); // Indentación para que 'ID Hotel: ...' se imprima justo debajo de 'ID Habitación: ...'
            String ind_nombres = " ".repeat(esp);
            System.out.println(ind_nombres + "ID Hotel: " + habitacion.getIdHotel());
            System.out.println(ind_nombres + "Tipo: " + habitacion.getTipo());
            System.out.println(ind_nombres + "Número: " + habitacion.getNumero());
            System.out.println(ind_nombres + "Precio por noche: " + habitacion.getPrecioNoche());
            System.out.println(ind_nombres + "Disponibilidad: " + habitacion.getDisponibilidad());
            System.out.println(ind_nombres + "Fecha de disponibilidad: " + habitacion.getFechaDisponible());
            System.out.println();

            if (!nodo.getRepetidos().estaVacia()) {
                for (T repetido : nodo.getRepetidos()) {
                    if (repetido instanceof Habitacion h)
                        habitacion = h;
                        System.out.println(ind_nombres + "ID Habitación: " + habitacion.getId());
                        System.out.println(ind_nombres + "ID Hotel: " + habitacion.getIdHotel());
                        System.out.println(ind_nombres + "Tipo: " + habitacion.getTipo());
                        System.out.println(ind_nombres + "Número: " + habitacion.getNumero());
                        System.out.println(ind_nombres + "Precio por noche: " + habitacion.getPrecioNoche());
                        System.out.println(ind_nombres + "Disponibilidad: " + habitacion.getDisponibilidad());
                        System.out.println(ind_nombres + "Fecha de disponibilidad: " + habitacion.getFechaDisponible());
                        System.out.println();
                }
            }
        } else if (nodo.clave instanceof Usuario usuario) { // Si T es Usuario
            String linea_clave = ind + "[" + posicion + "] ID Usuario: " + usuario.getId();
            System.out.println(linea_clave);
            int esp = linea_clave.indexOf("ID"); // Indentación para que 'Nombre: ...' se imprima justo debajo de 'ID Usuario: ...'
            String ind_nombres = " ".repeat(esp);
            System.out.println(ind_nombres + "Nombre: " + usuario.getNombreCompleto());
            System.out.println(ind_nombres + "Email: " + usuario.getEmail());
            System.out.println(ind_nombres + "Teléfono: " + usuario.getTelefono());
            System.out.println(ind_nombres + "Fecha de registro: " + usuario.getFechaRegistro());
            System.out.println();

            if (!nodo.getRepetidos().estaVacia()) {
                for (T repetido : nodo.getRepetidos()) {
                    if (repetido instanceof Usuario u)
                        usuario = u;
                        System.out.println(ind_nombres + "ID Usuario: " + usuario.getId());
                        System.out.println(ind_nombres + "Nombre: " + usuario.getNombreCompleto());
                        System.out.println(ind_nombres + "Email: " + usuario.getEmail());
                        System.out.println(ind_nombres + "Teléfono: " + usuario.getTelefono());
                        System.out.println(ind_nombres + "Fecha de registro: " + usuario.getFechaRegistro());
                        System.out.println();
                }
            }
        } else { // Para otros tipos
            System.out.println(ind + "[" + posicion + "] Clave: " + nodo.clave);
        }
    
        imprimir_nodosRec(nodo.hijoIzq, profundidad + 1, "Izquierdo");
        imprimir_nodosRec(nodo.hijoDer, profundidad + 1, "Derecho");
    }

    // Métodos adicionales como esHoja, esRaiz, etc.
    
    @Override
    public boolean esHoja(Nodo<T> nodo) {
        return nodo != null && nodo.hijoIzq == null && nodo.hijoDer == null;
    }

    @Override
    public boolean esRaiz(Nodo<T> nodo) {
        return nodo != null && nodo == this.raiz;
    }

    @Override
    public Nodo<T> getRaiz() {
        return raiz;
    }

    @Override
    public int profundidad(Nodo<T> nodo) {
        return calcularProfundidad(raiz, nodo, 0);
    }

    /**
     * Método auxiliar para calcular la profundidad de un nodo en el árbol.
     * 
     * @param actual Nodo actual.
     * @param objetivo Nodo cuyo nivel se quiere conocer.
     * @param nivel El nivel actual.
     * @return La profundidad del nodo.
     */
    private int calcularProfundidad(Nodo<T> actual, Nodo<T> objetivo, int nivel) {
        if (actual == null) return -1; // Si no encontramos el nodo, devolvemos -1
        if (actual == objetivo) return nivel; // Si encontramos el nodo, devolvemos la profundidad

        // Llamada recursiva para los hijos
        int izquierda = calcularProfundidad(actual.hijoIzq, objetivo, nivel + 1);
        if (izquierda != -1) return izquierda; // Si se encuentra en el hijo izquierdo, retorna la profundidad

        return calcularProfundidad(actual.hijoDer, objetivo, nivel + 1); // Si no se encuentra, se busca en el hijo derecho
    }

    @Override
    public int peso(Nodo<T> nodo) {
        if (nodo == null) return 0; // Si el nodo es nulo, el peso es 0
        return 1 + peso(nodo.hijoIzq) + peso(nodo.hijoDer); // El peso es 1 + el peso de los hijos
    }

    @Override
    public boolean tieneHijoIzq(Nodo<T> nodo) {
        return nodo != null && nodo.getHijoIzq() != null;
    }

    @Override
    public boolean tieneHijoDer(Nodo<T> nodo) {
        return nodo != null && nodo.getHijoDer() != null;
    }
    
    @Override
    public Nodo<T> crearArbolVacio() {
        this.raiz = null; // El árbol vacío tiene una raíz nula
        return this.raiz;
    }
}