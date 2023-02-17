/*
 * Autor -Allan
 * Objetivo - • Leia o nome de um arquivo e uma frase e salve essa frase 
nesse arquivo
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Ex1{
   public static void main(String[] args) throws IOException {
    Scanner sc=new Scanner(System.in);
    String nomeArq, frase, complemento =".txt";
    nomeArq=sc.nextLine();
    frase= sc.nextLine();
    nomeArq=nomeArq+complemento;
    FileWriter wr= new FileWriter(nomeArq);
    wr.write(frase);
    
    wr.close();
   }
    
}