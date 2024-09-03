package tps.TP1.Q14;
import java.util.Scanner;

public class AlgebraBooleanaRecursivo {
    private static String trocaBinaria(int[] valoresBinarios, String booleana, String troca, int i) {

        if (i < booleana.length()) {
            if (booleana.charAt(i) != ' ') {
                if (booleana.charAt(i) == 'A') {
                    troca += valoresBinarios[0]; //substitui o A pelo primeiro valor binario
                } else if (booleana.charAt(i) == 'B') {
                    troca += valoresBinarios[1]; //substitui o B pelo segundo valor binario
                } else if (booleana.charAt(i) == 'C') {
                    troca += valoresBinarios[2]; //substitui o C (caso tenha) pelo terceiro valor binario
                } else {
                    troca += booleana.charAt(i); //remove os espacos
                }
            }
            troca = trocaBinaria(valoresBinarios, booleana, troca, i + 1);
        }

        return troca;
    }

    private static String funcaoNot(String booleana, String not, int i) {

        if (i < booleana.length()) {
            if (booleana.charAt(i) == 'n' && (booleana.charAt(i + 4) == '1' || booleana.charAt(i + 4) == '0')) {
                not += booleana.charAt(i + 4) == '1' ? 0 : 1; //se for 1 vira 0, se for 0 vira 1
                i += 5;
            } else {
                not += booleana.charAt(i);
            }
            not = funcaoNot(booleana, not, i + 1);
        }

        return not;
    }

    private static String funcaoAnd(String booleana, String and, int i) {

        if (i < booleana.length()) {
            if (booleana.charAt(i) == 'a' && (booleana.charAt(i + 4) == '1' || booleana.charAt(i + 4) == '0') && (booleana.charAt(i + 6) == '1' || booleana.charAt(i + 6) == '0')) {
                if(booleana.charAt(i + 7) == ')') {
                    and += (booleana.charAt(i + 4) == '1' && booleana.charAt(i + 6) == '1') ? 1 : 0; //se ambos forem 1 continua 1, mas se algum for 0, vira 0
                    i+= 7; //passa essa operacao
                } else if (booleana.charAt(i + 9) == ')') {
                    and += (booleana.charAt(i + 4) == '1' && booleana.charAt(i + 6) == '1' && booleana.charAt(i + 8) == '1') ? 1 : 0; //se todos forem 1 continua 1, mas se algum for 0, vira 0
                    i += 9; //passa essa operacao
                } else if (booleana.charAt(i + 11) == ')') {
                    and += (booleana.charAt(i + 4) == '1' && booleana.charAt(i + 6) == '1' && booleana.charAt(i + 8) == '1' && booleana.charAt(i + 10) == '1') ? 1 : 0; //se todos forem 1 continua 1, mas se algum for 0, vira 0
                    i += 11; //passa essa operacao
                } else {
                    and += booleana.charAt(i);
                }
            } else {
                and += booleana.charAt(i);
            }
            and = funcaoAnd(booleana, and, i + 1);
        }
        
        return and;
    }

    private static String funcaoOr(String booleana, String or, int i) {

        if (i < booleana.length()) {
            if (booleana.charAt(i) == 'o' && booleana.charAt(i + 1) == 'r' && (booleana.charAt(i + 3) == '1' || booleana.charAt(i + 3) == '0') &&  (booleana.charAt(i + 5) == '1' || booleana.charAt(i + 5) == '0')) {
                if (booleana.charAt(i + 6) == ')') {
                    or += (booleana.charAt(i + 3) == '1' || booleana.charAt(i + 5) == '1') ? 1 : 0; //se algum for 1 continua 1, mas se algum for 0, vira 0
                    i += 6; //passa essa operacao
                } else if (booleana.charAt(i + 8) == ')') {
                    or += (booleana.charAt(i + 3) == '1' || booleana.charAt(i + 5) == '1' || booleana.charAt(i + 7) == '1') ? 1 : 0; //se algum for 1 continua 1, mas se algum for 0, vira 0
                    i+= 8; //passa essa operacao
                } else if (booleana.charAt(i + 10) == ')') {
                    or += (booleana.charAt(i + 3) == '1' || booleana.charAt(i + 5) == '1' || booleana.charAt(i + 7) == '1' || booleana.charAt(i + 9) == '1') ? 1 : 0; //se algum for 1 continua 1, mas se algum for 0, vira 0
                    i += 10; //passa essa operacao
                }
            } else {
                or += booleana.charAt(i);
            }
            or = funcaoOr(booleana, or, i + 1);
        }
        
        return or;
    }

    private static String contaParenteses(String booleana, int operacao) {
        String funcao = "";
        int tam = booleana.length() - 1;
    
    
        if (operacao == tam)
          funcao = booleana;
        else if (booleana.charAt(operacao) == 'n')
          funcao = funcaoNot(contaParenteses(booleana, operacao + 4), "", 0);
        else if (booleana.charAt(operacao) == 'a')
          funcao = funcaoAnd(contaParenteses(booleana, operacao + 4), "", 0);
        else if (booleana.charAt(operacao) == 'o')
          funcao = funcaoOr(contaParenteses(booleana, operacao + 3), "", 0);
        else
          funcao = contaParenteses(booleana, ++operacao);
    
        return funcao;
      }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdValoresB = sc.nextInt();
        String booleana;
        int[] valoresBinarios = new int[3];

        while(qtdValoresB != 0) {
            for(int i = 0 ; i < qtdValoresB ; i++) {
                valoresBinarios[i] = sc.nextInt();
            }

            booleana = sc.nextLine();

            booleana = trocaBinaria(valoresBinarios, booleana, "", 0);
            
            booleana = contaParenteses(booleana, 0);

            System.out.println(booleana);

            qtdValoresB = sc.nextInt();
        }
        sc.close();
    }
}
