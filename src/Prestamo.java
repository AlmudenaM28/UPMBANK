import java.util.Scanner;

public class Prestamo {
    private final double importe;
    private final int anios;
    private final double interesMensual;

    public Prestamo(double importe, int anios, double interesMensual) {
        this.importe = importe;
        this.anios = anios;
        this.interesMensual = interesMensual;
    }


    public double getImporte() {
        return importe;
    }

    public int getAnios() {
        return anios;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void imprimir(Cuenta cuenta){
        System.out.println(cuenta.getIBAN() + " Préstamo hipotecario de " + importe + "€ con un interés del " + interesMensual*100 + "% durante " + anios + " años." );
    }

    public void tablaAmortización() {
        System.out.printf("\n%18s %18s %18s %18s %18s \n", "", "PAGO MENSUAL", "INTERESES", "AMORTIZADO", "CAPITAL VIVO");
        double capitalVivo = importe;
        int numeroMeses = anios * 12;
        System.out.printf("%18d %18d %18d %18d %18.2f \n", 0, 0, 0, 0, capitalVivo);
        double pagoMensual = capitalVivo * interesMensual * ((Math.pow(1 + interesMensual, numeroMeses)) / ((Math.pow(1 + interesMensual, numeroMeses)) - 1));
        for (int i = 1; i <= numeroMeses; i++) {
            double intereses = capitalVivo * interesMensual;
            double amortizado = pagoMensual - intereses;
            capitalVivo -= amortizado;
            System.out.printf("%18d %18.2f %18.2f %18.2f %18.2f \n", i, pagoMensual, intereses, amortizado, capitalVivo);
        }
    }

    public static double setImporte() {
        boolean prestamoValido = false;
        double prestamo = 0;
        Scanner scan = new Scanner(System.in);
        while (!prestamoValido) {
            System.out.println("Introduzca la cantidad que desea solicitar: ");
            prestamo = scan.nextFloat();
            if (prestamo <= 0) {
                System.out.println("Cifra inválida. Intente de nuevo.");
            } else {
                prestamoValido = true;
            }
        }

        return prestamo;

    }


    public static int setAnios() {
        boolean aniosValido = false;
        int aniosPrestamo = 0;
        Scanner scan = new Scanner(System.in);
        while (!aniosValido) {
            System.out.println("Introduzca el número de años en que desea pagarlo: ");
            aniosPrestamo = scan.nextInt();
            if (aniosPrestamo <= 0) {
                System.out.println("Número de años inválido");
            } else if (aniosPrestamo > 30) {
                System.out.println("El número máximo de años es 30");
            } else {
                aniosValido = true;
            }
        }

        return aniosPrestamo;

    }

    public static double setInteresMensual() {
        boolean interesValido = false;
        double interes = 0;
        Scanner scan = new Scanner(System.in);
        while (!interesValido) {
            System.out.println("Introduzca el interés anual en %: ");
            interes = scan.nextInt();
            if (interes <= 0 | interes > 100) {
                System.out.println("Porcentaje inválido. El porcentaje debe estar entre 0 y 100");
            } else {
                interesValido = true;
            }
        }

        return interes / 100;

    }

}
