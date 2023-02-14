
/*
 Autor Allan
 Objetivo:• Leia dois números. Se um deles for maior que 45, realize a soma dos 
mesmos. Caso contrário, se os dois forem maior que 20, realize a subtração 
do maior pelo menor, senão, se um deles for menor do que 10 e o outro 
diferente de 0 realize a divisão do primeiro pelo segundo. Finalmente, se 
nenhum dos casos solicitados for válido, mostre seu nome na tela.
 */
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numA, numB;
        numA = sc.nextInt();
        numB = sc.nextInt();
        if (numA > 45 || numB > 45) 
        {
            System.out.printf("%d", (numA + numB));
        } 
        else if (numA > 20 || numB > 20) 
        {
            if (numA < numB) 
            {

                System.out.printf(" %d\n", (numB - numA));
            } else 
            {
                System.out.printf(" %d\n", (numA - numB));
            }

        } 
        else if (numA < 10 && numB != 0) 
        {
            System.out.printf(" %d\n", (numA / numB));
        }

        else if (numB < 10 && numA != 0) 
        {
            System.out.printf("%d\n", (numB / numA));
        } 
        else 
        {
            System.out.println("Allan\n");
        }

    }
}