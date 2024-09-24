#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

void troca (char *palavra, int i, char letraAntiga, char letraNova) {
    int tam = strlen(palavra);
    
    if (i < tam) {
        if(palavra[i] == letraAntiga) {
            palavra[i] = letraNova;    
            troca(palavra, i + 1, letraAntiga, letraNova);
        }
    } 

}

int main () {
    char palavra[5000];
    srand(4);
    scanf(" %[^\n\r]", palavra);
    
    char letraAntiga = 'a' + (abs(rand()) % 26);
    char letraNova = 'a' + (abs(rand()) % 26);

    while (strcmp(palavra, "FIM")) {   
        
        troca(palavra, 0, letraAntiga, letraNova);
        printf("%s\n", palavra);
        

        scanf(" %[^\n\r]", palavra);
    }
    

    return 0;
}