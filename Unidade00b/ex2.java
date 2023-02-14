import java.util.Scanner;

public class ex2 {

    public static boolean recebeOArray(int array[], int numeroRecebido,int tamanhoDoArray) {
        boolean resposta = false;
        int meio, direita =tamanhoDoArray , esquerda = 0;
        while (esquerda != direita) {
         
            meio = (esquerda + direita) / 2;
            if (numeroRecebido == array[meio]) {
                resposta = true;
                esquerda = direita;
            } else if (numeroRecebido > array[meio]) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return resposta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int numeroRecebido;
        for (int c = 0; c < 10; c++) {
            array[c] = sc.nextInt();
        }
        numeroRecebido = sc.nextInt();
        System.out.println(recebeOArray(array, numeroRecebido,10));

    }

}