
package obligatoriodatacenter;

public class ObligatorioDataCenter {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        System.out.println(s.inicializarSistema(4).resultado);
        System.out.println(s.registrarEmpresa("Juju","B9","pepe","juncho@gmail.com","Celeste").resultado);
        System.out.println(s.registrarEmpresa("Juju2","B9","pepe","juncho@gmail.com","Celeste").resultado);
        System.out.println(s.registrarEmpresa("Ju","B9","pepe","juncho@gmail.com","Celeste").resultado);
        System.out.println(s.registrarCiudad("Maldonado", 12032.3133, 12323.456346).resultado);
        System.out.println(s.registrarCiudad("Maldonado", 46.3133, 12323.456346).resultado);
        System.out.println(s.registrarDC("LPM", 46.3133, 1232423.456346, "Juju",23, 43).resultado);
       // System.out.println(s.eliminarPunto(12032.3133, 12323.456346).resultado);
        System.out.println(s.listadoEmpresas().valorString);
        System.out.println(s.destruirSistema().resultado);
    }
    
}
