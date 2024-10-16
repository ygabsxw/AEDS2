#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>



int ultrapassagens(int qtdCorredores, int posInicial[qtdCorredores], int posFinal[qtdCorredores]) {
   int posicaoInicialCorredor[qtdCorredores];
   int qtdUltrapassagens = 0;

    // Armazena a posição inicial de cada corredor
    for (int i = 0; i < qtdCorredores; i++) {
        posicaoInicialCorredor[posInicial[i]] = i;
    }

    // Compara as posições relativas entre os corredores nas posições finais
    for (int i = 0; i < qtdCorredores; i++) {
        for (int j = i + 1; j < qtdCorredores; j++) {
            // Verifica se um corredor que estava atrás ultrapassou outro
            if (posicaoInicialCorredor[posFinal[i]] > posicaoInicialCorredor[posFinal[j]]) {
                qtdUltrapassagens++;
            }
        }
    }

    return qtdUltrapassagens;
}

int main () {
    int qtdCorredores;

    while (scanf("%d", &qtdCorredores) != EOF) {

        int posInicial[qtdCorredores];
        int posFinal[qtdCorredores];

        for (int i = 0 ; i < qtdCorredores ; i++) {
            scanf("%d", &posInicial[i]);
        }

        for (int i = 0 ; i < qtdCorredores ; i++) {
            scanf("%d", &posFinal[i]);
        }

        int minUltrapassagens = ultrapassagens(qtdCorredores, posInicial, posFinal);

        printf("%d\n", minUltrapassagens);

    }

    
    return 0;
}