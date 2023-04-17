/**
 * q1 tp3,Lista com Aloca¸c˜ao Flex´ıvel: Refazer a Quest˜ao 3 “Lista com Aloca¸c˜ao Sequencial” do
Trabalho Pr´atico II usando lista dinˆamica simples em Java.
Autor  - Allan
 */
import java.io.RandomAccessFile;
public class q1 {
    public static class Celula{
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
    public static class Personagem {
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

    public static void encontraComando(String stringRecebida, Celula tmp, Celula primeiro, Celula ultimo) throws Exception
    {

        switch (stringRecebida.substring(0, 2)) {
            case "II":
                Personagem personagem=new Personagem();
                personagem.ler(stringRecebida.substring(3));
                tmp.atual=personagem;
                inserirInicio(tmp, primeiro);
                personagem=null;
                break;
            case "I*":
            
                tmp.atual.ler(stringRecebida.substring(stringRecebida.indexOf('/', 0)));
                if((Integer.parseInt(stringRecebida.substring(3)))==0)
                {
                    inserirInicio(tmp, primeiro);
                }
                inserirNaPosicao(tmp,primeiro, ultimo, Integer.parseInt(stringRecebida.substring(3)));
                break;
            case "IF":
                Personagem personagemTmp=new Personagem();
                personagemTmp.ler(stringRecebida.substring(3));
                inserirFinal(tmp, ultimo);
                personagemTmp=null;
                break;
            case "RI":
            if(primeiro==ultimo)
            {
                MyIO.println("ERRO! lista vazia");
            }
            else{
                System.out.println("(R) " + primeiro.prox.atual.nome);
                removerInicio(primeiro);
                break;
            }
            case "R*":
                System.out.println("(R) " + removerNaPosicao(primeiro, ultimo, Integer.parseInt(stringRecebida.substring(3))));
                break;
            case "RF":
            if(primeiro==ultimo)
            {
                MyIO.println("ERRO! Lista vazia");
            }
            else{
                System.out.println("(R) " + ultimo.atual.getNome());
                removerFim(primeiro, ultimo);
                break;
            }
        }
    }
    public static void inserirInicio(Celula tmp, Celula primeiro)  {
    tmp.prox= primeiro.prox;
    primeiro.prox=tmp;
    tmp=null;     

    }
    public static void inserirFinal(Personagem personagem, Celula tmp, Celula ultimo)
    {
        tmp.setAtual(personagem);
        ultimo.prox= tmp;
        ultimo=tmp;
        tmp=null;

    }
    public static void inserirFinal(Celula tmp, Celula ultimo)
    {

        ultimo.prox= tmp;
        ultimo=ultimo.prox;
        tmp=null;

    }
    public static void inserirNaPosicao(Celula tmp, Celula primeiro, Celula ultimo, int posicaoDesejada)  {
        Celula temporaria=new Celula();
        int posicao=1;
        temporaria=primeiro.prox;
        while(posicao<posicaoDesejada)
        {
        if(temporaria==ultimo)
        {
            MyIO.println("ERRO! Index out of bounds");
            posicao=posicaoDesejada;
        }
        else
        {
            temporaria=temporaria.prox;
            posicao++;
        }
        }
        tmp.prox=temporaria.prox;
        temporaria.prox=tmp;
        tmp=temporaria=null;
    }  
    public static void removerInicio(Celula primeiro)  {
        Celula temporaria=new Celula();
        temporaria=primeiro.prox;
        primeiro.prox=temporaria.prox;
        temporaria=null;
    }
    public static void removerFim(Celula primeiro, Celula ultimo) {
        Celula temporaria=primeiro.prox;
        while(temporaria.prox!=ultimo)
        {
            temporaria.prox=temporaria.prox.prox;
        }
        ultimo=temporaria;
        ultimo.prox=temporaria=null;


    }
    public static String removerNaPosicao(Celula primeiro, Celula ultimo,int posicaoDesejada)  {

        //teeste
        
        Celula temporaria=new Celula();
        int posicao=1;
        temporaria=primeiro.prox;
        while(posicao<posicaoDesejada||temporaria.prox==ultimo)
        {
            temporaria=temporaria.prox;
            posicao++;
        }
        Celula aux=new Celula();
        aux=temporaria.prox;
        String resposta=temporaria.prox.atual.getNome();
        temporaria.prox=aux.prox;
        aux=null;
        return resposta;
    }
    
        public static void main(String[] args) throws Exception
    {
        MyIO.setCharset("UTF-8");
        String input = MyIO.readLine();
        Celula primeiro=new Celula();
        Celula tmp=new Celula();
        Celula ultimo=primeiro;
        primeiro.prox=tmp;

        while (!input.equals("FIM"))
        {
            Personagem personagem =new Personagem();
            personagem.ler(input);
            tmp.atual=personagem;
            inserirFinal(personagem, tmp, ultimo);       
            input = MyIO.readLine().replaceAll("é", "\u00e9");
            ultimo=ultimo.prox;
            tmp=new Celula();
        }
        int repeticoes=MyIO.readInt();
        while(repeticoes>0)
        {
            input =MyIO.readLine();
            tmp=new Celula();
            encontraComando(input,tmp, primeiro, ultimo);
            repeticoes--;
        }
        tmp=primeiro;
       while(tmp!=ultimo)
       {
        tmp=tmp.prox;
        tmp.atual.imprimir();
       }

    }
}
