import java.io.RandomAccessFile;
public class q4 {
    public static void main(String[] args) throws Exception
    {
        int contadorComparacao = 0;
        long inicioTempo = System.nanoTime();
        String stringRecebida;
        Alvinegra an=new Alvinegra();
        //preenche a tabela hash
        //MyIO.setCharset("ISO-8859-1");
        stringRecebida = MyIO.readLine().replaceAll("é", "\u00e9");
        while (!stringRecebida.equals("FIM"))
        {
            Personagem personagem = new Personagem();
            personagem.ler(stringRecebida);
            an.inserir(personagem);
            stringRecebida = MyIO.readLine().replaceAll("é", "\u00e9");
        }
        //pesquisa
        stringRecebida = MyIO.readLine().replaceAll("é", "\u00e9");
        while (!stringRecebida.equals("FIM"))
        {
            MyIO.print(stringRecebida);
            if(an.pesquisar(stringRecebida))
            {
                MyIO.println(" SIM");
            }
            else
            {
                MyIO.println(" NÃO");
            }
        
            stringRecebida=MyIO.readLine().replaceAll("é", "\u00e9");//
        }
        long fimTempo = System.nanoTime();
        String tempoDecorrido = " , tempo decorrido em nanosegundos :" + (fimTempo - inicioTempo);
        String conteudoArquivo = "Número de comparações " + contadorComparacao+"\t"+ tempoDecorrido;
                String nomeDoArquivo = "AllanGuilhermeGomesPego_790152_alvinegra.txt";
        Arq.openWriteClose(nomeDoArquivo, conteudoArquivo);
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
    /*
     * public int hashInsercao(Personagem personagem) { int remocao=0;
     * 
     * }
     */
}


class Celula {
    private Personagem atual;
    private Celula prox;

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


class ListaEncadeada {
    Celula ultimo;
    Celula primeiro;

    public void encontraComando(String stringRecebida, Celula tmp) throws Exception
    {
        Personagem resp = new Personagem();
        Personagem personagem = new Personagem();
        switch (stringRecebida.substring(0, 2))
        {
            case "II":
                personagem.ler(stringRecebida.substring(3));
                tmp.setAtual(personagem);
                inserirInicio(tmp);
                personagem = null;
                break;
            case "I*":
                String auxString = stringRecebida.substring(6);
                personagem.ler(auxString);
                tmp.setAtual(personagem);
                if ((Integer.parseInt(stringRecebida.substring(3, 4))) == 0)
                {
                    inserirInicio(tmp);
                } else
                {
                    inserirNaPosicao(tmp, Integer.parseInt(stringRecebida.substring(3, 4)));
                }
                break;
            case "IF":
                personagem = new Personagem();
                personagem.ler(stringRecebida.substring(3));
                tmp.setAtual(personagem);
                inserirFinal(tmp);
                personagem = null;
                break;
            case "RI":
                if (primeiro == ultimo)
                {
                    MyIO.println("ERRO! lista vazia");
                } else
                {
                    resp = removerInicio();
                    System.out.println("(R) " + resp.getNome());
                }
                break;

            case "R*":
                if (Integer.parseInt(stringRecebida.substring(3)) == 0)
                {
                    resp = removerInicio();
                    System.out.println("(R) " + resp.getNome());
                } else
                {
                    resp = removerNaPosicao(Integer.parseInt(stringRecebida.substring(3)));
                    System.out.println("(R) " + resp.getNome());
                }
                break;
            case "RF":
                if (ultimo == primeiro)

                {
                    MyIO.println("ERRO! Lista vazia");
                } else
                {
                    resp = removerFim();
                    System.out.println("(R) " + resp.getNome());
                }
                break;

        }
    }

    public void inserirInicio(Celula tmp)
    {
        tmp.setProx(primeiro.getProx());
        primeiro.setProx(tmp);
        tmp = null;

    }

    public void inserirFinal(Personagem personagem, Celula tmp)
    {
        tmp.setAtual(personagem);
        ultimo.setProx(tmp);
        ultimo = tmp;
        tmp = null;

    }

    public void inserirFinal(Celula tmp)
    {

        ultimo.setProx(tmp);
        ultimo = tmp;
        tmp = null;

    }

