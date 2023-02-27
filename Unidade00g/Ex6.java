/*
 Autor- Allan 
 Objetivo:
•O banco do Zé abriu uma linha de crédito para os seus clientes. O valor 
máximo da prestação não poderá ultrapassar 40% do salário bruto. Fazer 
um algoritmo que permita entrar com o salário bruto e o valor da prestação 
e informar se o empréstimo será concedid

 */
import java.util.Scanner;
public class Ex6 {
    public static void main(String[]args)
    {
    Scanner sc = new Scanner(System.in);
    double prestacao, salario, porcentagemMax=0.4;
    prestacao= sc.nextDouble();
    salario= sc.nextDouble();
    if((prestacao/salario)>porcentagemMax)
{
    System.out.println("Empréstimo negado");
}
    else 
    {
        System.out.println("Empréstimo poderá ser concedido.");
    }



    }
}
