import java.io.RandomAccessFile;
import java.text.BreakIterator;
import java.text.Normalizer;

public class ArvoreDeArvoreBinariaTp4 {
    public static void main(String[] args) throws Exception {
        ArvoreBinariaExterna b = new ArvoreBinariaExterna();
        int[] chavesArvoreExterna = {7,3,11,1,5,9,12,0,2,4,6,8,10,13,14};
        for (int chave : chavesArvoreExterna){
            b.inserirExterna(chave);
        }        
        MyIO.setCharset("UTF-8");
        String input = MyIO.readLine().replaceAll("é", "\u00e9"); 
        while (!input.equals("FIM")){
            Personagem personagem = new Personagem();
            personagem.ler(input);
            // b.inserirNomeNaInterna(personagem.getNome(),personagem.getAltura());
            b.inserirNomeNaInterna(personagem);
            input = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        input = MyIO.readLine().replaceAll("é", "\u00e9");
        while (!input.equals("FIM")){
            String caminhoPercorrido = b.pesquisar(input);
            System.out.println(caminhoPercorrido.replaceAll("Ã", "\uFFFD"));
            input = MyIO.readLine().replaceAll("é", "\u00e9");

        }
    }    
}
//MAIN OK!!!
//////////////////////////////////////////////////////////////////////////////

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


//Classe Acima OK!
//////////////////////////////////////////////////////////////////////////////
class No2{
    public String nome;
    public No2 dir,esq;

    public No2(String nome){
        this.nome = nome;
    }
    public No2(String nome, No2 esq, No2 dir) {
        this.nome = nome;
        this.esq = esq;
        this.dir = dir;
    }

    public String getnome(){
        return nome;
    }

    public void setnome(Personagem nome) {
        String nomePersonagem = nome.getNome();
        this.nome = nomePersonagem;
    }
    public No2 getDir() {
        return dir;
    }
    public No2 getEsq() {
        return esq;
    }
    public void setDir(No2 dir) {
        this.dir = dir;
    }
    public void setEsq(No2 esq) {
        this.esq = esq;
    }
}
//Classe acima OK!
//////////////////////////////////////////////////////////////////////////////

class No1{
    private int modAltura;
    public No2 raizArvoreInterna;
    //public int modAltura;
    public No1 esq;
    public No1 dir;
    //private No2 raizArvoreInterna;

    public No1(){
        raizArvoreInterna = null;
    }

    public No1(int x){
        this.modAltura = x;
    }

    public No1(int altura,No1 esq,No1 dir,No2 raiz){
        this.modAltura = altura;
        this.esq = esq;
        this.dir = dir;
        this.raizArvoreInterna = raiz;
    }
    public No1 getDir() {
        return dir;
    }
    public No1 getEsq() {
        return esq;
    }
    public int getModAltura() {
        return modAltura;
    }
    public No2 getRaizArvoreInterna() {
        return raizArvoreInterna;
    }
    public void setDir(No1 dir) {
        this.dir = dir;
    }
    public void setEsq(No1 esq) {
        this.esq = esq;
    }
    public void setModAltura(int modAltura) {
        this.modAltura = modAltura;
    }
    public void setRaizArvoreInterna(No2 raizArvoreInterna) {
        this.raizArvoreInterna = raizArvoreInterna;
    }
    //Métodos acima OK!
//////////////////////////////////////////////////////////////////////////////


    //O inserirInterna e o inserirRecursivaInterna são os métodos para criação
    //da árvore com chave de pesquisa o nome do personagem.
    //Esses métodos fazem parte do No1 (chave de pesquisa = altura) que é uma
    //dimensão acima do No2.
    public void inserirInterna(String x) throws Exception{
        raizArvoreInterna = inserirRecursivaInterna(x,raizArvoreInterna);
    }
    private No2 inserirRecursivaInterna(String x, No2 no){
        if(no == null){
            return new No2(x);
        }
        int resultado = x.compareTo(no.nome);

        if(resultado < 0){
            no.esq = inserirRecursivaInterna(x,no.esq);
        }
        else if(resultado > 0){
            no.dir = inserirRecursivaInterna(x, no.dir);
        }
        return no;
    }
    //Métodos acima OK!
//////////////////////////////////////////////////////////////////////////////

//O método de pesquisa deverá retonar uma String contendo o caminho
//percorrido pela árvore interna(chave = nome).
//Esse método recebe um nó da árvore externa(chave=altura)
//O retorno será acrecentado no caminho da pesquisa dessa árvore com chave = altura.

