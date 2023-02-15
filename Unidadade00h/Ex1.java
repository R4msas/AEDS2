/*
 * Autor- Allan
 * Objetivo -  Faça um método recursivo que receba dois números inteiros e retorne a 
multiplicação do primeiro pelo segundo fazendo somas
 */
import java.util.Scanner;
class Ex1{
    
    public static void RecursivoSoma(int multiplicando, int multiplicador, int soma)
    {
        if(multiplicador==0)
        {
            System.out.println("A soma é "+soma+".");
            return;
        }
        soma+=multiplicando;
        RecursivoSoma(multiplicando, multiplicador-1, soma);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int multiplicando=sc.nextInt();
        int multiplicador=sc.nextInt();
        if (multiplicador<0)//verifica se o multiplicando é negativo e evita que a função entre em loop infinito
        {
            multiplicando*=-1;
            multiplicando*=-1;
        }
        RecursivoSoma(multiplicando, multiplicador,0);

    }
}