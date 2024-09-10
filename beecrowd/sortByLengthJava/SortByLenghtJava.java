import java.util.Scanner;

public class SortByLenghtJava {
    private static Scanner sc = new Scanner(System.in);

    private static void sortString (String []palavra, int palavraIndex) {
        
        for (int i = 1 ; i < palavraIndex; i++) {
            String key = palavra[i];
            int j = i - 1;
            while (j >= 0 && palavra[j].length() < key.length()) {
                palavra[j + 1] = palavra[j];
                j = j - 1;
            }
            palavra[j + 1] = key;
        }
    }

    private static void checkStrings (int N, String []frase) {

        for (int i = 0 ; i < N ; i++) {
            String []palavra = frase[i].split(" ");
            int palavraIndex = palavra.length;

            sortString(palavra, palavraIndex);

            for (int j = 0 ; j < palavraIndex ; j++) {
                System.out.print(palavra[j] + (j == palavraIndex - 1 ? "" : " ")); //se j chegou ao final da frase, nao da espaco, caso ainda nao tenha chegado, espaca e printa a proxima palavra
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = sc.nextInt();
        sc.nextLine();
        String []frase = new String[N];

        for (int i = 0 ; i < N ; i++) {
            frase[i] = sc.nextLine();
        }

        checkStrings(N, frase);

        sc.close();
    }
}
