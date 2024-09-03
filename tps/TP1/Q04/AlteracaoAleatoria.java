package tps.TP1.Q04;
import java.util.Random;
import java.util.Scanner;

public class AlteracaoAleatoria {
    private static Random gerador = new Random();

    private static String sorteio (String palavra) {
        int tam = palavra.length();
        char [] palavraNova = new char[palavra.length()];
        
        char letraAntiga = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        for(int i = 0 ; i < tam ; i++) {
            if(palavra.charAt(i) == letraAntiga) {
                palavraNova[i] = letraNova;
            } else {
                palavraNova[i] = palavra.charAt(i);
            }
        }

        return new String(palavraNova);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        gerador.setSeed(4);
        
        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.println(sorteio(palavra));

           palavra = sc.nextLine();
        }
        sc.close();
    }
}
