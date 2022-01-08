import java.io.*;
import java.util.Scanner;


public class UPMBank {
    static Cliente[] clientes = new Cliente[20];
    static ListaClientes listaClientes = new ListaClientes(clientes, 0);
    static Cuenta[] cuentas = new Cuenta[200];
    static ListaCuentas cuentasGlobal = new ListaCuentas(cuentas);

    public static void menuInicial() {
        Scanner scan = new Scanner(System.in);
        boolean stayMenu = true;
        upmBankAscii.logo();


        while (stayMenu) {
            try {
                System.out.print("Introduzca la operación que desea realizar:\n\t1)Dar de alta\n\t2)Crear cuenta\n\t3)Realizar depósito\n\t4)Realizar extracción\n\t5)Datos de cliente\n\t6)Hacer transferecia\n\t7)Pedir préstamo hipotecario\n\t8)Consultar tabla de amortización\n\t0)Salir\n");
                int opcion = scan.nextInt();
                if (opcion == 1) {
                    darseDeAlta();
                } else if (opcion == 2) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        if (estaDadoDeAlta(dni)) {
                            crearCuenta(listaClientes.getCliente(dni));
                        } else {
                            System.out.println("Error. El cliente no tiene ninguna cuenta creada.");
                            System.out.println("Pulse ENTER para continuar.");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Ningún cliente dado de alta");
                        System.out.println("Pulse ENTER para continuar.");
                        scan.nextLine();
                        scan.nextLine();
                    }
                } else if (opcion == 3) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        if (estaDadoDeAlta(dni) && tieneCuenta(listaClientes.getCliente(dni))) {
                            realizarDeposito(listaClientes.getCliente(dni));
                        } else {
                            System.out.println("Error. Alguna de estas condiciones no se ha dado: \n1) El cliente no está dado de alta.\n2) El cliente no tiene ninguna cuenta creada.");
                            System.out.println("Pulse ENTER para continuar.");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Ningún cliente no dado de alta");
                        System.out.println("Pulse ENTER para continuar.");
                        scan.nextLine();
                        scan.nextLine();
                    }
                } else if (opcion == 4) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        if (estaDadoDeAlta(dni) && tieneCuenta(listaClientes.getCliente(dni))) {
                            realizarExtraccion(listaClientes.getCliente(dni));
                        } else {
                            System.out.println("Error. Alguna de estas condiciones no se ha dado: \n1) El cliente no está dado de alta.\n2) El cliente no tiene ninguna cuenta creada.");
                            System.out.println("Pulse ENTER para continuar.");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Ningún cliente no dado de alta");
                        System.out.println("Pulse ENTER para continuar.");
                        scan.nextLine();
                        scan.nextLine();
                    }
                } else if (opcion == 5) {
                    System.out.println("DNI: ");
                    scan.nextLine();
                    String dni = scan.nextLine();
                    if (estaDadoDeAlta(dni)) {
                        consultaDatos(listaClientes.getCliente(dni));
                    } else {
                        System.out.println("Cliente no encontrado");
                        System.out.println("Pulse ENTER para continuar.");
                        scan.nextLine();
                    }
                } else if (opcion == 6) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        if (estaDadoDeAlta(dni) && tieneCuenta(listaClientes.getCliente(dni))) {
                            hacerTransferencia(listaClientes.getCliente(dni));
                        } else {
                            System.out.println("Error. Alguna de estas condiciones no se ha dado: \n1) El cliente no está dado de alta.\n2) El cliente no tiene ninguna cuenta creada.");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Ningún cliente no dado de alta");
                    }

                }else if (opcion == 7) {
                    if (listaClientes.numClientes > 0) {
                        System.out.println("DNI: ");
                        scan.nextLine();
                        String dni = scan.nextLine();
                        if (estaDadoDeAlta(dni) && tieneCuenta(listaClientes.getCliente(dni))) {
                            pedirPrestamo(listaClientes.getCliente(dni));
                        } else {
                            System.out.println("Error. Alguna de estas condiciones no se ha dado: \n1) El cliente no está dado de alta.\n2) El cliente no tiene ninguna cuenta creada.");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Ningún cliente no dado de alta");
                    }

                } else if (opcion == 0) {
                    stayMenu = false;
                    generarMatrizTransferencias();

                }
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                scan.nextLine();
            }
        }
    }


    public static boolean estaDadoDeAlta(String dni) {
        Cliente clienteBuscado = listaClientes.getCliente(dni);
        return clienteBuscado != null;
    }

    public static boolean tieneCuenta(Cliente cliente) {
        return cliente.getCuentas().numCuentas > 0;
    }

    public static void pedirPrestamo(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        double importe = 0;
        double interesMensual = 0;
        int anios = 0;
        int cuentaElegida;
        Cuenta cuenta;
        System.out.println("Pedir un préstamo hipotecario\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        if (!volver.equals("0")) {

            boolean menuPrestamo = true;
            while (menuPrestamo) {
                try {
                    System.out.println("Cuenta destino: ");
                    cliente.getCuentas().imprimir();
                    cuentaElegida = scan.nextInt() - 1;
                    boolean cifraCorrecta = false;
                    while (!cifraCorrecta) {
                        cuenta = cliente.getCuentas().getListaCuentas()[cuentaElegida];
                        importe = Prestamo.setImporte();
                        anios = Prestamo.setAnios();
                        interesMensual = Prestamo.setInteresMensual();
                        cuenta.saldo += importe;
                        Prestamo prestamoObj = new Prestamo(importe, anios, interesMensual);
                        cuenta.getPrestamos().anadirPrestamo(prestamoObj);
                        System.out.println("Ingreso realizado correctamente.");
                        System.out.println("Pulse ENTER para continuar o '0' para volver.");
                        scan.nextLine();
                        scan.nextLine();
                        menuPrestamo = false;
                        cifraCorrecta = true;
                    }
                } catch (Exception e) {
                    System.out.println("Número inválido.");
                    scan.nextLine();
                }
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
                    if (listaClientes.getClientes()[i].getDni().equals(dni.toUpperCase())) {
                        dniRepetido = true;
                    }
                    i++;
                }
            } catch (Exception ignored) {
            }

            if (!dniRepetido) {
                Cuenta[] cuentas = new Cuenta[10];
                ListaCuentas listaCuentas = new ListaCuentas(cuentas);
                listaClientes.getClientes()[listaClientes.numClientes] = (new Cliente(nombre, apellidos, correo, dni.toUpperCase(), fechaNacimiento, listaCuentas));
                listaClientes.numClientes++;
                System.out.println("Cliente creado correctamente.");

            } else {
                System.out.println("\nYa existe un cliente con el DNI " + dni.toUpperCase());
            }
        }
        System.out.println("Pulse ENTER para continuar.");
        scan.nextLine();
        scan.nextLine();
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
            Movimiento[] movimientos = new Movimiento[50];
            ListaMovimientos listaMovimientos = new ListaMovimientos(movimientos);
            Prestamo[] prestamos = new Prestamo[ListaPrestamos.getMaxPrestamos()];
            ListaPrestamos listaPrestamos = new ListaPrestamos(prestamos);
            Transferencia[] transferenciasEmitidas = new Transferencia[ListaTrasferencias.getMaxTransferencias()];
            ListaTrasferencias listaTrasferenciasEmitidas = new ListaTrasferencias(transferenciasEmitidas);
            Transferencia[] transferenciasRecibidas = new Transferencia[ListaTrasferencias.getMaxTransferencias()];
            ListaTrasferencias listaTrasferenciasRecibidas = new ListaTrasferencias(transferenciasRecibidas);
            Cuenta cuentaCreada = new Cuenta(codigoSucursal, DC, numeroCuenta, cliente, IBAN, tipoCuenta, listaMovimientos, listaPrestamos, listaTrasferenciasEmitidas, listaTrasferenciasRecibidas);
            cliente.getCuentas().getListaCuentas()[cliente.getCuentas().numCuentas] = cuentaCreada;
            cliente.getCuentas().numCuentas++;
            cuentasGlobal.getListaCuentas()[cuentasGlobal.numCuentas] = cuentaCreada;
            cuentasGlobal.numCuentas++;
        }
        System.out.println("Cuenta creada correctamente");
        System.out.println("Pulse ENTER para continuar.");
        scan.nextLine();
    }

    public static void hacerTransferencia(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar transferencia\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        int cuentaElegida = 11;
        if (!volver.equals("0")) {
            boolean menuTransferencia = true;
            while (menuTransferencia) {
                try {
                    while (cuentaElegida >= cliente.getCuentas().numCuentas) {
                        System.out.println("Cuenta origen: ");
                        cliente.getCuentas().imprimir();
                        cuentaElegida = scan.nextInt() - 1;
                    }
                    boolean destinoCorrecto = false;
                    while (!destinoCorrecto) {
                        System.out.println("IBAN destino: ");
                        scan.nextLine();
                        String IBANdestino = scan.nextLine();
                        int i = 0;
                        boolean cuentaEncontrada = false;
                        while (i < cuentasGlobal.numCuentas && !cuentaEncontrada) {
                            if (cuentasGlobal.getListaCuentas()[i].getIBAN().equals(IBANdestino) && !IBANdestino.equals(cliente.getCuentas().getListaCuentas()[cuentaElegida].getIBAN())) {
                                cuentaEncontrada = true;
                            }
                            i++;
                        }
                        if (cuentaEncontrada) {
                            double importe = 0;
                            boolean cancelar = false;
                            while (importe <= 0) {
                                System.out.println("Importe: ");
                                importe = scan.nextDouble();
                                if (importe > cliente.getCuentas().getListaCuentas()[cuentaElegida].saldo){
                                    System.out.println("Saldo insuficiente.\nPulse ENTER para continuar o '0' para volver al menú.");
                                    importe = 0;
                                    scan.nextLine();
                                    String volver2 = scan.nextLine();
                                    if (volver2.equals("0")) {
                                        cancelar = true;
                                        importe = 1;
                                    }
                                }
                            }
                            if (!cancelar) {
                                cliente.getCuentas().getListaCuentas()[cuentaElegida].getTransferenciasEmitidas().anadirTransferencia(new Transferencia(importe, cliente.getCuentas().getListaCuentas()[cuentaElegida], cuentasGlobal.getListaCuentas()[i - 1], TipoTransferencia.Emitida));
                                cuentasGlobal.getListaCuentas()[i - 1].getTransferenciasRecibidas().anadirTransferencia(new Transferencia(importe, cliente.getCuentas().getListaCuentas()[cuentaElegida], cuentasGlobal.getListaCuentas()[i - 1], TipoTransferencia.Recibida));
                                cuentasGlobal.getListaCuentas()[i - 1].saldo += importe;
                                cliente.getCuentas().getListaCuentas()[cuentaElegida].saldo -= importe;
                            }

                            destinoCorrecto = true;
                            menuTransferencia = false;

                        } else {
                            if (IBANdestino.equals(cliente.getCuentas().getListaCuentas()[cuentaElegida].getIBAN())){
                                System.out.println("No es posible hacer una transferencia a la misma cuenta de origen.");
                            }else {
                                System.out.println("Cuenta no encontrada. ");
                            }
                            System.out.println("\nPulse ENTER para continuar o '0' para volver al menú.");
                            String volver1 = scan.nextLine();
                            if (volver1.equals("0")) {
                                destinoCorrecto = true;
                                menuTransferencia = false;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Número inválido.");
                    scan.nextLine();
                }
            }
        }
    }

    public static void generarMatrizTransferencias() throws IOException {
        BufferedWriter escribir = new BufferedWriter(new FileWriter("matriz.txt"));
        for (int i = 0;i < cuentasGlobal.numCuentas; i++){
            escribir.write(cuentasGlobal.getListaCuentas()[i].getIBAN());
            escribir.newLine();
        }



        try {
            Double[][] matrizTransferencias = new Double[cuentasGlobal.numCuentas][cuentasGlobal.numCuentas];
            for (int j = 0; j < cuentasGlobal.numCuentas; j++) {
                Cuenta cuenta = cuentasGlobal.getListaCuentas()[j];
                escribir.newLine();
                for (int h = 0; h < cuentasGlobal.numCuentas; h++) {
                    String IBAN = cuentasGlobal.getListaCuentas()[h].getIBAN();
                    matrizTransferencias[j][h] = ListaTrasferencias.getTotalTransferenciaCuenta(IBAN, cuenta);
                    escribir.write(String.format("%10.2f",matrizTransferencias[j][h]));
                }
            }
            escribir.close();
        }catch(Exception ignored){}

    }

    public static void realizarDeposito(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar depósito\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        int cuentaElegida = 0;
        if (!volver.equals("0")) {
            boolean menuDeposito = true;
            while (menuDeposito) {
                try {
                    System.out.println("Cuenta destino: ");
                    cliente.getCuentas().imprimir();
                    cuentaElegida = scan.nextInt() - 1;
                    boolean cifraCorrecta = false;
                    while (!cifraCorrecta) {
                        System.out.println("Importe: ");
                        double ingreso = scan.nextDouble();
                        if (ingreso > 0) {
                            System.out.println("Ingreso realizado correctamente.");
                            cliente.getCuentas().getListaCuentas()[cuentaElegida].getMovimientos().anadirMovimiento(new Movimiento(ingreso, TipoMovimiento.Ingreso));
                            cliente.getCuentas().getListaCuentas()[cuentaElegida].saldo += ingreso;
                            System.out.println("Pulse ENTER para continuar o '0' para volver.");
                            scan.nextLine();
                            scan.nextLine();
                            menuDeposito = false;
                            cifraCorrecta = true;
                        } else {
                            System.out.println("Número inválido.\\nPulse ENTER para continuar o '0' para volver al menú.");
                            String volver1 = scan.nextLine();
                            if (volver1.equals("0")) {
                                cifraCorrecta = true;
                                menuDeposito = false;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Número inválido.");
                    scan.nextLine();
                }
            }
        }
    }

    public static void realizarExtraccion(Cliente cliente) {
        upmBankAscii.logo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Realizar extracción\nPulse ENTER para continuar o '0' para volver.");
        String volver = scan.nextLine();
        int cuentaElegida = 0;
        if (!volver.equals("0")) {
            boolean menuExtraccion = true;
            while (menuExtraccion) {
                try {
                    System.out.println("Cuenta destino: ");
                    cliente.getCuentas().imprimir();
                    cuentaElegida = scan.nextInt() - 1;
                    boolean cifraCorrecta = false;
                    while (!cifraCorrecta) {
                        System.out.println("Importe: ");
                        double extraccion = scan.nextDouble();
                        if (extraccion <= cliente.getCuentas().getListaCuentas()[cuentaElegida].saldo && extraccion > 0) {
                            System.out.println("Extracción realizada correctamente.");
                            cliente.getCuentas().getListaCuentas()[cuentaElegida].getMovimientos().anadirMovimiento(new Movimiento(extraccion, TipoMovimiento.Extracción));
                            cliente.getCuentas().getListaCuentas()[cuentaElegida].saldo -= extraccion;
                            System.out.println("Pulse ENTER para continuar o '0' para volver.");
                            scan.nextLine();
                            scan.nextLine();
                            menuExtraccion = false;
                            cifraCorrecta = true;
                        } else {
                            System.out.println("Saldo insuficiente.\\nPulse ENTER para continuar o '0' para volver al menú.");
                            String volver1 = scan.nextLine();
                            if (volver1.equals("0")) {
                                cifraCorrecta = true;
                                menuExtraccion = false;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Número inválido. Intente de nuevo.");
                    scan.nextLine();
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
                System.out.println("Campus: \n1. Campus sur\n2. Campus Ciudad Universitaria\n3. Campus Madrid Ciudad\n4. Campus Montegancedo");
                opcion = scan.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    cs = codigos[opcion - 1];
                    menuActivo = false;
                } else {
                    System.out.println("Número inválido");
                }
            } catch (Exception e) {
                System.out.println("Número inválido");
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
                    System.out.println("\t" + cliente.getCuentas().getListaCuentas()[i].getIBAN() + " " + cliente.getCuentas().getListaCuentas()[i].tipoCuenta + "  " + cliente.getCuentas().getListaCuentas()[i].saldo + "€");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (menu) {
                System.out.println("\n1)Ver transacciones\n2)Salir");
                String opcion = scan.nextLine();
                if (opcion.equals("1")) {
                    for (int i = 0; i < cliente.getCuentas().numCuentas; i++) {
                        cliente.getCuentas().getListaCuentas()[i].getMovimientos().imprimir(cliente.getCuentas().getListaCuentas()[i]);
                        cliente.getCuentas().getListaCuentas()[i].getTransferenciasRecibidas().imprimir();
                        cliente.getCuentas().getListaCuentas()[i].getTransferenciasEmitidas().imprimir();
                        cliente.getCuentas().getListaCuentas()[i].getPrestamos().imprimir(cliente.getCuentas().getListaCuentas()[i]);
                    }
                    System.out.println("\n Pulse ENTER para continuar");
                    scan.nextLine();
                    menu = false;
                } else if (opcion.equals("2")) {
                    menu = false;
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
    }

    public static String generarDNI(Scanner scan) {
        boolean dniCorrecto = false;
        String dni = null;
        do {
            try {
                System.out.println("DNI: ");
                dni = scan.nextLine();
                if (new validarDNI().validarNumero(dni) && new validarDNI().validarLetra(dni)) {
                    dniCorrecto = true;
                } else {
                    System.out.println("DNI incorrecto.");
                }
            } catch (Exception e) {
                System.out.println("DNI incorrecto.");
                scan.nextLine();
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
        System.out.println("Fecha de nacimiento en formato dd/mm/aaaa");
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
