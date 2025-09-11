package pe.visorweb.pagina.categoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pe.visorweb.pagina.base.PaginaBase;

public class PaginaMantenimientoCategoria extends PaginaBase {

	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;
	
	WebDriver driver;
	
	public PaginaMantenimientoCategoria(WebDriver driver) {
		super(driver);
	}
	
	public PaginaRegistrarCategoria cargarPaginaRegistrarCategoria() {
		btnNuevo.click();
		return new PaginaRegistrarCategoria(driver);
	}
	
}
