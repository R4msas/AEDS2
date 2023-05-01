#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// Definição do registro do personagem
typedef struct Celula
{
    Celula prox;
    Personagem atual;
}Celula;
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

// Função para trocar os elementos de lugar
void insercaoPorCor(Personagem listaPersonagem[], int tamanhoVetor, int cor, int h, int contador[])
{
    for (int i = (h + cor); i < tamanhoVetor; i += h)
    {
        Personagem personagemTemporario = listaPersonagem[i];
        int j = i - h;
        while ((j >= 0) && (listaPersonagem[j].peso > personagemTemporario.peso))
        {

            listaPersonagem[j + h] = listaPersonagem[j];
            contador[1]+=1;
            j -= h;
        }
        listaPersonagem[j + h] = personagemTemporario;
        contador[1]+=3;
    }

}

// Função para Ordenação por Shellsort
void ordenaPorShellsort(Personagem listaPersonagem[], int tamanhoVetor, int contador[])
{
    int h = 1;
    do
    {
        h = (h * 3) + 1;
    } while (h < tamanhoVetor);

    do
    {
        h /= 3;
        for (int cor = 0; cor < h; cor++)
        {

            insercaoPorCor(listaPersonagem, tamanhoVetor, cor, h,contador);
        }
    } while (h != 1);

}

// Função para Ordenação por Inserção
void ordenaPorInsercao(Personagem listaPersonagem[], int tamanhoVetor, int contador[])
{
    for (int i = 1; i < tamanhoVetor; i += 1)
    {
        Personagem personagemTemporario = listaPersonagem[i];
        int j = i - 1;
        while ((j >= 0) && ((listaPersonagem[j].peso > personagemTemporario.peso) || ((listaPersonagem[j].peso == personagemTemporario.peso) && (strcmp(listaPersonagem[j].nome, personagemTemporario.nome) > 0))))
        {
            listaPersonagem[j + 1] = listaPersonagem[j];
            j -= 1;
        }
        contador[0]+=3*i;//faz três comparações para cada valor
        listaPersonagem[j + 1] = personagemTemporario;
        contador[1]+=3;//swap faz três movimentações no array
    }

}

// Imprimir os resultados
void imprimirAtributos(Personagem listaPersonagens[], int tamanhoTotal)
{
    for (int i = 0; i < tamanhoTotal; i++)
    {
        printf(" ## %s", listaPersonagens[i].nome);
        printf(" ## %d", listaPersonagens[i].altura);
        if (fmod(listaPersonagens[i].peso, 1) == 0)
            printf(" ## %.0lf", listaPersonagens[i].peso);
        else
            printf(" ## %.1lf", listaPersonagens[i].peso);
        printf(" ## %s", listaPersonagens[i].corDoCabelo);
        printf(" ## %s", listaPersonagens[i].corDaPele);
        printf(" ## %s", listaPersonagens[i].corDosOlhos);
        printf(" ## %s", listaPersonagens[i].anoNascimento);
        printf(" ## %s", listaPersonagens[i].genero);
        printf(" ## %s", listaPersonagens[i].homeworld);
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
Celula *novaCelula()
{
    Celula *nova=(Celula*)malloc(sizeof(Celula));
    nova->prox=NULL;
    return nova;
}
void insereFim(Celula posicaoCelula[], Celula *tmp)
{
    posicaoCelula[1].prox=*tmp;
    posicaoCelula[1]=*tmp;
}
void removeFim(Celula posicaoCelula[])
{
    
}
int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int contador[2]={0,0};
    Celula posicaoCelula[2];//célula para o primeiro e para o último elemento do array
    scanf(" %[^\n]s", caminhoArquivo);
    getchar();
    Celula *tmp=novaCelula();
    tmp->atual=montaPersonagem(caminhoArquivo);
    posicaoCelula[0].prox=tmp;
    posicaoCelula[1]=*tmp;
    while (testaFim(caminhoArquivo) == false)
    {
        Celula *tmp=novaCelula();
        tmp->atual = montaPersonagem(caminhoArquivo);//lê o arquivo e grava o personagem no atual em tmp
        insereFim(posicaoCelula,tmp);
        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }
    int repeticoes;
    scanf("%d",&repeticoes);
    while(repeticoes>0)
    {

    }

    imprimirAtributos(posicaoCelula, contadorTamanho); // Imprimir os resultados
    return 0;
}