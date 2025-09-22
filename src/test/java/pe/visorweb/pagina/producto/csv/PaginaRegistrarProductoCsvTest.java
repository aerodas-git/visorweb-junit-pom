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
import pe.visorweb.pagina.producto.PaginaRegistrarProducto;

public class PaginaRegistrarProductoCsvTest {
	
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
	
	@CsvFileSource(resources="/datos-insertar-producto.csv",numLinesToSkip = 1,delimiter=',')
	@ParameterizedTest
	void insertarProducto(String usuario, String clave, String producto, String valuecbo, String precio, String mensajeEsperado ) {
		
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaRegistrarProducto.cargarPagina();
		paginaRegistrarProducto.guardar(producto, valuecbo, precio);
		
		Assertions
			.assertThat(paginaRegistrarProducto.getMensaje())
			.isEqualTo(mensajeEsperado);
		
	}
	
	

}
