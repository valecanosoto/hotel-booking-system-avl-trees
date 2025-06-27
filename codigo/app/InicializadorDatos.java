package app;

import java.time.LocalDate;

import modelo.GestorHoteles;
import modelo.GestorHabitaciones;
import modelo.GestorUsuarios;
import modelo.GestorReservas;

/**
 * Clase encargada de cargar registros persistentes en los gestores de las entidades.
 */
public class InicializadorDatos {

    

    public static void cargarHoteles(GestorHoteles hoteles) { // 30 hoteles

        hoteles.registrarHotel("Hotel María DB Plaza Central", "Ciudad de México", "Av. Insurgentes Sur 1234, Colonia Del Valle", "7053624331", "plaza_central@hotelmdb.com", 1);
        hoteles.registrarHotel("Hotel María DB Costa Azul", "Acapulco", "Costera Miguel Alemán 456, Colonia Costa Azul", "7517525458", "costa_azul@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Vista al Mar", "Cancún", "Boulevard Kukulkán 987, Colonia Zona Hotelera", "3842717031", "vista_mar@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Montañas", "Monterrey", "Carretera Nacional 2345, Colonia Chipinque", "3805565830", "montanas@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Jardines", "Puebla", "Calle 14 Sur 789, Colonia Jardines de San Manuel", "6454871533", "jardines@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Centro Histórico", "Guadalajara", "Av. Juárez 120, Colonia Centro", "7315861065", "centro_hist@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Laguna", "Mazatlán", "Av. del Mar 456, Colonia Sábalo Country", "2279954713", "laguna@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Palmeras", "Tulum", "Calle Coba Sur 222, Colonia Aldea Zama", "7314551447", "palmeras@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Colina", "San Miguel de Allende", "Camino Real a Querétaro 88, Colonia La Lejona", "4619334671", "colina@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Valle", "Valle de Bravo", "Av. Toluca 312, Colonia Santa María Ahuacatlán", "2702241902", "valle@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Paraíso", "Puerto Vallarta", "Calle Paseo de las Conchas Chinas 789, Colonia Conchas Chinas", "5723403786", "paraiso@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Brisas", "Manzanillo", "Av. Lázaro Cárdenas 999, Colonia Las Brisas", "6714638412", "brisas@hotelmdb.com", 3);
        hoteles.registrarHotel("Hotel María DB Oasis", "Ixtapa", "Boulevard Ixtapa 234, Colonia Zona Hotelera I", "2505881632", "oasis@hotelmdb.com", 1);
        hoteles.registrarHotel("Hotel María DB Horizonte", "Huatulco", "Blvd. Benito Juárez 876, Colonia Sector O", "2669026722", "horizonte@hotelmdb.com", 1);
        hoteles.registrarHotel("Hotel María DB Cascadas", "Xalapa", "Av. Ávila Camacho 321, Colonia Progreso Macuiltépetl", "6446239392", "cascadas@hotelmdb.com", 3);
        hoteles.registrarHotel("Hotel María DB Diamante", "Acapulco", "Boulevard de las Naciones 1001, Colonia Diamante", "6463846815", "diamante@hotelmdb.com", 5);
        hoteles.registrarHotel("Hotel María DB Esmeralda", "Querétaro", "Prolongación Zaragoza 777, Colonia El Mirador", "9127713674", "esmeralda@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Bahía", "La Paz", "Malecón Costero 456, Colonia Centro", "4094136867", "bahia@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Colinas", "Cuernavaca", "Calle Reforma 333, Colonia Vista Hermosa", "8998596851", "colinas@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Atardecer", "Taxco", "Calle Plateros 222, Colonia Centro", "7462670037", "atardecer@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Amanecer", "Zacatecas", "Av. Universidad 123, Colonia Tres Cruces", "5616338257", "amanecer@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Bosque", "Toluca", "Paseo Tollocan 888, Colonia Santa Ana Tlapaltitlán", "7406280757", "bosque@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Mirador", "Cholula", "Calle 14 Oriente 456, Colonia San Pedro", "7882749634", "mirador@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Ríos", "Tuxtla Gutiérrez", "Calzada al Sumidero 1010, Colonia Las Arboledas", "7202204603", "rios@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Estrella", "Tequila", "Calle Hidalgo 321, Colonia Centro", "3846976092", "estrella@hotelmdb.com", 5);
        hoteles.registrarHotel("Hotel María DB Luna", "Aguascalientes", "Av. Universidad 654, Colonia Bosques", "1142418126", "luna@hotelmdb.com", 3);
        hoteles.registrarHotel("Hotel María DB Sol", "Morelia", "Av. Camelinas 1024, Colonia Chapultepec Norte", "5714156648", "sol@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Galaxia", "Playa del Carmen", "Av. 10 entre 10 y 12, Colonia Centro", "6662984417", "galaxia@hotelmdb.com", 4);
        hoteles.registrarHotel("Hotel María DB Aurora", "Veracruz", "Boulevard Manuel Ávila Camacho 555, Colonia Costa Verde", "3478702989", "aurora@hotelmdb.com", 2);
        hoteles.registrarHotel("Hotel María DB Arcoiris", "San Cristóbal de las Casas", "Real de Guadalupe 789, Colonia Santa Lucía", "2547136589", "arcoiris@hotelmdb.com", 2);
    }
    
