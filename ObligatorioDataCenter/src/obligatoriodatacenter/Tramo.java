
package obligatoriodatacenter;

public class Tramo {
    private Punto origen;
    private Punto destino;
    int peso;

    public Punto getOrigen() {
        return origen;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public Punto getDestino() {
        return destino;
    }

    public void setDestino(Punto destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
   public Tramo(Punto pOrigen,Punto pDestino,int pPeso)
   {
       this.setOrigen(pOrigen);
       this.setDestino(pDestino);
       this.setPeso(pPeso);
   }
}
