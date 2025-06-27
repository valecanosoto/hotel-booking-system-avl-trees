package modelo;
import java.time.LocalDate;

/**
 * Clase que representa una habitación dentro de un hotel.
 */
public class Habitacion {
    private int id;                  // ID único de la habitación
    private int idHotel;            // ID del hotel al que pertenece
    private int numero;             // Número de la habitación
    private String tipo;            // Tipo de habitación: Individual, Doble, Suite, etc.
    private int capacidad;          // Capacidad máxima
    private String amenidades;      // Lista de amenidades separadas por coma
    private double precioNoche;     // Precio por noche
    private String disponibilidad;  // Estado actual de disponibilidad
    private LocalDate fechaDisponible; // Fecha a partir de la cual está disponible

    public Habitacion(int id, int idHotel, int numero, String tipo, int capacidad,
                      String amenidades, double precioNoche, String disponibilidad,
                      LocalDate fechaDisponibleDesde) {
        this.id = id;
        this.idHotel = idHotel;
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.amenidades = amenidades;
        this.precioNoche = precioNoche;
        this.disponibilidad = disponibilidad;
        this.fechaDisponible = fechaDisponibleDesde;
    }

    // Getters y setters

    public int getId() { return id; }
    public int getIdHotel() { return idHotel; }
    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public int getCapacidad() { return capacidad; }
    public String getAmenidades() { return amenidades; }
    public double getPrecioNoche() { return precioNoche; }
    public String getDisponibilidad() { return disponibilidad; }
    public LocalDate getFechaDisponible() { return fechaDisponible; }

    public void setPrecioNoche(double precio) { this.precioNoche = precio; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }
    public void setFechaDisponible(LocalDate fecha) { this.fechaDisponible = fecha; }

    @Override
    public String toString() {
        return String.format("Habitación %s (ID: %d) - $ %.2f", tipo, id, precioNoche);
    }
}