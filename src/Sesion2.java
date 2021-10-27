import java.util.Scanner;

public class Sesion2 {
    public static void main(String[] args) {
        esPrimo();
    }

    public static void esPrimo() {
        /*
            Cogeremos un número por consola y lo empezaremos a dividir empezando desde el número entre 2 hasta el 1 sin incluir.
            De esta forma que si es primo no va a tener ninguna división de resto cero y, por tanto, no se activará el boolean restoCero.
         */
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        System.out.println("Ingrese el numero entre 0 y 1000 que desee comprobar si es primo: ");
        while (menu) {
            int numero = scan.nextInt();
            if (numero < 1001 && numero >= 0) {
                boolean restoCero = false;
                int i = numero - 1;
                while (i > 1 && !restoCero) {
                    int resto = numero % i;
                    if (resto == 0) {
                        restoCero = true;
                    }
                    i--;
                }
                if (numero == 1 || numero == 0 || restoCero) {
                    System.out.println("El numero " + numero + " no es primo.");
                } else {
                    System.out.println("El numero " + numero + " es primo.");
                }
                comprobacionCincoVeinte();
                menu = false;
            }
        }
    }


    public static void comprobacionCincoVeinte() {
        /*
            * Primero se comprueba que el número introducido cumple con las reglas establecidas.

            * Una vez que el valor sea correcto, crearemos una variable contadorPrimos que cada vez que
              encuentre un primo sume 1.

            * Posteriormente haremos un bucle en el que se recorrerán todos los números desde el 2 hasta que el valor
            de contadorPrimos sea igual al del número dado.

            * El algoritmo para obtener si es primo o no es el mismo que en la función anterior.

            * Como solo puede haber 4 números por línea, se crea una variable contadorCaracteres a la cual se suma 1
              cada vez que se imprime un primo. Cuando llega a 4, se salta a la siguiente linea y contadorCaracteres
              vuelve a ser 0.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un numero comprendido entre 5 y 20");
        boolean menu = true;
        while (menu) {
            int numero = scan.nextInt();
            int contadorCaracteres = 0;
            if (numero > 4 && numero < 21) {
                int contadorPrimos = 0;
                int numeroInicio = 1;
                while (contadorPrimos != numero) {
                    numeroInicio++;
                    boolean restoCero = false;
                    int i = numeroInicio - 1;
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
            }
            if (numero < 5) {
                System.out.println("El numero debe ser mayor de 5");
            }
        }
    }
}






