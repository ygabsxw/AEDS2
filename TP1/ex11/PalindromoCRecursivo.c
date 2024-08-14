#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

bool ehPalindromo(char *palavra, int i, bool ehPalin) {
    int lenght = strlen(palavra);

    if(i < lenght/2) {
        if(palavra[i] != palavra[lenght - 1 - i]) {
            ehPalin = false;
            i = lenght;
        }
    } else if (i >= lenght) {
        return ehPalin;
    }

    return ehPalindromo(palavra, i + 1, ehPalin);
}

int main () {
    char palavra[5000];
    bool ehPalin = true;

    scanf(" %[^\n\r]", palavra);

    while(strcmp(palavra, "FIM")) {
        if (ehPalindromo(palavra, 0, ehPalin)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf(" %[^\n\r]", palavra);
    }

    return 0;
}