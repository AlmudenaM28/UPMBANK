public class ListaCuentas {
    Cuenta[] cuentas;
    int numCuentas;

    public ListaCuentas(Cuenta[] cuentas, int numCuentas) {
        this.cuentas = cuentas;
        this.numCuentas = numCuentas;
    }

    public Cuenta[] getCuentas() {
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
