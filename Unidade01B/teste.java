/*
Autor - Allan
Objetivo - 
*/
import java.util.Scanner;
/**
 * teste
 */
public class teste {
    

    public static void main(String[]args)
    {
    Scanner sc = new Scanner(System.in);
    int a=0;
    int n=sc.nextInt();
    for (int i = 1; i <= n; i *=2)
    {
    System.out.println("valor de i:"+i+"na iteração "+a);
    a ++;
    }
    System.out.println(a);
}
}