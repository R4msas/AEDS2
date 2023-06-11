/**
 * q1 tp3,Lista com Aloca¸c˜ao Flex´ıvel: Refazer a Quest˜ao 3 “Lista com Aloca¸c˜ao Sequencial” do
Trabalho Pr´atico II usando lista dinˆamica simples em Java.
Autor  - Allan
 */
import java.io.RandomAccessFile;
public class q7 {
    public static void main(String[] args) throws Exception
    {
        ListaEncadeada l=new ListaEncadeada();        
        MyIO.setCharset("UTF-8");
        String input = MyIO.readLine(); 
        Celula tmp=new Celula();
        l.primeiro=l.ultimo=new Celula();//primeiro e último apontam para a mesma célula.
        while (!input.equals("FIM"))
        {
            Personagem personagem =new Personagem();
            personagem.ler(input);
            tmp.setAtual(personagem);
            l.inserirFinal(tmp);       
            input = MyIO.readLine().replaceAll("é", "\u00e9");
            tmp=new Celula();
        }
        int tamanho=l.getTamanhoLista();//encontra o tamanho de uma lista
        l.quicksort(l.primeiro.getProx(), l.ultimo,0,tamanho-1);
        tmp=l.primeiro;
        while(tmp!=l.ultimo)
        {   tmp=tmp.getProx();
            tmp.getAtual().imprimir();
        }
    }
}
class Personagem {
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;
  
    Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
            String corDosOlhos, String anoNascimento, String genero, String homeworld) {
        setNome(nome);
        setAltura(altura);
        setPeso(peso);
        setCorDoCabelo(corDoCabelo);
        setCorDaPele(corDaPele);
        setCorDosOlhos(corDosOlhos);
        setAnoNascimento(anoNascimento);
        setGenero(genero);
        setHomeworld(homeworld);
    }

    Personagem() {
        setNome("");
        setAltura(0);
        setPeso(0.0);
        setCorDoCabelo("");
        setCorDaPele("");
        setCorDosOlhos("");
        setAnoNascimento("");
        setGenero("");
        setHomeworld("");
    }

    // Setter e Getter para o atributo nome
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    // Setter e Getter para o atributo altura
    public void setAltura(int altura)
    {
        this.altura = altura;
    }

    public int getAltura()
    {
        return altura;
    }

    // Setter e Getter para o atributo peso
    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getPeso()
    {
        return peso;
    }

    // Setter e Getter para o atributo corDoCabelo
    public void setCorDoCabelo(String corDoCabelo)
    {
        this.corDoCabelo = corDoCabelo;
    }

    public String getCorDoCabelo()
    {
        return corDoCabelo;
    }

    // Setter e Getter para o atributo corDaPele
    public void setCorDaPele(String corDaPele)
    {
        this.corDaPele = corDaPele;
    }

    public String getCorDaPele()
    {
        return corDaPele;
    }

    // Setter e Getter para o atributo corDosOlhos
    public void setCorDosOlhos(String corDosOlhos)
    {
        this.corDosOlhos = corDosOlhos;
    }

    public String getCorDosOlhos()
    {
        return corDosOlhos;
    }

    // Setter e Getter para o atributo anoNascimento
    public void setAnoNascimento(String anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoNascimento()
    {
        return anoNascimento;
    }

    // Setter e Getter para o atributo genero
    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getGenero()
    {
        return genero;
    }

    // Setter e Getter para o atributo homeworld
    public void setHomeworld(String homeworld)
    {
        this.homeworld = homeworld;
    }

    public String getHomeworld()
    {
        return homeworld;
    }

    public void ler(String filePath) throws Exception
    {

        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        // String jsonString = file.readLine().replaceAll("é", "\u00e9");
        String jsonString = file.readLine();
        file.close();

        // Separando keys e values e atribuindo a suas variaveis
        String[] pairs = jsonString.substring(1, jsonString.length() - 1).split(", '");
        for (String pair : pairs)
        {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replaceAll("\'", "");
            String value = keyValue[1].replaceAll("\'", "").trim();

            if (key.equals("name"))
            {
                setNome(value);
            } else if (key.equals("height"))
            {
                if (value.equals("unknown"))
                {
                    setAltura(0);
                    continue;
                }
                setAltura(Integer.parseInt(value));
            } else if (key.equals("mass"))
            {
                if (value.equals("unknown"))
                {
                    setPeso(0);
                    continue;
                }
                setPeso(Double.parseDouble(value.replaceAll(",", "")));
            } else if (key.equals("hair_color"))
            {
                setCorDoCabelo(value);
            } else if (key.equals("skin_color"))
            {
                setCorDaPele(value);
            } else if (key.equals("eye_color"))
            {
                setCorDosOlhos(value);
            } else if (key.equals("birth_year"))
            {
                setAnoNascimento(value);
            } else if (key.equals("gender"))
            {
                setGenero(value);
            } else if (key.equals("homeworld"))
            {
                setHomeworld(value);
            } else
            {
                break;
            }
        }
    }

    public void imprimir()
    {
        MyIO.setCharset("UTF-8");
        MyIO.print(" ## " + this.nome);
        MyIO.print(" ## " + this.altura);
        if (this.peso % 1.0 != 0)
        {
            MyIO.print(" ## " + String.format("%s", this.peso));
        } else
        {
            MyIO.print(" ## " + String.format("%.0f", this.peso));
        }
        MyIO.print(" ## " + this.corDoCabelo);
        MyIO.print(" ## " + this.corDaPele);
        MyIO.print(" ## " + this.corDosOlhos);
        MyIO.print(" ## " + this.anoNascimento);
        MyIO.print(" ## " + this.genero);
        MyIO.print(" ## " + this.homeworld);
        MyIO.print(" ## ");
        MyIO.println("");
    }

    public Personagem clone()
    {
        Personagem cloned = new Personagem();

        cloned.nome = this.nome;
        cloned.altura = this.altura;
        cloned.peso = this.peso;
        cloned.corDoCabelo = this.corDoCabelo;
        cloned.corDaPele = this.corDaPele;
        cloned.corDosOlhos = this.corDosOlhos;
        cloned.anoNascimento = this.anoNascimento;
        cloned.genero = this.genero;
        cloned.homeworld = this.homeworld;

        return cloned;
    }
}

