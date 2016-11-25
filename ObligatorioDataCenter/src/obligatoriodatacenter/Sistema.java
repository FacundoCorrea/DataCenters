package obligatoriodatacenter;

import obligatoriodatacenter.Retorno.Resultado;
import obligatoriodatacenter.Retorno;



public class Sistema implements ISistema {

        private Punto[] Puntos;
        private ABBEmpresa arbolE = new ABBEmpresa();
        private NodoPunto[] Tramos;
        @Override
        public Punto[] getCantPuntos() {
        return Puntos;
        }
        
        @Override
        public Ciudad darCiudad(double x, double y) {
        int i;
        Ciudad p = new Ciudad();
        for(i=0; i <= (Puntos.length -1) ;i++)
        {
            if(Puntos[i] != null)
            {
             if(Puntos[i] instanceof Ciudad)
             {
                if(Puntos[i].getCoordX() == x && Puntos[i].getCoordY()== y)
                {  
                p = (Ciudad) Puntos[i];
                }
             }
            }
        
        }
        return p;
        }
        
        @Override
        public DataCenter darDataCenter(double x, double y) {
        int i;
        DataCenter d = new DataCenter();
        for(i=0; i <= (Puntos.length -1) ;i++)
        {
            if(Puntos[i] != null)
            {
             if(Puntos[i] instanceof DataCenter)
             {
                if(Puntos[i].getCoordX() == x && Puntos[i].getCoordY()== y)
                {  
                d = (DataCenter) Puntos[i];
                }
             }
            }
        
        }
        return d;
        }
        
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
                arbolE.raiz = null;
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
            Punto auxOrigen = new Punto (coordXi,coordYi);
            Punto auxDestino = new Punto (coordXf,coordYf);
            Tramo auxT = new Tramo(auxOrigen,auxDestino,peso);
            if (peso<=0){ return new Retorno(Resultado.ERROR_1);}
            int i,a,b;
            boolean estadoInicio = false;
            boolean estadoFin = false;
            
            for(i=0; i <= ((Puntos.length)-1);i++){
                if(Puntos[i]!=null){
                    if(((Puntos[i].getCoordX())==coordXi) &&((Puntos[i].getCoordY())==coordYi)){
                          estadoInicio = true;
                    }
                    if(((Puntos[i].getCoordX())==coordXf) &&((Puntos[i].getCoordY())==coordYf)){
                          estadoFin = true;
                    }                
                }
            }
            if(estadoInicio || estadoFin == false){     
            return new Retorno(Resultado.ERROR_2);
            }
             for(a=0;a<=((Tramos.length)-1);a++){
                if(Tramos[a]!=null){
                    NodoPunto Anterior = Tramos[a].sig;
                    if((Tramos[a].getPunto().getCoordX()==auxT.getOrigen().getCoordX())&&(Tramos[a].getPunto().getCoordY()==auxT.getOrigen().getCoordY())){
                        NodoPunto aux = Tramos[a].sig;
                        while(aux.sig!=null){
                          if((aux.sig.punto.getCoordX()==auxT.getDestino().getCoordX())&&(aux.sig.punto.getCoordY()==auxT.getDestino().getCoordY())){
                             
                              return new Retorno(Resultado.ERROR_3);
                             
                          }
                          Anterior = aux;
                          aux = aux.sig;
                          //Anterior = Tramos[a];
                        }
                        Anterior.sig.punto=auxT.getDestino();
                        Anterior.sig.peso=auxT.getPeso();
                    }
                }
            }
           return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
        Retorno r = new Retorno(Resultado.ERROR_1);
        boolean estado = true;
        int i;
        for(i=0; i <= (Puntos.length -1) ;i++)
        {
            if(Puntos[i] != null)
            {
             if(Puntos[i].getCoordX() == coordX && Puntos[i].getCoordY()== coordY)
             {  
                Puntos[i] = Puntos[i + 1];
                r = new Retorno(Resultado.OK);
                estado = false;
             }
             if(!estado)
             {
                 Puntos[i] = Puntos[i + 1];
             }
            }
        }
        return r;
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
            StringBuilder string = new StringBuilder();
            return new Retorno(arbolE.listadoEmpresas(string).toString());
	}

	
	public Empresa PUTAEMPRESA() {
                return arbolE.buscarEmpresa("Pepe");
	}	
}
