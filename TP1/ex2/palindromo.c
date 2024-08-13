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
    char *palavra;

    scanf("%s", palavra);

    while (strcmp(palavra, "FIM")) {
        if (ehPalindromo(palavra)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf("%s", palavra);
    }

    return 0;
}