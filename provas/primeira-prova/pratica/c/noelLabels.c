#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void comportamento (int qtdCriancas, char *nomeCrianca[]) {
    int bomComportamento = 0;
    int malComportamento = 0;

    for (int i = 0 ; i < qtdCriancas ; i++) {
        if(nomeCrianca[i][0] == '+') 
            bomComportamento++;
        else 
            malComportamento++;
    }

    printf("\nSe comportaram: %d | Nao se comportaram: %d", bomComportamento, malComportamento);
}

void printaCriancas (int qtdCriancas, char *nomeCrianca[]) {
    for (int i = 0 ; i < qtdCriancas ; i++) 
        printf("%s\n", nomeCrianca[i] + 2);
    
}

void swap(int i, int j, char *nomeCrianca[]) {
    char *aux = nomeCrianca[i];
    nomeCrianca[i] = nomeCrianca[j];
    nomeCrianca[j] = aux;
}

void ordemAlfabetica (int qtdCriancas, char *nomeCrianca[]) {
    for (int i = 0 ; i < qtdCriancas ; i++) {
        for (int j = i + 1 ; j < qtdCriancas ; j++) {
            if(strcmp(nomeCrianca[i] + 2, nomeCrianca[j] + 2) > 0 )
                swap(i, j, nomeCrianca);
            else if ((strcmp(nomeCrianca[i] + 2, nomeCrianca[j] + 2) == 0) && (strcmp(nomeCrianca[i] + 3, nomeCrianca[j] + 3) > 0)) 
                swap(i, j, nomeCrianca);
            else if ((nomeCrianca[i][2] == nomeCrianca[j][2]) && (nomeCrianca[i][3] == nomeCrianca[j][3]) && (nomeCrianca[i][4] > nomeCrianca[j][4]))
                swap(i, j, nomeCrianca);
        }
    }
    
    printaCriancas(qtdCriancas, nomeCrianca);
}

void escreveNome (int qtdCriancas, char *nomeCrianca[]) {
    for (int i = 0 ; i < qtdCriancas ; i++) {
        nomeCrianca[i] = (char *)malloc(100 * sizeof(char));
        scanf(" %[^\n\r]", nomeCrianca[i]);
    }
}

int main () {
    int qtdCriancas;
    char *nomeCrianca[22];
    
    scanf("%d", &qtdCriancas);

    escreveNome(qtdCriancas, nomeCrianca);

    ordemAlfabetica(qtdCriancas, nomeCrianca);

    comportamento(qtdCriancas, nomeCrianca);

    for (int i = 0; i < qtdCriancas; i++) 
        free(nomeCrianca[i]);
    

    return 0;
}