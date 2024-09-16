import java.util.Scanner;

public class StacksOfParallelepipeds {

    private static void empilhaBloco(int[] blocos) {
        int[] bloco1 = {blocos[0], blocos[1], blocos[2]}; //dimensoes bloco1
        int[] bloco2 = {blocos[3], blocos[4], blocos[5]}; //dimensoes bloco2

        int resultado = 0;
        boolean bloco1no2 = false, bloco2no1 = false;

        for (int i = 0; i < 3; i++) {
            int a1 = bloco1[i];
            int b1 = bloco1[(i + 1) % 3];
            int c1 = bloco1[(i + 2) % 3];

            for (int j = 0; j < 3; j++) {
                int a2 = bloco2[j];
                int b2 = bloco2[(j + 1) % 3];
                int c2 = bloco2[(j + 2) % 3];

                int[][] faces1 = {{a1, b1}, {a1, c1}, {b1, c1}}; //possiveis faces
                int[][] faces2 = {{a2, b2}, {a2, c2}, {b2, c2}}; //possiveis faces

                for (int[] face1 : faces1) {
                    for (int[] face2 : faces2) {
                        int minFace1 = Math.min(face1[0], face1[1]);
                        int maxFace1 = Math.max(face1[0], face1[1]);
                        int minFace2 = Math.min(face2[0], face2[1]);
                        int maxFace2 = Math.max(face2[0], face2[1]);

                        if (minFace2 > minFace1 && maxFace2 > maxFace1) {
                            bloco1no2 = true;
                        }
                        if (minFace1 > minFace2 && maxFace1 > maxFace2) {
                            bloco2no1 = true;
                        }
                    }
                }
            }
        }

        if (bloco1no2 && bloco2no1) {
            resultado = 3;
        } else if (bloco1no2) {
            resultado = 1;
        } else if (bloco2no1) {
            resultado = 2;
        } else {
            resultado = 0;
        }

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdCasos = sc.nextInt();

        for (int i = 0 ; i < qtdCasos ; i++) {
            int[] blocos = new int[6];
            for(int j = 0 ; j < 6 ; j++) {
                blocos[j] = sc.nextInt();
            }
            empilhaBloco(blocos);
        }
        sc.close();
    }
}
