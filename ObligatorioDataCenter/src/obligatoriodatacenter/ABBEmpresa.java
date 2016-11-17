
package obligatoriodatacenter;

public class ABBEmpresa {
    NodoEmpresa raiz;
    
    public void insertar ()
    {
        NodoEmpresa nuevo = new NodoEmpresa();
        if (raiz == null)
        {
            raiz = nuevo;
        }else{
            nodoABB aux = raiz;
            nodoABB ant = raiz;
            while (aux != null)
            {
                ant = aux;
                if(aux.dato < valor){
                    aux = aux.der;
                }else{
                    aux = aux.izq;
                }
            }
                if(ant.dato<valor){
                    ant.der=nuevo;
                }else{
                    aux.izq=nuevo;
                }
            }
     }
    
            
        
    public void imprimirInOrden(nodoABB a)
    {
     if(a!= null){
     imprimirInOrden(a.izq);
         System.out.println(a.dato);
     imprimirInOrden(a.der);
     }   
    }
    
    public void imprimirPreOrden(nodoABB a)
    {
        if(a!=null)
        {
            System.out.println(a.dato);
            imprimirPreOrden(a.izq);
            imprimirPreOrden(a.der);
            
        }
    }
    
    public void eliminar(int valor)
    {
        
    }
    public int cantNodos() {
        if(raiz == null)
        return 0;

        ABB hIzq = new ABB();
        hIzq.raiz = this.raiz.izq;

        ABB hDer = new ABB();
        hDer.raiz = this.raiz.der;
        return 1+hIzq.cantNodos()+hDer.cantNodos();
    }
}
