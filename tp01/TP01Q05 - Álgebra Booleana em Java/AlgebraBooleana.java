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
        return c ;// retorna o tamanho do vetor;
                
       
    }

    private static void TransformaStringEmVetorChar(String vetor[],int tamanhoDoVetor)
    {
        
        for (int c = 0; c < tamanhoDoVetor ; c++)
        {
            if(vetor[c].length()>5)
            {
            char vetorChar[] = new char[vetor[c].length()];
            vetorChar = vetor[c].toCharArray();
            ParseChar(vetorChar);
        }
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
            inicioIndice = 8;// altera o início da pesquisa, caso seja de três variáveis
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
                fimPesq = c;//após encontrar a posição do parêntese, guarda-a e procura o primeiro parêntese
                for (int j = c - 1; j > 0; j--)
                {
                    if (vetorChar[j] == '(')//faz processo similar para encontrar o parêntese aberto
                    {
                        inicioPesq = j;
                        AlgebraBool(inicioPesq, fimPesq, vetorChar);//de posse das posições no vetor, chama o método que efetua a álgebra booleana
                        break;
                    }

                }
            }
        }
            System.out.println(vetorChar[fimPesq]);
        



    }

    private static void AlgebraBool(int inicioPesq, int fimPesq, char[] vetorChar)
    {
        if (vetorChar[inicioPesq - 1] == 't')// somente pode ter esta pesquisa se for um operador
                                             // not
        {
            for (int c = inicioPesq - 3; c < fimPesq; c++)
            {
                if (vetorChar[c]=='0')//testa se a proposição é falsa, se for inverte o valor 
                {
                    vetorChar[fimPesq]='1';
                }
                else if(vetorChar[c]=='1')//testa se é falsa, se for, inverte o valor
                {
                    vetorChar[fimPesq]='0';
                }
                vetorChar[c] = ' ';// apaga todos os caracteres do intervalo que não sejam relevantes
                
            }
            
            
            
            
        } else if (vetorChar[inicioPesq - 1] == 'd')// operador and
        {
            vetorChar[fimPesq]='1';//assume que a resposta é verdadeira
            for (int c = inicioPesq - 3; c < fimPesq; c++)
            {
                if(vetorChar[c]=='0')
                {
                vetorChar[fimPesq]='0';//caso uma das proposições seja falsa, altera a resposta para falso
                }
                vetorChar[c] = ' ';
            }
           
        } else if (vetorChar[inicioPesq - 1] == 'r')
        {
            vetorChar[fimPesq]='0';//assume que a resposta será falsa
            for (int c = inicioPesq - 2; c < fimPesq; c++)
            {
                if(vetorChar[c]=='1')
                {
                    vetorChar[fimPesq]='1';//caso uma das proposições seja verdadeira, altera a resposta para verdadeiro
                    
                }
                vetorChar[c]=' ';
                
            }
        }
            
        
        

    }

    public static void main(String[] args)
    {
        String[] vetor = new String[1000];
        int tamanhoDoVetor = LeituraDoPubIn(vetor);
        String novoVetor[] = new String[tamanhoDoVetor];
        novoVetor = vetor.clone();
        TransformaStringEmVetorChar(novoVetor,tamanhoDoVetor);

    }
}
