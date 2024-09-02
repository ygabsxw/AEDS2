#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>


void combinador(char palavra1[], char palavra2[]) {
    int tam1 = strlen(palavra1); 
    int tam2 = strlen(palavra2);
    char palavraFinal[tam1+tam2+1];
    int i = 0, j = 0, k = 0;

    for( ; i < tam1 && j < tam2 ; i++, j++) {
        palavraFinal[k++] = palavra1[i];
        palavraFinal[k++] = palavra2[j];
    }

    while(i < tam1) {
        palavraFinal[k++] = palavra1[i++];
    }
    while(j < tam2) {
        palavraFinal[k++] = palavra2[j++];
    }

    palavraFinal[k] = '\0';
    printf("%s\n", palavraFinal);
    
}

int main () {
    char palavra1[500];
    char palavra2[500];

    while(scanf(" %s", palavra1) != EOF) {
        scanf(" %s", palavra2);

        combinador(palavra1, palavra2);

    }
    

    return 0;
}