    public String pesquisarInterna(String nome,StringBuilder caminho)throws Exception{
        
        //StringBuilder caminhoInterna = new StringBuilder();
        
        pesquisarRecursivoInterna(raizArvoreInterna,nome,caminho);
        
        return caminho.toString();
    }

    private String pesquisarRecursivoInterna(No2 no,String nome,StringBuilder caminhoInterna) throws Exception{

        if (no == null) {
            caminhoInterna.append("NÃO");
            
            return caminhoInterna.toString();
        }

        int comparacao = nome.compareTo(no.nome);

        if(comparacao == 0){
            caminhoInterna.append("SIM");
            return caminhoInterna.toString();
        }
        else if(comparacao < 0){
            caminhoInterna.append("ESQ ");
            pesquisarRecursivoInterna(no.esq, nome, caminhoInterna);
        }
        else if(comparacao>0){
            caminhoInterna.append("DIR ");
            pesquisarRecursivoInterna(no.dir, nome, caminhoInterna);
        }
        return caminhoInterna.toString();
    }
}
// Verificar método pesquisa!
//////////////////////////////////////////////////////////////////////////////


//Criando a árvore Externa(chave = altura);

class ArvoreBinariaExterna{
    
    // private No1 raizExterna;
    public No1 raizExterna;
    public ArvoreBinariaExterna(){
        raizExterna = null;
    }
    public void setRaizExterna(No1 raizExterna) {
        this.raizExterna = raizExterna;
    }
    public No1 getRaizExterna() {
        return raizExterna;
    }

    public void inserirExterna(int x) throws Exception{
        raizExterna = inserirRecursivoExterna(x,raizExterna);
    }
    private No1 inserirRecursivoExterna(int x, No1 no){
        if ( no == null){
            return new No1(x);
        }
        else if(no.getModAltura()<x){
            no = inserirRecursivoExterna(x, no.esq);
        }
        else if(no.getModAltura()>x){
            no = inserirRecursivoExterna(x, no.dir);
        }
        return no;
    }
//Método acima OK!
//////////////////////////////////////////////////////////////////////////////

// Criando método para inserir o personagem nos nós da árvore externa;
// public void inserirNomeNaInterna(String nome, int altura) throws Exception{
//     raizExterna = inserirNomeNaInterna(nome,altura,raizExterna);
// }
public void inserirNomeNaInterna(Personagem objPersonagem) throws Exception{
    
    //primeiro devemos procurar em qual nó da árvore interna deverá ser inserido o personagem
    //A chave é o resto da divisão da altura por 15.
    int altura = objPersonagem.getAltura()%15;
    String nome = objPersonagem.getNome();
    raizExterna = inserirNomeNaInterna(nome,altura,raizExterna);
}

private No1 inserirNomeNaInterna(String nome,int altura, No1 i) throws Exception{
    if(i.getModAltura() == altura){
        i.inserirInterna(nome);
    }//else if(altura<i.getModAltura()){
    //else if(i.getModAltura() <altura){
    else if(altura<i.getModAltura()){
        i.esq = inserirNomeNaInterna(nome, altura, i.esq);
    }
    else if(altura>i.getModAltura()){    
    //else if(i.getModAltura()> altura){
        i.dir = inserirNomeNaInterna(nome, altura, i.dir);
    }
    return i;
}
//Método acima OK!
//////////////////////////////////////////////////////////////////////////////

//O método pesquisar da árvore com chave=altura, terá que percorrer todos os nós de todas as árvore.
//Deste modo deveremos utilizar um mostra pré ordem para a arvore externa e na arvore interna um pesquisar normal.
//No exercício nos é passado apenas o nome do personagem, sem a sua altura!
    public void caminharPre(No1 i,StringBuilder caminhoExterna,String nome) throws Exception{
        if(i!=null){
            caminhoExterna.append("esq ");
            i.pesquisarInterna(nome,caminhoExterna);
            caminharPre(i.esq,caminhoExterna,nome);
            caminhoExterna.append("dir ");
            i.pesquisarInterna(nome,caminhoExterna);
            caminharPre(i.dir,caminhoExterna,nome);
        }
    }

    public String pesquisar(String nomePersonagem)throws Exception{
        
        StringBuilder caminhoExterna = new StringBuilder();    
        caminhoExterna.append(nomePersonagem);
        caminhoExterna.append(" raiz ");
        caminharPre(raizExterna, caminhoExterna, nomePersonagem);
            
        return caminhoExterna.toString();
    }
}
