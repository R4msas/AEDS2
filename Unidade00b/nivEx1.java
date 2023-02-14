import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int numeroRecebido;
        for (int c = 0; c < 10; c++) {
            array[c] = sc.nextInt();
        }
        numeroRecebido = sc.nextInt();
        boolean resposta = false;
        for (int c = 0; c < 10; c++) {
            if (array[c] == numeroRecebido) {
                resposta = true;
                break;
            }
        }
        System.out.println("Existe o valor?" + resposta);
    }

} // knuth matematica concreta
