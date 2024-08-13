#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

bool ehPalindromo (char *palavra) {
    bool ehPalin = true;
    int length = strlen(palavra);
    
    for (int i = 0 ; i < length / 2 ; i++) {
        if (palavra[i] != palavra[length - 1 - i]) {
            ehPalin = false;
            break;
        }
    }

    return ehPalin;
}

char* escreve () {
    char *n = (char *) malloc(100 * sizeof(char));
    if (n == NULL) {
        printf("Erro de alocação de memória.\n");
        exit(1);
    }
    do {
        scanf("%s", n); 
    } while (&n != 'FIM');
    
    return n;
}

int main () {
    char *palavra = escreve();
    if (ehPalindromo(palavra)) {
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }
    
    free(palavra);
    return 0;
}