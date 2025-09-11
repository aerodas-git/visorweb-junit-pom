package pe.visorweb.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.pagina.categoria.PaginaMantenimientoCategoria;
import pe.visorweb.pagina.producto.PaginaMantenimientoProducto;

public class MenuPrincipal {

	@FindBy(xpath = "//div[@class='menu']/div")
	WebElement menuHamburguesa;
	
	@FindBy(xpath = "//span[contains(text(), 'Mod. de Almacén')]")
	WebElement menuModuloAlmacen;
	
	@FindBy(linkText = "Mnt. de Categoría")
	WebElement menuMntCategoria;
	
	@FindBy(linkText = "Mnt. de Productos")
	WebElement menuMntProducto;
	
	WebDriver driver;
	
	public MenuPrincipal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaginaMantenimientoCategoria cargarPaginaMantenimientoCategoria() {
		menuHamburguesa.click();
		menuModuloAlmacen.click();
		menuMntCategoria.click();
		return new PaginaMantenimientoCategoria(driver);
	}
	
	public PaginaMantenimientoProducto cargarPaginaMantenimientoProducto() {
		menuHamburguesa.click();
		menuModuloAlmacen.click();
		menuMntProducto.click();
		return new PaginaMantenimientoProducto(driver);
	}
	
	
}
