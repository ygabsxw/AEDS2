import java.util.Scanner;

public class Alien {
    private static void qtdVogais(String vogaisAlien, String frases) {
        int vogal = 0;

        for(int j = 0 ; j < vogaisAlien.length() ; j ++) {      
            for(int i = 0 ; i < frases.length() ; i++) {
                if(vogaisAlien.charAt(j) == frases.charAt(i)) {
                    vogal++;
                }
            }         
        }
        System.out.println(vogal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNextLine()) {
            String vogaisAlien = sc.nextLine();
            String frases = sc.nextLine();

            qtdVogais(vogaisAlien, frases);
        }

        sc.close();
    }
}
