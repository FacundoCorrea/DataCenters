package obligatoriodatacenter;

import obligatoriodatacenter.Retorno.Resultado;


public class Sistema implements ISistema {

        private Punto[] Puntos;
        private ABBEmpresa arbolE = new ABBEmpresa();
        
        
	@Override
	public Retorno inicializarSistema(int cantPuntos) {
            if(cantPuntos <= 0)
            {
                return new Retorno(Resultado.ERROR_1);
            }
            else
            {
		Puntos = new Punto[cantPuntos];
                return new Retorno(Resultado.OK);
            }
	}

	@Override
	public Retorno destruirSistema() {
		Puntos = null;
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarEmpresa(String nombre, String direccion,String pais, String email_contacto, String color) {
		Empresa e = new Empresa(nombre,direccion,pais,email_contacto,color);
                return arbolE.insertar(e);
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
            Ciudad ciudad = new Ciudad(nombre,"Amarillo",coordX,coordY);
            boolean Estado = false;         
            for(int i=0; i <= ((Puntos.length)-1);i++)
            {   
                if(Puntos[i] != null)
                {
                  if(Puntos[i].getCoordX() == coordX && Puntos[i].getCoordY()==coordY)
                  {
                      return new Retorno(Resultado.ERROR_2);
                  }
                }
                else
                {
                Puntos[i] = ciudad;
                i = Puntos.length;
                Estado = true;
                }
            }
            if(Estado)
            {
                return new Retorno(Resultado.OK);
            }
            else
            {
               return new Retorno(Resultado.ERROR_1); 
            }   
	}

	@Override
	public Retorno registrarDC(String nombre, Double coordX, Double coordY,String empresa, int capacidadCPUenHoras, int costoCPUporHora) {
            DataCenter dc = new DataCenter(nombre,empresa,capacidadCPUenHoras,costoCPUporHora,empresa,coordX,coordY);
            boolean Estado = false;
            int i;
            if(dc.getCapacidadCPUenHoras() <= 0)
            {
              return new Retorno(Resultado.ERROR_2);  
            }
            else if(arbolE.buscarEmpresa(empresa) == null)
            {
                return new Retorno(Resultado.ERROR_4);
            }
            else
            {
            for(i=0; i <= (Puntos.length -1) ;i++)
            {
                if(Puntos[i] != null)
                {
                    if(Puntos[i].getCoordX() == coordX && Puntos[i].getCoordY()== coordY)
                    {
                        return new Retorno(Resultado.ERROR_3);
                    }
                }
                else
                {
                    Puntos[i] = dc;
                    i = Puntos.length;
                    Estado = true;
                }
            }
            if(Estado)
            {
                return new Retorno(Resultado.OK);
            }
            else
            {
               return new Retorno(Resultado.ERROR_1); 
            }
            }
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf, int peso) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno mapaEstado() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno procesarInformacion(Double coordX, Double coordY,
			int esfuerzoCPUrequeridoEnHoras) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listadoRedMinima() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listadoEmpresas() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	
	public Empresa PUTAEMPRESA() {
                return arbolE.buscarEmpresa("Pepe");
	}	
}
