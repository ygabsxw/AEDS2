import java.util.Scanner;


public class SequenciaEspelho {
    private static String espelho (String num1, String num2) {
        char [] numFinal = new char[100];
        char start = num1.charAt(0); 
        char end = num2.charAt(0);
        int i = 0;

        while(start <= end) {

            numFinal[i] = start;
            i++;
            start++;
        }

        return new String(numFinal);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        
        if(sc.hasNextLine()) {
            for(int i = 0 ; i < 3 ; i++) {
                
                System.out.println(espelho(num1, num2));
                
                num1 = sc.nextLine();
                num2 = sc.nextLine();
                
            } 
        }

        sc.close();
    }
    
}