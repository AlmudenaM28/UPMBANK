import java.util.Scanner;

public class Sesion4 {
    static boolean salir = false;

    public static void main(String[] args) {
        while (!salir) {
            menu();
        }
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nSeleccione la operacion que desea realizar: \n1)Comprobar si un numero es primo");
        System.out.println("2)Escribir los n numeros primos");
        System.out.println("3)Escribir la lista de los números primos gemelos comprendidos entre dos valores");
        System.out.println("4)Mostrar  todas  las  formas  posibles  de  escribir  un  número  par  como  suma  de  dos  números primos");
        System.out.println("0) Salir");
        boolean menu = true;
        String opcion = "";
        while (menu) {
            opcion = scan.nextLine();
            if (opcion.equals("1")) {
                boolean numeroCorrecto = false;
                while (!numeroCorrecto) {
                    System.out.println("Escriba un numero entre 1 y 1000: ");
                    int num = scan.nextInt();
                    if (num >= 1 && num <= 1000) {
                        numeroCorrecto = true;
                        menu = false;
                        System.out.println(esPrimo(num,num /2));
                    } else {
                        System.out.println("El numero debe estar comprendido entre 1 y 1000");
                    }
                }

            } else if (opcion.equals("2")) {
                boolean numeroCorrecto = false;
                while (!numeroCorrecto) {
                    System.out.println("Escriba un numero entre 5 y 20: ");
                    int num = scan.nextInt();
                    if (num >= 5 && num <= 1000) {
                        numeroCorrecto = true;
                        menu = false;
                        escribePrimos(num);
                    } else {
                        System.out.println("El numero debe estar comprendido entre 5 y 20");
                    }
                }

            } else if (opcion.equals("3")) {
                boolean menuNum1 = true;
                while (menuNum1) {
                    System.out.println("Debe escribir dos números entre 1 y 500.\nEscribe el primer número");
                    int n1 = scan.nextInt();
                    System.out.println("Escribe el segundo número mayor que el primero");
                    int n2 = scan.nextInt();
                    if (n2 > n1) {
                        menuNum1 = false;
                        menu = false;
                        primosGemelos(n1, n2);
                    } else {
                        System.out.println("El primer numero debe ser menor que el segundo, " + n1 + ">" + n2);
                    }
                }

            } else if (opcion.equals("4")) {
                mostrarSumaDePrimos(25);
                menu = false;
            } else if (opcion.equals("0")) {
                salir = true;
                menu = false;
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

    }

    public static boolean esPrimo(int num, int primerDivisor) {
        boolean esPrimoBoolean = num != 1;
        while (primerDivisor > 1 && esPrimoBoolean) {
            int resto = num % primerDivisor;
            if (resto == 0) {
                esPrimoBoolean = false;
            }else{
                primerDivisor--;
                return esPrimo(num, primerDivisor);
            }
        }
        return esPrimoBoolean;
    }


    public static void escribePrimos(int num) {
        boolean menu = true;
        while (menu) {
            int contadorCaracteres = 0;
            if (num >= 5 && num <= 20) {
                int contadorPrimos = 0;
                int numeroInicio = 1;
                while (contadorPrimos != num) {
                    numeroInicio++;
                    boolean restoCero = false;
                    int i = num / 2;
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
        }
    }

    public static void primosGemelos(int num1, int num2) {
        int contador = 1;
        while (num1 < num2 || num1 + 2 < num2) {
            int num3 = num1 + 2;
            if (esPrimo(num1,(num1 / 2)) && esPrimo(num3,(num3 / 2))){
                System.out.printf("\n%2d.%5d%5d", contador, num1, num3);
                contador++;
            }
            num1++;
        }
    }

    public static void mostrarSumaDePrimos(int num){
        int numero = num - 1;
        while(numero > 1){
            boolean sumaEncontrada = false;
            if (esPrimo(numero,numero/2)){
                int segundoNumero = num - numero;
                while(!sumaEncontrada) {
                    if (esPrimo(segundoNumero, segundoNumero/2) && segundoNumero + numero == num) {
                        System.out.println(num + " = " + numero + " + " + segundoNumero);
                        sumaEncontrada = true;
                    }else{
                        segundoNumero++;
                    }
                }
            }
            numero--;
        }
    }
}
