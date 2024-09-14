#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

char* correcaoNome(char nomeP1[], char nomeP2[], int tamP1, int tamP2) {
    int tam = tamP1 + tamP2;
    char* nomeCompleto = (char*) malloc(tam + 3);
    
    int j = 0;
    int i;

    for (i = 0 ; i < tamP2 ; i += 2) {
        nomeCompleto[j++] = nomeP1[i];
        nomeCompleto[j++] = nomeP1[i + 1];
        
        nomeCompleto[j++] = nomeP2[i];
        nomeCompleto[j++] = nomeP2[i + 1];
    }

    nomeCompleto[j++] = nomeP1[i++];
    nomeCompleto[j++] = nomeP1[i++];

    return nomeCompleto;
}

int main () {
    int qtdCriancas;
    char nomeP1[100];
    char nomeP2[100];

    scanf("%d", &qtdCriancas);

    for (int i = 0 ; i < qtdCriancas ; i++) {
        scanf(" %[^\n\r]", nomeP1);
        scanf(" %[^\n\r]", nomeP2);

        int tamP1 = strlen(nomeP1); 
        int tamP2 = strlen(nomeP2);

        char* nomeCrianca = correcaoNome(nomeP1, nomeP2, tamP1, tamP2);
        printf("%s\n", nomeCrianca);

        free(nomeCrianca);
    }

    return 0;
}