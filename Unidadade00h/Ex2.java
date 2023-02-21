/*
 * Autor- Allan
 * Faça um método recursivo que receba um string e retorne um número 
inteiro indicando a quantidade de caracteres NOT vogal AND NOT 
consoante maiúscula da string recebida como parâmetro
 */
import java.util.Scanner;
class Ex2
{
public static int RecursivoString(String frase, int tamanhoString,int resp)
{
    
    char caractere=frase.charAt(tamanhoString);
    int ascii=(int)caractere;
    if(ascii>97&&ascii<123&&ascii!=101&&ascii!=105&&ascii!=111&&ascii!=117)
    { 
    System.out.println("resp DEVERIA AUMENTAR"+resp);
    resp++;
    System.out.println("Resp tá aumentando? agora é"+resp);
    }
    if(tamanhoString>0)
    {
       RecursivoString(frase, tamanhoString-1,resp);
    }
    return resp;
    }

public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String frase= sc.nextLine();
    int tamanhoString=frase.length()-1;
    int resp=0;
    RecursivoString(frase,tamanhoString,resp);
    System.out.println("A resposta é "+resp);
}
}

