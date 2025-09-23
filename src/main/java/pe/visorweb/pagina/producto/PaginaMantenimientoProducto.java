package pe.visorweb.pagina.producto;

import java.nio.file.Files;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaMantenimientoProducto extends PaginaBase {


	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;
	
	//ACTUALIZAR
	
	@FindBy(id="btnFiltrar")
	WebElement btnFiltrar;
	
	@FindBy(xpath="//tr[@data-ri='2']")
	WebElement productoActualizado;
	
	@FindBy(id="btnActualizar")
	WebElement btnActualizar;
	
	//ELIMINAR
	
	@FindBy(id="tablaProductos_data")
	WebElement tablaDatos;
	
	@FindBy(id="btnEliminar")
	WebElement btnEliminar;
	
	
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
	
	public PaginaEliminarProducto cargarPaginaEliminarProducto(String value) {
		btnFiltrar.click();
		List<WebElement> filas = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody[@id='tablaProductos_data']/tr"),1 ));
		//System.out.println("********* "+ filas.size());

		if (value != "") {
			tablaDatos.findElement(By.xpath(".//tr[@data-ri='"+value+"']")).click();
		}	
		btnEliminar.click();
		return new PaginaEliminarProducto(driver);
	}

	
}
