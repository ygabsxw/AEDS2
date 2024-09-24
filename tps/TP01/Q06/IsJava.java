package tps.TP01.Q06;
import java.util.Scanner;

public class IsJava {
    private static boolean onlyVogais (String palavra) {
        int tam = palavra.length() - 1;
        boolean vogais = true;

        for (int i = 0 ; i <= tam ; i++) {
            if(!(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U')) {
                vogais = false;
                i = tam;
            }
        }

        return vogais;
    } //funcao que retorna true or false para a string que possui apenas vogais

    private static boolean onlyConsoantes (String palavra) {
        int tam = palavra.length() - 1;
        boolean consoantes = true;

        for (int i = 0 ; i <= tam ; i++) {
            if((palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U' ) || (palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9' ) || (palavra.charAt(i) == ',' || palavra.charAt(i) == '.')) {
                consoantes = false;
                i = tam;
            }
        }

        return consoantes;
    } //funcao que retorna true or false para a string que possui apenas consoantes

    private static boolean inteiros (String palavra) {
        int tam = palavra.length() - 1;
        boolean inteiro = true;

        for (int i = 0 ; i <= tam ; i++) {
            if(!(palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9')) {
                    inteiro = false;
                    i = tam;
            }
        }

        return inteiro;
    } //funcao que retorna true or false para a string é um num inteiro

    private static boolean reais (String palavra) {
        int tam = palavra.length() - 1;
        boolean real = true;

        for (int i = 0 ; i <= tam ; i++) {
            if(!((palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9') || (palavra.charAt(i) == ',' || palavra.charAt(i) == '.'))) {
                real = false;
                i = tam;
        }
        }

        return real;
    } //funcao que retorna true or false para a string é um num real

    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        String palavra = sc.nextLine();
        String sim = "SIM";
        String nao = "NAO";
        String x1, x2, x3, x4; //auxiliar para ajudar na hora da escrita se é SIM ou NAO

        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            if(onlyVogais(palavra)) x1 = sim;
            else x1 = nao;
            if(onlyConsoantes(palavra)) x2 = sim;
            else x2 = nao;
            if(inteiros(palavra)) x3 = sim;
            else x3 = nao;
            if(reais(palavra)) x4 = sim;
            else x4 = nao;
            
            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);

            palavra = sc.nextLine();
        }

        sc.close();
    }
}
