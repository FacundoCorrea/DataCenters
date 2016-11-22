
package obligatoriodatacenter;

public class ObligatorioDataCenter {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        System.out.println(s.inicializarSistema(4).resultado);
        System.out.println(s.registrarEmpresa("Juju","B9","pepe","juncho@gmail.com","Celeste").resultado);
        System.out.println(s.registrarCiudad("Maldonado", 12032.3133, 12323.456346).resultado);
        System.out.println(s.registrarDC("LPM", 12313.1231, 25214.542353, "Movistar", 23, 43).resultado);
        System.out.println(s.PUTAEMPRESA().getNombre());
    }
    
}
