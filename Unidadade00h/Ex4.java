/*
 * Autor- Allan
 *Objetivo: Faça um método recursivo para cada um dos problemas abaixo
método 1
 T(0) = 1
T(1) = 2
T(n) = T(n-1) * T(n-2) - T(n-1)
método 2
T(0) = 1
T(n) = T(n-1)^2
 */
import java.util.Scanner;
import java.lang.Math;
public class Ex4 {
public static int Metodo_1(int n)
{

int funcao;
  
    if(n==0)
    {
    funcao =1;
    }
    else if (n==1)
    {
    funcao =2;
    }
    else
   {
       
    int aux2=Metodo_1(n-2);
    int aux1=Metodo_1(n-1);
    funcao=(aux2*aux1)-aux1;
    }
    
    return funcao;
}
public static double Metodo_2(int n)
{
double funcao;
if (n==0)
{
    funcao=1;
}
else if(n>0)
{
    double aux=Metodo_2(n-1);
    funcao=Math.pow(aux,2);
}
else{
System.out.println("Erro, recebido como parâmetro um número negativo, retorno de -1.");
return -1;
}
return funcao;
}

public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int numeroRecebido=sc.nextInt();
    System.out.println("A resposta no Metodo 1 é "+Metodo_1(numeroRecebido));
    System.out.println("A resposta no Metodo 2 é "+Metodo_2(numeroRecebido));




}
}
