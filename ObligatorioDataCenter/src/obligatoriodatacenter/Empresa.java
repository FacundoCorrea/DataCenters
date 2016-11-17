package obligatoriodatacenter;


public class Empresa {
private String Nombre;
private String Direccion;
private String Pais;
private String Email_Contacto; 
private String Color;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEmail_Contacto() {
        return Email_Contacto;
    }

    public void setEmail_Contacto(String Email_Contacto) {
        this.Email_Contacto = Email_Contacto;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

public Empresa(String pNombre,String pDireccion,String pPais,String pEmail_Contacto,String pColor)
{
    this.setNombre(pNombre);
    this.setDireccion(pDireccion);
    this.setPais(pPais);
    this.setEmail_Contacto(pEmail_Contacto);
    this.setColor(pColor);
}
        
}
