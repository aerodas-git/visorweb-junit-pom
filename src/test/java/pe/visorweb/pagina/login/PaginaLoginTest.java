package pe.visorweb.pagina.login;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;

public class PaginaLoginTest {

	WebDriver driver;
	PaginaLogin paginaLogin;
	
	@BeforeEach
	void configuracionInicial() {
		driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
	}
	
	@Test
	void iniciarSesion() {
		
		paginaLogin.cargarPagina();
		paginaLogin.iniciarSesion("admin", "clave");
		
		Assertions
			.assertThat(paginaLogin.getMensaje())
			.isEqualTo("Bienvenido(a) al Sistema Visor de Almacén");
	}
	
}
