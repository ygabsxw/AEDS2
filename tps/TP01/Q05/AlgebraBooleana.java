package tps.TP01.Q05;
import java.util.Scanner;

public class AlgebraBooleana {
    private static String trocaBinaria(int[] valoresBinarios, String booleana) {
        String troca = "";

        for (int i = 0 ; i < booleana.length() ; i++) {
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
        }

        return troca;
    }

    private static String funcaoNot(String booleana) {
        String not = "";

        for (int i = 0 ; i < booleana.length() ; i++) {
            if (booleana.charAt(i) == 'n' && (booleana.charAt(i + 4) == '1' || booleana.charAt(i + 4) == '0')) {
                not += booleana.charAt(i + 4) == '1' ? 0 : 1; //se for 1 vira 0, se for 0 vira 1
                i += 5;
            } else {
                not += booleana.charAt(i);
            }
        }

        return not;
    }

    private static String funcaoAnd(String booleana) {
        String and = ""; //and(A,B,C,D)

        for (int i = 0 ; i < booleana.length() ; i++) {
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
        }
        
        return and;
    }

    private static String funcaoOr(String booleana) {
        String or = ""; //or(A,B,C,D)

        for (int i = 0 ; i < booleana.length() ; i++) {
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
        }
        
        return or;
    }

    private static String contaParenteses(String booleana) {
        int operacao = 0;

        for(int i = 0 ; i < booleana.length() ; i++) {
            if(booleana.charAt(i) == '(') {
                operacao++;
            }
        }

        char[] funcao = new char[operacao];

        for (int i = 0 ; i < booleana.length() - 2; i++) {
            if(booleana.charAt(i + 2) == 't') { //se for not
                funcao[--operacao] = 'n';
            } else if(booleana.charAt(i + 2) == 'd') { //se for and
                funcao[--operacao] = 'a';
            } else if (booleana.charAt(i + 1) == 'r') { //se for or
                funcao[--operacao] = 'o';
            } 
        }

        for (int i = 0 ; i < funcao.length ; i++) {
            if(funcao[i] == 'n') {
                booleana = funcaoNot(booleana);
            } else if(funcao[i] == 'a') {
                booleana = funcaoAnd(booleana);
            } else {
                booleana = funcaoOr(booleana);
            }
        }

        return booleana;
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

            booleana = trocaBinaria(valoresBinarios, booleana);
            
            booleana = contaParenteses(booleana);

            System.out.println(booleana);

            qtdValoresB = sc.nextInt();
        }
        sc.close();
    }
}
