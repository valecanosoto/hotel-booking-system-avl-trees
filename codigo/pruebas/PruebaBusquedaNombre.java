
import java.util.Scanner;

import comparadores.ComparadorNombre;
import estructuras.ArbolAVL;
import estructuras.Nodo;
import modelo.Hotel;

public class PruebaBusquedaNombre {

    public static void main(String[] args) {
        ArbolAVL<Hotel> arbolHoteles = new ArbolAVL<>(new ComparadorNombre());

        // Insertar hoteles
        insertarHoteles(arbolHoteles);

        System.out.println("\nÁrbol de hoteles (ordenado por Nombre):");
        arbolHoteles.imprimirArbol();

        // Búsqueda
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del hotel a buscar:");
        String nombre = scanner.nextLine();

        Hotel claveBusqueda = new Hotel(0, nombre, null, null, null, null, 0);
        Nodo<Hotel> resultado = arbolHoteles.buscar(claveBusqueda);

        if (resultado != null) {
            System.out.println("Hotel encontrado:");
            System.out.println(resultado.getClave().toString());
        } else {
            System.out.println("Hotel no encontrado por nombre.");
        }

        scanner.close();
    }

    public static void insertarHoteles(ArbolAVL<Hotel> arbol) {
        arbol.insertar(new Hotel(1, "Hotel María DB Plaza Central", "Ciudad de México",
            "Av. Juárez 100 Col. Centro", "7053624331", "plaza_central@hotelmdb.com", 1));

        arbol.insertar(new Hotel(2, "Hotel María DB Costa Azul", "Acapulco",
            "Calle del Mar 12 Col. Playa Azul", "7517525458", "costa_azul@hotelmdb.com", 4));

        arbol.insertar(new Hotel(3, "Hotel María DB Vista al Mar", "Cancún",
            "Boulevard Costero 200 Col. Océano", "3842717031", "vista_mar@hotelmdb.com", 4));

        arbol.insertar(new Hotel(4, "Hotel María DB Montañas", "Chiapas",
            "Sierra Nevada 15 Col. Alturas", "3805565830", "montanas@hotelmdb.com", 4));

        arbol.insertar(new Hotel(5, "Hotel María DB Jardines", "Morelia",
            "Jardín Botánico 22 Col. Flora", "6454871533", "jardines@hotelmdb.com", 2));

        arbol.insertar(new Hotel(6, "Hotel María DB Centro Histórico", "Puebla",
            "Calle Hidalgo 1 Col. Centro", "7315861065", "centro_hist@hotelmdb.com", 4));

        arbol.insertar(new Hotel(7, "Hotel María DB Laguna", "Mazatlán",
            "Malecón 77 Col. Laguna Norte", "2279954713", "laguna@hotelmdb.com", 4));
    }
}
