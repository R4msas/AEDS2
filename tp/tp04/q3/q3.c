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
}Personagem;
typedef struct Celula
{
    struct Celula *prox;
    Personagem *person;
} Celula;
typedef struct No
{
    Personagem *person;
    struct No * esq;
    struct No * dir;
    int nivel;
} No;
No * balancear(No* no);
No* novoNo(Personagem* personagem);
No* rotacionarDir(No* no);
int getAltura(No* no);
No* rotacionarEsq(No* no);
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
int encontraMaior(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
void setAltura(No* no) {
    int a =getAltura(no->esq);
    int b=getAltura(no->dir);
    no->nivel = 1 + encontraMaior(a,b);
    
	return;
    }
int getAltura(No* no) {
    int resp;
if(no==NULL)
{
    resp=0;
}
else{
    resp=no->nivel;
}
        return resp;
	}
int pesquisa(No* no, char nomePersonagem[]) {
   int resp=0;
    if(no==NULL)
    {
        resp=0;
    }
    else if(strcmp(nomePersonagem, no->person->nome)==0)
    {
        resp=1;
    }
    else if(strcmp(nomePersonagem,no->person->nome)<0)
    {
        printf(" esq");
        resp=pesquisa(no->esq, nomePersonagem);
    }
    else
    {
        printf(" dir");
        resp=pesquisa(no->dir, nomePersonagem);
    }
    return resp;
}
No* inserir(Personagem* personInserir, No* no){
		if (no == NULL) {
			no = novoNo(personInserir);
		} else if (strcmp(personInserir->nome, no->person->nome)<0) {
			no->esq = inserir(personInserir, no->esq);
		} else if (strcmp(personInserir->nome, no->person->nome)>0) {
			no->dir=inserir(personInserir, no->dir);
		} else {
			printf("Erro ao inserir! %s", personInserir->nome);
		}
		return balancear(no);
	}
// Função para estruturar o personagem
void montaPersonagem2(char caminhoArquivo[], Personagem * personagem)
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
No* novoNo(Personagem* personagem)
{
    No* newNo= (No*)malloc(sizeof(No));
    newNo->person=personagem;
    newNo->dir=NULL;
    newNo->esq=NULL;
    newNo->nivel=0;
    return newNo;
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

No* balancear(No* no){
		if (no != NULL) {
            int a=getAltura(no->dir);
            int b=getAltura(no->esq);
			int fator =  a- b;
			// Se balanceada
			if (fator>=-1&&fator<=1) {
				setAltura(no);
			// Se desbalanceada para a direita
			} else if (fator == 2) {
				int fatorFilhoDir = getAltura(no->dir->dir) - getAltura(no->dir->esq);
				// Se o filho a direita também estiver desbalanceado
				if (fatorFilhoDir == -1) {
					no->dir= rotacionarDir(no->dir);
				}
				no = rotacionarEsq(no);
			// Se desbalanceada para a esquerda
			} else if (fator == -2) {
				int fatorFilhoEsq = getAltura(no->esq->dir) - getAltura(no->esq->esq);
				// Se o filho a esquerda também estiver desbalanceado
				if (fatorFilhoEsq == 1) {
					no->esq = rotacionarEsq(no->esq);
				}
				no = rotacionarDir(no);
			}
		return no;
	}
}
No* rotacionarDir(No* no)
{
   // printf("Rotação a direita\n");apagar
    No* noEsq=no->esq;
    No* noEsqDir=noEsq->dir;
    noEsq->dir=no;
    no->esq=noEsqDir;
    setAltura(no);
    setAltura(noEsq);
    return noEsq;

}
No* rotacionarEsq(No* no)
{
   // printf("Rotação a esquerda\n");//apagar
    No* noDir=no->dir;
    No* noDirEsq=noDir->esq;
    noDir->esq=no;
    no->dir=noDirEsq;
    setAltura(no);
    setAltura(noDir);
    return noDir;
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
    novaCelula->person = NULL;

    return novaCelula;
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
    time_t inicio = time(NULL); // Marcar o início da execução

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();
    char * p=strchr(caminhoArquivo,'\r');//Tinha um arquivo no verde que tinha este /r e tava atrapalhando a pesquisa
        if(p!=NULL)
        {
            *p='\0';
        }

    Personagem* personagem=newPersonagem();
    montaPersonagem2(caminhoArquivo,personagem);
    No* raiz=novoNo(personagem);
    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (testaFim(caminhoArquivo) == false)//inserção dos elementos na árvore
    {
        char * p=strchr(caminhoArquivo,'\r');
        if(p!=NULL)
        {
            *p='\0';
        }
        Personagem* personagem=newPersonagem();
        montaPersonagem2(caminhoArquivo, personagem);
        raiz=inserir(personagem, raiz);
        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }
    char stringRecebida[30];
    scanf(" %[^\n]s", stringRecebida);
    getchar();
    while (testaFim(stringRecebida) == false)//pesquisa
    {
        char * p=strchr(stringRecebida,'\r');
        if(p!=NULL)
        {
            *p='\0';
        }

        printf("%s raiz",stringRecebida);
        if(pesquisa(raiz, stringRecebida))
        {
            printf(" SIM\n");
        }
        else{
            printf(" NÃO\n");
        }
        scanf(" %[^\n]s", stringRecebida);
        getchar();
    }

    criarLog(inicio, contadorComparacao);

    return 0;
}