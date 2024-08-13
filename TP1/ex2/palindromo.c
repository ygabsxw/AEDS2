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
            i = length;
        }
    }

    return ehPalin;
}

int main () {
    char palavra[5000];
    
    scanf(" %[^\n\r]", palavra);

    while (strcmp(palavra, "FIM")) {
        if (ehPalindromo(palavra)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf(" %[^\n\r]", palavra);
    }

    getchar();
    return 0;
}