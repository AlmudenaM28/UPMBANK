public class ListaCuentas {
    private Cuenta[] cuentas;
    int numCuentas;

    public ListaCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
        this.numCuentas = 0;
    }

    public void imprimir() {
        for (int i = 0; i < numCuentas; i++) {
            System.out.println("\t" + (i + 1) + ". " + cuentas[i].getIBAN() + " " + cuentas[i].tipoCuenta + "  " + cuentas[i].saldo + "€");
        }
    }

    public Cuenta[] getListaCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getNumCuentas() {
        return numCuentas;
    }

    public void setNumCuentas(int numCuentas) {
        this.numCuentas = numCuentas;
    }
}
