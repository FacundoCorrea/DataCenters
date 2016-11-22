
package obligatoriodatacenter;

import java.util.ArrayList;
import obligatoriodatacenter.Retorno.Resultado;
import obligatoriodatacenter.Retorno;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABBEmpresa {
    NodoEmpresa raiz;
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    ArrayList<String> Empresas;
    
    

    public Retorno insertar(Empresa e){
        Retorno r = new Retorno(Resultado.OK);
        Matcher mather = pattern.matcher(e.getEmail_Contacto());
        
        if (mather.find() == true) {
        if (esVacio()) {
            NodoEmpresa nuevo = new NodoEmpresa();
            nuevo.empresa = e;
            nuevo.der = new ABBEmpresa();
            nuevo.izq= new ABBEmpresa();
            raiz = nuevo;
        }
        else {
            if (e.getNombre().compareTo(raiz.empresa.getNombre()) == 0)
            {
                r = new Retorno(Resultado.ERROR_2);
            }
            if (e.getNombre().compareTo(raiz.empresa.getNombre()) > 0) {
                raiz.der.insertar(e);
            }
            if (e.getNombre().compareTo(raiz.empresa.getNombre()) < 0){
                raiz.izq.insertar(e);
            }
        }
        }
        else
        {
           r = new Retorno(Resultado.ERROR_1) ;
        }
        
        return r;
    }
    public Empresa buscarEmpresa(String nombre){
        Empresa buscada = null;
        if (!esVacio()) {
            if (nombre.equals(raiz.empresa.getNombre())) {
            return this.raiz.empresa;
            }
            else {
                if (nombre.compareTo(raiz.empresa.getNombre()) < 0) {
                    buscada = raiz.izq.buscarEmpresa(nombre);
                }
                else {
                    buscada = raiz.der.buscarEmpresa(nombre);
                }
            }
        }
        return buscada;
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    
    public Retorno listadoEmpresas()
    {
        String empresas = "";
        if(!this.esVacio()){
            this.raiz.der.listadoEmpresas();
            Empresas.add(this.raiz.empresa.getNombre() + ";" + this.raiz.empresa.getEmail_Contacto()+ "|");
            this.raiz.izq.listadoEmpresas();
        }
        
        for(String e : Empresas)
        {
           empresas = empresas + e; 
        }
        
        return new Retorno(empresas);
    }
  
}
