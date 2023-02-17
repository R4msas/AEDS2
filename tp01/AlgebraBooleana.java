/*
 * Autor- Allan 
 * Objetivo Crie um método iterativo que recebe uma string contendo uma
express˜ao booleana e o valor de suas entradas e retorna um booleano indicando se a express˜ao
´e verdadeira ou falsa. Cada string de entrada ´e composta por um n´umero inteiro n indicando
o n´umero de entradas da express˜ao booleana corrente. Em seguida, a string cont´em n valores
bin´arios (um para cada entrada) e a express˜ao booleana. Na sa´ıda padr˜ao, para cada linha
de entrada, escreva uma linha de sa´ıda com SIM / NAO indicando se a express˜ao corrente ´e ˜
verdadeira ou falsa.
 */
import java.util.Scanner;

public class AlgebraBooleana
{
    public static void AlgebraBool(String vetor[])
{
    for (int c = 0;c<1000;c++)
        {
       char vetorChar[]=new char[vetor[c].length()]
       vetorChar=toCharArray(vetor[c]);
        }
}
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
String[] vetor=new String[1000];
for(int c=0;c<1000;c++)
{
    vetor[c]=sc.nextLine();
}
AlgebraBool(vetor);
}
}