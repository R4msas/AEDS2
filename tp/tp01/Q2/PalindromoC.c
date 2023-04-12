#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
/*
Autor - Allan
Objetivo - Crie um m´etodo iterativo que recebe uma string como parˆametro e
retorna true se essa ´e um pal´ındromo. Na sa´ıda padr˜ao, para cada linha de entrada, escreva
uma linha de sa´ıda com SIM/NAO indicando se a linha ´e um pal´ındromo. Destaca-se que uma ˜
linha de entrada pode ter caracteres n˜ao letras. A entrada termina com a leitura de FIM.
*/
bool isPalindrome(char vetorRecebido[], int indice);
bool checaFim(char vetorRecebido []);
int main(void)
{
    char vetorRecebido[1000];
    int indice;
    int resposta;
    int count;
    scanf(" %[^\n]s", vetorRecebido);
    getchar();
    // tem a função de repetir até que o último vetor seja igual a FIM
        while (checaFim(vetorRecebido))
        {
            indice = strlen(vetorRecebido);
            if(isPalindrome(vetorRecebido,indice-1))
            {
            printf("SIM\n");
            }
            else
            {
            printf("NAO\n");
            }
            vetorRecebido[0]='\0';//troca o marcador de fim para o começo, para poder ignorar o restante dos char da leitura anterior.
            scanf(" %[^\n]s", vetorRecebido);//lê o array novamente.
            getchar();
            } 
    }
    bool isPalindrome(char vetorRecebido[],int indice)
    {
        int contador = 0;
        int resposta = 0;
        for (int c = 0; c < indice; c++)
        {
            if (vetorRecebido[indice-1-c] == vetorRecebido[c])
            {
                contador++;
            }
        } 
        if (contador == indice)
        {
            resposta = 1;
        }
        return resposta;
    }
bool checaFim(char vetorRecebido [])
{
    bool resposta=true;
    if((vetorRecebido[0]=='F')&&(vetorRecebido[1]=='I')&&(vetorRecebido[2]=='M'))
    {
        resposta =false;
    }
    return resposta;
}