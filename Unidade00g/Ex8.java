/*
 Autor- Allan 
 Objetivo:• Faça um programa que leia a nota de 5 alunos e mostre na tela a média 
das mesmas
 */
import java.util.Scanner;
public class Ex8 {
     public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
    double []nota=new double[5];
        double media=0;
    for(int c=0; c<5;c++)
    {
        nota[c]=sc.nextDouble();
        media+=nota[c];
    }
    media=media/5;
System.out.println("A media obtida foi de "+media+".");

    }
}
