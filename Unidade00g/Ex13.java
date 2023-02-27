/*
 Autor- Allan 
 Objetivo:
Faça um programa que leia um número inteiro n e mostre na tela o n-ésimo 
termo da sequência de Fibonacci
 */
import java.util.Scanner;
public class Ex13 {
    public static void Fibonnaci(int numRecebido)
    {   int primeiroNum=0, segundoNum=1, fib=0;//
        if(numRecebido==1)
            {
                System.out.println(segundoNum);
                return;
            }
        for(int c=1;c<numRecebido;c++)
        {
            fib=primeiroNum+segundoNum;
            primeiroNum=segundoNum;
            segundoNum=fib;
        }
        
        System.out.println(fib);
    }
     public static void main(String[]args)
     {
        Scanner sc = new Scanner(System.in);
        int numRecebido=sc.nextInt();
        Fibonnaci(numRecebido);
     }  
}
