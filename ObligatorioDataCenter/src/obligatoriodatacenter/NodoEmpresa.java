
package obligatoriodatacenter;


public class NodoEmpresa {
    Empresa empresa;
    ABBEmpresa izq;
    ABBEmpresa der;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ABBEmpresa getIzq() {
        return izq;
    }

    public void setIzq(ABBEmpresa izq) {
        this.izq = izq;
    }

    public ABBEmpresa getDer() {
        return der;
    }

    public void setDer(ABBEmpresa der) {
        this.der = der;
    }
    
    public NodoEmpresa(Empresa pEmpresa,ABBEmpresa pIzq,ABBEmpresa pDer)
    {
        this.setEmpresa(pEmpresa);
        this.setDer(pDer);
        this.setIzq(pIzq);
    }
    
    public NodoEmpresa()
    {}
}
