public class digitoControl {
    public static int obtenerDC(long numeroAleatorio, int codigoSucursal, int codigoEntidad){
        int CE_1 = Integer.parseInt(String.valueOf(Integer.toString(codigoEntidad).charAt(0)));
        int CE_2 = Integer.parseInt(Integer.toString(codigoEntidad).charAt(1);
        int CE_3 = Integer.parseInt(Integer.toString(codigoEntidad).charAt(2);
        int CE_4 = Integer.parseInt(Integer.toString(codigoEntidad).charAt(3);

        int CS_1 = Integer.parseInt(Integer.toString(codigoSucursal).substring(0,0));
        int CS_2 = Integer.parseInt(Integer.toString(codigoSucursal).substring(1,1));
        int CS_3 = Integer.parseInt(Integer.toString(codigoSucursal).substring(2,2));
        int CS_4 = Integer.parseInt(Integer.toString(codigoSucursal).substring(3,3));

        int a = 11 - ((6 * CS_4 + 3 * CS_3 + 7 * CS_2 + 9 * CS_1 + 10 * CE_4 + 4 * CE_3 + 8 * CE_2 + 4 * CE_1) % 11);

        int c1 = 0;
        if (a < 10) {
            c1 = a;
        } else if (a == 10) {
            c1 = 1;
        } else if (a == 11) {
            c1 = 0;
        }

        int NC_0 = Integer.parseInt(Long.toString(numeroAleatorio).substring(0,0));
        int NC_1 = Integer.parseInt(Long.toString(numeroAleatorio).substring(1,1));
        int NC_2 = Integer.parseInt(Long.toString(numeroAleatorio).substring(2,2));
        int NC_3 = Integer.parseInt(Long.toString(numeroAleatorio).substring(3,3));
        int NC_4 = Integer.parseInt(Long.toString(numeroAleatorio).substring(4,4));
        int NC_5 = Integer.parseInt(Long.toString(numeroAleatorio).substring(5,5));
        int NC_6 = Integer.parseInt(Long.toString(numeroAleatorio).substring(6,6));
        int NC_7 = Integer.parseInt(Long.toString(numeroAleatorio).substring(7,7));
        int NC_8 = Integer.parseInt(Long.toString(numeroAleatorio).substring(8,8));
        int NC_9 = Integer.parseInt(Long.toString(numeroAleatorio).substring(9,9));

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

    public static void main (String[] args){
        long digitoControl1 = NC.obtenerNC();
        System.out.println(digitoControl1);
        System.out.println(digitoControl.obtenerDC(digitoControl1,0201,9010));

    }


}
