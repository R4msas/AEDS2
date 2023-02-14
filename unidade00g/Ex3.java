
/*
Autor-Allan 
• Leia 10 números inteiros, selecione o maior e imprima seu valor na tela.
*/
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int maiorNumero;
        for (int c = 0; c < 10; c++) {
            array[c] = sc.nextInt();
        }
        maiorNumero = array[0];
        for (int c = 1; c < 10; c++) {
            if (array[c] > maiorNumero) {
                maiorNumero = array[c];
            }

        }

        System.out.println("maior número é " + maiorNumero);

    }
}