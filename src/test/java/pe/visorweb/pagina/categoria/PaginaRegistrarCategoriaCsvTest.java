package pe.visorweb.pagina.categoria;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;

public class PaginaRegistrarCategoriaCsvTest {

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
	
	@CsvFileSource(resources = "/datos-insertar-categoria.csv",numLinesToSkip = 1,delimiter=',')
	@ParameterizedTest
	void insertar( String usuario, String clave, String categoria, String mensajeEsperado) {
		
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaRegistrarCategoria.cargarPagina();
		paginaRegistrarCategoria.guardar(categoria);
		
		Assertions
			.assertThat(paginaRegistrarCategoria.getMensaje())
			.isEqualTo(mensajeEsperado);
	}
	
}
