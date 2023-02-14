import java.util.Scanner;

public class ex3 {
    public static void recebeArray(int array[])
    {   int menor, maior;
        menor=array[0];
        maior=array[0];
        for (int c=1;c<array.length;c++)
        {   if(maior<array[c])
            {
            maior=array[c];
            }
            if(menor>array[c])
            {
            menor=array[c];
            }
        }  
        System.out.printf("O maior número é %d e o menor é %d",maior, menor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[] = new int[10];
        for (int c = 0; c < 10; c++) 
        {
            array[c] = sc.nextInt();
        }
        recebeArray(array);
    }
}
