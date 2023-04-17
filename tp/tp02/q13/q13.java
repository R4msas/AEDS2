/*
 * Autor Allan
 * Objetivo - Ordenação por shellsort
 */
import java.io.RandomAccessFile;
public class Celula{
    private Personagem atual;
    private Personagem prox;
    public Personagem getAtual() {
        return atual;
    }
    public void setAtual(Personagem atual) {
        this.atual = atual;
    }
    public Personagem getProx() {
        return prox;
    }
    public void setProx(Personagem prox) {
        this.prox = prox;
    }   
    
}

public class q1 {

    public class Personagem {
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

        public void Ler(String filePath) throws Exception
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

        public void Imprimir()
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

    /*
     * public static void retiraPilha(int posicaoArray, Personagem[] arrayDePersonagens) {
     * MyIO.println("(R) " + arrayDePersonagens[posicaoArray].nome);
     * arrayDePersonagens[posicaoArray] = null; }
     */
    public boolean comparaString(String primeiraString, String segundaString)//retorna se a primeira string é menor que a segunda
    {
        boolean resposta = false;
        int c = 0;
        int tamanhoDaMenorString;
       if (primeiraString.length()<segundaString.length())
       {
        tamanhoDaMenorString=primeiraString.length();
       }
       else{
        tamanhoDaMenorString=segundaString.length();
       }
            while (c < tamanhoDaMenorString)
            {
                if (primeiraString.charAt(c) == segundaString.charAt(c))
                {
                    c++;
                } else if (primeiraString.charAt(c) < segundaString.charAt(c))
                {
                    resposta = true;
                    c = tamanhoDaMenorString;
                } else
                {
                    c = tamanhoDaMenorString;
                }
            }
       
        return resposta;
    }

    public void ordenaInsercao(Personagem[] arrayDePersonagens, int posicaoFinalDoArray, int contador[])
    {
        boolean shift = false;
        int posicaoShift = 0;

        for (int primeiraPosicaoDesordenada =1; primeiraPosicaoDesordenada < posicaoFinalDoArray; primeiraPosicaoDesordenada++)
        {

            shift=false;
            Personagem auxiliar = new Personagem();
            for (int ordenada = primeiraPosicaoDesordenada - 1; ordenada >= 0; ordenada--)
            {
               /* MyIO.println("primeira posicao desordenada:"
                        + arrayDePersonagens[primeiraPosicaoDesordenada].anoNascimento
                        + ", posicao ordenada " + arrayDePersonagens[ordenada].anoNascimento); */
                contador[0]+=1;
                if ((arrayDePersonagens[primeiraPosicaoDesordenada].altura==
                arrayDePersonagens[ordenada].altura)&&comparaString(arrayDePersonagens[primeiraPosicaoDesordenada].nome,
                arrayDePersonagens[ordenada].nome))
                {
                    //MyIO.println("posicao menor, efetua troca do shift");
                    posicaoShift = ordenada;
                    shift = true;
                } else if (shift)
                {
                    break;
                }
                else         
                {
                    ordenada = -1;
                }
            }
            if (shift)
            {
                contador[1]+=1;
               /*  MyIO.println(
                        "efetua o shift de " + primeiraPosicaoDesordenada + "até " + posicaoShift); */
                auxiliar = arrayDePersonagens[primeiraPosicaoDesordenada];
                for (int j = primeiraPosicaoDesordenada; j > posicaoShift; j--)
                {
                    arrayDePersonagens[j] = arrayDePersonagens[j - 1];
                }
                arrayDePersonagens[posicaoShift] = auxiliar;
              /*   MyIO.println("array ordenado até o momento");
                for (int c = 0; c <= primeiraPosicaoDesordenada; c++)
                {
                    arrayDePersonagens[c].Imprimir();
                } */
            }

        }
       /*  long fimTempo = System.nanoTime();
        String tempoDecorrido = " , tempo decorrido em nanosegundos :" + (fimTempo - inicioTempo);
        String conteudoArquivo = "Número de comparações " + contadorComparacao
                + ", número de troca de posições " + contadorPosicao + tempoDecorrido;
        return conteudoArquivo; */
    }
    
