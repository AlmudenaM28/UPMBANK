public class digitoControl {
    public static int obtenerDC(String numeroAleatorio, String codigoSucursal, String codigoEntidad){

        int CE_1 = Integer.parseInt(Character.toString(codigoEntidad.charAt(0)));
        int CE_2 = Integer.parseInt(Character.toString(codigoEntidad.charAt(1)));
        int CE_3 = Integer.parseInt(Character.toString(codigoEntidad.charAt(2)));
        int CE_4 = Integer.parseInt(Character.toString(codigoEntidad.charAt(3)));

        int CS_1 = Integer.parseInt(Character.toString(codigoSucursal.charAt(0)));
        int CS_2 = Integer.parseInt(Character.toString(codigoSucursal.charAt(1)));
        int CS_3 = Integer.parseInt(Character.toString(codigoSucursal.charAt(2)));
        int CS_4 = Integer.parseInt(Character.toString(codigoSucursal.charAt(3)));

        int a = 11 - ((6 * CS_4 + 3 * CS_3 + 7 * CS_2 + 9 * CS_1 + 10 * CE_4 + 4 * CE_3 + 8 * CE_2 + 4 * CE_1) % 11);

        int c1 = 0;
        if (a < 10) {
            c1 = a;
        } else if (a == 10) {
            c1 = 1;
        } else if (a == 11) {
            c1 = 0;
        }

        int NC_0 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(0)));
        int NC_1 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(1)));
        int NC_2 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(2)));
        int NC_3 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(3)));
        int NC_4 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(4)));
        int NC_5 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(5)));
        int NC_6 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(6)));
        int NC_7 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(7)));
        int NC_8 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(8)));
        int NC_9 = Integer.parseInt(Character.toString(numeroAleatorio.charAt(9)));


        int b = 11 - ((NC_0 + 2 * NC_1 + 4 * NC_2 + 8 * NC_3 + 5 * NC_4 + 10 * NC_5 + 9 * NC_6 + 7 * NC_7 + 3 * NC_8 + 6 * NC_9) % 11);
        int c2 = 0;
        if (b < 10) {
            c2 = b;
        } else if (b == 10) {
            c2 = 1;
        } else if (b == 11) {
            c2 = 0;
        }

        return Integer.parseInt(Integer.toString(c1) + c2);
    }
}
