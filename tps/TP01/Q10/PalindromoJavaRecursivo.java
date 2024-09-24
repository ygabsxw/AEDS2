package tps.TP01.Q10;

import java.util.Scanner;

public class PalindromoJavaRecursivo {
    private static boolean ehPalindromo (String palavra, int i, boolean ehPalin) {
        
        if (i < palavra.length() / 2) {
            if (palavra.charAt(i) != palavra.charAt(palavra.length() - 1 - i)) {
                ehPalin = false;
                i = palavra.length();
            }
        } else if (i >= palavra.length()) {
                return ehPalin;
        }    
            
        return ehPalindromo(palavra, i + 1, ehPalin);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        String palavra = sc.nextLine();
        
        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            if(ehPalindromo(palavra, 0, true)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            palavra = sc.nextLine();
        }        
        sc.close();
    }
}