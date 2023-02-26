/*
Autor - Allan
Objetivo - Crie um m´etodo iterativo que recebe uma string como parˆametro e
retorna true se essa ´e um pal´ındromo. Na sa´ıda padr˜ao, para cada linha de entrada, escreva
uma linha de sa´ıda com SIM/NAO indicando se a linha ´e um pal´ındromo. Destaca-se que uma ˜
linha de entrada pode ter caracteres n˜ao letras. A entrada termina com a leitura de FIM
*/
 public class PalindromoEmJava {
    /*
     * Este módulo recebe um vetor de caracteres,grava-os no vetor se estes forem maiores que 2 caracteres,retorna a quantidade Strings gravadas,valor máximo de Strings recebidas é 1000.
    */
      public static int LeituraDoPubIn(String vetorStringRecebida[], String vetorStringInvertida[])
    {   int c=0;
        String str=MyIO.readLine();;
        while(str.length()>2)
        {
            vetorStringRecebida[c] = str;
            vetorStringInvertida[c]=new StringBuilder(vetorStringRecebida[c]).reverse().toString();
            c++;
            str=MyIO.readLine();
        }
        return c-1;
    }
    public static void ComparaVetoresString(String[]vetorStringRecebida,String []vetorStringInvertida,int tamanhoDoVetor)
    {   boolean resposta;
        String stringRecebida;
        String stringInvertida;

        for(int c=0;c<tamanhoDoVetor;c++)
        {
            stringRecebida=vetorStringRecebida[c];
            stringInvertida=vetorStringInvertida[c];
            resposta=IsPalindrome(stringRecebida, stringInvertida);
            if(resposta)
            {
                System.out.println("SIM");
            }
            else
            {
                System.out.println("NAO");
            }
        }
    }
    public static boolean IsPalindrome(String stringRecebida, String stringInvertida)
    {
        boolean resposta=stringInvertida.equals(stringRecebida);
        return resposta;
    }
    public static void main(String[]args)
    {
    String[] vetorStringRecebida=new String[1000];
    String[] vetorStringInvertida= new String[1000];      
    int tamanhoDoVetor=LeituraDoPubIn(vetorStringRecebida,vetorStringInvertida);
    ComparaVetoresString(vetorStringRecebida, vetorStringInvertida,tamanhoDoVetor);
    }
}