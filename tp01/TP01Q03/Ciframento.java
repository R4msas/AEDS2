/*
Autor - Allan
Objetivo - Ciframento de C´esar em Java - O Imperador J´ulio C´esar foi um dos principais nomes do
Imp´erio Romano. Entre suas contribui¸c˜oes, temos um algoritmo de criptografia chamado “Ciframento de C´esar”. Segundo os historiadores, C´esar utilizava esse algoritmo para criptografar as
mensagens que enviava aos seus generais durante as batalhas. A ideia b´asica ´e um simples deslocamento de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens
for 3, todas as ocorrˆencias do caractere ’a’ s˜ao substitu´ıdas pelo caractere ’d’, as do ’b’ por ’e’,
e assim sucessivamente. Crie um m´etodo iterativo que recebe uma string como parˆametro e
retorna outra contendo a entrada de forma cifrada. Neste exerc´ıcio, suponha a chave de ciframento trˆes. Na sa´ıda padr˜ao, para cada linha de entrada, escreva uma linha com a mensagem
criptografada
*/
public class Ciframento {
 public static String CifraString(String stringRecebida)
 {
    StringBuilder cifrada=new StringBuilder();
    int cifra=3;
    int ascii;
    for(int c=0;c<stringRecebida.length();c++)
    {
        ascii=(int)(stringRecebida.charAt(c)+(cifra));
        cifrada.append((char)ascii);
    }
    String stringCifra=cifrada.toString();
return stringCifra;
 }
public static void main(String[]args)
{
    String stringRecebida=MyIO.readLine();;
    while(!stringRecebida.equals("FIM"))
    {
        MyIO.println(CifraString(stringRecebida));
        stringRecebida=MyIO.readLine();
    }
    
}
    
}