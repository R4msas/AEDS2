#include <stdio.h>
int recursivo (char vetor[], int resp, int indice)
{
    int ascii=(int)vetor[indice];
    printf("O valor ascii é",ascii);
    if(ascii>97&&ascii<123&&ascii!=101&&ascii!=105&&ascii!=111&&ascii!=117)
    { 
    resp++;
    }
    if(indice>0)
    {
       recursivo(vetor, indice-1,resp);
        }
    printf("o resp é %d", resp);
    return resp;
}

int main (void){
    
    char vetor[30];
    for (int  i = 0; i < 30; i++)
 {
   scanf("%[^\n]",&vetor[i]);
 }
 int indice=0;
 for(int c=0;c<30;c++)
    {
        char ch=vetor[c];
    if(ch!="\n")
    indice=c;
    }
 printf("O valor é %d",recursivo(vetor,0,indice));
    
}