package laboratorios.lab01.recursivoJava;
import java.util.Scanner;

public class Recursivo {
    // funcao recursiva para achar a quantidade de letras maiuscula na string
    private static int maiusculas(String palavra, int i, int count) {
        if(i >= palavra.length()) {
            return count;
        } //retorna a contagem de maiusculas para a main saindo da recursividade

        if(palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'Z') {
            count++;
        }

        return maiusculas(palavra, i + 1, count);
    } 

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        int i = 0;
        int c = 0;

        while (!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.println(maiusculas(palavra, i, c));

            palavra = sc.nextLine();
        }
        sc.close();
    }

}