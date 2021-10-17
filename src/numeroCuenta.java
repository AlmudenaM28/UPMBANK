import java.util.Random;

public class numeroCuenta {
    public String obtenerNumeroCuenta(){
        Random random = new Random();
        StringBuilder NC = new StringBuilder();;
        for(int i = 0; i < 10; i++){
            NC.append(random.nextInt(9));
        }
        int c1 = 0;
        String CE = "9010";
        String CS = "0201";
        int a = 11 - ((6* (int) CE.charAt(3) +3* (int) CE.charAt(2)+7*(int)CE.charAt(1)+9*(int)CE.charAt(0))%11);
        if(a < 10){c1 = a;}
        else if (a == 10){c1 = 1;}
        else if(a == 11){c1 = 0;}

        int c2 = 0;

        int b = 11 - ((NC.charAt(1) + 2*NC.charAt(2) + 4*NC.charAt(3) + 8*NC.charAt(4) + 5*NC.charAt(5)
                + 10*NC.charAt(6) + 9*NC.charAt(7) + 7*NC.charAt(8) + 3*NC.charAt(9))%11);
        if(b < 10){c2 = b;}
        else if (b == 10){c2 = 1;}
        else if(b== 11){c2 = 0;}
        return (CE + CS + c1 + c2 + NC);
    }
}
