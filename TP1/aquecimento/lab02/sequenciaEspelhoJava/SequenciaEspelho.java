import java.util.Scanner;

public class SequenciaEspelho {
    private static String espelho (int num1, int num2) {
        String numFinal = "";
        
        
        for(int i = num1 ; i <= num2 ; i++) {
            numFinal += i;
        }

        int tam = numFinal.length();

        for(int i = 0; i < tam ; i++) {
            numFinal += numFinal.charAt(tam - 1 -i);
        }

        return numFinal;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    
        while(sc.hasNextLine()) {

            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            sc.nextLine();

            System.out.println(espelho(num1, num2));           
        }
        sc.close();
    }
    
}