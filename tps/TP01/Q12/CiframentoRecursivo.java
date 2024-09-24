package tps.TP01.Q12;
import java.util.Scanner;

public class CiframentoRecursivo {
    public static String ciframento (String palavra, int i) {
        int tamanho = palavra.length();
        char[] decifrada = new char[palavra.length()];

        if(i < tamanho) {
            decifrada[i] = palavra.charAt(i);
            if(palavra.charAt(i) >= 0 && palavra.charAt(i) <= 127) {
                decifrada[i] += 3;
            }
        } else {
            return new String(decifrada);
        }

        return ciframento(palavra, i + 1);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        String palavra = sc.nextLine();


        while (!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.println(ciframento(palavra, 0));

            palavra = sc.nextLine();

        }

        sc.close();
    }
}
