package pe.visorweb.pagina.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.visorweb.menu.MenuPrincipal;

public class PaginaBase {

	
	protected WebDriver driver;
	protected WebDriverWait driverWait;

	
	protected MenuPrincipal menuPrincipal;
	
	public PaginaBase(WebDriver driver) {
		this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera de 10 segundos
		this.menuPrincipal = new MenuPrincipal(driver);
		PageFactory.initElements(driver, this);
	}
	
	protected void escribir(WebElement elemento, String texto) {
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	protected void click(WebElement elemento) {
		elemento.click();
	}
	
	protected void cboselect(WebElement elemento, String value) {
		Select select = new Select(elemento);
		select.selectByValue(value);
	}
	
}
