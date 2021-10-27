import java.util.Scanner;
public class Main {
    public static void menuInicial() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione la operacion que desea realizar: \n1)Comprobar si un numero es primo");
        System.out.println("2)Escribir los n numeros primos");
        System.out.println("3)Escribir la lista de los números primos gemelos comprendidos entre dos valores");
        System.out.println("4)Mostrar  todas  las  formas  posibles  de  escribir  un  número  par  como  suma  de  dos  números primos");
        System.out.println("0) Salir");
        boolean menuActivo = true;
        while(menuActivo) {
            int opcion = scan.nextInt();
            if (opcion == 1) {
                System.out.println("Ha elegido la opcion 1.");
                break;
            }
            if (opcion == 2) {
                System.out.println("Ha elegido la opcion 2.");
                break;
            }
            if (opcion == 3) {
                System.out.println("Ha elegido la opcion 3.");
                break;
            }
            if (opcion == 4) {
                System.out.println("Ha elegido la opcion 4.");
                break;
            }
            if (opcion == 0) {
                System.out.println("Saliendo...");
                menuActivo = false;
            }
            else{
                System.out.println("Caracter invalido. Intente de nuevo.");
            }
        }
    }
    public static void main(String[] args){
        menuInicial();
    }
}

