enum TipoTransferencia{
    Emitida, Recibida
}

public class Transferencia {
    double importe;
    Cuenta origen;
    Cuenta destino;
    TipoTransferencia tipoTransferencia;

    public Transferencia(double importe, Cuenta origen, Cuenta destino, TipoTransferencia tipoTransferencia) {
        this.importe = importe;
        this.origen = origen;
        this.destino = destino;
        this.tipoTransferencia = tipoTransferencia;
    }

    public void imprimir(){
        if (tipoTransferencia == TipoTransferencia.Emitida) {
            System.out.println(origen.getIBAN() + " envia " + importe + "€ a " + destino.getIBAN());
        }else if (tipoTransferencia == TipoTransferencia.Recibida){
            System.out.println(destino.getIBAN() + " recibe " + importe + "€ de " + origen.getIBAN());
        }
    }

}
