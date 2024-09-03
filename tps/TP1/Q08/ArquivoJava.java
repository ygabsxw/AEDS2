package tps.TP1.Q08;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.BufferedReader;

public class ArquivoJava {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        try {
            RandomAccessFile arq = new RandomAccessFile("archive.txt", "rw");
                for(int i = 0; i < n; i++){
                    Double a = sc.nextDouble();
                    arq.writeDouble(a);
                }

                arq.close();
            arq = new RandomAccessFile("archive.txt", "r");
            long pos = arq.length();
            
            while(pos >=0){
                pos-=8;
                arq.seek(pos);
                Double num = arq.readDouble();
                int numInt = num.intValue(); 

                if (num - numInt == 0) {
                    System.out.println(numInt); 
                } else {
                    System.out.println(num); 
                }
            }
            
            arq.close();
        }
        catch (Exception e) {}

       sc.close();
    }
}
