import java.util.Scanner;
import java.net;

public class LeituraHTML {
    private static 

    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        String url;

        while(!(titulo.length() == 3 && titulo.charAt(0) == 'F' && titulo.charAt(1) == 'I' && titulo.charAt(2) == 'M')) {
            url = sc.nextLine();

            System.out.println();
            
            
            
            titulo = sc.nextLine();
        }

        sc.close();
    }
}
