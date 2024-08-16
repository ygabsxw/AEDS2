#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

void sorteio (char *palavra, int i, char letraAntiga, char letraNova) {
    int tam = strlen(palavra);
    
    if (i < tam) {
        if(palavra[i] == letraAntiga) {
            palavra[i] = letraNova;    
            sorteio(palavra, i + 1, letraAntiga, letraNova);
        }
    } 

}

int main () {
    char palavra[5000];
    srand(4);
    char letraAntiga = 'a' + (abs(rand()) % 26);
    char letraNova = 'a' + (abs(rand()) % 26);

    scanf(" %[^\n\r]", palavra);

    while (strcmp(palavra, "FIM")) {
        sorteio(palavra, 0, letraAntiga, letraNova);
        printf("%s\n", palavra);
        

        scanf(" %[^\n\r]", palavra);
    }

    return 0;
}