    /*
 Autor- Allan 
 Objetivo:
• Faça um programa que leia um número inteiro N indicando a nota máxima 
em uma prova P. Em seguida, leia a nota de 20 alunos (entre 0 e N) e 
mostre na tela: (i) a média da turma, (ii) o número de alunos cuja nota foi 
menor que a média da Universidade (suponha 60%) e (iii) a quantidade de 
alunos com conceito A (mais de 90%).
 */
import java.util.Scanner;

public class Ex12 {


public static void main(String[]args)
{ 

    Scanner sc = new Scanner(System.in);
    int aluno =20;
    double acimaMedia=0, abaixoMedia=0, media=0;
    double [] array= new double[20];
    double nota=sc.nextDouble();
    for (int c=0;c<20;c++)
    {
        array[c]=sc.nextDouble();
        if(array[c]/nota>0.90)
        {
            acimaMedia++;
        }
        else if(array[c]/nota<0.60)
        {
            abaixoMedia++;
        }
    media+=array[c];
    }
    media=media/20;
    System.out.println("media da turma "+media+", alunos abaixo da média "+abaixoMedia+" alunos com conceito A "+acimaMedia);   
    
}
}