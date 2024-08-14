#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

int maiusculas (char *palavra, int i) {
    int count = 0;
    int length = srtlen(palavra);

    if(palavra[i] >= 'A' && palavra [i] <= 'Z') {
        count+1;
        maiusculas(palavra, i+1);
    }
}

int main () {

    return 0;
}