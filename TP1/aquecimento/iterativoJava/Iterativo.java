import java.util.Scanner;

public class Iterativo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();

        while (!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            int maiusculas = 0;
            for(int i = 0 ; i < palavra.length() ; i++) {
                if(palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'Z') {
                    maiusculas++;
                }
            }
            System.out.println(maiusculas);

            palavra = sc.nextLine();
        }
        sc.close();
    }
}
