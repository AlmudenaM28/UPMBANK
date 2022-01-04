import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class UPMBank {
    static Cliente[] clientes = new Cliente[20];
    static ListaClientes listaClientes = new ListaClientes(clientes, 0);

    public static void menuInicial() {
        Scanner scan = new Scanner(System.in);
        boolean stayMenu = true;
        upmBankAscii.logo();


        while (stayMenu) {
            try {
                System.out.print("Introduzca la operación que desea realizar:\n\t1)Darse de alta\n\t2)Crear cuenta\n\t3)Realizar depósito\n\t4)Realizar extracción\n\t5)Datos de cliente\n\t6)Hacer transferecia\n\t7)Pedir préstamo hipotecario\n\t8)Consultar tabla de amortización\n\t0)Salir\n");
                int opcion = scan.nextInt();
                if (opcion == 1) {
                    stayMenu = false;
                    darseDeAlta();
                } else if (opcion == 2) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("Introduzca su DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        Cliente clienteBuscado = listaClientes.getCliente(dni);
                        if (clienteBuscado != null) {
                            if (clienteBuscado.getCuentas().numCuentas < 10) {
                                crearCuenta(clienteBuscado);
                                stayMenu = false;
                            } else {
                                System.out.println("No puedes crear más cuentas.");
                                menuInicial();
                            }
                        } else {
                            System.out.println("Cliente no encontrado");
                            menuInicial();
                        }
                        stayMenu = false;
                    } else {
                        System.out.println("Debe darse de alta.");
                    }
                } else if (opcion == 3) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("Introduzca su DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        Cliente clienteBuscado = listaClientes.getCliente(dni);
                        if (clienteBuscado != null) {
                            if (clienteBuscado.getCuentas().numCuentas > 0) {
                                realizarDeposito(clienteBuscado);
                            }else{
                                System.out.println("Debe crear una cuenta primero");
                                menuInicial();
                            }
                        } else {
                            System.out.println("Cliente no encontrado");
                            menuInicial();
                        }
                        stayMenu = false;
                    } else {
                        System.out.println("Debe darse de alta.");
                        menuInicial();
                    }
                } else if (opcion == 4) {
                    if (true) {
                        //realizarExtraccion();
                        stayMenu = false;
                    } else if (true) {
                        System.out.println("Fondos insuficientes.");
                        //menuInicial(cliente);
                    } else {
                        System.out.println("Primero crearse una cuenta.");
                    }
                } else if (opcion == 5) {
                    System.out.println("Introduzca su DNI: ");
                    scan.nextLine();
                    String dni = scan.nextLine();
                    Cliente clienteBuscado = listaClientes.getCliente(dni);
                    if (clienteBuscado != null) {
                        consultaDatos(listaClientes.getCliente(dni));
                        stayMenu = false;
                    } else {
                        System.out.println("Cliente no encontrado");
                    }
                }
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                scan.nextLine();
            }
        }
    }


    public static void darseDeAlta() {
        upmBankAscii.logo();
        Fecha fechaNacimiento;
        boolean dniRepetido = false;
        String nombre, primerApellido, segundoApellido, correo, apellidos, dni;
        Scanner scan = new Scanner(System.in);

        System.out.println("Darse de alta\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (!volver.equals("0")) {
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
            int i = 0;
            try {
                while (i < listaClientes.getClientes().length && !dniRepetido) {
                    if (listaClientes.getClientes()[i].getDni().equals(dni)) {
                        dniRepetido = true;
                    }
                    i++;
                }
            }catch (Exception ignored){}

            if (!dniRepetido) {
                Cuenta[] cuentas = new Cuenta[10];
                ListaCuentas listaCuentas = new ListaCuentas(cuentas, 0);
                listaClientes.getClientes()[listaClientes.numClientes] = (new Cliente(nombre, apellidos, correo, dni, fechaNacimiento, listaCuentas));
                listaClientes.numClientes++;
            }else{
                System.out.println("\nYa existe un cliente con el DNI " + dni);
                System.out.println("Pulse ENTER para continuar o '0' para volver.");
                scan.nextLine();
                scan.nextLine();
            }
        }
        menuInicial();
    }

    public static void crearCuenta(Cliente cliente) throws Exception {
        Scanner scan = new Scanner(System.in);
        upmBankAscii.logo();
        System.out.println("Crear cuenta\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (!volver.equals("0")) {
            TipoCuenta tipoCuenta = Cuenta.setTipoCuenta();
            long numeroCuenta = NC.obtenerNC();
            int codigoSucursal = Main.CS;
            int codigoEntidad = 9010;
            int DC = digitoControl.obtenerDC(numeroCuenta, codigoSucursal, codigoEntidad);
            String IBAN = (Integer.toString(codigoEntidad) + 0 + codigoSucursal + DC + numeroCuenta);
            ListaMovimientos movimientos = new ListaMovimientos();
            cliente.getCuentas().getListaCuentas()[cliente.getCuentas().numCuentas] = new Cuenta(codigoSucursal, DC, numeroCuenta, cliente, IBAN, tipoCuenta, movimientos);
            cliente.getCuentas().numCuentas++;
        }
        menuInicial();
    }

    public static void realizarDeposito(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar depósito\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        int cuentaElegida = 0;
        boolean menuPrincipal = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            boolean menuDeposito = true;
            while (menuDeposito){
                try {
                    System.out.println("Escoja la cuenta a la que desea realizar el depósito: ");
                    cliente.getCuentas().imprimir();
                    cuentaElegida = scan.nextInt() - 1;
                    boolean cifraCorrecta = false;
                    while (!cifraCorrecta) {
                        System.out.println("Escriba la cantidad que desea depositar: ");
                        double ingreso = scan.nextDouble();
                        if (ingreso > 0){
                            System.out.println("Ingreso realizado correctamente.");
                            cliente.getCuentas().cuentas[cuentaElegida].getMovimientos().anadirMovimiento(new Movimiento(ingreso, TipoMovimiento.Ingreso));
                            cliente.getCuentas().cuentas[cuentaElegida].saldo += ingreso;
                            menuInicial();
                        }
                    }
                }catch(Exception e){
                    System.out.println("Número inválido. Intente de nuevo.");
                }
            }
        }
    }

    public static void realizarExtraccion(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar depósito\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        int cuentaElegida = 0;
        boolean menuPrincipal = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            boolean menuDeposito = true;
            while (menuDeposito){
                try {
                    System.out.println("Escoja la cuenta a la que desea realizar el depósito: ");
                    cliente.getCuentas().imprimir();
                    cuentaElegida = scan.nextInt() - 1;
                    boolean cifraCorrecta = false;
                    while (!cifraCorrecta) {
                        System.out.println("Escriba la cantidad que desea depositar: ");
                        double ingreso = scan.nextDouble();
                        if (ingreso > 0){
                            System.out.println("Ingreso realizado correctamente.");
                            cliente.getCuentas().cuentas[cuentaElegida].getMovimientos().anadirMovimiento(new Movimiento(ingreso, TipoMovimiento.Ingreso));
                            cliente.getCuentas().cuentas[cuentaElegida].saldo += ingreso;
                        }
                    }
                }catch(Exception e){
                    System.out.println("Número inválido. Intente de nuevo.");
                }
            }
        }
    }





    public static int codigoSucursal() throws Exception {
        upmBankAscii.logo();
        boolean menuActivo = true;
        Scanner scan = new Scanner(System.in);
        BufferedReader lector = new BufferedReader(new FileReader("sucursales.txt"));
        String linea = lector.readLine();
        int[] codigos = new int[4];
        int cs = 0;
        for (int i = 0; i < 4; i++) {
            codigos[i] = Integer.parseInt(linea.split("=")[1]);
            linea = lector.readLine();
        }
        int opcion;
        while (menuActivo) {
            try {
                System.out.println("Elija el campus en el que se encuentre: \n1. Campus sur\n2. Campus Ciudad Universitaria\n3. Campus Madrid Ciudad\n4. Campus Montegancedo");
                opcion = scan.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    cs = codigos[opcion - 1];
                    menuActivo = false;
                } else {
                    System.out.println("Input inválido");
                }
            } catch (Exception e) {
                System.out.println("Input inválido");
                scan.nextLine();
            }
        }

        return cs;
    }

    public static void consultaDatos(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Consultar datos de cliente\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menu = true;
        if (!volver.equals("0")) {
            cliente.imprimir();
            System.out.println("Cuentas bancarias: ");
            try {
                for (int i = 0; i < cliente.getCuentas().numCuentas; i++) {
                    System.out.println("\t" + cliente.getCuentas().getListaCuentas()[i].getIBAN() + " " + cliente.getCuentas().getListaCuentas()[i].tipoCuenta + "  " + cliente.getCuentas().getListaCuentas()[i].saldo + "" );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (menu) {
                System.out.println("\n1)Ver transacciones\n2)Salir");
                String opcion = scan.nextLine();
                if (opcion.equals("1")) {
                    //System.out.println(transacciones);
                    System.out.println("\n Pulse ENTER para continuar");
                    scan.nextLine();
                    scan.nextLine();
                    menu = false;
                    menuInicial();
                } else if (opcion.equals("2")) {
                    menu = false;
                    menuInicial();
                } else {
                    System.out.println("Opción inválida");
                }
            }
        } else {
            menuInicial();
        }
    }

    public static String generarDNI(Scanner scan) {
        boolean dniCorrecto = false;
        String dni;
        System.out.println("DNI: ");
        do {
            dni = scan.nextLine();
            if (new validarDNI().validarNumero(dni) && new validarDNI().validarLetra(dni)) {
                dniCorrecto = true;
            } else {
                System.out.println("DNI incorrecto. Intente de nuevo por favor.");
            }
        } while (!dniCorrecto);
        return dni;
    }

    public static boolean correoCorrecto(String correo) {

        boolean terminacionCorrecta;
        boolean numeroCamposCorrecto;
        boolean digitoLetraCorrecto = true;
        boolean longitudCorrecta;
        String[] correoAlfaNumerico = correo.split("@");

        terminacionCorrecta = correo.endsWith("@alumnos.upm.es") || correo.endsWith("@upm.es");
        longitudCorrecta = correoAlfaNumerico[0].length() > 0;
        numeroCamposCorrecto = correoAlfaNumerico.length == 2;


        int i = 0;
        while (i < correoAlfaNumerico[0].length() && digitoLetraCorrecto) {
            digitoLetraCorrecto = Character.isLetter(correoAlfaNumerico[0].charAt(i)) || Character.isDigit(correoAlfaNumerico[0].charAt(i));
            i++;
        }

        return (terminacionCorrecta && numeroCamposCorrecto && digitoLetraCorrecto && longitudCorrecta);
    }

    public static String generarCorreo(Scanner scan) {
        boolean correoCorrecto = false;
        String correo = "";
        do {
            System.out.println("Correo electrónico: ");
            correo = scan.nextLine();
            correoCorrecto = correoCorrecto(correo);

        } while (!correoCorrecto);

        return correo;
    }

    public static Fecha generarFechaNacimiento(Scanner scan) {
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
