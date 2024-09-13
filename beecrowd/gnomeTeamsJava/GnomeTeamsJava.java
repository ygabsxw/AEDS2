import java.util.Scanner;

public class GnomeTeamsJava {
    private static void teams (int qtdDuendes, String []nome, int []idade) {
        
        int qtdTeams = qtdDuendes/3;

        for (int i = 0 ; i < qtdTeams ; i++) {
            System.out.println("Time " + (i + 1));
            System.out.println(nome[i] + " " + idade[i]);                       
            System.out.println(nome[i + qtdTeams] + " " + idade[i + qtdTeams]); 
            System.out.println(nome[i + 2 * qtdTeams] + " " + idade[i + 2 * qtdTeams]); 
            System.out.println();
        }  
    }

    private static void swap (int maior, int i, String []nome, int []idade) {
        String auxNome = nome[i];
        nome[i] = nome[maior];
        nome[maior] = auxNome;

        int auxIdade = idade[i];
        idade[i] = idade[maior];
        idade[maior] = auxIdade;
    }
    
     private static void idadeDecrescente (int qtdDuendes, String []nome, int []idade) {
        for (int i = 0 ; i < qtdDuendes - 1 ; i++) {
            int maior = i;
            for (int j = i + 1 ; j < qtdDuendes ; j++) {
                if (idade[maior] < idade[j]) {
                    maior = j;
                } else if (idade[maior] == idade[j]) {
                    if (nome[maior].compareTo(nome[j]) > 0) {
                        maior = j;
                    }
                }
            }
            swap(maior, i, nome, idade);
        }

        teams(qtdDuendes, nome, idade);
     }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdDuendes = sc.nextInt();
        sc.nextLine();
        String []nome = new String[100];
        int []idade = new int[100];

        for (int i = 0 ; i < qtdDuendes ; i++) {
            nome[i] = sc.next();
            idade[i] = sc.nextInt();
            sc.nextLine();
        }

        idadeDecrescente(qtdDuendes, nome, idade);


        sc.close();
    }
}

