/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriodatacenter;

/**
 *
 * @author Emerson
 */
public class NodoPunto {
    Punto punto;
    NodoPunto sig;
    int peso;

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public NodoPunto getSig() {
        return sig;
    }

    public void setSig(NodoPunto sig) {
        this.sig = sig;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
