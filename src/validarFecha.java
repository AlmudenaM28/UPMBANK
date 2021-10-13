import java.time.Year;

public class validarFecha {
    public static boolean validar(String dia, String mes, String anio) {
        /*
            1. Comprobar que se siga el formato correcto DD/MM/AAAA
            2. Comprobar que el día y el mes son correctos
         */
        boolean mes31 = false;
        boolean mes30 = false;
        boolean febrero = false;
        int anioActual = Year.now().getValue();

        if (mes.equals("01") || mes.equals("03") || mes.equals("05") || mes.equals("07")
                || mes.equals("08") || mes.equals("10") || mes.equals("12")) {
            mes31 = true;
        } else if (mes.equals("02")) {
            febrero = true;
        } else {
            mes30 = true;
        }

        if (dia.length() != 2 || mes.length() != 2 || anio.length() != 4) {
            System.out.println("El formato debe ser dd/mm/aaaa");
            return false;
        } else if (Integer.parseInt(anio) > anioActual) {
            System.out.println("Año inválido");
            return false;
        } else {
            if (mes31 && Integer.parseInt(dia) > 31 || mes30 && Integer.parseInt(dia) > 30
                    || febrero && Integer.parseInt(dia) > 28) {
                System.out.println("Datos inválidos");
                return false;
            } else {
                return true;
            }
        }
    }
}
