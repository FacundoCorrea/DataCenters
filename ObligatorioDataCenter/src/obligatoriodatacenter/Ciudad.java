
package obligatoriodatacenter;

public class Ciudad  extends Punto{
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Ciudad(String pNombre,String pColor,double pCoordX,double pCoordY)
    {
        super(pCoordX,pCoordY);
        this.setNombre(pNombre);
    }
    
}
