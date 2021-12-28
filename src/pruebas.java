import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class pruebas {
    public static void main (String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader("sucursales.txt"));
        String linea = lector.readLine();
        int[] codigos = new int[4];
        for (int i = 0; i < 4;i++) {
            codigos[i] = Integer.parseInt(linea.split("=")[1]);
            linea = lector.readLine();
        }

        System.out.println(codigos[0]);
        System.out.println(codigos[1]);
        System.out.println(codigos[2]);
        System.out.println(codigos[3]);
    }


}
