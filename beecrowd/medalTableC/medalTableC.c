#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void novaOrdem (int qtdPaises, char *Paises[], int ouro[], int prata[], int bronze[]) {
    for (int i = 0 ; i < qtdPaises ; i++) {
        printf("%s %d %d %d\n", Paises[i], ouro[i], prata[i], bronze[i]);
    }
}

void swap(int i, int j, char *Paises[], int ouro[], int prata[], int bronze[]) {
    char *auxPaises = Paises[i];
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

void ordemMedalhas (int qtdPaises, char *Paises[], int ouro[], int prata[], int bronze[]) {
    
    for (int i = 0 ; i < qtdPaises ; i++) {
        for (int j = i + 1 ; j < qtdPaises ; j++) {
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

void escrevePaises (int qtdPaises, char *Paises[50], int ouro[], int prata[], int bronze[]) {
    for (int i = 0 ; i < qtdPaises ; i++) {
        Paises[i] = (char *)malloc(50 * sizeof(char));

        scanf(" %[^\n] %d %d %d", Paises[i], &ouro[i], &prata[i], &bronze[i]);
    }
}

int main () {
    int qtdPaises;
    char *Paises[50];
    int ouro[50];
    int prata[50];
    int bronze[50];

    scanf("%d", &qtdPaises);
    
    escrevePaises(qtdPaises, Paises, ouro, prata, bronze);

    ordemMedalhas(qtdPaises, Paises, ouro, prata, bronze);

    for (int i = 0 ; i < qtdPaises ; i++) {
        free(Paises[i]);
    }

    return 0;
}