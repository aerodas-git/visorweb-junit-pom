package pe.visorweb.helper;

public class VisorHelper {

	public static void pausar() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException exception) {
			throw new RuntimeException(exception);
		}
	}
	
}
