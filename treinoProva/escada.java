/**
 * Autor Allan
 */
public class escada {
    public static void main(String[] args) {
        Matriz m=new Matriz();
        m.constroiMatriz(5, 5);
        m.encontraCelula(3,3)
        System.out.println("fim");
    }

    
}
class Matriz{
   
    Celula inicio;

    public void constroiMatriz(int i, int j)
    {
        Celula ancora=inicio=new Celula();
        Celula tmp=ancora;
        for(int c=i;c>1;c--)
        {
            Celula aux=new Celula();
            tmp.dir=aux;
            aux.esq=tmp;
            tmp=aux;
        }
        while(j>1)
        {
            tmp=new Celula();
            ancora.inf=tmp;
            tmp.sup=ancora;
            while(i>1)
            {
                Celula aux=new Celula();
                tmp.dir=aux;
                aux.esq=tmp;
                aux.sup=tmp.sup.dir;
                aux.sup.inf=aux;
                tmp=aux;
                i--;
            }
            ancora=ancora.inf;
            j--;
        }
    }
    public void encontraCelula(int i, int j)
    {
        Celula tmp= inicio;
        while(i>0)
        {
            tmp=tmp.dir;
        i--;
        }
        while(j>0)
        {
          tmp=tmp.inf;
          j--;  
        }
    }
}
class Celula{
    int numero;
    Celula inf;
    Celula sup;
    Celula dir;
    Celula esq;
}