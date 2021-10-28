import java.util.Random;

public class NC {
    public static long obtenerNC() {
        Random random = new Random();
        String numero;
        do{
            numero = Integer.toString(random.nextInt(9));
        }while (Integer.parseInt(numero) == 0);

        for (int i = 0;i<9;i++){
            numero += random.nextInt(9);
        }

        return Long.parseLong(numero);
    }
}
