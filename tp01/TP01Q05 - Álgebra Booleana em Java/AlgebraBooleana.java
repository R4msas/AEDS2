/*
 * Autor- Allan Objetivo Crie um método iterativo que recebe uma string contendo uma express˜ao
 * booleana e o valor de suas entradas e retorna um booleano indicando se a express˜ao ´e verdadeira
 * ou falsa. Cada string de entrada ´e composta por um n´umero inteiro n indicando o n´umero de
 * entradas da express˜ao booleana corrente. Em seguida, a string cont´em n valores bin´arios (um
 * para cada entrada) e a express˜ao booleana. Na sa´ıda padr˜ao, para cada linha de entrada,
 * escreva uma linha de sa´ıda com SIM / NAO indicando se a express˜ao corrente ´e ˜ verdadeira ou
 * falsa.
 */
import java.util.Scanner;

public class AlgebraBooleana {
    private static int LeituraDoPubIn(String vetor[])
    {
        Scanner sc = new Scanner(System.in);
        int c = 0;

        do
        {
            String str = sc.nextLine();
            vetor[c] = str;
            c++;
        } while (sc.hasNextLine() == true);
        return c + 1;// retorna o tamanho do vetor;
    }

    private static void TransformaStringEmVetorChar(String vetor[])
    {
        for (int c = 0; c < vetor.length; c++)
        {
            char vetorChar[] = new char[vetor[c].length()];
            vetorChar = vetor[c].toCharArray();
            ParseChar(vetorChar);
        }

    }



    private static void ParseChar(char vetorChar[])
    {
        int A, B, C, inicioPesq, fimPesq = -8008;
        A = vetorChar[2];
        B = vetorChar[4];
        C = vetorChar[6];
        int inicioIndice = 6;// inicia a variável caso seja um caso de duas variáveis
        if (vetorChar[0] == '3')
        {
            inicioIndice = 8;// altera a variável caso seja de três variáveis
        }
        /*
         * analisa cada membro do array e altera o seu valor para o valor de 0 ou 1, dependendo da
         * variável.
         */
        for (int c = inicioIndice; c < vetorChar.length; c++)
        {
            if (vetorChar[c] == 'A')
            {
                vetorChar[c] = (char) A;
            } else if (vetorChar[c] == 'B')
            {
                vetorChar[c] = (char) B;
            } else if (vetorChar[c] == 'C')
            {
                vetorChar[c] = (char) C;
            }
        }
        
        /* Nesta iteração procura-se o parêntese mais interno da expressão */
        for (int c = inicioIndice; c < vetorChar.length; c++)
        {
            if (vetorChar[c] == ')')
            {
                fimPesq = c;
                for (int j = c - 1; j > 0; j--)
                {
                    if (vetorChar[j] == '(')
                    {
                        inicioPesq = j;
                        AlgebraBool(inicioPesq, fimPesq, vetorChar);
                        break;
                    }

                }
            }
        }
        if (fimPesq == vetorChar.length - 1)
        {
            System.out.println(vetorChar[fimPesq]);
        }



    }

    private static void AlgebraBool(int inicioPesq, int fimPesq, char[] vetorChar)
    {
        if (vetorChar[inicioPesq - 1] == 't')// somente pode ter esta pesquisa se for um operador
                                             // not
        {
            
            for (int c = inicioPesq - 3; c <= fimPesq; c++)
            {
                if (vetorChar[c]=='0')//testa se a proposição é falsa, se for inverte o valor 
                {
                    vetorChar[c]='1';
                }
                else if(vetorChar[c]=='1')//testa se é falsa, se for, inverte o valor
                {
                    vetorChar[c]='0';
                }
                else{
                vetorChar[c] = ' ';// apaga todos os caracteres do intervalo que não sejam relevantes
                }
            }
            
            
        } else if (vetorChar[inicioPesq - 1] == 'd')// operador and
        {
            int contador=0;
            for (int c = inicioPesq - 3; c <= fimPesq; c++)
            {
                if(vetorChar[c]=='1')
                {
                    contador++;//caso a proposição seja verdadeira, conta um e apaga o valor atual
                    vetorChar[c]=' ';
                }
                else
                {
                vetorChar[c] = ' ';
                }
            }
            if(contador==2)//caso seja verdadeira, informa 1
            {
                vetorChar[fimPesq]='1';
            }
            else{
                vetorChar[fimPesq]='0';
            }
           
        } else if (vetorChar[inicioPesq - 1] == 'r')
        {
            int contador=0;
            for (int c = inicioPesq - 2; c <= fimPesq; c++)
            {
                if(vetorChar[c]=='1')
                {
                    contador++;//conta as proposições verdadeiras
                    vetorChar[c]=' ';
                }
                else
                {
                vetorChar[c] = ' ';
                }
            }
            if(contador==0)//se não houver proposições verdadeiras é gravado como falso
            {
                vetorChar[fimPesq]='0';
            }
            else{
                vetorChar[fimPesq]='1';
            }
        } else
        {
            System.out.println("ERRO no AlgebraBool");

        }
        

    }

    public static void main(String[] args)
    {
        String[] vetor = new String[1000];
        int tamanhoDoVetor = LeituraDoPubIn(vetor);
        String novoVetor[] = new String[tamanhoDoVetor];
        novoVetor = vetor.clone();
        TransformaStringEmVetorChar(novoVetor);

    }
}
