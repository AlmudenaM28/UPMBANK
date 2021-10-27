import java.util.Scanner;

public class Sesion1 {
    public static void menuInicial() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione la operacion que desea realizar: \n1)Comprobar si un numero es primo");
        System.out.println("2)Escribir los n numeros primos");
        System.out.println("3)Escribir la lista de los números primos gemelos comprendidos entre dos valores");
        System.out.println("4)Mostrar  todas  las  formas  posibles  de  escribir  un  número  par  como  suma  de  dos  números primos");
        System.out.println("0) Salir");
        boolean menu = true;
        while (menu) {
            String opcion = scan.nextLine();
            if (opcion.equals("1")) {
                System.out.println("Ha elegido la opcion 1.");
                menu = false;
            }
            if (opcion.equals("2")) {
                System.out.println("Ha elegido la opcion 2.");
                menu = false;
            }
            if (opcion.equals("3")) {
                System.out.println("Ha elegido la opcion 3.");
                menu = false;
            }
            if (opcion.equals("4")) {
                System.out.println("Ha elegido la opcion 4.");
                menu = false;
            }
            if (opcion.equals("5")) {
                System.out.println("Saliendo...");
                menu = false;
            } else {
                System.out.println("Caracter invalido. Intente de nuevo.");
            }
        }

        numeroEntero();
    }

        public static void numeroEntero(){
            System.out.println("Escribe un numero entero entre 0 y 1000");
            boolean menu = true;
            while (menu) {
                Scanner scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if (numero > 0 && numero < 1000) {
                    System.out.println("Todo correcto");
                    numerosDivisibles();
                    menu = false;
                }
                if (numero > 1000) {
                    System.out.println("El numero tiene que ser menor de 1000");
                }
                if (numero < 0) {
                    System.out.println("El numero debe ser mayor de 0");
                }
                if (numero == 0 || numero == 1000) {
                    System.out.println("Los numero deben estar comprendidos entre 0 y 1000 pero no pueden tomar su valor.");
                }
            }
        }

        public static void numerosDivisibles(){
            Scanner scan = new Scanner(System.in);
            boolean menu = true;
            while (menu){
                System.out.println("Escribe el primer numero");
                int primerNumero = scan.nextInt();
                System.out.println("Escribe el segundo numero mayor que el primero y divisible entre este");
                int segundoNumero = scan.nextInt();
                if (segundoNumero>primerNumero && segundoNumero%primerNumero==0){
                    System.out.println("Todo correcto, "+primerNumero+"<"+segundoNumero+
                            " ; "+segundoNumero+"%"+primerNumero+"=0");
                    menu = false;
                }
                if (segundoNumero<primerNumero){
                    System.out.println("El primer numero debe ser menor que el segundo, "
                            +primerNumero+">"+segundoNumero);
                }
                if(segundoNumero%primerNumero!=0){
                    System.out.println("El segundo numero debe ser divisible entre el primero, "
                            +segundoNumero+"%"+primerNumero+"!=0");

                }
                if(segundoNumero==primerNumero){
                    System.out.println("Los numeros deben ser distintos");
                }
            }
        }

    public static void main(String[] args){
        menuInicial();
    }
}

