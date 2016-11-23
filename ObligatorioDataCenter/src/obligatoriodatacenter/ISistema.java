package obligatoriodatacenter;

public interface ISistema {

	Retorno inicializarSistema (int cantPuntos);
	
	Retorno destruirSistema();
	
	Retorno registrarEmpresa(String nombre, String direccion, String
			pais, String email_contacto, String color);
	
	Retorno registrarCiudad(String nombre, Double coordX, Double
			coordY);
	
	Retorno registrarDC(String nombre, Double coordX, Double coordY,
			String empresa, int capacidadCPUenHoras, int costoCPUporHora);
	
	Retorno registrarTramo(Double coordXi, Double coordYi, Double
			coordXf, Double coordYf, int peso);
	
	Retorno eliminarTramo(Double coordXi, Double coordYi, Double
			coordXf, Double coordYf);
	
	Retorno eliminarPunto(Double coordX, Double coordY);
	
	Retorno mapaEstado();
	
	Retorno procesarInformacion (Double coordX, Double coordY, int
			esfuerzoCPUrequeridoEnHoras);
	
	Retorno listadoRedMinima();
	
	Retorno listadoEmpresas();
	
	
}
