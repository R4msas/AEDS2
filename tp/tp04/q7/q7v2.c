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
typedef struct Celula
{
    struct Celula *prox;
    Personagem *atual;
} Celula;
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

void montaPersonagem2(char caminhoArquivo[], Personagem* personagem)
{
    FILE *leitura = fopen(caminhoArquivo, "r");

    char descricaoPersonagem[1000];

    fscanf(leitura, " %[^\n]s", descricaoPersonagem);
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
                strcpy(personagem->nome, atributo);
                break;
            case 2:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                personagem->altura = atoi(atributo);
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
                personagem->peso = atof(atributo);
                break;
            case 4:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->corDoCabelo, atributo);
                break;
            case 5:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->corDaPele, atributo);
                break;
            case 6:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->corDosOlhos, atributo);
                break;
            case 7:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->anoNascimento, atributo);
                break;
            case 8:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->genero, atributo);
                break;
            case 9:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem->homeworld, atributo);

                i = strlen(descricaoPersonagem); // Encerra os ciclos de repetição desnecessários
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return;
}
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
void criarLog(time_t inicio, int contador)
{
    float tempo;
    time_t final = time(NULL); // Marcar o final da execução

    tempo = difftime(final, inicio);

    FILE *log = fopen("790152_.txt", "w");
    int numeroComparacoes = contador;

    fprintf(log, "Matricula: 790152\tNumero Comparacoes: %d\tTempo Execucao: %fs\n", numeroComparacoes, tempo);

    fclose(log);
}
struct Celula *novaCelula()
{
    struct Celula *novaCelula = (struct Celula *)malloc(sizeof(Celula));
    novaCelula->prox = NULL;
    novaCelula->atual = NULL;

    return novaCelula;
}
void removeEspacos(char *str)
{
    int tamanho = strlen(str);
    int i, j;

    // Percorre a string, movendo os caracteres que não sejam um espaço para frente
    for (i = 0, j = 0; i < tamanho; i++)
    {
        if (str[i] != ' ')
        {
            str[j] = str[i];
            j++;
        }
    }

    // Define o novo terminador de string
    str[j] = '\0';
}
Personagem *malocPersonagem(Personagem personagem)
{
    Personagem *person = (Personagem *)malloc(sizeof(Personagem));
    person->altura=personagem.altura;
    person->nome[0]='\0';
    strcat(person->nome,personagem.nome);
    return person;
}
Personagem* newPersonagem()
{
    Personagem *person = (Personagem *)malloc(sizeof(Personagem));
    person->nome[0]='\0';
    int altura=0;
    double peso=0;
    person->corDoCabelo[0]='\0';
    person->corDaPele[0]='\0';
    person->corDosOlhos[0]='\0';
    person->anoNascimento[0]='\0';
    person->genero[0]='\0';
    person->homeworld[0]='\0';
    return person;
}
int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int contadorComparacao = 0;
    struct Celula *hashTable[25] = {NULL}; 
    scanf(" %[^\n]s", caminhoArquivo);
    
    getchar();

    time_t inicio = time(NULL); // Marcar o início da execução

    while (testaFim(caminhoArquivo) == false)
    {
        char * p=strchr(caminhoArquivo,'\r');
        if(p!=NULL)
        {
            *p='\0';
        }
        Personagem* personagem=newPersonagem();
        montaPersonagem2(caminhoArquivo, personagem);
        int hash=personagem->altura % 25;
        contadorComparacao++;
        if (hashTable[hash] == NULL)
        {
            hashTable[hash]=novaCelula();
            hashTable[hash]->atual=personagem;
        }
        else
        {
            struct Celula* tmp2=novaCelula();
            tmp2->atual=personagem;
            tmp2->prox=hashTable[hash]->prox;    // inicializa o personagem recebido na célula tmp
            hashTable[hash]->prox = tmp2;       // atualiza a referência da primeira célula com tmp
        }
        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }
    char stringRecebida[30];
    scanf(" %[^\n]s", stringRecebida);
    getchar();
    while (testaFim(stringRecebida) == false)
    {
        removeEspacos(stringRecebida);
        char * p=strchr(stringRecebida,'\r');
        if(p!=NULL)
        {
            *p='\0';
        }
        char preCaminho[] = "/tmp/personagens/";
        char caminho[60] = "";
        strcat(caminho, preCaminho);
        strcat(caminho, stringRecebida);
        
        strcat(caminho, ".txt");
        Personagem* personagem=newPersonagem();
        montaPersonagem2(caminho, personagem);
        char nomePerson[40]="";
        strcat(nomePerson, personagem->nome);
        int hash=personagem->altura % 25;
        contadorComparacao++;
        printf("%s ", personagem->nome);
        if (hashTable[hash] == NULL)
        {
            printf("NÃO\n");
        }
        else{
        if (strcmp(personagem->nome, hashTable[hash]->atual->nome) == 0)
        {
            contadorComparacao++;
            printf("SIM\n");
        }
        else
        {
            contadorComparacao++;
            int resp = 0;
            struct Celula *tmp = hashTable[hash]; // recebe a posição 0 da lista
            while (resp == 0 && tmp->prox != NULL)
            {
                struct Celula *aux = tmp; // struct Celula auxiliar para poder retirar o próximo ponteiro se necessário.
                tmp = tmp->prox;
                if (strcmp(personagem->nome,tmp->atual->nome) == 0)
                {
                    contadorComparacao++;
                    resp = 1;              // caso tenha achado o personagem, para o while
                    aux->prox = tmp->prox; // retira tmp da lista
                    free(tmp);             // libera da memória
                }
            }
            if (resp == 1)
            {
                printf("SIM\n");
            }
            else
            {
                    printf("NÃO\n");
            }
        }
        }
        free(personagem);
        scanf(" %[^\n]s", stringRecebida);
        getchar();
    }

    criarLog(inicio, contadorComparacao);

    return 0;
}