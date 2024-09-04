import java.util.Scanner;

public class ListaPapaiNoelJava {
    private static Scanner sc = new Scanner(System.in);

    private static void comportamento (int qtdCriancas, String[] nomeCrianca) {
        int bomComp = 0;
        int malComp = 0;
        for (int i = 0 ; i < qtdCriancas ; i++) {
            if (nomeCrianca[i].charAt(0) == '+')
                bomComp++;
            else 
                malComp++; 
        }

        System.out.println("Se comportaram: " + bomComp + " | Nao se comportaram: " + malComp);
    }

    private static void printaCriancas (int qtdCriancas, String []nomeCrianca) {
        for (int i = 0 ; i < qtdCriancas ; i++) 
            System.out.println(nomeCrianca[i].substring(2));
    }

    private static void swap (int i, int j, String[] nomeCrianca) {
        String aux = nomeCrianca[i];
        nomeCrianca[i] = nomeCrianca[j];
        nomeCrianca[j] = aux;
    }

    private static void ordemAlfabetica (int qtdCriancas, String[] nomeCrianca) {
        for (int i = 0 ; i < qtdCriancas - 1 ; i++) {
            for (int j = i + 1 ; j < qtdCriancas ; j++) {
                if (nomeCrianca[i].charAt(2) > nomeCrianca[j].charAt(2))
                    swap(i, j, nomeCrianca);
                else if ((nomeCrianca[i].charAt(2) == nomeCrianca[j].charAt(2)) && (nomeCrianca[i].charAt(3) > nomeCrianca[j].charAt(3)))
                    swap(i, j, nomeCrianca);
                else if ((nomeCrianca[i].charAt(2) == nomeCrianca[j].charAt(2)) && (nomeCrianca[i].charAt(3) > nomeCrianca[j].charAt(3)) && (nomeCrianca[i].charAt(4) > nomeCrianca[j].charAt(4)))
                    swap(i, j, nomeCrianca);
            }
        }

        printaCriancas(qtdCriancas, nomeCrianca);
    }

    private static void escreveNome(int qtdCriancas, String[] nomeCrianca) {
        for (int i = 0 ; i < qtdCriancas ; i++) 
            nomeCrianca[i] = sc.nextLine();
    }

    public static void main(String[] args) {
        
        int qtdCriancas = sc.nextInt();
        sc.nextLine();
        String []nomeCrianca = new String[qtdCriancas];

        escreveNome(qtdCriancas, nomeCrianca);

        ordemAlfabetica(qtdCriancas, nomeCrianca);

        comportamento(qtdCriancas, nomeCrianca);

        sc.close();
    }
}