    public static void cargarHabitaciones(GestorHabitaciones habitaciones) { // 87 registros
            
        habitaciones.registrarHabitacion(1, 102, "Doble", 4, "Wi-Fi, aire acondicionado, TV, minibar", 1400.00, "Disponible");
        habitaciones.registrarHabitacion(1, 103, "Suite", 3, "Jacuzzi, balcón, minibar, aire acondicionado, TV", 3200.00, "Disponible");
        habitaciones.registrarHabitacion(1, 104, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1200.00, "Disponible");
        habitaciones.registrarHabitacion(1, 105, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3600.00, "Disponible");
        habitaciones.registrarHabitacion(2, 203, "Individual", 2, "Wi-Fi, aire acondicionado, TV", 1300.00, "Disponible");
        habitaciones.registrarHabitacion(2, 204, "Triple", 6, "Balcón, minibar, aire acondicionado, Wi-Fi", 1900.00, "Disponible");
        habitaciones.registrarHabitacion(2, 205, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3400.00, "Disponible");
        habitaciones.registrarHabitacion(2, 206, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1600.00, "Disponible");
        habitaciones.registrarHabitacion(2, 207, "Deluxe", 6, "TV inteligente, balcón, aire acondicionado", 3700.00, "Disponible");
        habitaciones.registrarHabitacion(3, 304, "Individual", 2, "Wi-Fi, aire acondicionado, TV", 1250.00, "Disponible");
        habitaciones.registrarHabitacion(3, 305, "Doble", 4, "Minibar, balcón, aire acondicionado", 1550.00, "Disponible");
        habitaciones.registrarHabitacion(3, 306, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3300.00, "Disponible");
        habitaciones.registrarHabitacion(3, 307, "Deluxe", 6, "Wi-Fi, aire acondicionado, minibar", 3600.00, "Disponible");
        habitaciones.registrarHabitacion(3, 308, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5200.00, "Disponible");
        habitaciones.registrarHabitacion(4, 405, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1600.00, "Disponible");
        habitaciones.registrarHabitacion(4, 406, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3400.00, "Disponible");
        habitaciones.registrarHabitacion(4, 407, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1250.00, "Disponible");
        habitaciones.registrarHabitacion(4, 408, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3700.00, "Disponible");
        habitaciones.registrarHabitacion(5, 506, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1650.00, "Disponible");
        habitaciones.registrarHabitacion(5, 507, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3500.00, "Disponible");
        habitaciones.registrarHabitacion(5, 508, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5300.00, "Disponible");
        habitaciones.registrarHabitacion(6, 607, "Individual", 2, "Wi-Fi, aire acondicionado, TV", 1300.00, "Disponible");
        habitaciones.registrarHabitacion(6, 608, "Doble", 4, "Minibar, balcón, aire acondicionado", 1600.00, "Disponible");
        habitaciones.registrarHabitacion(6, 609, "Triple", 6, "Wi-Fi, aire acondicionado, minibar", 2000.00, "Disponible");
        habitaciones.registrarHabitacion(6, 610, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3800.00, "Disponible");
        habitaciones.registrarHabitacion(7, 708, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3600.00, "Disponible");
        habitaciones.registrarHabitacion(7, 709, "Deluxe", 6, "Wi-Fi, aire acondicionado, minibar", 3900.00, "Disponible");
        habitaciones.registrarHabitacion(7, 710, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5400.00, "Disponible");
        habitaciones.registrarHabitacion(8, 109, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1550.00, "Disponible");
        habitaciones.registrarHabitacion(8, 110, "Triple", 6, "Balcón, minibar, aire acondicionado, Wi-Fi", 1900.00, "Disponible");
        habitaciones.registrarHabitacion(8, 111, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3400.00, "Disponible");
        habitaciones.registrarHabitacion(9, 210, "Individual", 2, "Wi-Fi, aire acondicionado, TV", 1350.00, "Disponible");
        habitaciones.registrarHabitacion(9, 211, "Doble", 4, "Minibar, balcón, aire acondicionado", 1650.00, "Disponible");
        habitaciones.registrarHabitacion(9, 212, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3700.00, "Disponible");
        habitaciones.registrarHabitacion(10, 311, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3500.00, "Disponible");
        habitaciones.registrarHabitacion(10, 312, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5400.00, "Disponible");
        habitaciones.registrarHabitacion(10, 313, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1600.00, "Disponible");
        habitaciones.registrarHabitacion(10, 314, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1300.00, "Disponible");
        habitaciones.registrarHabitacion(11, 412, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1650.00, "Disponible");
        habitaciones.registrarHabitacion(11, 413, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3600.00, "Disponible");
        habitaciones.registrarHabitacion(11, 414, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3800.00, "Disponible");
        habitaciones.registrarHabitacion(12, 513, "Individual", 2, "Wi-Fi, aire acondicionado, TV", 1350.00, "Disponible");
        habitaciones.registrarHabitacion(12, 514, "Doble", 4, "Minibar, balcón, aire acondicionado", 1700.00, "Disponible");
        habitaciones.registrarHabitacion(12, 515, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5500.00, "Disponible");
        habitaciones.registrarHabitacion(13, 614, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3600.00, "Disponible");
        habitaciones.registrarHabitacion(13, 615, "Deluxe", 6, "Wi-Fi, aire acondicionado, minibar", 3900.00, "Disponible");
        habitaciones.registrarHabitacion(13, 616, "Doble", 4, "Wi-Fi, minibar, aire acondicionado", 1700.00, "Disponible");
        habitaciones.registrarHabitacion(14, 715, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1400.00, "Disponible");
        habitaciones.registrarHabitacion(14, 716, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3700.00, "Disponible");
        habitaciones.registrarHabitacion(14, 717, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5500.00, "Disponible");
        habitaciones.registrarHabitacion(14, 718, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1650.00, "Disponible");
        habitaciones.registrarHabitacion(15, 818, "Triple", 6, "Balcón, minibar, aire acondicionado, Wi-Fi", 2000.00, "Disponible");
        habitaciones.registrarHabitacion(15, 819, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3700.00, "Disponible");
        habitaciones.registrarHabitacion(15, 820, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 3900.00, "Disponible");
        habitaciones.registrarHabitacion(15, 821, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1350.00, "Disponible");
        habitaciones.registrarHabitacion(16, 921, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1700.00, "Disponible");
        habitaciones.registrarHabitacion(16, 922, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3800.00, "Disponible");
        habitaciones.registrarHabitacion(16, 923, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5600.00, "Disponible");
        habitaciones.registrarHabitacion(17, 1023, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 4000.00, "Disponible");
        habitaciones.registrarHabitacion(17, 1024, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1400.00, "Disponible");
        habitaciones.registrarHabitacion(17, 1025, "Doble", 4, "Minibar, balcón, aire acondicionado", 1700.00, "Disponible");
        habitaciones.registrarHabitacion(17, 1026, "Triple", 6, "Balcón, minibar, aire acondicionado, Wi-Fi", 2100.00, "Disponible");
        habitaciones.registrarHabitacion(18, 1126, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3900.00, "Disponible");
        habitaciones.registrarHabitacion(18, 1127, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5700.00, "Disponible");
        habitaciones.registrarHabitacion(18, 1128, "Doble", 4, "Wi-Fi, aire acondicionado, minibar", 1750.00, "Disponible");
        habitaciones.registrarHabitacion(19, 1228, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1450.00, "Disponible");
        habitaciones.registrarHabitacion(19, 1229, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 4100.00, "Disponible");
        habitaciones.registrarHabitacion(19, 1230, "Triple", 6, "Balcón, minibar, aire acondicionado, Wi-Fi", 2200.00, "Disponible");
        habitaciones.registrarHabitacion(20, 1330, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 4000.00, "Disponible");
        habitaciones.registrarHabitacion(20, 1331, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5800.00, "Disponible");
        habitaciones.registrarHabitacion(21, 124, "Doble", 4, "Wi-Fi, minibar, aire acondicionado", 1850.00, "Disponible");
        habitaciones.registrarHabitacion(21, 125, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3750.00, "Disponible");
        habitaciones.registrarHabitacion(22, 226, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 4050.00, "Disponible");
        habitaciones.registrarHabitacion(22, 227, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1450.00, "Disponible");
        habitaciones.registrarHabitacion(23, 328, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5800.00, "Disponible");
        habitaciones.registrarHabitacion(24, 429, "Doble", 4, "Wi-Fi, minibar, aire acondicionado", 1900.00, "Disponible");
        habitaciones.registrarHabitacion(24, 430, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3800.00, "Disponible");
        habitaciones.registrarHabitacion(25, 531, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 4100.00, "Disponible");
        habitaciones.registrarHabitacion(25, 532, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1500.00, "Disponible");
        habitaciones.registrarHabitacion(26, 633, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 5900.00, "Disponible");
        habitaciones.registrarHabitacion(27, 734, "Doble", 4, "Wi-Fi, minibar, aire acondicionado", 1950.00, "Disponible");
        habitaciones.registrarHabitacion(27, 735, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3850.00, "Disponible");
        habitaciones.registrarHabitacion(28, 836, "Deluxe", 6, "TV inteligente, minibar, aire acondicionado", 4200.00, "Disponible");
        habitaciones.registrarHabitacion(28, 837, "Individual", 2, "Wi-Fi, escritorio, baño privado", 1550.00, "Disponible");
        habitaciones.registrarHabitacion(29, 938, "Presidencial", 10, "Balcón privado, jacuzzi, servicio a la habitación", 6000.00, "Disponible");
        habitaciones.registrarHabitacion(30, 1039, "Doble", 4, "Wi-Fi, minibar, aire acondicionado", 2000.00, "Disponible");
        habitaciones.registrarHabitacion(30, 1040, "Suite", 3, "Jacuzzi, TV pantalla plana, caja fuerte", 3900.00, "Disponible");
    }

