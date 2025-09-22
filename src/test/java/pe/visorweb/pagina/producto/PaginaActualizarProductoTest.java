package pe.visorweb.pagina.producto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaActualizarProductoTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaActualizarProducto paginaActualizarProducto;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaActualizarProducto = new PaginaActualizarProducto(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
		
	}
	
	@Test
	void actualizarProductoExitoso() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaActualizarProducto.cargarPagina();
		paginaActualizarProducto.actualizar("INCA KOLA ACT","6","12.22");;
		
		Assertions
			.assertThat(paginaActualizarProducto.getMensaje())
			.isEqualTo("Se actualizó de manera correcta el Producto");
	}
	
	@Test
	void actualizarProductoNombreVacio() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaActualizarProducto.cargarPagina();
		paginaActualizarProducto.actualizar("","6","12.22");;
		
		Assertions
			.assertThat(paginaActualizarProducto.getMensaje())
			.isEqualTo("Nombre: Error de validación: se necesita un valor.");
	}
	
	@Test
	void actualizarProductoPrecioVacio() {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaActualizarProducto.cargarPagina();
		paginaActualizarProducto.actualizar("INCA KOLA","6","");;
		
		Assertions
			.assertThat(paginaActualizarProducto.getMensaje())
			.isEqualTo("Precio: Error de validación: se necesita un valor.");
	}
	
	
}
