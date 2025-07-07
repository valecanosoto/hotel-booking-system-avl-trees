# Hotel Booking System with AVL Trees – Java Application

## 📝 Descripción general

Este proyecto consistió en el desarrollo de un **sistema de reservas para una cadena hotelera con múltiples sucursales**, orientado a la **gestión eficiente de usuarios, habitaciones y reservas**. Fue implementado en Java utilizando estructuras de datos personalizadas, en particular **árboles AVL y listas enlazadas**, sin apoyo de librerías externas.

El objetivo principal fue aplicar conceptos de **estructuras de datos, programación modular y comparadores personalizados**, integrando funcionalidades que simulan un entorno real de operación hotelera, como:

- Registro y búsqueda de hoteles por nombre, categoría o ciudad
- Consulta de habitaciones disponibles por precio y fecha
- Registro y cancelación de reservas
- Cálculo del importe facturado por cliente
- Control de disponibilidad por habitación

Este proyecto fue desarrollado con fines académicos como parte del curso de *Estructuras de Datos*, con énfasis en el diseño desde cero de estructuras eficientes y reutilizables.

---

## 📁 Estructura del proyecto

El código fuente se encuentra organizado en la carpeta principal `codigo/` y distribuido en los siguientes paquetes:

### `app/`
Contiene las clases principales que inicializan y ejecutan el sistema:

- `InicializadorDatos.java`: carga datos iniciales de hoteles, habitaciones, usuarios y reservas.
- `SistemaHotel.java`: clase principal que lanza la aplicación.

### `modelo/`
Contiene las entidades del sistema y sus gestores lógicos:

- `Hotel.java`, `Habitacion.java`, `Usuario.java`, `Reserva.java`
- `GestorHoteles.java`, `GestorHabitaciones.java`, `GestorUsuarios.java`, `GestorReservas.java`

### `estructuras/`
Implementaciones propias de estructuras de datos:

- `ArbolAVL.java`, `ListaEnlazadaSimple.java`, `Nodo.java`
- `TDABinaryTree.java`, `TDALista.java`

### `comparadores/`
Clases para ordenamiento personalizado dentro de los árboles AVL.

### `pruebas/`
Contiene pruebas funcionales o unitarias utilizadas durante el desarrollo.

#### Estructura visual del proyecto:


	|--- codigo
		|--- app
	                  |--- InicializadorDatos.java
	                  |--- SistemaHotel.java
	        |--- comparadores
	                  |---   [...]
	        |--- estructuras
	                  |--- ArbolAVL.java
	                  |--- ListaEnlazadaSimple.java
	                  |--- Nodo.java
	                  |--- TDABinaryTree.java
	                  |--- TDALista.java
	        |--- modelo
	                  |--- GestorHabitaciones.java
	                  |--- GestorHoteles.java
	                  |--- GestorReservas.java
	                  |--- GestorUsuarios.java
	                  |--- Habitacion.java
	                  |--- Hotel.java
	                  |--- Reserva.java
	                  |--- Usuario.java
	        |--- pruebas
	                  |--- [...]

---

## ⚙️ Requisitos

- Java Development Kit (JDK) 11 o superior
- Terminal o consola
- (Opcional) Visual Studio Code u otro entorno de desarrollo

---

## 🚀 Instrucciones de uso

### 1. Abrir la terminal

  * En Windows, abrir el "Símbolo del sistema" (CMD).
  * En Linux, usar la terminal de su elección (bash, zsh, etc.).

O, equivalentemente, hacerlo desde Visual Studio Code con `Ctrl + ñ`.


### 2. Compilar el proyecto

Ubicarse en la carpeta raíz del proyecto (`codigo`) y ejecutar:

  * Para Windows:
	
	javac -encoding UTF-8 -d out app\*.java estructuras\*.java modelo\*.java comparadores\*.java

  * Para Linux:
	
	javac -encoding UTF-8 -d out $(find . -name "*.java")


### 3. Ejecutar el proyecto

Igualmente, desde la raíz del proyecto, escribir:

	java -cp out app.SistemaHotel

---

## 👩‍💻 Autora

Valeria Cano Soto
valecanosoto@ciencias.unam.mx
Facultad de Ciencias – UNAM
Proyecto final para el curso de Estructuras de Datos
Junio de 2025

---

## 📄 Licencia

Uso educativo y demostrativo. Se permite su modificación y reutilización con fines no comerciales.
