public class Cuenta {
    final static int CODIGO_ENTIDAD = 9010;
    int codigoSucursal, digitoControl;
    long numeroCuenta;
    String IBAN;
    TipoCuenta tipoCuenta;
    Cliente titular;
    ListaMovimientos movimientos;
    ListaPrestamos prestamos;
    ListaTrasferencias trasferenciasRecibidas;
    ListaTrasferencias trasferenciasEmitidas;

    public Cuenta(int codigoSucursal, int digitoControl, long numeroCuenta, Cliente titular, String IBAN) {
        this.codigoSucursal = codigoSucursal;
        this.digitoControl = digitoControl;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.IBAN = IBAN;
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

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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

    public ListaTrasferencias getTrasferenciasRecibidas() {
        return trasferenciasRecibidas;
    }

    public void setTrasferenciasRecibidas(ListaTrasferencias trasferenciasRecibidas) {
        this.trasferenciasRecibidas = trasferenciasRecibidas;
    }

    public ListaTrasferencias getTrasferenciasEmitidas() {
        return trasferenciasEmitidas;
    }

    public void setTrasferenciasEmitidas(ListaTrasferencias trasferenciasEmitidas) {
        this.trasferenciasEmitidas = trasferenciasEmitidas;
    }
}
