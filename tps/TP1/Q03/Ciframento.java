package tps.TP1.Q03;
import java.util.Scanner;

public class Ciframento {
    private static String ciframento (String palavra) {
        char[] decifrada = new char[palavra.length()];

        for(int i = 0 ; i < palavra.length() ; i++) {
            decifrada[i] = palavra.charAt(i);
            if (palavra.charAt(i) >= 0 && palavra.charAt(i) <= 127) { 
                decifrada[i] += 3; 
            } 
        }

        return new String(decifrada);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        String palavra = sc.nextLine();

        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.println(ciframento(palavra));

            palavra = sc.nextLine();
        }

        sc.close();
    }
}
