import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class todosLosMenus {

    static String dniIntro; //Lo necesitamos en distintas funciones

    public static void menuInicial() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean stayMenu = true;
        upmBankAscii.logo();

        while (stayMenu) {
            /*  Usamos una String y comprobamos que sea un número, si no lo es salta un
                error. Esto evita que el programa se detenga al introducir texto en un nextInt() .
             */

            System.out.print("\nIntroduzca la operación que desea realizar:\n\t1)Darse de alta\n\t2)Crear cuenta\n\t0)Salir\n\n");
            String opcion = scan.nextLine();
            try {
                int numero = Integer.parseInt(opcion);
                if (numero == 1) {
                    stayMenu = false;
                    darseDeAlta();
                }
                if (numero == 2)
                    crearCuentaBancaria();
                stayMenu = false;

                if (numero == 0) {
                    stayMenu = false;
                }
            } catch(Exception e){
                System.out.println("Carácter inválido");
            }
        }
    }


    public static void darseDeAlta() throws IOException {

        upmBankAscii.logo();

        boolean dniCorrecto = false;
        boolean correoCorrecto = false;
        boolean fechaCorrecta = false;

        String nombre, dni, correo, primerApellido, segundoApellido, mes, dia, anio;

        Scanner scan = new Scanner(System.in);

        System.out.println("Nombre: ");
        nombre = scan.nextLine();

        System.out.println("Primer apellido: ");
        primerApellido = scan.nextLine();

        System.out.println("Segundo apellido: ");
        segundoApellido = scan.nextLine();

        System.out.println("DNI: ");
        do {
            dni = scan.nextLine();
            if (new validarDNI().validarNumero(dni) && new validarDNI().validarLetra(dni)) {
                dniCorrecto = true;
                //Tienen que devolver true los dos metodos de la clase validar DNI
            } else {
                System.out.println("DNI incorrecto. Intente de nuevo por favor.");
            }
        } while (!dniCorrecto);

        System.out.println("Correo electrónico: ");
        do {
            correo = scan.nextLine();
            if (correo.endsWith("@alumnos.upm.es") || correo.endsWith("@upm.es")) {
                correoCorrecto = true;
            } else {
                System.out.println("Correo incorrecto. Intente de nuevo.");
            }
        } while (!correoCorrecto);

        System.out.println("Introduzca su fecha de nacimiento en formato dd/mm/aaaa");
        do {
            System.out.println("Dia: ");
            dia = scan.nextLine();

            System.out.println("Mes: ");
            mes = scan.nextLine();

            System.out.println("Año: ");
            anio = scan.nextLine();

            if (validarFecha.validar(dia, mes, anio)) {
                fechaCorrecta = true;
            }
        } while (!fechaCorrecta);

        menuInicial();
    }

    public static void crearCuentaBancaria() {

        Scanner scan = new Scanner(System.in);
        upmBankAscii.logo();
        boolean cuentaCorriente, cuentaAhorro, cuentaRemunerada = false;
        boolean menuCuenta = true;
        while(menuCuenta) {
            String nombre, primerApellido, segundoApellido, nombreCompleto;
            System.out.println("Escriba su nombre");
            nombre = scan.nextLine() + " ";
            System.out.println("Escriba su primer apellido");
            primerApellido = scan.nextLine() + " ";
            System.out.println("Escriba su segundo apellido");
            segundoApellido = scan.nextLine() + " ";
            nombreCompleto = nombre + primerApellido + segundoApellido;
            System.out.println("Elija su tipo de cuenta: \n1) Corriente\n2) Ahorro\n3) Remunerada");
            int opcion = scan.nextInt();
            try {
                if (opcion == 1){
                    cuentaCorriente = true;
                    scan.close();
                }else if(opcion == 2){
                    cuentaAhorro = true;
                    scan.close();
                }else if(opcion == 3){
                    cuentaRemunerada = true;
                    scan.close();
                }
            }catch(Exception e){
                System.out.println("Carácter inválido");
        }

            System.out.println(nombreCompleto);
            if(cuentaAhorro = true){ System.out.println("Cuenta de ahorro");}
            else if(cuentaRemunerada = true){ System.out.println("Cuenta remunerada");}
            else if(cuentaCorriente = true){ System.out.println("Cuenta corriente");}
            numeroCuenta numeroCuenta = new numeroCuenta();
            menuCuenta = false;

        }
    }
}