    public static void cargarUsuarios(GestorUsuarios usuarios) { // 20 registros
        
        usuarios.registrarUsuario("Juan", "García", "López", "jgarcia1@example.com", "5512345678", "Ciudad de México", "Calle Reforma 123, Colonia Centro");
        usuarios.registrarUsuario("María", "Martínez", "Sánchez", "mmartinez2@example.com", "5523456789", "Guadalajara", "Av. Juárez 45, Colonia Americana");
        usuarios.registrarUsuario("Pedro", "Rodríguez", "Gómez", "prodriguez3@example.com", "5534567890", "Monterrey", "Calle Hidalgo 98, Colonia Obispado");
        usuarios.registrarUsuario("Ana", "Hernández", "Pérez", "ahernandez4@example.com", "5545678901", "Puebla", "Av. Reforma Sur 12, Colonia La Paz");
        usuarios.registrarUsuario("Luis", "González", "Ramírez", "lgonzalez5@example.com", "5556789012", "Mérida", "Calle 60 210, Colonia Itzimná");
        usuarios.registrarUsuario("Laura", "Díaz", "Fernández", "ldiaz6@example.com", "5567890123", "Querétaro", "Av. Universidad 101, Colonia Centro");
        usuarios.registrarUsuario("Carlos", "Vázquez", "Jiménez", "cvazquez7@example.com", "5578901234", "Toluca", "Calle Morelos 15, Colonia Moderna");
        usuarios.registrarUsuario("Sofía", "Castillo", "Morales", "scastillo8@example.com", "5589012345", "León", "Av. López Mateos 77, Colonia San Juan Bosco");
        usuarios.registrarUsuario("Jorge", "Ortega", "Silva", "jortega9@example.com", "5590123456", "Cancún", "Calle Palenque 456, Colonia Centro");
        usuarios.registrarUsuario("Patricia", "Ruiz", "Cruz", "pruiz10@example.com", "5501234567", "Aguascalientes", "Av. Madero 23, Colonia Primavera");
        usuarios.registrarUsuario("Ricardo", "Mendoza", "Reyes", "rmendoza11@example.com", "5512345679", "Tijuana", "Blvd. Agua Caliente 1212, Colonia Aviación");
        usuarios.registrarUsuario("Gabriela", "Guerrero", "Ortiz", "gguerrero12@example.com", "5523456780", "Culiacán", "Calle Álvaro Obregón 35, Colonia Guadalupe");
        usuarios.registrarUsuario("Fernando", "Pacheco", "Navarro", "fpacheco13@example.com", "5534567891", "Saltillo", "Av. Universidad 88, Colonia República");
        usuarios.registrarUsuario("Adriana", "Campos", "Vega", "acampos14@example.com", "5545678902", "Morelia", "Calle Madero Poniente 500, Colonia Las Américas");
        usuarios.registrarUsuario("Miguel", "Ríos", "Méndez", "mrios15@example.com", "5556789013", "Chihuahua", "Av. Tecnológico 301, Colonia Santo Niño");
        usuarios.registrarUsuario("Alejandra", "Soto", "Cervantes", "asoto16@example.com", "5567890124", "Veracruz", "Calle Independencia 16, Colonia Centro");
        usuarios.registrarUsuario("Raúl", "Delgado", "Rojas", "rdelgado17@example.com", "5578901235", "Cuernavaca", "Calle Galeana 89, Colonia Jardines");
        usuarios.registrarUsuario("Carmen", "Cortés", "Medina", "ccortes18@example.com", "5589012346", "San Luis Potosí", "Av. Carranza 301, Colonia Del Valle");
        usuarios.registrarUsuario("Francisco", "Salazar", "Aguilar", "fsalazar19@example.com", "5590123457", "Oaxaca", "Calle Alcalá 234, Colonia Reforma");
        usuarios.registrarUsuario("Daniela", "Rosas", "Valdez", "drosas20@example.com", "5501234568", "Tuxtla Gutiérrez", "Blvd. Belisario Domínguez 45, Colonia Terán");
    }

