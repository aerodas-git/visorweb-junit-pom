package pe.visorweb.pagina.producto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaListarProducto extends PaginaBase {

	
	@FindBy(id="txtFiltro")
	WebElement txtFiltro;
	
	@FindBy(id="btnFiltrar")
	WebElement btnFiltrar;
	
	@FindBy(id="tablaProductos_data")
	WebElement tablaDatos;
	
	@FindBy(xpath="//tr[@class='ui-widget-content ui-datatable-empty-message']")
	WebElement lblMensaje;
	
	public PaginaListarProducto(WebDriver driver) {
		super(driver);
	}
	
	public void cargarPagina() {
		
		menuPrincipal
			.cargarPaginaMantenimientoProducto();
	}
	
	public void listar(String textoFiltro) {
		escribir(txtFiltro,textoFiltro);
		click(btnFiltrar);
		
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		List<WebElement> filas = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody[@id='tablaProductos_data']/tr"),0 ));
		//System.out.println("**** filas del resultado de la tabla: "+filas.size());
		String mensajeObtenido = "Existen registros para la consulta";;
		
		boolean existeTexto = tablaDatos.getText().contains("No existe registros para la consulta"); 
		//System.out.println("**** existeTexto: "+existeTexto);
		
		if (filas.size() == 1 && existeTexto) {

			mensajeObtenido = lblMensaje.getText();
		}
		//System.out.println("****mensajeobtenido: "+mensajeObtenido);
		return mensajeObtenido;
	}

}
