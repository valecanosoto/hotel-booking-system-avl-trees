
import java.util.Scanner;

import comparadores.ComparadorCiudad;
import estructuras.ArbolAVL;
import estructuras.ListaEnlazadaSimple;
import modelo.Hotel;

public class PruebaBusquedaCiudad {

    public static void main(String[] args) {
        // Creamos el árbol AVL con el comparador por ciudad
        ArbolAVL<Hotel> arbolHoteles = new ArbolAVL<>(new ComparadorCiudad());

        // Insertamos hoteles
        insertarHoteles(arbolHoteles);

        System.out.println("\nÁrbol de hoteles (ordenado por Ciudad):");
        arbolHoteles.imprimirArbol();

        // Solicitamos ciudad al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el nombre de la ciudad para buscar hoteles:");
        String ciudad = scanner.nextLine();

        // Creamos una clave de búsqueda ficticia con solo la ciudad
        Hotel claveBusqueda = new Hotel(0, null, ciudad, null, null, null, 0);

        // Obtenemos la lista de hoteles con esa ciudad
        ListaEnlazadaSimple<Hotel> resultado = arbolHoteles.buscar_repetidos(claveBusqueda);

        // Mostramos resultados
        if (resultado != null && resultado.size() > 0) {
            System.out.println("Hoteles encontrados en la ciudad \"" + ciudad + "\":");
            for (int i = 0; i < resultado.size(); i++) {
                System.out.println(resultado.obtener(i).toString());
                System.out.println();
            }
        } else {
            System.out.println("No se encontraron hoteles en la ciudad \"" + ciudad + "\".");
        }

        scanner.close();
    }

    public static void insertarHoteles(ArbolAVL<Hotel> arbol) {
        arbol.insertar_repetido(new Hotel(1, "Hotel María DB Plaza Central", "Ciudad de México",
            "Av. Juárez 100 Col. Centro", "7053624331", "plaza_central@hotelmdb.com", 1));

        arbol.insertar_repetido(new Hotel(2, "Hotel María DB Costa Azul", "Acapulco",
            "Calle del Mar 12 Col. Playa Azul", "7517525458", "costa_azul@hotelmdb.com", 4));

        arbol.insertar_repetido(new Hotel(3, "Hotel María DB Vista al Mar", "Cancún",
            "Boulevard Costero 200 Col. Océano", "3842717031", "vista_mar@hotelmdb.com", 4));
        
        arbol.insertar_repetido(new Hotel(9, "Hotel María DB Cancún Sol", "Cancún",
            "Av. Kukulkán 300 Col. Sol", "5551209345", "sol@hotelmdb.com", 4));
        
        arbol.insertar_repetido(new Hotel(10, "Hotel María DB Cancún Arena", "Cancún",
            "Zona Hotelera 180 Col. Arena", "5558890345", "arena@hotelmdb.com", 4));
        
        arbol.insertar_repetido(new Hotel(4, "Hotel María DB Montañas", "Chiapas",
            "Sierra Nevada 15 Col. Alturas", "3805565830", "montanas@hotelmdb.com", 4));

        arbol.insertar_repetido(new Hotel(5, "Hotel María DB Jardines", "Morelia",
            "Jardín Botánico 22 Col. Flora", "6454871533", "jardines@hotelmdb.com", 2));

        arbol.insertar_repetido(new Hotel(6, "Hotel María DB Centro Histórico", "Puebla",
            "Calle Hidalgo 1 Col. Centro", "7315861065", "centro_hist@hotelmdb.com", 4));

        arbol.insertar_repetido(new Hotel(7, "Hotel María DB Laguna", "Mazatlán",
            "Malecón 77 Col. Laguna Norte", "2279954713", "laguna@hotelmdb.com", 4));

        arbol.insertar_repetido(new Hotel(8, "Hotel María DB Reforma", "Ciudad de México",
            "Paseo de la Reforma 200", "5523447890", "reforma@hotelmdb.com", 3));
    }
}
