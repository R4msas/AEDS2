import java.util.ArrayList;
import java.util.Scanner;

/**
 * treinoProva
 */
public class treinoProva {
public static void main(String[] args) {
String s=MyIO.readLine();
String r=removePontuacao(s);
MyIO.println(r);

}
    public static String removePontuacao(String s)
    {
        String regex = "\\p{Punct}";
        String result = s.replaceAll(regex, "");
        return result;
    }
    public static String removeCaractereEspecial(String s)//retira pontuação e caracteres especiais.
    {
        String regex = "[^a-zA-Z0-9\\s]";
        s = s.replaceAll(regex, "");
        return s;
    }
   public static ArrayList<String> leituraString()
    {
        ArrayList <String> array=new ArrayList<>();
        String input=MyIO.readLine();
        while(!input.equals("FIM"))
        {
            array.add(input);
            input=MyIO.readLine();
        }
        return array;
    }
    public static ArrayList<String> leituraPalavra()
    {
        Scanner sc=new Scanner(System.in);
        ArrayList <String> array=new ArrayList<>();
        String input=sc.next();
        while(!input.equals("FIM"))
        {
            array.add(input);
            input=sc.next();
        }
        return array;
    }
}