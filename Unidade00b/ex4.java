import java.util.Scanner;
public class ex4 {
    public static void recebeArray(int array[])
    {   int menor, maior;
        menor=array[0];
        maior=array[0];
        int contador=0;
        for (int c=1;c<array.length;c++)
        {   if(maior<array[c])
            {
            maior=array[c];
            contador++;
            continue;//caso o maior número até este momento seja menor que o maior já registrado, não fará a comparação com o menor elemento
            
            }
            if(menor>array[c])
            {
            menor=array[c];
            contador++;
        }
        }  
        System.out.printf("O maior número é %d e o menor é %d\n",maior, menor);
    System.out.println(contador);
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