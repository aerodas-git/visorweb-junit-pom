package pe.visorweb.pagina.categoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaRegistrarCategoria extends PaginaBase{

	@FindBy(id = "txtNombre")
	WebElement txtNombre;
	
	@FindBy(id = "btnGuardar")
	WebElement btnGuardar;
	
	@FindBy(xpath = "//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-error-summary']")
	WebElement lblMensaje;
	
		
	//WebDriver driver;
	
	//MenuPrincipal menuPrincipal;
		
	public PaginaRegistrarCategoria(WebDriver driver) {
		super(driver);
		
	}
	
	public void cargarPagina() {
		menuPrincipal
			.cargarPaginaMantenimientoCategoria()
			.cargarPaginaRegistrarCategoria();
	}
	
	public void guardar(String categoria) {
		//txtNombre.clear();
		//txtNombre.sendKeys(categoria);
		escribir(txtNombre, categoria);
		//btnGuardar.click();
		click(btnGuardar);
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
		}
	
}
