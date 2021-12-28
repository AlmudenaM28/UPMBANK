public class digitoControl {
    public static int obtenerDC(long numeroCuenta, int cs, int ce) {
        int c1, c2;
        int c = 6 * (cs % 10) + 3 * (cs / 10 % 10) + 7 * (cs / 100 % 10) + 9 * (cs / 1000) + 10 * (ce % 10) + 5 * (ce / 10 % 10) + 8 * (ce / 100 % 10) + 4 * (ce / 1000);
        c = 11 - (c % 11);
        if (c == 11)
            c1 = 0;
        else if (c == 10)
            c1 = 1;
        else c1 = c;

        c = (int) ((numeroCuenta / 1000000000) + 2 * (numeroCuenta / 100000000 % 10) + 4 * (numeroCuenta / 10000000 % 10) + 8 * (numeroCuenta / 100000 % 10) +
                5 * (numeroCuenta / 10000 % 10) + 10 * (numeroCuenta / 1000 % 10) + 9 * (numeroCuenta / 1000 % 10) + 7 * (numeroCuenta / 100 % 10) +
                3 * (numeroCuenta / 10 % 10) + 6 * (numeroCuenta % 10));

        c = 11 - (c % 11);
        if (c == 11)
            c2 = 0;
        else if (c == 10)
            c2 = 1;
        else c2 = c;

        return Integer.parseInt(Integer.toString(c1) + c2);
    }
}
