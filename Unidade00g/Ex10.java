/*
 Autor- Allan 
 Objetivo:
• • Faça um programa que leia um número inteiro N e mostre na tela os N 
primeiros números inteiros ímpares.

 */
import java.util.Scanner;
public class Ex10 {
    public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
   int contador=sc.nextInt();
   int numeroImpar=1;
   while (contador>0)
   {
    System.out.println(numeroImpar);
    numeroImpar+=2;
    contador--;
   } 
    }
}
