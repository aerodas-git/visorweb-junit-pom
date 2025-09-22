package pe.visorweb.pagina.producto.csv;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;
import pe.visorweb.pagina.producto.PaginaActualizarProducto;

public class PaginaActualizarProductoCsvTest {

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
	
	
	@CsvFileSource(resources="/datos-actualizar-producto.csv",numLinesToSkip = 1,delimiter=',')
	@ParameterizedTest
	void actualizarProducto(String usuario, String clave, String producto, String valuecbo, String precio, String mensajeEsperado) {
	
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaActualizarProducto.cargarPagina();
		paginaActualizarProducto.actualizar(producto, valuecbo, precio);
		
		Assertions
			.assertThat(paginaActualizarProducto.getMensaje())
			.isEqualTo(mensajeEsperado);
		
		
	}

	
	
}
