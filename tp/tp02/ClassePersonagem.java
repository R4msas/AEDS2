import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * Autor - Allan 
 * Crie uma classe Personagem seguindo todas as regras apresentadas no slide
introducaoOO.pdf. Sua classe ter´a os atributos privados nome (String), altura (int), peso (double), corDoCabelo (String), codDaPele (String), corDosOlhos (String), anoNascimento (String),
genero (String), homeworld (String). Sua classe tamb´em ter´a pelo menos dois construtores, e os
m´etodos gets, sets, clone, imprimir e ler. O m´etodo imprimir mostra os atributos do registro
(ver cada linha da sa´ıda padr˜ao) e o ler lˆe os atributos de um registro.
A entrada padr˜ao ´e composta por v´arias linhas e cada uma cont´em uma string indicando o
arquivo a ser lido. A ´ultima linha da entrada cont´em a palavra FIM. A sa´ıda padr˜ao tamb´em
cont´em v´arias linhas, uma para cada registro contido em uma linha da entrada padr˜ao.
 */
class Personagem {
    
}
public class ClassePersonagem {

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
