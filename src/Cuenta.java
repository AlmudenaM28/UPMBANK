import java.util.Scanner;

enum TipoCuenta{
    Corriente, Ahorro, Remunerada;
}


public class Cuenta {
    final static int CODIGO_ENTIDAD = 9010;
    private int codigoSucursal, digitoControl;
    private long numeroCuenta;
    private String IBAN;
    TipoCuenta tipoCuenta;
    private Cliente titular;
    private ListaMovimientos movimientos;
    private ListaPrestamos prestamos;
    private ListaTrasferencias trasferenciasRecibidas;
    private ListaTrasferencias trasferenciasEmitidas;
    double saldo = 0;

    public Cuenta(int codigoSucursal, int digitoControl, long numeroCuenta, Cliente titular, String IBAN, TipoCuenta tipoCuenta, ListaMovimientos listaMovimientos,
                  ListaPrestamos listaPrestamos, ListaTrasferencias listaTrasferenciasEmitidas, ListaTrasferencias listaTrasferenciasRecibidas) {
        this.codigoSucursal = codigoSucursal;
        this.digitoControl = digitoControl;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.IBAN = IBAN;
        this.tipoCuenta = tipoCuenta;
        this.movimientos = listaMovimientos;
        this.prestamos = listaPrestamos;
        this.trasferenciasEmitidas = listaTrasferenciasEmitidas;
        this.trasferenciasRecibidas = listaTrasferenciasRecibidas;
    }

    public void imprimir(){
        System.out.println(titular.getNombre());
        System.out.println(titular.getApellidos());
        System.out.println(titular.getDni());
        System.out.println(this.IBAN);
        System.out.println("Saldo: " + saldo + "€");
    }



    public String getIBAN() { return IBAN; }

    public double getSaldo() {
        return saldo;
    }

    public static int getCodigoEntidad() {
        return CODIGO_ENTIDAD;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public int getDigitoControl() {
        return digitoControl;
    }

    public void setDigitoControl(int digitoControl) {
        this.digitoControl = digitoControl;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public static TipoCuenta setTipoCuenta() {
        boolean menuOpcion = true;
        Scanner scan = new Scanner(System.in);
        TipoCuenta tipoCuenta = null;
        while (menuOpcion) {
            System.out.println("Elija su tipo de cuenta: \n1) Corriente\n2) Ahorro\n3) Remunerada");
            String opcion = scan.nextLine();
            if (opcion.equals("1")) {
                menuOpcion = false;
                tipoCuenta = TipoCuenta.Corriente;
            } else if (opcion.equals("2")) {
                menuOpcion = false;
                tipoCuenta = TipoCuenta.Ahorro;
            } else if (opcion.equals("3")) {
                menuOpcion = false;
                tipoCuenta = TipoCuenta.Remunerada;
            } else {
                System.out.println("Opción inválida");
            }
        }
        return tipoCuenta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ListaMovimientos getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ListaMovimientos movimientos) {
        this.movimientos = movimientos;
    }

    public ListaPrestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ListaPrestamos prestamos) {
        this.prestamos = prestamos;
    }

    public ListaTrasferencias getTransferenciasRecibidas() {
        return trasferenciasRecibidas;
    }

    public void setTransferenciasRecibidas(ListaTrasferencias trasferenciasRecibidas) {
        this.trasferenciasRecibidas = trasferenciasRecibidas;
    }

    public ListaTrasferencias getTransferenciasEmitidas() {
        return trasferenciasEmitidas;
    }

    public void setTrasferenciasEmitidas(ListaTrasferencias trasferenciasEmitidas) {
        this.trasferenciasEmitidas = trasferenciasEmitidas;
    }
}
