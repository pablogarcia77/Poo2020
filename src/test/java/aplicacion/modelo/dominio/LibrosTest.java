package aplicacion.modelo.dominio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibrosTest {
    static Libros target;
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
		target = new Libros();
		Boolean resultado = target.verificarISBN("8476157118"); 
		assertTrue(resultado);
	}
}
