
package obligatoriodatacenter;

public class Punto {
private double coordX;
private double coordY;

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public Punto (double pCoordX,double pCoordY)
    {
        this.setCoordX(pCoordX);
        this.setCoordY(pCoordY);
    }
}

