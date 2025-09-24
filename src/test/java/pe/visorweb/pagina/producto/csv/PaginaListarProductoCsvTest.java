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
import pe.visorweb.pagina.producto.PaginaListarProducto;

public class PaginaListarProductoCsvTest {

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
	
	@CsvFileSource(resources = "/datos-listar-producto.csv",numLinesToSkip = 1,delimiter=',')
	@ParameterizedTest
	void listarProducto(String usuario, String clave, String textoBuscar, String mensajeEsperado) {
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaListarProducto.cargarPagina();
		paginaListarProducto.listar(textoBuscar);
		
		
		Assertions
			.assertThat(paginaListarProducto.getMensaje())
			.isEqualTo(mensajeEsperado);
		
	}
	
	
	
}
