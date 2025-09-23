package pe.visorweb.pagina.producto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaEliminarProductoTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaEliminarProducto paginaEliminarProducto;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaEliminarProducto = new PaginaEliminarProducto(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
		
	}
	
	@Test
	void eliminarProductoExitoso() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaEliminarProducto.cargarPagina("3");
		paginaEliminarProducto.eliminarProducto();
		
		
		Assertions
			.assertThat(paginaEliminarProducto.getMensaje())
			.isEqualTo("Se eliminó de manera correcta el Producto");
	}
	
	
	@Test
	void eliminarProductoVacio() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaEliminarProducto.cargarPagina("");
		paginaEliminarProducto.eliminarProducto();
		
		
		Assertions
			.assertThat(paginaEliminarProducto.getMensaje())
			.isEqualTo("No ha seleccionado un Producto");
	}
	
	
}
