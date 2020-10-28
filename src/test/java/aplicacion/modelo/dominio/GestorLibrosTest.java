package aplicacion.modelo.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GestorLibrosTest {
	static String isbn = "8476157118";
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
		Libro target = new Libro(isbn, "Atahualpa");
		GestorLibros.agregarLibro(isbn, target);
		assertEquals(GestorLibros.libros.size(), 1);
	}
}
