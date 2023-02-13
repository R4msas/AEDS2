import java.util.Scanner;

public class nivEx2 
{

   public static boolean recebeOArray(int array[], int numeroRecebido)
    {
        boolean resposta = false;
        for(int c=0; c<numeroRecebido; c++)
        {
            if (array[c] == numeroRecebido)
        {
            resposta = true;
            break;
        }
        }
        return resposta;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int numeroRecebido;
        for (int c = 0; c < 10; c++) 
        {
            array[c] = sc.nextInt();
        }
        numeroRecebido = sc.nextInt();
        System.out.println(recebeOArray(array, numeroRecebido));

    }

}
