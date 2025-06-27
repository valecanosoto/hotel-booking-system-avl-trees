package modelo;
import java.time.LocalDate;

import comparadores.ComparadorIDUsuario;
import estructuras.ArbolAVL;
import estructuras.Nodo;

public class GestorUsuarios {
    private ArbolAVL<Usuario> arbolUsuarios;
    private int contadorUsuarios = 1;

    public GestorUsuarios() {
        this.arbolUsuarios = new ArbolAVL<>(new ComparadorIDUsuario());
    }

    /**
     * Registra un nuevo usuario en el sistema y le asigana un ID generado de manera automática.
     * @param nombre Nombre del usuario.
     * @param apellidoPaterno Apellido paterno.
     * @param apellidoMaterno Apellido materno.
     * @param email Correo electrónico.
     * @param telefono Teléfono.
     * @param ciudad Ciudad de residencia.
     * @param direccion Dirección completa.
     * @return ID asiganado del nuevo usuario.
     */
    public int registrarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno,
                                 String email, String telefono, String ciudad, String direccion) {

        Usuario nuevoUsuario = new Usuario(contadorUsuarios++, nombre, apellidoPaterno, apellidoMaterno,
                                           email, telefono, ciudad, direccion, LocalDate.now());

        arbolUsuarios.insertar(nuevoUsuario);
        return nuevoUsuario.getId();
    }

    /**
     * Busca un usuario en el árbol por su ID.
     * @param idUsuario ID del usuario.
     * @return El objeto Usuario si lo encuentra, o null si no se encuentra.
     */
    public Usuario buscarUsuario(int idUsuario) {
        Usuario claveUsuario = new Usuario(idUsuario, null, null, null, null,
        null, null, null, null);
        Nodo<Usuario> nodo = arbolUsuarios.buscar(claveUsuario);
        return nodo != null ? nodo.getClave() : null;
    }

    /**
     * Imprime todos los usuarios registrados.
     */
    public void imprimirUsuarios() {
        arbolUsuarios.imprimirArbol();
    }

    /**
     * Devuelve la referencia al árbol, en caso de que se requiera acceder directamente.
     */
    public ArbolAVL<Usuario> getArbolUsuarios() {
        return arbolUsuarios;
    }
}