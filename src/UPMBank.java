import java.util.Scanner;

public class UPMBank {
    static Cliente[] clientes = new Cliente[20];
    static ListaClientes listaClientes = new ListaClientes(clientes, 1);
    public static void menuInicial(Cliente cliente) {
        Scanner scan = new Scanner(System.in);
        boolean stayMenu = true;
        upmBankAscii.logo();


        while (stayMenu) {
            /*  Usamos una String y comprobamos que sea un número, si no lo es salta un
                error. Esto evita que el programa se detenga al introducir texto en un nextInt() .
             */

            System.out.print("Introduzca la operación que desea realizar:\n\t1)Darse de alta\n\t2)Crear cuenta\n\t3)Realizar depósito\n\t4)Realizar extracción\n\t5)Datos de cliente\n\t6)Hacer transferecia\n\t7)Pedir préstamo hipotecario\n\t8)Consultar tabla de amortización\n\t0)Salir\n");
            String opcion = scan.nextLine();
            if (opcion.equals("1")) {
                stayMenu = false;
                darseDeAlta(cliente);
            } else if (opcion.equals("2")) {
                if (true) {
                   // crearCuentaBancaria();
                    stayMenu = false;
                } else {
                    System.out.println("Debe darse de alta.");
                }
            } else if (opcion.equals("3")) {
                if (true) {
                    //realizarDeposito();
                    stayMenu = false;
                } else {
                    System.out.println("Primero debe crear una cuenta");
                }
            } else if (opcion.equals("4")) {
                if (true) {
                    //realizarExtraccion();
                    stayMenu = false;
                } else if (true) {
                    System.out.println("Fondos insuficientes.");
                    menuInicial(cliente);
                } else {
                    System.out.println("Primero crearse una cuenta.");
                }
            } else if (opcion.equals("5")) {
                if (true) {
                    consultaDatos(cliente);
                    stayMenu = false;
                } else {
                    System.out.println("Debe darse de alta.");
                }
            }
        }
    }


    public static void darseDeAlta(Cliente cliente) {
        upmBankAscii.logo();
        Fecha fechaNacimiento;
        ListaCuentas listaCuentas;

        String nombre, primerApellido, segundoApellido, correo, apellidos, dni;
        Scanner scan = new Scanner(System.in);

        System.out.println("Darse de alta\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (volver.equals("0")) {
            menuInicial(cliente);
        } else {
            System.out.println("Nombre: ");
            nombre = scan.nextLine();

            System.out.println("Primer apellido: ");
            primerApellido = scan.nextLine();

            System.out.println("Segundo apellido: ");
            segundoApellido = scan.nextLine();

            apellidos = primerApellido + " " + segundoApellido;
            dni = generarDNI(scan);
            correo = generarCorreo(scan);
            fechaNacimiento = generarFechaNacimiento(scan);
            Cuenta[] cuentas = new Cuenta[10];
            listaCuentas = new ListaCuentas(cuentas, 0);
            cliente = new Cliente(nombre, apellidos, correo, dni, fechaNacimiento, listaCuentas);
            listaClientes.nuevoCliente(cliente);
            menuInicial(cliente);
        }
    }

    public static void consultaDatos(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Consultar datos de cliente\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menu = true;
        if (!volver.equals("0")) {
            cliente.imprimir();
            while (menu) {
                System.out.println("\n1)Ver transacciones\n2)Salir");
                String opcion = scan.nextLine();
                if (opcion.equals("1")) {
                    //System.out.println(transacciones);
                    System.out.println("\n Pulse ENTER para continuar");
                    scan.nextLine();
                    scan.nextLine();
                    menu = false;
                    menuInicial(cliente);
                } else if (opcion.equals("2")) {
                    menu = false;
                    menuInicial(cliente);
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
    }

    public static String generarDNI (Scanner scan){
        boolean dniCorrecto = false;
        String dni;
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
        return dni;
    }

    public static String generarCorreo(Scanner scan){
        String correo;
        boolean correoCorrecto = false;
        System.out.println("Correo electrónico: ");
        do {
            correo = scan.nextLine();
            if (correo.endsWith("@alumnos.upm.es") || correo.endsWith("@upm.es")) {
                correoCorrecto = true;
            } else {
                System.out.println("Correo incorrecto. Intente de nuevo.");
            }
        } while (!correoCorrecto);

        return correo;
    }

    public static Fecha generarFechaNacimiento(Scanner scan){
        int dia, mes, anio;
        boolean fechaCorrecta = false;
        Fecha fechaNacimiento = null;
        System.out.println("Introduzca su fecha de nacimiento en formato dd/mm/aaaa");
        do {
            System.out.println("Dia: ");
            dia = scan.nextInt();

            System.out.println("Mes: ");
            mes = scan.nextInt();

            System.out.println("Año: ");
            anio = scan.nextInt();


            if (Fecha.comprobarFecha(dia, mes, anio)) {
                fechaCorrecta = true;
                fechaNacimiento = new Fecha(dia, mes, anio);
            }

        } while (!fechaCorrecta);

        return fechaNacimiento;
    }
}
