/*
Para que el DNI sea correcto se tienen que cumplir 3 declaraciones:
1.Que la longitud sea de 9 caracteres
2.Que el ultimo caracter sea una letra y esta sea correcta
3.Que el resto de caracteres sean numeros
 */
public class validarDNI {
    public boolean validarLetra(String dni) {
        //Comprobamos las dos primeras declaraciones
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int numero = Integer.parseInt(dni.substring(0, 8));
        String letra = String.valueOf(dni.charAt(8));
        return dni.length() == 9 && Character.isLetter(dni.charAt(8)) && letra.toUpperCase().equals(letras[numero % 23]);//Devolvemos el valor ya sea true o false
    }

    public boolean validarNumero(String dni) {
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder dniCorrecto = new StringBuilder(); //Creamos una string nueva que iremos construyendo.
        for (int i = 0; i < 8; i++) { //Encadenamos dos bucles for, uno que recorra el dni dado y otro la array.
            char compruebaNumero = dni.charAt(i);
            for (int j = 0; j < numeros.length; j++) {
                if (Character.toString(compruebaNumero).equals(numeros[j])) {
                    dniCorrecto.append(numeros[j]); //Aqui comprobara que  el caracter en i del dni coincida
                }                                   //con alguno de los numeros de la array y lo añadira a la
            }                                       //StringBuilder
        }
        return dniCorrecto.length() == 8;           //Si se ha introducido un numero correcto la String que
    }                                               //hemos construido debera tener 8 caracteres.

}


