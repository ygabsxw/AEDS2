import java.util.Scanner;

public class CutOffRounder {

    private static String igualandoOsZeros (String aux, int maxLen) {
        while (aux.length() < maxLen) {
            aux += "0";
        }

        return aux;
    }

    private static int rounder (String num, String cutoff) {
        String []numSplit = num.split("\\.");
        String []cutSplit = cutoff.split("\\.");
        int numRounded; 

        if ((numSplit.length == 2)) {
            String parteInteira = numSplit[0];
            String parteDecimal = numSplit[1];

            if (parteInteira.isEmpty()) parteInteira = "0";
            if (parteDecimal.isEmpty()) parteDecimal = "0";
            
            String cut = cutSplit.length == 2 ? cutSplit[1] : "0";
            if (cut.isEmpty()) cut = "0";


            int maxLen = Math.max(parteDecimal.length(), cut.length());
            parteDecimal = igualandoOsZeros(parteDecimal, maxLen);
            cut = igualandoOsZeros(cut, maxLen);

            int inteiroInt = Integer.parseInt(parteInteira);
            int decimalInt = Integer.parseInt(parteDecimal);

            int cutInt = Integer.parseInt(cut);
            
            if (decimalInt >= cutInt) {
                numRounded = inteiroInt + 1;
            } else {
                numRounded = inteiroInt;
            }
        } else {
            numRounded = Integer.parseInt(numSplit[0]);
        }

        return numRounded;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num;
        String cutoff;
        int numRounded;


        while (sc.hasNextLine()) {
            num = sc.nextLine();
            cutoff = sc.nextLine();

            numRounded = rounder(num, cutoff);
            System.out.println(numRounded);
        }

        sc.close();
    }
}
