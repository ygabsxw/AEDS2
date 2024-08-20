#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

int main() {
    FILE *file = fopen("archive.txt", "wb");
    int n, numInt;
    double num;
    scanf("%d", &n);
  
    for(int i = 0 ; i < n ; i++) {    
        scanf("%lf", &num);    
        fwrite(&num, sizeof(double), 1, file);
    }

    fclose(file);

    file = fopen("archive.txt", "rb");
    
    fseek(file, 0, SEEK_END);
    long pos = ftell(file);
    fseek(file, 0, SEEK_SET);

    while(pos >= sizeof(double)) {
        pos -= sizeof(double);
        fseek(file, pos, SEEK_SET);
        fread(&num, sizeof(double), 1, file);
        
        numInt = (int)num;

        if (numInt - num == 0) {
            printf("%d\n", numInt);
        } else {
            printf("%g\n", num);
        }
    }

    fclose(file);


    return 0;
}