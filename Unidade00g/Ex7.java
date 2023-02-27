/*
 Autor- Allan 
 Objetivo:
• Seja uma partida de futebol, leia os números de gols do mandante e do 
visitante e imprima quem foi o vencedor ou se foi empate.

 */
import java.util.Scanner;
import java.lang.Math;
public class Ex7 {
    public static void efetuaCalculo(double x, double y)//recebe a função com o menor número primeiro.
    {
        System.out.println(Math.pow(x,3));
        System.out.println(Math.log(y)/Math.log(x));// Usando o princípio que log b(n) = log e(n) / log e(b).
    }
    public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
    double numA, numB;
    numA=sc.nextDouble();
    numB=sc.nextDouble();
    if(numA>numB)
    {
        efetuaCalculo(numB,numA);//chama a função com o menor valor primeiro
    }
    else if (numB>numA)
    {
        efetuaCalculo(numA, numB);
    }
    else
    {
        System.out.println("Parâmetro não informado para números iguais.");
    }
}
}
