import java.util.Scanner;

public class TipoCuenta {
    String tipoCuenta;

    public TipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }



    public static String tipoCuenta() {
        boolean menuOpcion = true;
        Scanner scan = new Scanner(System.in);
        String tipoCuenta = "";
        while (menuOpcion) {
            System.out.println("Elija su tipo de cuenta: \n1) Corriente\n2) Ahorro\n3) Remunerada");
            String opcion = scan.nextLine();
            if (opcion.equals("1")) {
                menuOpcion = false;
                tipoCuenta = "Cuenta corriente";
            } else if (opcion.equals("2")) {
                menuOpcion = false;
                tipoCuenta = "Cuenta de ahorro";
            } else if (opcion.equals("3")) {
                menuOpcion = false;
                tipoCuenta = "Cuenta remunerada";
            } else {
                System.out.println("Opción inválida");
            }
        }
        return tipoCuenta;
    }
}
