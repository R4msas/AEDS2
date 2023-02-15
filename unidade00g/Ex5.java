/*
 Autor- Allan 
 Objetivo:
• Seja uma partida de futebol, leia os números de gols do mandante e do 
visitante e imprima quem foi o vencedor ou se foi empate.

 */



import java.util.Scanner;
public class Ex5 {
    
    public static void main(String[]args)
    { 
    Scanner sc = new Scanner(System.in);
    int golVisitante, golMandante;
    golMandante = sc.nextInt();
    golVisitante = sc.nextInt();
    if(golMandante>golVisitante)
    {
        System.out.println("O vencedor foi o mandante");
    }
    else if(golVisitante>golMandante)
    {
        
        System.out.println("O vencedor foi o visitante");
    }
    else
    {
        
        System.out.println("Houve empate.");
    }

    }
}
