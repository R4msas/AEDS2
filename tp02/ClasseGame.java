import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * Autor - Allan Crie uma classe Game seguindo todas as regras apresentadas no slide unidade00l
 * nivelamento introducaoOO.pdf. Sua classe ter´a os atributos privados app id (Inteiro), name
 * (String), release date (Data), owners (String), age (Inteiro), price (Float), dlcs (Inteiro),
 * languages (Vetor de Strings), website (String), windows (Boolean), mac (Boolean), linux
 * (Boolean), upvotes (Float), avg pt (Inteiro), developers (String), genres (Vetor de Strings). Ela
 * ter´a tamb´em pelo menos dois construtores, e os m´etodos gets, sets, clone e imprimir e ler. O
 * m´etodo imprimir mostra a String ‘‘app id name release date owners age price dlcs [languages]
 * website windows mac linux upvotes avg pt developers [genres]’’, contendo todos os atributos da
 * classe. O m´etodo ler deve efetuar a leitura dos atributos de um registro. Veja que os dados
 * est˜ao divididos em v´arios arquivos. A entrada padr˜ao ´e composta por v´arias linhas e cada uma
 * cont´em o identificador de um jogo. A ´ultima linha da entrada cont´em F IM. A sa´ıda padr˜ao
 * tamb´em cont´em v´arias linhas, uma para cada registro contido na entrada padr˜ao, conforme o
 * exemplo abaixo 730 Counter-Strike: Global Offensive Aug/2012 50000000 - 100000000 0 0.00 1
 * [Czech, Danish, Dutch, English, Finnish, French, German, Hungarian, Italian, Japanese, Korean,
 * Norwegian, Polish, Portuguese, Portuguese - Brazil, Romanian, Russian, Simplified Chinese,
 * Spanish - Spain, Swedish, Thai, Traditional Chinese, Turkish, Bulgarian, Ukrainian, Greek,
 * Spanish - Latin America, Vietnamese] http://blog.counter-strike.net/ true true true 88% 508h 4m
 * Valve,Hidden Path Entertainment [Action, Free to Play]
 */
class Game {
    private int app_id;
    private String name;
    private String releaseDate;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    public Game() {

        this.app_id = -1;
        this.name = "";
        this.releaseDate = null;
        this.owners = null;
        this.age = -1;
        this.price = -1;
        this.dlcs = -1;
        this.languages = null;
        this.website = null;
        this.windows = false;
        this.mac = false;
        this.linux = false;
        this.upvotes = -1;
        this.avg_pt = -1;
        this.developers = null;
        this.genres = null;
    }

public Game (int app_id, String name, String releaseDate, String owners, int age, price, int dlcs, String [] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String []genres)
{
this.app_id= app_id;
this.name= name;
this.releaseDate=releaseDate;
this.owners= owners;
this.age= age;
this.price= price;
this.dlcs= dlcs;
this.languages[]= languages;
this.website= website;
this.windows= windows;
this.mac= mac;
this.linux= linux;
this.upvotes= upvotes;
this.avg_pt= avg_pt;
this.developers= developers;
this.genres[]= genres;
}

    public int getApp_id()
    {
        return app_id;
    }

    public int getAvg_pt()
    {
        return avg_pt;
    }

    public int getAge()
    {
        return age;
    }

    public String getDevelopers()
    {
        return developers;
    }

    public int getDlcs()
    {
        return dlcs;
    }

    public String[] getGenres()
    {
        return genres;
    }

    public String[] getLanguages()
    {
        return languages;
    }

    public boolean getLinux()
    {
        return linux;
    }

    public boolean getMac()
    {
        return mac;
    }

    public String getName()
    {
        return name;
    }

    public String getOwners()
    {
        return owners;
    }

    public float getPrice()
    {
        return price;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public float getUpvotes()
    {
        return upvotes;
    }

    public String getWebsite()
    {
        return website;
    }

    public boolean getWindows()
    {
        return windows;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setApp_id(int app_id)
    {
        this.app_id = app_id;
    }

    public void setAvg_pt(int avg_pt)
    {
        this.avg_pt = avg_pt;
    }

    public void setDevelopers(String developers)
    {
        this.developers = developers;
    }

    public void setDlcs(int dlcs)
    {
        this.dlcs = dlcs;
    }

    public void setGenres(String[] genres)
    {
        this.genres = genres;
    }

    public void setLanguages(String[] languages)
    {
        this.languages = languages;
    }

    public void setLinux(boolean linux)
    {
        this.linux = linux;
    }

    public void setMac(boolean mac)
    {
        this.mac = mac;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOwners(String owners)
    {
        this.owners = owners;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public void setUpvotes(float upvotes)
    {
        this.upvotes = upvotes;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public void setWindows(boolean windows)
    {
        this.windows = windows;
    }

    public void imprimir()
    {
        MyIO.print(getApp_id());
        MyIO.print(getName());
        MyIO.print(getReleaseDate());
        MyIO.print(getOwners());
        MyIO.print(getAge());
        MyIO.print(getPrice());
        MyIO.print(getDlcs());
        // MyIO.print(getLanguages());
        MyIO.print(getWebsite());
        MyIO.print(getWindows());
        MyIO.print(getMac());
        MyIO.print(getLinux());
        MyIO.print(getUpvotes());
        MyIO.print(getDevelopers());
        // MyIO.print(getGenres());


    }
}


public class ClasseGame {

    public static void main(String[] args)
    {
        String numeroDoJogo;
        int indice;
        Game jogo[] = new Game[100];
        int numeroDojogo = MyIO.readInt();
        String horaDeSairDoLoop= "não é fim";
        while (!(horaDeSairDoLoop.equals("FIM")))
        {

            jogo[indice] = new Game();
            jogo[indice].setApp_id(numeroDojogo);
        }


    }

}
