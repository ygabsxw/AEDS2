package tps.TP01.Q15;
import java.util.Scanner;

public class IsRecursivo {
    private static boolean onlyVogais (String palavra, int i, boolean vogais) {
        int tam = palavra.length();

        if (i < tam) {
            if (!(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U')) {
                vogais = false;
                i = tam;
            }

        } else {
            return vogais;
        }
        
        return onlyVogais(palavra, i + 1, vogais);
    }

    private static boolean onlyConsoantes (String palavra, int i, boolean consoantes) {
        int tam = palavra.length();

        if (i < tam) {
            if ((palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U') || (palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9' ) || (palavra.charAt(i) == ',' || palavra.charAt(i) == '.')) {
                consoantes = false;
                i = tam;
            }
        } else {
            return consoantes;
        }

        return onlyConsoantes(palavra, i + 1, consoantes);
    }

    private static boolean inteiros (String palavra, int i, boolean inteiro) {
        int tam = palavra.length();

        if (i < tam) {
            if (!(palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9')) {
                inteiro = false;
                i = tam;
            }
        } else {
            return inteiro;
        }

        return inteiros(palavra, i + 1, inteiro);
    }

    private static boolean reais (String palavra, int i, boolean real) {
        int tam = palavra.length();

        if (i < tam) {
            if (!((palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9') || (palavra.charAt(i) == ',' || palavra.charAt(i) == '.'))) {
                real = false;
                i = tam;
            }
        } else {
            return real;
        }

        return reais(palavra, i + 1, real);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();

        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.print(onlyVogais(palavra, 0, true) ? "SIM " : "NAO ");
            System.out.print(onlyConsoantes(palavra, 0, true) ? "SIM " : "NAO ");
            System.out.print(inteiros(palavra, 0, true) ? "SIM " : "NAO ");
            System.out.println(reais(palavra, 0, true) ? "SIM " : "NAO ");

            palavra = sc.nextLine();
        }
        sc.close();
    }
}