    public static void cargarReservas(GestorReservas reservas) { // 55 registros
        
        reservas.cargarReserva(7, 33, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(12, 5, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 24));
        reservas.cargarReserva(3, 72, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 18));
        reservas.cargarReserva(9, 20, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 18));
        reservas.cargarReserva(18, 9, LocalDate.of(2025, 5, 15), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(4, 80, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 23));
        reservas.cargarReserva(2, 67, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(20, 1, LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 26));
        reservas.cargarReserva(1, 44, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(15, 55, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(5, 28, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(11, 13, LocalDate.of(2025, 5, 23), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(14, 77, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 21));
        reservas.cargarReserva(8, 13, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(10, 31, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 21));
        reservas.cargarReserva(17, 2, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 18));
        reservas.cargarReserva(19, 66, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(6, 7, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 18));
        reservas.cargarReserva(13, 48, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(16, 53, LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 26));
        reservas.cargarReserva(1, 12, LocalDate.of(2025, 5, 23), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(3, 70, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(7, 68, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 21));
        reservas.cargarReserva(20, 15, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(5, 29, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(12, 26, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 23));
        reservas.cargarReserva(9, 35, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(18, 3, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(14, 58, LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(2, 64, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(16, 16, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 24));
        reservas.cargarReserva(11, 22, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(4, 6, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(17, 27, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(13, 39, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 23));
        reservas.cargarReserva(8, 80, LocalDate.of(2025, 5, 23), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(19, 42, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(6, 10, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(10, 36, LocalDate.of(2025, 5, 23), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(1, 79, LocalDate.of(2025, 5, 24), LocalDate.of(2025, 5, 27));
        reservas.cargarReserva(15, 41, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(3, 4, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(7, 38, LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 24));
        reservas.cargarReserva(20, 50, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 21));
        reservas.cargarReserva(5, 70, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 23));
        reservas.cargarReserva(12, 68, LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(9, 74, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 17));
        reservas.cargarReserva(18, 26, LocalDate.of(2025, 5, 23), LocalDate.of(2025, 5, 25));
        reservas.cargarReserva(4, 32, LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 24));
        reservas.cargarReserva(14, 1, LocalDate.of(2025, 5, 21), LocalDate.of(2025, 5, 22));
        reservas.cargarReserva(2, 19, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 21));
        reservas.cargarReserva(16, 43, LocalDate.of(2025, 5, 17), LocalDate.of(2025, 5, 19));
        reservas.cargarReserva(11, 14, LocalDate.of(2025, 5, 24), LocalDate.of(2025, 5, 26));
        reservas.cargarReserva(6, 25, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 20));
        reservas.cargarReserva(10, 49, LocalDate.of(2025, 5, 16), LocalDate.of(2025, 5, 18));
    }
}