    public void inserirNaPosicao(Celula tmp, int posicaoDesejada)
    {
        imprimeTodos();
        Celula temporaria = new Celula();
        int posicao = 1;
        temporaria.setProx(primeiro.getProx());
        while (posicao < posicaoDesejada)
        {
            if (temporaria == ultimo)
            {
                MyIO.println("ERRO! Index out of bounds");
                posicao = posicaoDesejada;
            } else
            {
                temporaria = temporaria.getProx();
                posicao++;
            }
        }
        tmp.setProx(temporaria.getProx());
        temporaria.setProx(tmp);
        tmp = temporaria = null;
        imprimeTodos();
    }

    public Personagem removerInicio()
    {
        Personagem resposta = primeiro.getProx().getAtual();
        primeiro.setProx(primeiro.getProx().getProx());
        return resposta;
    }

    public Personagem removerFim()
    {
        Celula temporaria = primeiro.getProx();
        while (temporaria.getProx() != ultimo)
        {
            temporaria = temporaria.getProx();
        }
        Personagem resposta = ultimo.getAtual();
        temporaria.setProx(null);
        ultimo = temporaria;
        return resposta;
    }

    public Personagem removerNaPosicao(int posicaoDesejada)
    {
        imprimeTodos();
        Celula temporaria = new Celula();
        int posicao = 1;// no método de identificar o comando já verifica se é na posicao 0
        Personagem resposta = null;
        temporaria = primeiro.getProx();
        while (posicao < posicaoDesejada && temporaria.getProx() != ultimo)
        {
            temporaria = temporaria.getProx();
            posicao++;
        }
        if (posicao < posicaoDesejada)
        {
            MyIO.println("Lista menor que a posicao desejada");
        } else
        {
            Celula aux = new Celula();
            aux = temporaria.getProx();
            resposta = aux.getAtual();
            temporaria.setProx(aux.getProx());
            aux.setProx(null);
            aux = temporaria = null;
        }
        imprimeTodos();
        return resposta;

    }

    public void imprimeTodos()
    {
        Celula tmp = primeiro;
        while (tmp.getProx() != null)
        {
            tmp = tmp.getProx();
            tmp.getAtual().imprimir();
        }
    }
}

class No{
    public boolean cor;
    public Personagem personagem;
    public No esq;
    public No dir;
    public boolean isCor()
    {
        return cor;
    }
    public void setCor(boolean cor)
    {
        this.cor = cor;
    }
    public Personagem getPersonagem()
    {
        return personagem;
    }
    public void setPersonagem(Personagem personagem)
    {
        this.personagem = personagem;
    }
    public No getEsq()
    {
        return esq;
    }
    public void setEsq(No esq)
    {
        this.esq = esq;
    }
    public No getDir()
    {
        return dir;
    }
    public void setDir(No dir)
    {
        this.dir = dir;
    }
}
class Alvinegra{
    private No raiz;

    public No getRaiz()
    {
        return raiz;
    }

