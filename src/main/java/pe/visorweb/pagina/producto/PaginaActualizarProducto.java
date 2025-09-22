package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaActualizarProducto extends PaginaBase {


	@FindBy(id="txtNombre")
	WebElement txtNombre;
	
	@FindBy(id="cboCategoria")
	WebElement cboCategoria;
	
	@FindBy(id="txtPrecio")
	WebElement txtPrecio;
	
	@FindBy(id="btnGuardar")
	WebElement btnGuardar;
	
	@FindBy(xpath="//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-error-summary']")
	WebElement lblMensaje;
	
	public PaginaActualizarProducto(WebDriver driver) {
		super(driver);
	}
	
	public void cargarPagina() {
		menuPrincipal
			.cargarPaginaMantenimientoProducto()
			.cargarPaginaActualizarProducto();
	}
	
	public void actualizar(String producto, String value, String precio) {
		//txtNombre.clear();
		//txtNombre.sendKeys(categoria);
		escribir(txtNombre, producto);
		cboselect(cboCategoria, value);
		escribir(txtPrecio, precio);
		click(btnGuardar);
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
		}
	

}
