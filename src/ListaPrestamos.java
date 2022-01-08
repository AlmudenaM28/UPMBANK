public class ListaPrestamos {
    private Prestamo[] prestamos;
    int numeroPrestamos;
    private final static int MAX_PRESTAMOS = 50;

    public ListaPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
        this.numeroPrestamos = 0;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }

    public static int getMaxPrestamos() {
        return MAX_PRESTAMOS;
    }

    public void anadirPrestamo(Prestamo prestamo) {
        prestamos[numeroPrestamos] = prestamo;
        numeroPrestamos++;
    }

    public void imprimir(Cuenta cuenta){
        for (int i = 0; i < numeroPrestamos; i++){
            prestamos[i].imprimir(cuenta);
        }
    }

}
