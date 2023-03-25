#include <stdio.h>
struct fila
{   int valor;
    int * pointer;
}fa;
void preencheFila (struct fila usuarioFila[])
{
    scanf("%d",usuarioFila[0].valor);
    for (int c=1;c<3;c++)
    {
        scanf("%d",&usuarioFila[c].valor);
        usuarioFila[c-1].pointer=&usuarioFila[c];    
    }
    usuarioFila[2].pointer=NULL;
}
void exibeFila(struct fila usuarioFila[],int contador)
{
while (usuarioFila[contador].pointer!=NULL)
{
    printf("%D",usuarioFila[contador].valor);
    exibeFila(usuarioFila[contador].pointer, contador+1);
}
}
int main (void)
{
 struct fila usuarioFila[3];
 preencheFila(usuarioFila);
 exibeFila(usuarioFila,0);

}