    public void swapPersonagem(Personagem[] arrayDePersonagens, int posicaoA,int posicaoB)
    {
        Personagem aux= new Personagem();
        aux=arrayDePersonagens[posicaoA];
        arrayDePersonagens[posicaoA]=arrayDePersonagens[posicaoB];
        arrayDePersonagens[posicaoB]=aux;

    }


    public String ordenaHeapSort(Personagem[] arrayDepersonagens, int posicaoFinalDoArray)
    {
        int [] contador={0,0};//índice 0 comparações, 1 é movimentações
        
        long inicioTempo = System.nanoTime();
            for (int i = (posicaoFinalDoArray / 2) - 1; i >= 0; i--)
            {
                heapify(arrayDepersonagens, posicaoFinalDoArray, i,contador);//cria o max heap
            }   
            for (int i = posicaoFinalDoArray - 1; i >= 0; i--) {
                swapPersonagem(arrayDepersonagens, 0, i);
                contador[1]+=1;
                heapify(arrayDepersonagens, i, 0,contador);
            }
        ordenaInsercao(arrayDepersonagens, posicaoFinalDoArray,contador);
        long fimTempo = System.nanoTime();
        int contadorPosicao = contador[1];
        int contadorComparacao = contador[0]; 
        String tempoDecorrido = " , tempo decorrido em nanosegundos :" + (fimTempo - inicioTempo);
        String conteudoArquivo = "Número de comparações " + contadorComparacao
                + ", número de troca de posições " + contadorPosicao + tempoDecorrido;
        return conteudoArquivo;
    }
        public void heapify(Personagem arrayDePersonagens[], int n, int root,int []contador)
        {
            
            int maior = root; // Inicializa maior como root
            int esq = 2 * root + 1; 
            int dir = 2 * root + 2; 
            // MyIO.println("tamanho do Array"+arrayDePersonagens.length+"root: "+root+"esq: "+esq+" dir"+dir);
            contador[0]+=1;
            
            if ((esq < n) && (arrayDePersonagens[esq].altura > arrayDePersonagens[maior].altura))
                maior = esq;
            contador[0]+=1;
            if (dir < n && arrayDePersonagens[dir].altura > arrayDePersonagens[maior].altura)
                maior = dir;
                contador[0]+=2;//efetua duas comparações por chamada do heapfy
            if (maior != root) {
                /* MyIO.println("Root: nome"+arrayDePersonagens[root].nome+", altura "+arrayDePersonagens[root].altura);
                MyIO.println("Esquerda: nome"+arrayDePersonagens[esq].nome+", altura "+arrayDePersonagens[esq].altura);
                MyIO.println("Direita: nome"+arrayDePersonagens[dir].nome+", altura "+arrayDePersonagens[dir].altura);
                MyIO.println("troca entre "+arrayDePersonagens[root].nome+"e o maior "+arrayDePersonagens[maior].nome); */
                swapPersonagem(arrayDePersonagens, root, maior);
                contador[1]+=1;
                heapify(arrayDePersonagens, n, maior,contador);//recursivamente chama heapify para o resto do heap afetado
            }
        }
    public static void main(String[] args) throws Exception
    {
        MyIO.setCharset("UTF-8");
        Personagem arrayDePersonagens[] = new Personagem[100];
        String input = MyIO.readLine();
        int posicaoArray = 0;

        while (!input.equals("FIM"))
        {
            arrayDePersonagens[posicaoArray] = new Personagem();
            arrayDePersonagens[posicaoArray].Ler(input);
            input = MyIO.readLine().replaceAll("é", "\u00e9");
            posicaoArray++;// cria a próxima posição no array
        }
        String nomeDoArquivo = "790152_heapsort.txt";
        Arq.openWriteClose(nomeDoArquivo, ordenaHeapSort(arrayDePersonagens, posicaoArray));

        for (int c = 0; c < posicaoArray; c++)
        {
            arrayDePersonagens[c].Imprimir();
        }

    }
}
