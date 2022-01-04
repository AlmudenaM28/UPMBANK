public class ListaMovimientos {
    Movimiento[] movimientos;
    int numMovimientos = 0;
    final static int MAX_MOVIMIENTOS = 50;

    public void anadirMovimiento (Movimiento movimiento){
        movimientos[numMovimientos] = movimiento;
        numMovimientos++;
    }

    public void imprimir(){
        for (int i = 0; i < numMovimientos; i++){
            movimientos[i].imprimir();
        }
    }
}
