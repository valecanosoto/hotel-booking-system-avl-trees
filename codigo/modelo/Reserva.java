package modelo;
import java.time.LocalDate;

/**
 * Clase que representa una reserva hecha por un cliente para una habitación en específico.
 */
public class Reserva {
    private int idReserva;
    private int idCliente;
    private int idHabitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private String estadoReserva;      // Cancelada, Confirmada, Finalizada.
    private double importeTotal;

    public Reserva(int idReserva, int idCliente, int idHabitacion,
                   LocalDate fechaInicio, LocalDate fechaTermino,
                   String estadoReserva, double importeTotal) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estadoReserva = estadoReserva;
        this.importeTotal = importeTotal;
    }

    // Getters y setters

    public int getIdReserva() { return idReserva; }
    public int getIdCliente() { return idCliente; }
    public int getIdHabitacion() { return idHabitacion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaTermino() { return fechaTermino; }
    public String getEstadoReserva() { return estadoReserva; }
    public double getImporteTotal() { return importeTotal; }

    public void setFechaInicio(LocalDate fecha) { this.fechaInicio = fecha; }
    public void setFechaTermino(LocalDate fecha) { this.fechaTermino = fecha; }
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = estadoReserva; }
    public void setImporteTotal(double importe) { this.importeTotal = importe; }

    @Override
    public String toString() {
        return String.format("Reserva (ID %d): Habitación %d, %s a %s, Estado: %s, Importe: $%.2f",
            idReserva, idHabitacion,
            fechaInicio, fechaTermino, estadoReserva, importeTotal);
    }
}