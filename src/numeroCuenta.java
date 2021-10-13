import java.util.Arrays;
import java.util.Random;

public class numeroCuenta {
    public numeroCuenta(){
        Random random = new Random();
        int[] NC = new int[10];
        for(int i = 0; i < NC.length; i++){
            NC[i] = random.nextInt();
        }
        int c1 = 0;
        int[] CE = {9,0,1,0};
        int[] CS = {0,2,0,1};
        int a = 11 - ((6*CE[4]+3*CE[3]+7*CE[2]+9*CE[1])%11);
        if(a < 10){c1 = a;}
        else if (a == 10){c1 = 1;}
        else if(a == 11){c1 = 0;}

        int c2 = 0;

        int b = 11 - ((NC[1] + 2*NC[2] + 4*NC[3] + 8*NC[4] + 5*NC[5] + 10*NC[6] + 9*NC[7] + 7*NC[8] + 3*NC[9])%11);
        if(b < 10){c2 = b;}
        else if (b == 10){c2 = 1;}
        else if(b== 11){c2 = 0;}

        System.out.println(Arrays.toString(CE) + Arrays.toString(CS) + Integer.toString(c1) + Integer.toString(c2) + Arrays.toString(NC));

    }
}
