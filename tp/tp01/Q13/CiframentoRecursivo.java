/*
Autor - Allan
Objetivo - Recursivo Ciframento de Cesar Recursivo. Receba uma string como parâmetro e
retorna outra contendo a entrada de forma cifrada. Neste exercício, suponha a chave de ciframento três. Na saída padrão, para cada linha de entrada, escreva uma linha com a mensagem
criptografada.
*/
/**
 * CiframentoRecursivo
 */
public class CiframentoRecursivo {

    public static void cifraStringRecursiva(String stringRecebida, int posicaoString, char vetorChar[])
 {
    int cifra=3;
    int ascii;
    if(posicaoString>0)
    {   
        cifraStringRecursiva(stringRecebida, posicaoString-1,vetorChar);
    }
        ascii=(int)(stringRecebida.charAt(posicaoString)+(cifra));
        vetorChar[posicaoString]=((char)ascii);
           
 }

    public static void main(String[]args)
    {   char vetorChar[];
        String stringRecebida=MyIO.readLine();;
    while(!stringRecebida.equals("FIM"))
    {
        int posicaoString=stringRecebida.length()-1;//encontra a última posição da string
        vetorChar=new char [posicaoString+1];
        cifraStringRecursiva(stringRecebida, posicaoString, vetorChar);
        for (int c=0;c<posicaoString;c++)
        {
            MyIO.print(vetorChar[c]);
        }
        MyIO.println(vetorChar[posicaoString]);
        stringRecebida=MyIO.readLine();
    }
    }
}