public class validarDNI {
    public boolean validarLetra(String dni) {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
        return Character.isLetter(letra) && letra == letras[numero%23];
    }

    public boolean validarNumero(String dni) {
        int i = 0;
        boolean esNumero = true;
        while (i < 8 && esNumero) {
            if (!Character.isDigit(dni.charAt(i))) {
                esNumero = false;
            }
            i++;
        }
        return esNumero;
    }
}


