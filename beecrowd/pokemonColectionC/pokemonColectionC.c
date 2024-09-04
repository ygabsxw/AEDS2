#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int checkPokemons (int qtdPokemons, char *pokemons[100]) {
    int realCaptured = qtdPokemons;
    bool alreadyCaptured[qtdPokemons];
    for (int i = 0 ; i < qtdPokemons ; i++) {
        if (!alreadyCaptured[i]) {
            for (int j = i + 1 ; j < qtdPokemons ; j++) {
                if((strcmp(pokemons[i], pokemons[j]) == 0) && !alreadyCaptured[j]) {
                    realCaptured--;
                    alreadyCaptured[j] = true;
                }
            }
        }      
    }

    return realCaptured;
}

void capturedPokemons (int qtdPokemons, char *pokemons[100]) {
    
    for (int i = 0 ; i < qtdPokemons ; i++) {
        pokemons[i] = (char *)malloc(100 * sizeof(char));
        scanf(" %[^\n\r]", pokemons[i]);
    }
}

int main () {
    int qtdPokemons;
    char *pokemons[100];

    scanf("%d", &qtdPokemons);

    capturedPokemons(qtdPokemons, pokemons);

    int pokemonsDisponiveis = checkPokemons(qtdPokemons, pokemons);

    int faltam = 151 - pokemonsDisponiveis;

    printf("Falta(m) %d pomekon(s).", faltam);

    for (int i = 0; i < qtdPokemons; i++) {
        free(pokemons[i]);
    }

    return 0;
}