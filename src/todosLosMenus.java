import java.util.Scanner;

public class todosLosMenus {

    static double saldo = 0;
    static String numero;
    static String transacciones = "\n";
    static String datosCliente = "\n";
    static boolean dadoAlta = false;
    static boolean cuentaCreada = false;

    public static void menuInicial() {
        Scanner scan = new Scanner(System.in);
        boolean stayMenu = true;
        upmBankAscii.logo();

        while (stayMenu) {
            /*  Usamos una String y comprobamos que sea un número, si no lo es salta un
                error. Esto evita que el programa se detenga al introducir texto en un nextInt() .
             */

            System.out.print("""

                    Introduzca la operación que desea realizar:
                    \t1)Darse de alta
                    \t2)Crear cuenta
                    \t3)Realizar depósito
                    \t4)Realizar extracción
                    \t5)Datos de cliente
                    \t0)Salir

                    """);
            String opcion = scan.nextLine();
            if (opcion.equals("1")) {
                stayMenu = false;
                darseDeAlta();
            } else if (opcion.equals("2")) {
                if (dadoAlta) {
                    crearCuentaBancaria();
                    stayMenu = false;
                } else {
                    System.out.println("Debe darse de alta.");
                }
            } else if (opcion.equals("3")) {
                if (cuentaCreada) {
                    realizarDeposito();
                    stayMenu = false;
                } else {
                    System.out.println("Primero debe crear una cuenta");
                }
            } else if (opcion.equals("4")) {
                if (cuentaCreada) {
                    realizarExtraccion();
                    stayMenu = false;
                } else {
                    System.out.println("Primero debe crear una cuenta");
                }
            } else if (opcion.equals("5")) {
                if (dadoAlta) {
                    consultaDatos();
                    stayMenu = false;
                } else {
                    System.out.println("Debe darse de alta.");
                }
            } else if (opcion.equals("0")) {
                stayMenu = false;
            } else {
                System.out.println("Opción inválida");
            }
        }
    }


    public static void darseDeAlta() {

        upmBankAscii.logo();

        boolean dniCorrecto = false;
        boolean correoCorrecto = false;
        boolean fechaCorrecta = false;

        String nombre, dni = null, correo = null, primerApellido, segundoApellido, mes, dia, anio, nombreCompleto = null,
                fechaFinal = null;

        Scanner scan = new Scanner(System.in);

        System.out.println("Darse de alta\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (volver.equals("0")) {
            menuInicial();
        } else {

            System.out.println("Nombre: ");
            nombre = scan.nextLine();

            System.out.println("Primer apellido: ");
            primerApellido = scan.nextLine();

            System.out.println("Segundo apellido: ");
            segundoApellido = scan.nextLine();

            nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;

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

                fechaFinal = dia + "/" + mes + "/" + anio;

                if (validarFecha.validar(dia, mes, anio)) {
                    fechaCorrecta = true;
                    dadoAlta = true;
                }

            } while (!fechaCorrecta);
        }

