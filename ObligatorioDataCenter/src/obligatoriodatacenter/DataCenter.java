
package obligatoriodatacenter;

public class DataCenter extends Punto{
  private String Nombre;
  private String Empresa;
  private int capacidadCPUenHoras;
  private int costoCPUporHora;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public int getCapacidadCPUenHoras() {
        return capacidadCPUenHoras;
    }

    public void setCapacidadCPUenHoras(int capacidadCPUenHoras) {
        this.capacidadCPUenHoras = capacidadCPUenHoras;
    }

    public int getCostoCPUporHora() {
        return costoCPUporHora;
    }

    public void setCostoCPUporHora(int costoCPUporHora) {
        this.costoCPUporHora = costoCPUporHora;
    }
 
  
  
    public DataCenter(String pNombre,String pEmpresa,int pCapacidadCPUenHoras,int pCostoCPUporHora,String pColor,double pCoordX,double pCoordY)
    {
        super(pCoordX,pCoordY);
        this.setNombre(pNombre);
        this.setEmpresa(pEmpresa);
        this.setCapacidadCPUenHoras(pCapacidadCPUenHoras);
        this.setCostoCPUporHora(pCostoCPUporHora);
        
    }
}
