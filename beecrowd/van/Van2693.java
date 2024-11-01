import java.util.*;

public class Van2693 {

    private static void swap (String []name, char []regiao, int []distancia, int i, int j) {
        String sAux = name[j];
        name[j] = name[i];
        name[i] = sAux;

        char cAux = regiao[j];
        regiao[j] = regiao[i];
        regiao[i] = cAux;

        int iAux = distancia[j];
        distancia[j] = distancia[i];
        distancia[i] = iAux;
    }

    private static void sort(String []name, char []regiao, int []distancia, int qtd) {
        for (int i = 0 ; i < qtd ; i++) {
            int menor = i;
            for (int j = i + 1 ; j < qtd ; j++) {
                if(name[menor].compareTo(name[j]) > 0 && distancia[menor] == distancia[j]) {
                    menor = j;
                }
                
            }
            if (menor != i) {
                swap(name, regiao, distancia, i, menor);
            }
        }
    }

    private static void rota (String []name, char []regiao, int []distancia, int qtd) {
        for (int i = 0 ; i < qtd ; i++) {
            int menor = i;
            for (int j = i + 1 ; j < qtd ; j++) {
                if (distancia[j] < distancia[menor]) {
                    menor = j;
                }
            }
            if (menor != i) {
                swap(name, regiao, distancia, i, menor);
            }
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        while(sc.hasNextInt()) {
            int qtdAlunos = sc.nextInt();
            sc.nextLine();

            String []name = new String[qtdAlunos];
            char []regiao = new char[qtdAlunos];
            int []distancia = new int[qtdAlunos];

            for (int i = 0 ; i < qtdAlunos ; i++) {
                name[i] = sc.next();
                regiao[i] = sc.next().charAt(0);
                distancia[i] = sc.nextInt();
                // sc.nextLine();
            }

            sort(name, regiao, distancia, qtdAlunos);

            rota(name, regiao, distancia ,qtdAlunos);

            for (int i = 0 ; i < qtdAlunos ; i++) {
                System.out.println(name[i]);
            }
        }

        sc.close();
    }
}
