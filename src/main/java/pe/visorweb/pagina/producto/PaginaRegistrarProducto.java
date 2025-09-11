package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaRegistrarProducto extends PaginaBase {

	@FindBy(id = "txtNombre")
	WebElement txtNombre;
	
	@FindBy(id = "btnGuardar")
	WebElement btnGuardar;
	
	@FindBy(id = "cboCategoria")
	WebElement cboCategoria;
	
	@FindBy(id = "txtPrecio")
	WebElement txtPrecio;
	
	@FindBy(xpath = "//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-error-summary']")
	WebElement lblMensaje;
	
	
	public PaginaRegistrarProducto(WebDriver driver) {
			super(driver);
}

	public void cargarPagina(){
		menuPrincipal
			.cargarPaginaMantenimientoProducto()
			.cargarPaginaRegistrarProducto();
		
	}
	
	public void guardar(String categoria, String value, String precio) {
		//txtNombre.clear();
		//txtNombre.sendKeys(categoria);
		escribir(txtNombre, categoria);
		cboselect(cboCategoria, value);
		escribir(txtPrecio, precio);
		click(btnGuardar);
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
		}
	
	
}
