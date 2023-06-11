/**
 * q1 tp3,Lista com Aloca¸c˜ao Flex´ıvel: Refazer a Quest˜ao 3 “Lista com Aloca¸c˜ao Sequencial” do
 * Trabalho Pr´atico II usando lista dinˆamica simples em Java. Autor - Allan
 */
import java.io.RandomAccessFile;
public class q5 {
    public static void main(String[] args) throws Exception
    {
        Personagem hashTable[] = new Personagem[30];
        int tamTab=21; 
        int tamReserva = 9;
        int posicaoReserva = 0;
        int contadorComparacao = 0;
        long inicioTempo = System.nanoTime();
        String stringRecebida;
        //preenche a tabela hash
        stringRecebida = MyIO.readLine();
        while (!stringRecebida.equals("FIM"))
        {

            Personagem personagem = new Personagem();
            personagem.ler(stringRecebida);
            int hash = personagem.getAltura() % 21;
            if (hashTable[hash] == null)
            {
                hashTable[hash] = personagem;
            } 
            else if (posicaoReserva<tamReserva)
            {
                hashTable[tamTab+posicaoReserva] = personagem;//insere na posição da reserva.
                posicaoReserva++;
            }

            stringRecebida = MyIO.readLine();
        }
        posicaoReserva--;//esta variável sempre aponta para a próxima posição, após o preenchimento é preciso voltá-la para a posição atual 
        //pesquisa
        stringRecebida = MyIO.readLine();
        while (!stringRecebida.equals("FIM"))
        {
            
            String nomePersonagem=stringRecebida.replaceAll("\\s","");
            nomePersonagem+=".txt";
            String caminhoArquivo= "/tmp/personagens/";
            caminhoArquivo+=nomePersonagem;
            Personagem personagem = new Personagem();
            personagem.ler(caminhoArquivo);
            int hash = personagem.getAltura() % 21;
            MyIO.print(stringRecebida+" ");
            contadorComparacao++;
            if(hashTable[hash]==null)
            {
                MyIO.println("NÃO");
            }
            else if(hashTable[hash].getNome().equals(personagem.getNome()))
            {
                contadorComparacao++;
                MyIO.println("SIM");
            }
            else if(posicaoReserva>=0)//se reserva for igual a -1 está vazia.
            {
            contadorComparacao++;//caso não entre no else if anterior, conta também a comparação que é devida
                Boolean possuiPersonagem=false;
                for(int c=0; c<=posicaoReserva; c++) 
                {
                    contadorComparacao++;
                    if(hashTable[tamTab+c].getNome().equals(personagem.getNome()))//se o nome estiver dentro da reserva
                    {
                        hashTable[tamTab+c]=hashTable[tamTab+posicaoReserva];//coloca a última posição da reserva na posição onde havia o personagem
                        c=posicaoReserva; //para parar o for
                         posicaoReserva--;//diminui o tamanho da reserva
                         MyIO.println("SIM");
                         possuiPersonagem=true;
                    }
                    
                }
                if(possuiPersonagem==false)
                    {
                        MyIO.println("NÃO");
                    }
            }
            stringRecebida=MyIO.readLine();
        }
        long fimTempo = System.nanoTime();
        String tempoDecorrido = " , tempo decorrido em nanosegundos :" + (fimTempo - inicioTempo);
        String conteudoArquivo = "Número de comparações " + contadorComparacao+"\t"+ tempoDecorrido;
                String nomeDoArquivo = "AllanGuilhermeGomesPego_790152_hashReserva.txt";
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
