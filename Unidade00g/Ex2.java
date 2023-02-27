/*
 Autor- Allan 
 Objetivo:
• Leia 10 números inteiros, selecione o menor e o maior e imprima os seus 
respectivos valores na tela.

 */
import java.util.Scanner;

public class Ex2 {
   public static void main (String[] args)
   {
    Scanner sc= new Scanner(System.in);
    int array[]= new int[3];
    for(int c=0;c<3;c++)
    {
        array[c]=sc.nextInt();
        
    }
    int menor =array[0];
    int maior = array[0];
    for(int c=1;c<3;c++)
    {
    if (array[c]>maior)
    {
        maior=array[c];
    }
    if (array[c]<menor)
    {
        menor=array[c];
    }
}
System.out.printf("O maior é %d e o menor é  %d", maior, menor);
}

}
