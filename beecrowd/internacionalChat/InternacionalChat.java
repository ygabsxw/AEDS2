import java.util.Scanner;

public class InternacionalChat {

    private static boolean idiomaChat (int qtdPessoas, String []idioma) {
        boolean idiomasIguais = true;
        
        for (int i = 0 ; i < qtdPessoas - 1 ; i++) {
            if (!(idioma[i].equals(idioma[i + 1]))) {
                idiomasIguais = false;
                i = qtdPessoas;
            }
        }

        return idiomasIguais;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdChats = sc.nextInt();
        sc.nextLine();

        for (int i = 0 ; i < qtdChats ; i++) {
            int qtdPessoas = sc.nextInt();
            sc.nextLine();

            String []idioma = new String[qtdPessoas];

            for (int j = 0 ; j < qtdPessoas ; j++) {
                idioma[j] = sc.nextLine();
            } 
            
            String linguaChat = idiomaChat(qtdPessoas, idioma) ? idioma[0] : "ingles";
            System.out.println(linguaChat);
        
        }
        sc.close();
    }
}
