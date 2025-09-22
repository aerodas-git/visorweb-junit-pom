package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorweb.pagina.base.PaginaBase;

public class PaginaMantenimientoProducto extends PaginaBase {


	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;
	
	//Actualizar
	
	@FindBy(id="btnFiltrar")
	WebElement btnFiltrar;
	
	@FindBy(xpath="//tr[@data-ri='2']")
	WebElement productoActualizado;
	
	@FindBy(id="btnActualizar")
	WebElement btnActualizar;
	
	WebDriver driver;

	public PaginaMantenimientoProducto(WebDriver driver) {
		super(driver);
	}
	
	public PaginaRegistrarProducto cargarPaginaRegistrarProducto() {
		btnNuevo.click();
		return new PaginaRegistrarProducto(driver);
	}
	
	public PaginaActualizarProducto cargarPaginaActualizarProducto() {
		btnFiltrar.click();
		productoActualizado.click();
		btnActualizar.click();
		return new PaginaActualizarProducto(driver);
	}
	
}
