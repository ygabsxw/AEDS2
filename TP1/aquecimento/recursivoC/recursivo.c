#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

int maiusculas (char *palavra, int i, int count) {
    int length = strlen(palavra);

    if (i >= length) {
        return count;
    } // retorna o contagem de maiusculas tirando ela da recursividade

    if (palavra[i] >= 'A' && palavra[i] <= 'Z') {
        count++;  
    }

    return maiusculas(palavra, i + 1, count);

}

int main () {
    char palavra[5000];
    int i = 0;
    int c = 0;
    
    scanf(" %[^\n\r]", palavra);
    while(strcmp(palavra, "FIM")) {
        printf("%d\n", maiusculas(palavra, i, c));
        scanf(" %[^\n\r]", palavra);
    }

    return 0;
}
