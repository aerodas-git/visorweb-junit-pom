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
import pe.visorweb.pagina.producto.PaginaEliminarProducto;

public class PaginaEliminarProductoTestCsv {

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
	
	@CsvFileSource(resources = "/datos-eliminar-producto.csv",numLinesToSkip = 1,delimiter=',')
	@ParameterizedTest
	void eliminarProducto(String usuario, String clave, String value, String mensajeEsperado) {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaEliminarProducto.cargarPagina(value);
		paginaEliminarProducto.eliminarProducto();
		
		
		Assertions
			.assertThat(paginaEliminarProducto.getMensaje())
			.isEqualTo(mensajeEsperado);
		
	}
	
	
}
