/*
Autor - Allan
Objetivo - 
*/
import java.util.Scanner;
public class teste2 {
    public static void main(String[]args)
    {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int contador=0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        { 
           for(int k=0;k<n;k++)
           {
               for(int l=0;l<n;l++)
               {
                for (int m=0;m<9;m++)
                {
                    contador++;
                }
               }
            }
            for (int m=0;m<5;m++)
           {
            contador++;
           }
            
            
       
        }
   }
   int f=0;
   while(f<n/2)
   {
    contador++;
   }
   System.out.println(contador);

    }
}
