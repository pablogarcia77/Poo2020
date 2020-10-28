package aplicacion.modelo.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GestorLibrosTest {
	static String isbn = "8476157118", isbn2 = "0764526413", isbn3 = "9780863815805"; 
	// @BeforeAll
	// public static void setUp() {
	// 	target = new Libros();
	// }
	// @AfterAll
	// public static void tearDown() {
	// 	target = null;
	// }
	@DisplayName("Chequear ISBN")
	@Test
	public void chequearISBN() {
		Boolean resultado = GestorLibros.verificarISBN(isbn);
		assertTrue(resultado);
	}
	
	@DisplayName("Agregar Libro")
	@Test
	public void agregarLibro(){
		Libro target = new Libro("Atahualpa",isbn);
		GestorLibros.agregarLibro(isbn, target);
		assertEquals(GestorLibros.libros.size(), 1);
	}

	@DisplayName("Ordenar Libros")
	@Test
	public void ordenarLibro(){
		Libro libro1 = new Libro("Libro 1",isbn);
		Libro libro2 = new Libro("Libro 2",isbn);
		Libro libro3 = new Libro("Libro 3",isbn);
		
		GestorLibros.agregarLibro(isbn,libro3);
		GestorLibros.agregarLibro(isbn,libro2);
		GestorLibros.agregarLibro(isbn,libro1);

		GestorLibros.ordenarLibros(GestorLibros.getLibros());

		List<Libro> aux = new ArrayList<Libro>();
		aux.add(libro1);
		aux.add(libro2);
        aux.add(libro3);
        
        assertEquals(GestorLibros.getLibros(),aux);
	}

	@DisplayName("Buscar libro por ISBN")
	@Test
    public void buscarLibro(){
		Libro libro1 = new Libro("Libro 1",isbn);
		Libro libro2 = new Libro("Libro 2",isbn2);
		Libro libro3 = new Libro("Libro 3",isbn3);
		
		GestorLibros.agregarLibro(isbn3,libro3);
		GestorLibros.agregarLibro(isbn2,libro2);
		GestorLibros.agregarLibro(isbn,libro1);

		assertTrue(GestorLibros.buscarLibro(isbn2));
	
	}
}