        datosCliente += ("\n" + nombreCompleto + "\n" + dni + "\n" + correo + "\n" + fechaFinal + "\nCuentas: \n\t");
        menuInicial();
    }

    public static void crearCuentaBancaria() {
        Scanner scan = new Scanner(System.in);
        upmBankAscii.logo();
        System.out.println("Crear cuenta\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (!volver.equals("0")) {

            boolean cuentaAhorro = false, cuentaRemunerada = false, menuCuenta = true, menuOpcion = true;
            String nombre, primerApellido, segundoApellido, nombreCompleto = null;
            while (menuCuenta) {
                System.out.println("Escriba su nombre");
                nombre = scan.nextLine() + " ";
                System.out.println("Escriba su primer apellido");
                primerApellido = scan.nextLine() + " ";
                System.out.println("Escriba su segundo apellido");
                segundoApellido = scan.nextLine() + " ";
                nombreCompleto = nombre + primerApellido + segundoApellido;
                while (menuOpcion) {
                    System.out.println("Elija su tipo de cuenta: \n1) Corriente\n2) Ahorro\n3) Remunerada");
                    String opcion = scan.nextLine();
                    if (opcion.equals("1")) {
                        menuCuenta = false;
                        menuOpcion = false;
                    } else if (opcion.equals("2")) {
                        cuentaAhorro = true;
                        menuCuenta = false;
                        menuOpcion = false;
                    } else if (opcion.equals("3")) {
                        cuentaRemunerada = true;
                        menuCuenta = false;
                        menuOpcion = false;
                    } else {
                        System.out.println("Opción inválida");
                    }
                }

                cuentaCreada = true;

            }

            numero = new numeroCuenta().obtenerNumeroCuenta();
            System.out.println(nombreCompleto);
            if (cuentaAhorro) {
                datosCliente += (numero + " Cuenta ahorro\t");
                System.out.println("Cuenta de ahorro");
            } else if (cuentaRemunerada) {
                datosCliente += (numero + " Cuenta remunerada\t");
                System.out.println("Cuenta remunerada");
            } else {
                datosCliente += (numero + " Cuenta corriente\t");
                System.out.println("Cuenta corriente");
            }
            System.out.println("Número de cuenta: " + numero);
            System.out.println("Saldo: " + saldo + "€");
            System.out.println("Pulse ENTER para continuar");
            scan.nextLine();
        }
        menuInicial();
    }


    public static void realizarDeposito() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar depósito\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menuPrincipal = true, menuIngreso = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            while (menuPrincipal) {
                System.out.println("Escriba la cuenta a la que desea realizar un depósito: ");
                String cuentaObjetivo = scan.nextLine();
                if (cuentaObjetivo.equals(numero)) {
                    while (menuIngreso) {
                        System.out.println("Escriba la cantidad de dinero que desea transferir: ");
                        try {
                            String ingreso = scan.nextLine();
                            double ingresoNum = Double.parseDouble(ingreso);
                            if (ingresoNum > 0) {
                                saldo += ingresoNum;
                                System.out.println("Ingreso realizado con éxito.");
                                System.out.println("[" + numero + "] Saldo de la cuenta: " + saldo + "€");
                                transacciones += ("\n[" + numero + "] " + "+" + ingresoNum + "€ " + "Saldo: " + saldo + "€");
                                menuIngreso = false;
                                menuPrincipal = false;
                                System.out.println("Pulse ENTER para continuar");
                                scan.nextLine();
                                menuInicial();
                            } else {
                                System.out.println("Cifra inválida, intente de nuevo.");
                            }
                        } catch (Exception e) {
                            System.out.println("Cifra inválida, intente de nuevo.");
                        }
                    }
                }
            }
        }
    }


    public static void realizarExtraccion() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar extracción\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menuPrincipal = true, menuIngreso = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            while (menuPrincipal) {
                System.out.println("Escriba la cuenta a la que desea realizar una extracción: ");
                String cuentaObjetivo = scan.nextLine();
                if (cuentaObjetivo.equals(numero)) {
                    while (menuIngreso) {
                        System.out.println("Escriba la cantidad de dinero que desea extraer: ");
                        try { //Se usa la excepcion para que no  crashee al parsear en caso de poner una letra por ejemplo
                            String extraccion = scan.nextLine();
                            double extrNum = Double.parseDouble(extraccion);
                            if (extrNum > saldo) {
                                System.out.println("Fondos insuficientes");
                            } else {
                                if (extrNum > 0) {
                                    saldo -= extrNum;
                                    System.out.println("Extracción realizada con éxito.");
                                    System.out.println("[" + numero + "] Saldo de la cuenta: " + saldo + "€");
                                    transacciones += ("\n[" + numero + "] " + "-" + extrNum + "€ " + "Saldo: " + saldo + "€");
                                    menuIngreso = false;
                                    menuPrincipal = false;
                                    System.out.println("Pulse ENTER para continuar");
                                    scan.nextLine();
                                    menuInicial();
                                } else {
                                    System.out.println("Cifra inválida, intente de nuevo.");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Cifra inválida, intente de nuevo.");
                        }
                    }
                }
            }
        }
    }


    public static void consultaDatos() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Consultar datos de cliente\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menu = true;
        if (!volver.equals("0")) {
            System.out.println(datosCliente);
            while (menu) {
                System.out.println("\n1)Ver transacciones\n2)Salir");
                String opcion = scan.nextLine();
                if (opcion.equals("1")) {
                    System.out.println(transacciones);
                    System.out.println("\n Pulse ENTER para continuar");
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
        }
    }
}

