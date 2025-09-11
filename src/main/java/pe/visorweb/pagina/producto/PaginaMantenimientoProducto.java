package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorweb.pagina.base.PaginaBase;

public class PaginaMantenimientoProducto extends PaginaBase {


	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;
	
	WebDriver driver;

	public PaginaMantenimientoProducto(WebDriver driver) {
		super(driver);
	}
	
	public PaginaRegistrarProducto cargarPaginaRegistrarProducto() {
		btnNuevo.click();
		return new PaginaRegistrarProducto(driver);
	}
	
}
