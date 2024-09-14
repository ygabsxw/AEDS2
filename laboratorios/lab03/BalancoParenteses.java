package laboratorios.lab03;
import java.util.Scanner;

public class BalancoParenteses {    
    private static boolean contaParenteses(String expressao) {
        int tam = expressao.length();
        int qtdParentese = 0;
        boolean parentesesCorretos = false;

        for(int i = 0 ; i < tam ; i++) {
            if(expressao.charAt(i) == '(') {
                qtdParentese++;
            } else if(expressao.charAt(i) == ')') {
                qtdParentese--;
            }
        
            if(qtdParentese < 0) {
                parentesesCorretos = false;
                i = tam;
            }
        }

        if(qtdParentese == 0) {
            parentesesCorretos = true;
        }

        return parentesesCorretos;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String expressao = sc.nextLine();

        while(!(expressao.length() == 3 && expressao.charAt(0) == 'F' && expressao.charAt(1) == 'I' && expressao.charAt(2) == 'M')) {
            if(contaParenteses(expressao)) {
                System.out.println("correto");
            } else {
                System.out.println("incorreto");
            }

            expressao = sc.nextLine();
        }

        sc.close();
    }
}
