package pe.visorweb.pagina.producto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaListarProductoTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaListarProducto paginaListarProducto;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaListarProducto = new PaginaListarProducto(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
		
	}
	
	@Test
	void listarProductoExitoso() {
		
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaListarProducto.cargarPagina();
		paginaListarProducto.listar("PRUEBA");
		
		Assertions
			.assertThat(paginaListarProducto.getMensaje())
			.isEqualTo("Existen registros para la consulta");
		
	}
	
	@Test
	void listarProductoNoExitoso() {
		
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaListarProducto.cargarPagina();
		paginaListarProducto.listar("NOEXISTE");
		
		Assertions
			.assertThat(paginaListarProducto.getMensaje())
			.isEqualTo("No existe registros para la consulta");
		
	}
	
	
	
	
}
