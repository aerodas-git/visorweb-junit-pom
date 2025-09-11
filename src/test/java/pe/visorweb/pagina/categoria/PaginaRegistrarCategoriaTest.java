package pe.visorweb.pagina.categoria;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaRegistrarCategoriaTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
		
	}
	
	@Test
	void insertarCategoriaExitosa() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarCategoria.cargarPagina();
		paginaRegistrarCategoria.guardar("Categoria prueba 20250910");
		
		Assertions
			.assertThat(paginaRegistrarCategoria.getMensaje())
			.isEqualTo("Se guardó de manera correcta la Categoría");
	}
	
	@Test
	void insertarCategoriaVacia() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarCategoria.cargarPagina();
		paginaRegistrarCategoria.guardar("");
		
		Assertions
			.assertThat(paginaRegistrarCategoria.getMensaje())
			.isEqualTo("Nombre: Error de validación: se necesita un valor.");
	}
	
	
}
