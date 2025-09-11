package pe.visorweb.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VisorDriver {

	public enum Navegador {CHROME, FIREFOX, EDGE }
	
	private VisorDriver() {
			
	}
	
	public static WebDriver getDriver(Navegador navegador) {

		switch (navegador) {
		case FIREFOX:
			return getFirefoxDriver();
		case EDGE:
			return getEdgeDriver();
		default:
			return getChromeDriver();
		}
		
//		if (navegador == Navegador.FIREFOX) {
//			return getFirefoxDriver();
//		} else if (navegador == Navegador.EDGE) {
//			return getEdgeDriver();
//		}
//		return getChromeDriver();
		
	}

	private static WebDriver getEdgeDriver() {
		return aplicarConfiguracionComun(new EdgeDriver());
	}

	private static WebDriver getChromeDriver() {
		return aplicarConfiguracionComun(new ChromeDriver());
	}

	private static WebDriver getFirefoxDriver() {
		return aplicarConfiguracionComun(new FirefoxDriver());
	}
	
	private static WebDriver aplicarConfiguracionComun(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	
}
