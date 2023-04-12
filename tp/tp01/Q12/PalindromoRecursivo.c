/*
Autor-Allan
Objetivo - Algoritmo recursivo que verifica se a frase informada é um palíndromo
*/
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
int isPalindrome(char vetorRecebido[], int posInicial, int posFinal);
bool checaFim(char vetorRecebido[]);
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
        indice = (strlen(vetorRecebido))-2;//valor da última posição do vetor; dúvida, ao testar o pub.in é preciso ser -2 no strlen. se for para ler do teclado deve ser -1;
       // printf("%s \n///// valor da última pos %d\n",vetorRecebido, indice);//erase
        if (isPalindrome(vetorRecebido, 0, indice)) // chama a função com o marcador -1
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        vetorRecebido[0] = '\0';          // troca o marcador de fim para o começo, para poder ignorar o restante dos char da leitura anterior.
        scanf(" %[^\n]s", vetorRecebido); // lê o array novamente.
        getchar();
    }
}
int isPalindrome(char vetorRecebido[], int posInicial, int posFinal)
{
    int resposta = 1;

    if (posInicial < posFinal)
    {
        if (vetorRecebido[posInicial] != vetorRecebido[posFinal])
        {
           resposta = 0;
          // printf("encontrou letra diferente na posicao inicial %d e %d posicao final\n",posInicial,posFinal);//erase
        
        }
        else
        {
            isPalindrome(vetorRecebido, posInicial + 1, posFinal - 1);    
        }
    }
    return resposta;
}
bool checaFim(char vetorRecebido[])
{
    bool resposta = true;
    if ((vetorRecebido[0] == 'F') && (vetorRecebido[1] == 'I') && (vetorRecebido[2] == 'M'))
    {
        resposta = false;
    }
    return resposta;
}