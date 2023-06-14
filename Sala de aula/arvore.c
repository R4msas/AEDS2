#include <stdlib.h>
#include <stdio.h>
typedef struct No
{
    int elemento;
    struct No* esq;
    struct No* dir;
}No;
No* newNo(int elementoRecebido)
{
    No* novo= (No*)malloc(sizeof(No));
    novo->elemento=elementoRecebido;
    novo->dir=NULL;
    novo->esq=NULL;
return novo;
}
void inserirNo(int numero, No* raiz)
{
    if(numero<raiz->elemento)
    {
        if(raiz->esq==NULL)
        {
            raiz->esq=newNo(numero);
        }
        else{
            inserirNo(numero, raiz->esq);
        }
    }
    else if (numero>raiz->elemento)
    {
        if(raiz->dir==NULL)
        {
            raiz->dir=newNo(numero);
        }
        else{
            inserirNo(numero, raiz->dir);
        }
    }
    else{
        printf("ERRO!");
    }
}
void percorrePre(No* raiz)
{
    if(raiz->esq!=NULL)
    {
        percorrePre(raiz->esq);
    }
    printf("%d\n",raiz->elemento);
    if(raiz->dir!=NULL)
    {
        percorrePre(raiz->dir);
    }
}
void percorrePos(No* raiz)
{
    if(raiz->dir!=NULL)
    {
        percorrePos(raiz->dir);
    }
    printf("%d\n",raiz->elemento);
    if(raiz->esq!=NULL)
    {
        percorrePre(raiz->esq);
    }
}
int main (void)
{
No* raiz=newNo(7);
int contador=10;
while(contador>0)
{
    int numero;
    scanf("%d",&numero);
    inserirNo(numero, raiz);
    contador--;
}
percorrePre(raiz);
percorrePos(raiz)

}
