package modelo;

/**
 * Clase que representa un hotel con su respectiva información.
 */
public class Hotel {
    private int id;                // ID único del hotel
    private String nombre;         // Nombre del hotel
    private String ciudad;         // Ciudad donde se ubica el hotel
    private String direccion;      // Dirección completa: calle, número, colonia, etc.
    private String telefono;       // Número telefónico
    private String email;          // Correo electrónico
    private int categoria;         // Categoría de 1 a 5 estrellas

    public Hotel(int id, String nombre, String ciudad, String direccion,
                            String telefono, String email, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
    }

    // Getters y setters

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public int getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setCategoria(int categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDirección: " + direccion + "\nCiudad: " + ciudad + "\nTeléfono: " + telefono +
               "\nCategoría: " + categoria + " estrellas";
    }
}