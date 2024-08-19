#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

int maiusculas (char *palavra) {
    int count = 0;
    int length = strlen(palavra);

    for (int i = 0 ; i < length ; i++) {
        if(palavra[i] >= 'A' && palavra [i] <= 'Z') {
            count++;
        }
    }
    return count;
}

int main () {
    char palavra[5000];
    

    scanf(" %[^\n\r]", palavra);
    while(strcmp(palavra, "FIM")) {
        printf("%d\n", maiusculas(palavra));
        scanf(" %[^\n\r]", palavra);
    }

    return 0;
}