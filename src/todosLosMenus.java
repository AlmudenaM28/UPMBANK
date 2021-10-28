import java.time.LocalDate;
import java.util.Scanner;

public class todosLosMenus {

    static double saldo = 0;
    static String transacciones = "\n";
    static String datosCliente = "\n";
    static boolean dadoAlta = false;
    static boolean cuentaCreada = false;
    static LocalDate fecha = LocalDate.now();
    static int contadorOperaciones = 1;
    static String CS = "0201";
    static String CE = "9010";
    static long numCuenta = 0;
    static int DC = 0;
    static String IBAN = "";

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
                    \t6)Hacer transferecia  
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
                if (cuentaCreada && saldo != 0) {
                    realizarExtraccion();
                    stayMenu = false;
                } else if (saldo == 0) {
                    System.out.println("Fondos insuficientes.");
                    menuInicial();
                } else {
                    System.out.println("Primero crearse una cuenta.");
                }
            } else if (opcion.equals("5")) {
                if (dadoAlta) {
                    consultaDatos();
                    stayMenu = false;
                } else {
                    System.out.println("Debe darse de alta.");
                }
            } else if (opcion.equals("6")) {
                if (cuentaCreada && saldo != 0) {
                    hacerTransferencia();
                    stayMenu = false;
                } else if (saldo == 0) {
                    System.out.println("Fondos insuficientes.");
                    menuInicial();
                } else {
                    System.out.println("Primero crearse una cuenta.");
                }
            } else if (opcion.equals("7")) {
                if (cuentaCreada) {
                    prestamoHipotecario();
                } else {
                    System.out.println("Primero debe crear una cuenta.");
                    menuInicial();
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

            numCuenta = NC.obtenerNC();
            DC = digitoControl.obtenerDC(Long.toString(numCuenta), CS, CE );
            IBAN = (CE + " " + CS +  " " + DC + " " + numCuenta);
            System.out.println(nombreCompleto);
            if (cuentaAhorro) {
                datosCliente += (IBAN + " Cuenta ahorro\t");
                System.out.println("Cuenta de ahorro");
            } else if (cuentaRemunerada) {
                datosCliente += (IBAN + " Cuenta remunerada\t");
                System.out.println("Cuenta remunerada");
            } else {
                datosCliente += (IBAN + " Cuenta corriente\t");
                System.out.println("Cuenta corriente");
            }
            System.out.println("Número de cuenta: " + IBAN);
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
        boolean menuPrincipal = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            while (menuPrincipal) {
                    System.out.println("Escriba la cantidad de dinero que desea transferir: ");
                    try {
                        String ingreso = scan.nextLine();
                        double ingresoNum = Double.parseDouble(ingreso);
                        if (ingresoNum > 0) {
                            saldo += ingresoNum;
                            System.out.println("Ingreso realizado con éxito.");
                            System.out.println("[" + IBAN + "] Saldo de la cuenta: " + saldo + "€");
                            transacciones += ("\nDepósito\t\t[" + IBAN + "]\t" + contadorOperaciones + ".\t+" + ingresoNum + "€ " + "Saldo: " + saldo + "€\t" + fecha);
                            contadorOperaciones++;
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


    public static void realizarExtraccion() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar extracción\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menuPrincipal = true;
        if (volver.equals("0")) {
            menuInicial();
        } else {
            while (menuPrincipal) {
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
                                System.out.println("[" + IBAN + "] Saldo de la cuenta: " + saldo + "€");
                                transacciones += ("\nExtracción\t\t[" + IBAN + "]\t" + contadorOperaciones + ".\t-" + extrNum + "€ " + "Saldo: " + saldo + "€\t" + fecha);
                                contadorOperaciones++;
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


    public static void consultaDatos() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Consultar datos de cliente\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menu = true;
        if (!volver.equals("0")) {
            System.out.println(datosCliente + saldo + "€");
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

    public static void hacerTransferencia() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hacer una transferencia\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        boolean menu = true;
        if (!volver.equals("0")) {
            while (menu) {
                System.out.println("Cuenta de origen: " + IBAN + "\nPor favor introduzca el IBAN del destinatario: ");
                String numeroDestino = scan.nextLine();
                if (!numeroDestino.startsWith("9010")) {
                    System.out.println("Solo se pueden realizar transferencias a cuentas de UPMBank");
                } else if (numeroDestino.replace(" ","").length() != 20) {
                    System.out.println("Número de cuenta inválido");
                } else if (numeroDestino.equals(IBAN)) {
                    System.out.println("No puede hacerse una trasferencia a si mismo.");
                } else {
                    boolean menuTransferencia = true;
                    while (menuTransferencia) {
                        try {
                            System.out.println("Ingrese la cantidad de dinero que desea transferir: ");
                            double transferencia = scan.nextDouble();
                            if (transferencia < 0) {
                                System.out.println("Cifra inválida intente de nuevo");
                            } else if (transferencia > saldo) {
                                System.out.println("Fondos insuficientes.");
                            } else {
                                saldo -= transferencia;
                                transacciones += ("\nTransferencia\t[" + IBAN + "]\t" + contadorOperaciones + ".\t-" + transferencia + "€ " + "Saldo: " + saldo + "€\t" + fecha + "\tDestino: [" + numeroDestino + "]");
                                contadorOperaciones++;
                                System.out.println("Pulse ENTER para continuar");
                                scan.nextLine();
                                menuTransferencia = false;
                                menu = false;
                                menuInicial();
                            }
                        } catch (Exception e) {
                            System.out.println("Error, intente de nuevo.");
                            hacerTransferencia();
                        }
                    }
                }
            }
        }
    }

    public static void prestamoHipotecario() {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Pedir un préstamo hipotecario\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (!volver.equals("0")) {


        }
    }
}

