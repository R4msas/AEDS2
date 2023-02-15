/*
 Autor- Allan 
 Objetivo:
•Faça um programa que leia n números e mostre quais deles são maiores 
que a média
 */
import java.util.Scanner;
public class Ex14 {
    public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
    double media=0;   
    int n=sc.nextInt();
    int [] array=new int[n];
    for(int c=0;c<n;c++)
    {
        array[c]=sc.nextInt();
        media+=array[c];
    }
    media=media/n;
    for(int c=0;c<n;c++)
    {
        if(array[c]>media)
        {
            System.out.println("Numero acima da media"+array[c]);
        }
    }
}
}