class Celula{
    private Personagem atual;
    private Celula prox;
    private Celula ant;
    public Celula getAnt() {
        return ant;
    }
    public void setAnt(Celula ant) {
        this.ant = ant;
    }
    public Personagem getAtual()
    {
        return atual;
    }
    public void setAtual(Personagem atual)
    {
        this.atual = atual;
    }
    public Celula getProx()
    {
        return prox;
    }
    public void setProx(Celula prox)
    {
        this.prox = prox;
    }
}

class ListaEncadeada{
    Celula ultimo;
    Celula primeiro;
    int comparacoes;
    int swap;
public int getTamanhoLista()
{   Celula tmp=primeiro;
    int tamanho=0;
    while(tmp.getProx()!=null)
    {
        tamanho++;
        tmp=tmp.getProx();

    }
    return tamanho;
}
public void quicksort(Celula inicio, Celula fim, int left,int right)
{ 
    Celula esq=inicio;
    Celula dir=fim;
    int i=left;
    int j=right;
    Personagem pivo=fim.getAtual();//cria um personagem pivo que recebe o personagem gravado na primeira posicao da lista
    while(i<=j)
    {
        comparacoes+=3;
        //testa se a cor do cabelo é menor, caso falso, testa se é igual, se sim, verifica se o nome é menor; se sim, o ponteiro não é alterado; 
        while ((esq.getAtual().getCorDoCabelo().compareTo(pivo.getCorDoCabelo()))<0||esq.getAtual().getCorDoCabelo().compareTo(pivo.getCorDoCabelo())==0&&esq.getAtual().getNome().compareTo(pivo.getNome())<0)
        {
            comparacoes+=3;
            esq=esq.getProx();
            i++;
        }
        
        
        comparacoes+=3;
        while(((dir.getAtual().getCorDoCabelo().compareTo(pivo.getCorDoCabelo())))>0||(dir.getAtual().getCorDoCabelo().compareTo(pivo.getCorDoCabelo()))==0&&dir.getAtual().getNome().compareTo(pivo.getNome())>0)
        {
            comparacoes+=3;
            dir=dir.getAnt();
            j--;
        
        }
        String a=esq.getAtual().getCorDoCabelo();
        a+=esq.getAtual().getNome();
        String b=dir.getAtual().getCorDoCabelo();
        b+=dir.getAtual().getNome();
        swapPersonagem(esq, dir);
        swap++;
        comparacoes++;
        if(!(esq.getAtual().getNome().equals(pivo.getNome())))//verifica se o nome é igual, se não move o ponteiro
        {
            i++;
            esq=esq.getProx();
        }
        comparacoes++;
        if(!(dir.getAtual().getNome().equals(pivo.getNome())))
        {
            j--;
            dir=dir.getAnt();
        }
    }
    if(left<j)
    {
    quicksort(inicio, dir,left, j);//chama recursivamente do início até o pivô
    }
    if(i<right)
    quicksort(esq, fim,i,right);// chama recursivamente do pivô até o fim
}
   
    



public void swapPersonagem(Celula a, Celula b)//troca o personagem entre duas células
{
    Personagem tmp=new Personagem();
    tmp=a.getAtual();
    a.setAtual(b.getAtual());
    b.setAtual(tmp);
}
    public void encontraComando(String stringRecebida, Celula tmp) throws Exception
    {
        Personagem resp=new Personagem();
        Personagem personagem=new Personagem();
        switch (stringRecebida.substring(0, 2)) {
            case "II":
                personagem.ler(stringRecebida.substring(3));
                tmp.setAtual(personagem);
                inserirInicio(tmp);
                personagem=null;
                break;
            case "I*":
            String auxString= stringRecebida.substring(6);
                personagem.ler(auxString);            
                tmp.setAtual(personagem);   
                if((Integer.parseInt(stringRecebida.substring(3,4)))==0)
                {
                    inserirInicio(tmp);
                }
                else {
                inserirNaPosicao(tmp, Integer.parseInt(stringRecebida.substring(3,4)));
                }
                break;
            case "IF":
                personagem=new Personagem();
                personagem.ler(stringRecebida.substring(3));
                tmp.setAtual(personagem);
                inserirFinal(tmp);
                personagem=null;
                break;
            case "RI":
            if(primeiro==ultimo)
            {
                MyIO.println("ERRO! lista vazia");
            }
            else{
                resp=removerInicio();
                System.out.println("(R) " + resp.getNome());
            }
                break;
            
            case "R*":
            if(Integer.parseInt(stringRecebida.substring(3))==0)
            {
                resp=removerInicio();
                System.out.println("(R) " + resp.getNome());
            }
            else {
                resp=removerNaPosicao(Integer.parseInt(stringRecebida.substring(3)));
                System.out.println("(R) " + resp.getNome());
            }
                break;
            case "RF":
            if(ultimo==primeiro)
            
            {
                MyIO.println("ERRO! Lista vazia");
            }
            else{
                resp=removerFim();
                System.out.println("(R) " + resp.getNome());
            }
                break;
            
        }
    }
   public void inserirInicio(Celula tmp)  {
    tmp.setProx(primeiro.getProx());
    primeiro.setProx(tmp);
    tmp=null;     

    }
    public void inserirFinal(Personagem personagem, Celula tmp)
    {
        tmp.setAtual(personagem);
        ultimo.setProx(tmp);
        tmp.setAnt(ultimo);
        ultimo=tmp;
        tmp=null;

    }
    public void inserirFinal(Celula tmp)
    {
        tmp.setAnt(ultimo);
        ultimo.setProx(tmp);
        ultimo=tmp;
        tmp=null;

    }
    public void inserirNaPosicao(Celula tmp, int posicaoDesejada)  {
        Celula temporaria=new Celula();
        int posicao=1;
        temporaria.setProx(primeiro.getProx());
        while(posicao<posicaoDesejada)
        {
        if(temporaria==ultimo)
        {
            MyIO.println("ERRO! Index out of bounds");
            posicao=posicaoDesejada;
        }
        else
        {
            temporaria=temporaria.getProx();
            posicao++;
        }
        }
        tmp.setProx(temporaria.getProx());
        temporaria.setProx(tmp);
        tmp=temporaria=null;
    }  
    public Personagem removerInicio()  {
        Personagem resposta=primeiro.getProx().getAtual();
        primeiro.setProx(primeiro.getProx().getProx());
        return resposta;
    }
    public Personagem removerFim() {
        Celula temporaria=primeiro.getProx();
        while(temporaria.getProx()!=ultimo)
        {
            temporaria=temporaria.getProx();
        }
        Personagem resposta=ultimo.getAtual();
        temporaria.setProx(null);
        ultimo=temporaria;
        return resposta;
    }
    public Personagem removerNaPosicao(int posicaoDesejada)  {
        Celula temporaria=new Celula();
        int posicao=1;//no método de identificar o comando já verifica se  é na posicao 0
        Personagem resposta=null;
        temporaria=primeiro.getProx();
        while(posicao<posicaoDesejada&&temporaria.getProx()!=ultimo)
        {
            temporaria=temporaria.getProx();
            posicao++;
        }
        if(posicao<posicaoDesejada)
        {
            MyIO.println("Lista menor que a posicao desejada");
        }
        else{
        Celula aux=new Celula();
        aux=temporaria.getProx();
        resposta=aux.getAtual();
        temporaria.setProx(aux.getProx());
        aux.setProx(null);
        aux=temporaria=null;
        }
        return resposta;

    }
    
}