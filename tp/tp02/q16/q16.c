#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

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
            contador[1] += 1;
            j -= h;
        }
        listaPersonagem[j + h] = personagemTemporario;
        contador[1] += 3;
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

            insercaoPorCor(listaPersonagem, tamanhoVetor, cor, h, contador);
        }
    } while (h != 1);
}

void swapPersonagem(Personagem listaPersonagem[], int posicaoA, int posicaoB)
{
    Personagem aux = listaPersonagem[posicaoA];
    listaPersonagem[posicaoA] = listaPersonagem[posicaoB];
    listaPersonagem[posicaoB] = aux;
}
// Função para Ordenação por Inserção
void ordenaBolha(Personagem listaPersonagem[], int tamanhoVetor, int contador[])
{

    int i, j;
    for (i = 0; i < tamanhoVetor - 1; i++)
    {

        for (j = 0; j < tamanhoVetor - i - 1; j++)
        {
            contador[0] += 1;
    if (strcmp(listaPersonagem[j].anoNascimento, listaPersonagem[j + 1].anoNascimento) > 0)
    {
      //  printf("Nome: %s nascimento %s , maior que: Nome:%s ano nascimento %s \n",listaPersonagem[j].nome,listaPersonagem[j].anoNascimento, listaPersonagem[j+1].nome,listaPersonagem[j+1].anoNascimento);
        contador[1] += 3;
        swapPersonagem(listaPersonagem, j, j + 1);
    }
    }
    }
}
void ordenaEscopoSelecao(Personagem listaPersonagem[], int inicioAnoIgual, int terminoAnoIgual, int contador[])
{
    for (int c = inicioAnoIgual; c < terminoAnoIgual; c++)
    {
        int menor = c;
        for (int i = c + 1; i <= terminoAnoIgual; i++)
        {
            contador[0] += 1;
            if (strcmp(listaPersonagem[menor].nome, listaPersonagem[i].nome) > 0)
            {
                menor = i;
            }
        }
        swapPersonagem(listaPersonagem, menor, c);
        contador[1] += 3; // swap faz três movimentações no array
    }
}
void ordenaSelecao(Personagem listaPersonagem[], int tamanhoVetor, int contador[])
{

    int i;
    for (int c = 0; c < tamanhoVetor - 1; c++)
    {
        int i = c + 1;
        int terminoAnoIgual = 0, inicioAnoIgual = 0;
        contador[0] += 1;
        while (listaPersonagem[c].anoNascimento == listaPersonagem[i].anoNascimento) // encontra
        {
            inicioAnoIgual = c;
            terminoAnoIgual = i;
            i++;
        }
        c = i; // evita que compare um nome que sabemos que é igual
        if (terminoAnoIgual != 0)
        {
            ordenaEscopoSelecao(listaPersonagem, inicioAnoIgual, terminoAnoIgual, contador);
        }
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

    FILE *log = fopen("790152_bolha.txt", "w");
    int numeroComparacoes = contador[0];
    int numeroMovimentacoes = contador[1];

    fprintf(log, "Matricula: 790152\tNumero Comparacoes: %d\tNumero Movimentacoes: %d\tTempo Execucao: %fs\n", numeroComparacoes, numeroMovimentacoes, tempo);

    fclose(log);
}

int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0;
    int contador[2] = {0, 0};

    Personagem listaPersonagem[100];

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();
    while (testaFim(caminhoArquivo) == false)
    {
        listaPersonagem[contadorTamanho] = montaPersonagem(caminhoArquivo);
        contadorTamanho += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }
    time_t inicio = time(NULL); // Marcar o início da execução

    ordenaBolha(listaPersonagem, contadorTamanho, contador); // Ordena peso por Shellsort, mas não troca os nomes, por ser instável

    ordenaSelecao(listaPersonagem, contadorTamanho, contador); // Ordena peso e nome por Inserção, por ser estável

    imprimirAtributos(listaPersonagem, contadorTamanho); // Imprimir os resultados

    criarLog(inicio, contador);

    return 0;
}