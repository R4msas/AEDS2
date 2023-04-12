/*
 * Autor - Allan Objetivo - Crie um método iterativo que recebe uma string como parâmetro e retorna
 * true se essa é um palíndromo. Na saída padrão, para cada linha de entrada, escreva uma linha de
 * saída com SIM/NAO indicando se a linha é um palíndromo. Destaca-se que uma linha de entrada pode
 * ter caracteres não letras. A entrada termina com a leitura de FIM
 */
public class PalindromoRecursivo {
    /*
     * Este módulo recebe um vetor de caracteres,grava-os no vetor se estes forem maiores que 2
     * caracteres,retorna a quantidade Strings gravadas,valor máximo de Strings recebidas é 1000.
     */
    public static int leituraDoPubIn(String vetorStringRecebida[], String vetorStringInvertida[])
    {
        int c = 0;
        String str = MyIO.readLine();;
        while (!(str.equals("FIM")))
        {
            vetorStringRecebida[c] = str;
            vetorStringInvertida[c] =
                    new StringBuilder(vetorStringRecebida[c]).reverse().toString();
            c++;
            str = MyIO.readLine();
        }
        return c - 1;
    }

    public static void comparaVetoresString(String[] vetorStringRecebida,
            String[] vetorStringInvertida, int tamanhoDoVetor)
    {
        boolean resposta;
        String stringRecebida;
        String stringInvertida;
        stringRecebida = vetorStringRecebida[tamanhoDoVetor];
        stringInvertida = vetorStringInvertida[tamanhoDoVetor];
        if (tamanhoDoVetor > 0)
        {
            comparaVetoresString(vetorStringRecebida, vetorStringInvertida, tamanhoDoVetor - 1);
        }

        resposta = isPalindrome(stringRecebida, stringInvertida);
        if (resposta)
        {
            System.out.println("SIM");
        } else
        {
            System.out.println("NAO");
        }
    }

    public static boolean isPalindrome(String stringRecebida, String stringInvertida)
    {
        boolean resposta = stringInvertida.equals(stringRecebida);
        return resposta;
    }

    public static void main(String[] args)
    {
        String[] vetorStringRecebida = new String[1000];
        String[] vetorStringInvertida = new String[1000];
        int tamanhoDoVetor = leituraDoPubIn(vetorStringRecebida, vetorStringInvertida);
        comparaVetoresString(vetorStringRecebida, vetorStringInvertida, tamanhoDoVetor);
    }
}
