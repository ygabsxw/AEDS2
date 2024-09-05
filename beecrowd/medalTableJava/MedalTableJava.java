import java.util.Scanner;

public class MedalTableJava {
    private static Scanner sc = new Scanner(System.in);

    private static void novaOrdem(int qtdPaises, String[] Paises, int[] ouro, int[] prata, int[] bronze) {
        for (int i = 0; i < qtdPaises; i++) {
            System.out.println(Paises[i] + " " + ouro[i] + " " + prata[i] + " " + bronze[i]);
        }
    }

    private static void swap(int i, int j, String[] Paises, int[] ouro, int[] prata, int[] bronze) {
        String auxPaises = Paises[i];
        Paises[i] = Paises[j];
        Paises[j] = auxPaises;

        int aux = ouro[i];
        ouro[i] = ouro[j];
        ouro[j] = aux;

        aux = prata[i];
        prata[i] = prata[j];
        prata[j] = aux;

        aux = bronze[i];
        bronze[i] = bronze[j];
        bronze[j] = aux;
    }

    private static void ordemMedalhas(int qtdPaises, String[] Paises, int[] ouro, int[] prata, int[] bronze) {
        for (int i = 0; i < qtdPaises; i++) {
            for (int j = i + 1; j < qtdPaises; j++) {
                if (ouro[i] < ouro[j]) {
                    swap(i, j, Paises, ouro, prata, bronze);
                } else if (ouro[i] == ouro[j]) {
                    if (prata[i] < prata[j]) {
                        swap(i, j, Paises, ouro, prata, bronze);
                    } else if (prata[i] == prata[j]) {
                        if (bronze[i] < bronze[j]) {
                            swap(i, j, Paises, ouro, prata, bronze);
                        }
                    }
                }
            }
        }

        novaOrdem(qtdPaises, Paises, ouro, prata, bronze);
    }

    private static void escrevePaises(int qtdPaises, String[] Paises, int[] ouro, int[] prata, int[] bronze) {
        for (int i = 0; i < qtdPaises; i++) {
            Paises[i] = sc.next(); 
            ouro[i] = sc.nextInt();  
            prata[i] = sc.nextInt(); 
            bronze[i] = sc.nextInt(); 
        }
    }

    public static void main(String[] args) {
        int qtdPaises = sc.nextInt();
        String[] Paises = new String[qtdPaises];
        int[] ouro = new int[qtdPaises];
        int[] prata = new int[qtdPaises];
        int[] bronze = new int[qtdPaises];

        escrevePaises(qtdPaises, Paises, ouro, prata, bronze);

        ordemMedalhas(qtdPaises, Paises, ouro, prata, bronze);

        sc.close();
    }
}
