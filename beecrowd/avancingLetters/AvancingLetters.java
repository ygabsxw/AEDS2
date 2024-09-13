import java.util.Scanner;

public class AvancingLetters {

    private static int operacoes (String palavraInicial, String palavraFinal) {
        int qtdMov = 0;
        int tam = palavraInicial.length();

        if (!(palavraInicial.equals(palavraFinal))) {
            StringBuilder palavraAtual = new StringBuilder(palavraInicial);
            
            for (int i = 0 ; i < tam ; i++) {
                while (palavraAtual.charAt(i) != palavraFinal.charAt(i)) {
                    palavraAtual.setCharAt(i, (char) (palavraAtual.charAt(i) + 1));
                    qtdMov++;
                }
            }
        }

        return qtdMov;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdPalavras = sc.nextInt();
        sc.nextLine();

        for (int i = 0 ; i < qtdPalavras ; i++) {
            String []palavra = sc.nextLine().split(" ");
            String palavraInicial = palavra[0];
            String palavraFinal = palavra[1];

            int mov = operacoes(palavraInicial, palavraFinal);
            System.out.println(mov);
        }

        sc.close();
    }
}
