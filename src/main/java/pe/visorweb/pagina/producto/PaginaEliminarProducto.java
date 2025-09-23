package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaEliminarProducto extends PaginaBase {

	@FindBy(id="btnSi")
	WebElement btnSi;
	
	@FindBy(id="btnNo")
	WebElement btnNo;
	
	@FindBy(xpath="//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-warn-summary']")
	WebElement lblMensaje;
	
	
	
	WebDriver driver;
	
	public PaginaEliminarProducto(WebDriver driver) {
			super(driver);
	}
	
	public void cargarPagina(String value) {
		menuPrincipal
			.cargarPaginaMantenimientoProducto()
			.cargarPaginaEliminarProducto(value);
	}
	
	public void eliminarProducto() {
		btnSi.click();
	}
	
		
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
		}

	
	
}
