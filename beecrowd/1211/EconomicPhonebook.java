import java.util.*;

public class EconomicPhonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int listasTelefonicas = sc.nextInt();
            sc.nextLine();
            String[] telefones = new String[listasTelefonicas];

            for (int i = 0 ; i < listasTelefonicas ; i++) {
                telefones[i] = sc.nextLine();
            }

            int mesmosCaracter = calcularEconomia(listasTelefonicas, telefones);

            System.out.println(mesmosCaracter);

        }

        sc.close();
    }

    public static int calcularEconomia(int tam, String[] telefones) {
        int economia = 0;

        for (int i = 1; i < tam; i++) {
            String atual = telefones[i];
            String anterior = telefones[i - 1];
            int prefixoComum = calcularPrefixoComum(atual, anterior);
            economia += prefixoComum;
        }

        return economia;
    }

    public static int calcularPrefixoComum(String atual, String anterior) {
        int tamanhoComum = 0;

        for (int i = 0 ; i < atual.length() && i < anterior.length() ; i++) {
            if (atual.charAt(i) == anterior.charAt(i)) {
                tamanhoComum++;
            } else {
                break;
            }
        }

        return tamanhoComum;
    }
}
