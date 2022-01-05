
enum TipoMovimiento {
    Ingreso, Extracción
}

public class Movimiento {
    private final double importe;
    TipoMovimiento tipoMovimiento;

    public Movimiento(double importe, TipoMovimiento tipoMovimiento) {
        this.importe = importe;
        this.tipoMovimiento = tipoMovimiento;
    }

    public void imprimir(Cuenta cuenta){
        System.out.println(cuenta.getIBAN() + " " + tipoMovimiento + " de " + importe + "€");
    }

}
