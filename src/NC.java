import java.util.Random;

public class NC {
    public static long obtenerNC(){
        Random random = new Random();
        int mitadPrimera = random.nextInt(99999);
        int mitadSegunda = random.nextInt(99999);
        return Long.parseLong(Integer.toString(mitadPrimera)+mitadSegunda);
    }

    public static void main (String[] args){
        System.out.println(obtenerNC());

    }

}
