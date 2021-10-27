import java.util.Scanner;

public class Sesion3 {

    static boolean salir = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (!salir) {
            menu();
        }
        leerNúmero();

        boolean menu = true;
        while (menu) {
            System.out.println("Ingrese el numero entre 0 y 1000 que desee comprobar si es primo: ");
            int numero = scan.nextInt();
            if (numero >= 0 && numero <= 1000) {
                menu = false;
                System.out.println(esPrimo(numero));
            } else {
                System.out.println("Número inválido");
            }
        }

        boolean numeroCorrecto = false;
        while (!numeroCorrecto) {
            System.out.println("Escriba un numero entre 5 y 20: ");
            int num = scan.nextInt();
            if (num >= 5 && num <= 1000) {
                numeroCorrecto = true;
                escribePrimos(num);
            } else {
                System.out.println("El numero debe estar comprendido entre 5 y 20");
            }

        }
    }

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione la operacion que desea realizar: \n1)Comprobar si un numero es primo");
        System.out.println("2)Escribir los n numeros primos");
        System.out.println("3)Escribir la lista de los números primos gemelos comprendidos entre dos valores");
        System.out.println("4)Mostrar  todas  las  formas  posibles  de  escribir  un  número  par  como  suma  de  dos  números primos");
        System.out.println("0) Salir");
        boolean menu = true;
        String opcion = "";
        while (menu) {
            opcion = scan.nextLine();
            if (opcion.equals("1")) {
                menu = false;
            } else if (opcion.equals("2")) {
                menu = false;
            } else if (opcion.equals("3")) {
                menu = false;
            } else if (opcion.equals("4")) {
                menu = false;
            } else if (opcion.equals("0")) {
                salir = true;
                menu = false;
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        System.out.println(opcion);
        return Integer.parseInt(opcion);

    }


    public static boolean esPrimo(int num) {
        boolean numeroPrimo = num != 1;
        int i = num/2;
        while (i > 1 && numeroPrimo) {
            int resto = num % i;
            if (resto == 0) {
                numeroPrimo = false;
            }
            i--;
        }
        return numeroPrimo;
    }

    public static int leerNúmero() {
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        boolean menu2 = true;
        int numero = 0;
        while (menu) {
            System.out.println("Escribe el primer numero");
            int n1 = scan.nextInt();
            System.out.println("Escribe el segundo numero mayor que el primero");
            int n2 = scan.nextInt();
            if (n2 > n1) {
                while (menu2) {
                    System.out.println("Ingrese un número comprendido entre estos dos: ");
                    numero = scan.nextInt();
                    if (numero > n2 || numero < n1) {
                        System.out.println("El número debe estar comprendido entre " + n1 + " y " + n2);
                    } else {
                        menu = false;
                        menu2 = false;
                    }
                }
            }
            if (n2 < n1) {
                System.out.println("El primer numero debe ser menor que el segundo, " + n1 + ">" + n2);
            }
        }
        return numero;
    }

    public static void escribePrimos(int numero) {
        boolean menu = true;
        while (menu) {
            int contadorCaracteres = 0;
            if (numero > 4 && numero < 21) {
                int contadorPrimos = 0;
                int numeroInicio = 1;
                while (contadorPrimos != numero) {
                    numeroInicio++;
                    boolean restoCero = false;
                    int i = numeroInicio/2;
                    while (i > 1 && !restoCero) {
                        int resto = numeroInicio % i;
                        if (resto == 0) {
                            restoCero = true;
                        }

                        i--;
                    }
                    if (!restoCero) {
                        if (contadorCaracteres < 4) {
                            System.out.printf("%8d", numeroInicio);
                            contadorCaracteres++;
                        } else {
                            System.out.printf("\n%8d", numeroInicio);
                            contadorCaracteres = 1;
                        }
                        contadorPrimos++;
                    }
                }
                menu = false;
            }
            if (numero > 20) {
                System.out.println("El numero tiene que ser menor de 20");
                menu = false;
            }
            if (numero < 5) {
                System.out.println("El numero debe ser mayor de 5");
                menu = false;
            }
        }
    }
}
