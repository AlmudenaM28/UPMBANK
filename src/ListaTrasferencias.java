public class ListaTrasferencias {
    private Transferencia[] transferencias;
    int numeroTransferencias;
    private final static int MAX_TRANSFERENCIAS = 50;

    public ListaTrasferencias(Transferencia[] transferencias) {
        this.transferencias = transferencias;
        this.numeroTransferencias = 0;
    }

    public Transferencia[] getTransferencias() {
        return transferencias;
    }

    public static int getMaxTransferencias() {
        return MAX_TRANSFERENCIAS;
    }

    public void anadirTransferencia(Transferencia transferencia) {
        transferencias[numeroTransferencias] = transferencia;
        numeroTransferencias++;
    }

    public static double getTotalTransferenciaCuenta(String IBAN, Cuenta cuenta){
        double totalImporte = 0.0;
        for (int i = 0;i < cuenta.getTransferenciasEmitidas().numeroTransferencias; i++){
            if (cuenta.getTransferenciasEmitidas().getTransferencias()[i].destino.getIBAN().equals(IBAN)){
                totalImporte += cuenta.getTransferenciasEmitidas().getTransferencias()[i].importe;
            }
        }
        return totalImporte;
    }

    public void imprimir(){
        for (int i = 0; i < numeroTransferencias; i++){
            transferencias[i].imprimir();
        }
    }
}
