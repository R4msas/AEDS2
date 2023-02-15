/*
 * Autor -Allan
 * Objetivo - Leia o nome de um arquivo e mostre seu conteúdo na tela

 */
import java.io.*;
import java.util.Scanner;
class Ex2{
   public static void main(String[] args) throws IOException {
    Scanner sc=new Scanner(System.in);
    String nomeArq, complemento =".txt";
    nomeArq=sc.nextLine();
    nomeArq=nomeArq+complemento;
    int contador;
    FileReader ler = new FileReader(nomeArq);
    while((contador=ler.read())!=-1)
    {
        System.out.print((char)contador);
    }
   }
          
}