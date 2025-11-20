package com.utn.biblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        // 1. Creamos una biblioteca
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central UTN");
        System.out.printf(">> 1. Biblioteca '%s' creada.\n\n", miBiblioteca.getNombre());

        // 2. Crear al menos tres autores
        System.out.println(">> 2. Creando Autores:");
        Autor a1 = new Autor("A001", "Gabriel Garcia Marquez", "Colombiano");
        Autor a2 = new Autor("A002", "Jane Austen", "Británica");
        Autor a3 = new Autor("A003", "Jorge Luis Borges", "Argentino");
        a1.mostrarInfo(); a2.mostrarInfo(); a3.mostrarInfo();
        System.out.println();

        // 3. Agregar 5 libros asociados a los autores
        System.out.println(">> 3. Agregando 5 Libros:");
        miBiblioteca.agregarLibro("978-0307277671", "Cien años de soledad", 1967, a1);
        miBiblioteca.agregarLibro("978-0141439518", "Orgullo y Prejuicio", 1813, a2);
        miBiblioteca.agregarLibro("978-0140284683", "Ficciones", 1944, a3);
        miBiblioteca.agregarLibro("978-8420485548", "El amor en los tiempos del cólera", 1985, a1);
        miBiblioteca.agregarLibro("978-0141439589", "Sentido y Sensibilidad", 1811, a2);
        System.out.println("Libros agregados.\n");

        // 4. Listar todos los libros con su información y la del autor
        System.out.println(">> 4. Listando todos los libros:");
        miBiblioteca.listarLibros();
        System.out.println();

        // 5. Buscar un libro por su ISBN y mostrar su información
        String isbnBuscado = "978-0141439518";
        System.out.printf(">> 5. Buscando libro por ISBN: %s\n", isbnBuscado);
        Libro lBuscado = miBiblioteca.buscarLibroPorIsbn(isbnBuscado);
        if (lBuscado != null) {
            lBuscado.mostrarInfo();
        } else {
            System.out.println("Libro no encontrado.");
        }
        System.out.println();
        
        // 6. Filtrar y mostrar los libros publicados en un año específico (1811)
        System.out.println(">> 6. Filtrando libros por año 1811:");
        miBiblioteca.filtrarLibrosPorAnio(1811);
        System.out.println();

        // 7. Eliminar un libro por su ISBN (978-0141439518) y listar los libros restantes
        String isbnEliminar = "978-0141439518";
        System.out.printf(">> 7. Eliminando libro por ISBN: %s\n", isbnEliminar);
        if (miBiblioteca.eliminarLibro(isbnEliminar)) {
            System.out.printf("Libro con ISBN %s eliminado.\n", isbnEliminar);
        } else {
            System.out.println("Libro no encontrado o error al eliminar.");
        }
        System.out.println("\nListado restante:");
        miBiblioteca.listarLibros();
        System.out.println();

        // 8. Mostrar la cantidad total de libros en la biblioteca
        System.out.println(">> 8. Cantidad total de libros:");
        System.out.printf("Total de libros: %d.\n", miBiblioteca.obtenerCantidadLibros());
        System.out.println();

        // 9. Listar todos los autores de los libros disponibles en la biblioteca
        System.out.println(">> 9. Listando autores disponibles:");
        miBiblioteca.mostrarAutoresDisponibles();
    }
}
