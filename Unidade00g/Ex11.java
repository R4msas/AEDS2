/*
 Autor- Allan 
 Objetivo:
Faça um programa que leia um número inteiro N e mostre na tela os N 
primeiros números da sequência 1, 5, 12, 16, 23, 27 34

 */
import java.util.Scanner;
public class Ex11 {
    public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
   int contador=sc.nextInt();
   int soma=1;//
   for(int c=0;c<contador;c++)
   {
    if (c==0)
    {
        System.out.println(soma);
    }
    else if(c%2==0)
    {
        soma+=7;
        System.out.println(soma);
    }
    else
    {
        soma+=4;
        System.out.println(soma);
    }
   }

    }
}
