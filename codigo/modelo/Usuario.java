package modelo;
import java.time.LocalDate;

/**
 * Clase que representa a un cliente del sistema.
 */
public class Usuario {
    private int id;                    // ID único del cliente
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private String ciudad;
    private String direccionCompleta; // Calle, número, colonia, etc.
    private LocalDate fechaRegistro;

    public Usuario(int id, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String email, String telefono, String ciudad, String direccionCompleta,
                   LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.direccionCompleta = direccionCompleta;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters

    public int getId() { return id; }
    public String getNombreCompleto() {
        return String.format("%s %s %s", nombre, apellidoPaterno,
                             (apellidoMaterno != null ? apellidoMaterno : ""));
    }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getCiudad() { return ciudad; }
    public String getDireccionCompleta() { return direccionCompleta; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }

    @Override
    public String toString() {
        return String.format("Usuario %d: %s (%s)", id, getNombreCompleto(), email);
    }
}