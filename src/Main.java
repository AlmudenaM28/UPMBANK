public class Main{
    public static int CS = 0;

    static {
        try {
            CS = UPMBank.codigoSucursal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UPMBank.menuInicial();
    }
}
