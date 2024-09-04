import java.util.Scanner;
import java.util.HashSet;

public class pokemonColectionJava {
    private static int checkPokemons(int qtdPokemons, String[] pokemons) {
        HashSet<String> uniquePokemons = new HashSet<>();

        for (int i = 0; i < qtdPokemons; i++) {
            uniquePokemons.add(pokemons[i]); 
        }

        return uniquePokemons.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdPokemons = sc.nextInt();
        sc.nextLine();
        String[] pokemons = new String[qtdPokemons];

        for (int i = 0 ; i < qtdPokemons ; i++) {
            pokemons[i] = sc.nextLine();
        }

        int pokemonsDisponiveis = checkPokemons(qtdPokemons, pokemons);

        int faltam = 151 - pokemonsDisponiveis;

        System.out.println("Falta(m) " + faltam + " pomekon(s).");

        sc.close();
    }
}
