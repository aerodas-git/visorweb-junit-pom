package pe.visorweb.pagina.producto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaRegistrarProductoTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaRegistrarProducto paginaRegistrarProducto;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarProducto = new PaginaRegistrarProducto(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
		
	}
	
	@Test
	void insertarProductoExitoso() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarProducto.cargarPagina();
		paginaRegistrarProducto.guardar("Producto prueba 1", "2", "12.3");
		
		Assertions
			.assertThat(paginaRegistrarProducto.getMensaje())
			.isEqualTo("Se guardó de manera correcta el Producto");
	}
	
	
	@Test
	void insertarProductoVacio() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarProducto.cargarPagina();
		paginaRegistrarProducto.guardar("", "2", "12.3");
		
		Assertions
			.assertThat(paginaRegistrarProducto.getMensaje())
			.isEqualTo("Nombre: Error de validación: se necesita un valor.");
	}
	
}
