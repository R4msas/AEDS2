#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

// Definição do registro do personagem
typedef struct Personagem
{
    char nome[40];
    int altura;
    double peso;
    char corDoCabelo[40];
    char corDaPele[40];
    char corDosOlhos[40];
    char anoNascimento[40];
    char genero[40];
    char homeworld[40];
} Personagem;
typedef struct Celula
{
    struct Celula *prox;
    struct Personagem *atual;
}Celula;
// Função para retornar o resto da divisão com double
double fmod(double x, double y)
{
    return x - (int)(x / y) * y;
}

// Capturar o atributo entre aspas simples
void leituraAtributo(char atributo[], char descricaoPersonagem[], int index)
{
    int i = 0;

    while (descricaoPersonagem[index] != '\'')
    {
        atributo[i] = descricaoPersonagem[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

// Função para testar o fim do arquivo
bool testaFim(char palavra[])
{
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        teste = true;
    }

    return teste;
}

// Função para estruturar o personagem
Personagem montaPersonagem(char caminhoArquivo[])
{
    FILE *leitura = fopen(caminhoArquivo, "r");

    char descricaoPersonagem[1000];

    fscanf(leitura, " %[^\n]s", descricaoPersonagem);

    Personagem personagem; // Cria a variável struct

    int contador = 0;

    for (int i = 0; i < strlen(descricaoPersonagem); i++)
    {
        if (descricaoPersonagem[i] == ':')
        {
            char atributo[50];
            contador++;

            switch (contador)
            {
            case 1:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.nome, atributo);
                break;
            case 2:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                personagem.altura = atoi(atributo);
                break;
            case 3:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                for (int i = 0; i < strlen(atributo); i++)
                {
                    if (atributo[i] == ',')
                    {
                        atributo[i] = atributo[i - 1];
                        atributo[i - 1] = '0';
                    }
                }
                personagem.peso = atof(atributo);
                break;
            case 4:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDoCabelo, atributo);
                break;
            case 5:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDaPele, atributo);
                break;
            case 6:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDosOlhos, atributo);
                break;
            case 7:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.anoNascimento, atributo);
                break;
            case 8:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.genero, atributo);
                break;
            case 9:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.homeworld, atributo);

                i = strlen(descricaoPersonagem); // Encerra os ciclos de repetição desnecessários
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return personagem;
}

// Imprimir os resultados
void imprimirAtributos(Celula *celulaPosicao[])
{   Celula* tmp=celulaPosicao[0];
    while(tmp->prox!=NULL)
    {
        tmp=tmp->prox;
        printf(" ## %s", tmp->atual->nome);
        printf(" ## %d", tmp->atual->altura);
        if (fmod(tmp->atual->peso, 1) == 0)
            printf(" ## %.0lf", tmp->atual->peso);
        else
            printf(" ## %.1lf", tmp->atual->peso);
        printf(" ## %s", tmp->atual->corDoCabelo);
        printf(" ## %s", tmp->atual->corDaPele);
        printf(" ## %s", tmp->atual->corDosOlhos);
        printf(" ## %s", tmp->atual->anoNascimento);
        printf(" ## %s", tmp->atual->genero);
        printf(" ## %s", tmp->atual->homeworld);
        printf(" ## \n");
    }
}

// Função para criar arquivo de log
void criarLog(time_t inicio, int contador[])
{
    float tempo;
    time_t final = time(NULL); // Marcar o final da execução

    tempo = difftime(final, inicio);

    FILE *log = fopen("790152_shellsort.txt", "w");
    int numeroComparacoes=contador[0];
    int numeroMovimentacoes=contador[1];

    fprintf(log, "Matricula: 790152\tNumero Comparacoes: %d\tNumero Movimentacoes: %d\tTempo Execucao: %fs\n", numeroComparacoes, numeroMovimentacoes, tempo);

    fclose(log);
}
Celula *novaCelula(Personagem person)
{
    Celula *nova=(Celula*)malloc(sizeof(Celula));
    nova->prox=NULL;
    nova->atual=&person;
    return nova;
}
void insereFim(Celula *posicaoCelula[], Celula *tmp, float media[])
{
    posicaoCelula[1]->prox=tmp;
    posicaoCelula[1]=tmp;
    media[1]+=(float)tmp->atual->altura;
    media[0]++;
    int valor=((media[1]/media[0])+0.5);
    printf("%d\n", valor);
}
void removeFim(Celula *posicaoCelula[], float media[])
{
 Celula *tmp=posicaoCelula[0]->prox;
 if(posicaoCelula[0]->prox==NULL)
 {
    printf("Lista vazia");
 }   
 else{
    while(tmp->prox!=posicaoCelula[1])
    {
        tmp=tmp->prox;
    }
 }
 printf("(R) %s",posicaoCelula[1]->atual->nome);
 media[1]-=posicaoCelula[1]->atual->altura;
 media[0]--;
 tmp->prox=NULL;
 posicaoCelula[1]=tmp;
 free(tmp);
}
void geraSubString(char primeiraString[], char segundaString[],int inicio, int fim)//inclui a posicao de inicio e a de fim, ex: primeiraString =abcde, inicio 1, fim 3, segundaString bcd.
{   int j=0;
    for(int c=inicio;c<=fim;c++)
    {
        primeiraString[c]=segundaString[j];
        j++;
    }
}
int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int contador[2]={0,0};
    float media[2]={0,0};//posicao zero para quantidade na fila, posicao 1 para a soma das alturas.
    Celula *posicaoCelula[2];//célula para o primeiro e para o último elemento do array
    scanf(" %[^\n]s", caminhoArquivo);
    getchar();
    struct Celula *tmp=novaCelula(montaPersonagem(caminhoArquivo));
    posicaoCelula[0]->prox=tmp;
    posicaoCelula[1]=tmp;
    while (testaFim(caminhoArquivo) == false)
    {
        Celula *tmp=novaCelula(montaPersonagem(caminhoArquivo));
        insereFim(posicaoCelula,tmp,media);
        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }
    int repeticoes;
    scanf("%d",&repeticoes);
    while(repeticoes>0)
    { 
    scanf(" %[^\n]s", caminhoArquivo);
    getchar();
    if(caminhoArquivo[0]=='R')
    {
        removeFim(posicaoCelula, media);
    }
    else{
        char subString[100];
        geraSubString(caminhoArquivo,subString,2,sizeof(caminhoArquivo)-1);
        Celula *tmp=novaCelula(montaPersonagem(caminhoArquivo));
        insereFim(posicaoCelula,tmp, media);
    }    
    }

    imprimirAtributos(posicaoCelula); // Imprimir os resultados
    return 0;
}