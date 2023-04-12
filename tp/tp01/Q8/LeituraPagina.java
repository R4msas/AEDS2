/**
 * Autor - Allan
 * Leia duas strings sendo que a primeira ´e o nome de
uma p´agina web e a segunda, seu endere¸co. Por exemplo, “Pontif´ıcia Universidade Cat´olica de
Minas Gerais” e “www.pucminas.br”. Em seguida, mostre na tela o n´umero de vogais (sem e
com acento), consoantes e dos padr˜oes “< br >” e “< table >” que aparecem no c´odigo dessa
p´agina. A entrada padr˜ao ´e composta por v´arias linhas. Cada uma cont´em v´arias strings sendo
que a primeira ´e um endere¸co web e as demais o nome dessa p´agina web. A ´ultima linha da
entrada padr˜ao cont´em a palavra “FIM”. A sa´ıda padr˜ao cont´em v´arias linhas sendo que cada
uma apresenta o n´umero de ocorrˆencia (valor xi entre parˆenteses) de cada caractere ou string
solicitado. Cada linha de sa´ıda ser´a da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) ´a(x6) ´e(x7)
´ı(x8) ´o(x9) ´u(x10) `a(x11) `e(x12) `ı(x13) `o(x14) `u(x15) ˜a(x16) ˜o(x17) ˆa(x19) ˆe(x19) ˆı(x20) ˆo(x21)
ˆu(x22) consoante(x23) < br >(x24) < table >(x25) nomep´agina(x26).
https://www.scrapingbee.com/blog/java-parse-html-jsoup/ 
*/
import java.lang.*;

public class LeituraPagina {
    public void leituraPubIN(String nomeSite, String enderecoSite)
    {

    }

    public static void main(String[]args)
    {
    String nomeSite=MyIO.readLine();
    String enderecoSite;
    while(!nomeSite.equals("FIM")){
       enderecoSite=MyIO.readLine();

    }
 }
}