    public void setRaiz(No raiz)
    {
        this.raiz = raiz;
    }
    public Boolean pesquisar(String nome)
    {
        MyIO.print(" raiz");
        Boolean resp =pesquisar(nome, raiz);
        return resp;
    }
    public Boolean pesquisar(String nome, No no)
    {
        Boolean resp= false;
        if(no==null)
        {

        }
        else if(no.personagem.getNome().equals(nome))
        {
            resp=true;
        }
        else if(nome.compareTo(no.personagem.getNome())<0)
        {
            MyIO.print(" esq");
            resp=pesquisar(nome, no.esq);
        }
        else{
            MyIO.print(" dir");
            resp=pesquisar(nome, no.dir);
        }
        return resp;
    }
    public void inserir(Personagem personagem) throws Exception {
      //árvore vazia
      if (raiz == null) {
         raiz = new No();
         raiz.personagem=personagem;
      } else if (raiz.esq == null && raiz.dir == null) {
         if (personagem.getNome().compareTo(raiz.personagem.getNome())<0) {
            raiz.esq = new No();
            raiz.esq.personagem=personagem;
         } else {
            raiz.dir = new No();
            raiz.dir.personagem=personagem;
         }
//arvore com dois elementos, raiz e dir
      } else if (raiz.esq == null) 
      {
         if (personagem.getNome().compareTo(raiz.personagem.getNome())<0) {
            raiz.esq = new No();
            raiz.esq.personagem=personagem;
         } else if (personagem.getNome().compareTo(raiz.dir.personagem.getNome())<0) {
            raiz.esq = new No();
            raiz.esq.personagem=raiz.personagem;
            raiz.personagem = personagem;
         } else {
            raiz.esq = new No();
            raiz.esq.personagem=raiz.personagem;
            raiz.personagem = raiz.dir.personagem;
            raiz.dir.personagem = personagem;
         }
         raiz.esq.cor = raiz.dir.cor = false;

      // Senao, se a arvore tiver dois personagems (raiz e esq)
      } 
      else if (raiz.dir == null) {
         if (personagem.getNome().compareTo(raiz.personagem.getNome())>0) {
            raiz.dir = new No();
            raiz.dir.personagem=personagem;
         } else if (personagem.getNome().compareTo(raiz.esq.personagem.getNome())>0) {
            raiz.dir = new No();
            raiz.dir.personagem=raiz.personagem;
            raiz.personagem = personagem;
         } else {
            raiz.dir = new No();
            raiz.dir.personagem=raiz.personagem;
            raiz.personagem = raiz.esq.personagem;
            raiz.esq.personagem = personagem;
         }
         raiz.esq.cor = raiz.dir.cor = false;

      // Senao, a arvore tem tres ou mais personagems
      } else {
         inserir(personagem, null, null, null, raiz);
      }
      raiz.cor = false;
   }
private void inserir(Personagem personagem, No bisavo, No avo, No pai, No atual)
{
    if (atual==null)
    {
        if((personagem.getNome().compareTo(pai.personagem.getNome()))<0)
        {
            pai.esq=atual=new No();
            atual.personagem=personagem;  
            atual.cor=true;          
        }
        else{
            pai.dir=atual=new No();
            atual.personagem=personagem;
            atual.cor=true;
        }
        if(pai.cor==true)
        {
            balancear(bisavo, avo, pai, atual);
        }
    }
    else{
        if(atual.esq!=null&& atual.dir!=null&&atual.esq.cor==true&&atual.dir.cor==true)
        {
            atual.cor=true;
            atual.esq.cor=atual.dir.cor=false;
            if(atual==raiz)
            {
                atual.cor=false;
            }
            else if(pai.cor==true){
                balancear(bisavo, avo, pai, atual);
            }
        }
        if (personagem.getNome().compareTo(atual.personagem.getNome())<0)
        {
            inserir(personagem, avo, pai, atual, atual.esq);
        }
        else 
        {
            inserir(personagem, avo, pai, atual, atual.dir);
        }
    }
}
private void balancear(No bisavo, No avo, No pai, No atual)
{
if (pai.cor == true) {
         // 4 tipos de reequilibrios e acoplamento
         if (pai.personagem.getNome().compareTo(avo.personagem.getNome()) >0 ) { // rotacao a esquerda ou direita-esquerda
            if (atual.personagem.getNome().compareTo(pai.personagem.getNome())>0) {
               avo = rotacaoEsq(avo);
            } else {
               avo = rotacaoDirEsq(avo);
            }
         } else { // rotacao a direita ou esquerda-direita
            if (atual.personagem.getNome().compareTo(pai.personagem.getNome())<0) {
               avo = rotacaoDir(avo);
            } else {
               avo = rotacaoEsqDir(avo);
            }
         }
         if (bisavo == null) {
            raiz = avo;
         } else if (avo.personagem.getNome().compareTo(bisavo.personagem.getNome())<0) {
            bisavo.esq = avo;
         } else {
            bisavo.dir = avo;
         }
         // reestabelecer as cores apos a rotacao
         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;
      } 
}
private No rotacaoDir(No no) {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }
private No rotacaoEsq(No no) {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;
      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }
private No rotacaoDirEsq(No no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }
private No rotacaoEsqDir(No no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }
} 