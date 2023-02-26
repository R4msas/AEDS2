#include <stdio.h>
#include <string.h>
#include <stdlib.h> 
/*
Autor - Allan
Objetivo - Crie um m´etodo iterativo que recebe uma string como parˆametro e
retorna true se essa ´e um pal´ındromo. Na sa´ıda padr˜ao, para cada linha de entrada, escreva
uma linha de sa´ıda com SIM/NAO indicando se a linha ´e um pal´ındromo. Destaca-se que uma ˜
linha de entrada pode ter caracteres n˜ao letras. A entrada termina com a leitura de FIM.
*/
void Imprime (char vetor [])
{   int c=0;
    while(vetor[c]!='\0')
    {
        printf("%c",vetor[c]);
    }
}
int IsPalindrome (char vetorRecebido[], char vetorInvertido[], int indice);
int main (void)
{
char vetorRecebido[1000];
char vetorInvertido[1000];
int indice;
int resposta;
int count;
 do{
    count=0;
    do
    {
    
    scanf("%[^/n]%*c",vetorRecebido[count]);
    count++;
    }while(vetorRecebido[count]!='\0');
      
    indice=(sizeof(vetorRecebido)/sizeof(vetorRecebido[0]))-1;//ignora o char indicando o fim do vetor de char
    for(int i=0;i<indice;i++)
    {
        vetorInvertido[indice-1-i]=vetorRecebido[i];
    }
    Imprime(vetorInvertido);
    if(vetorRecebido[0]=='F'&&vetorRecebido[1]=='I'&&vetorRecebido[2]=='M')
    {
        break;
    }
    
    resposta=IsPalindrome(vetorRecebido,vetorInvertido,indice);
    if(resposta)
    {
        printf("SIM\n");
    }
    else{
        printf("NAO\n");
    }
    vetorRecebido[0]='\0';
    vetorInvertido[0]='\0';
    scanf("%[^/n]",vetorRecebido);


    }while(vetorRecebido[0]!='F'&&vetorRecebido[1]!='I'&&vetorRecebido[2]!='M');
}
int IsPalindrome (char vetorRecebido[], char vetorInvertido[], int indice)
{   int contador=0;
    int resposta =0;
    for(int c=0;c<indice;c++)
    {
        if( vetorInvertido[indice-1-c]==vetorRecebido[c])
        {
            contador++;
        }
    }
    if(contador==indice)
    {
        resposta=1;
    }
    return resposta;
}
