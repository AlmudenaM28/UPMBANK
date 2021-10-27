import java.util.Random;

public class numeroCuenta {
    public String obtenerNumeroCuenta() {

        Random random = new Random();
        String CS = "0201";



        int c1 = 0;
        String CE = "9010";
        int CE_1 = 9;
        int CE_2 = 0;
        int CE_3 = 1;
        int CE_4 = 0;
        int a = 11 - ((6 * CE_1 + 3 * CE_2 + 7 * CE_3 + 9 * CE_4) % 11);
        if (a < 10) {
            c1 = a;
        } else if (a == 10) {
            c1 = 1;
        } else if (a == 11) {
            c1 = 0;
        }


        int c2 = 0;
        int r1= random.nextInt(9),
                r2= random.nextInt(9),
                r3= random.nextInt(9),
                r4= random.nextInt(9),
                r5= random.nextInt(9),
                r6= random.nextInt(9),
                r7= random.nextInt(9),
                r8 = random.nextInt(9),
                r9 = random.nextInt(9),
                r10 = random.nextInt(9);

        String NC = Integer.toString(r1) + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9 + r10;
        int b = 11 - ((r1 + 2 * r2 + 4 * r3 + 8 * r4 + 5 * r5 + 10 * r6 + 9 * r7 + 7 * r8 + 3 * r9) % 11);
        if (b < 10) {
            c2 = b;
        } else if (b == 10) {
            c2 = 1;
        } else if (b == 11) {
            c2 = 0;
        }


        return (CE + CS + c1 + c2 + NC);
    }
}

