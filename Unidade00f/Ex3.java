/*
 * Autor -Allan
 * Objetivo - Leia o nome de um arquivo e mostre seu conteúdo convertido 
para letras maiúsculas
 */
import java.io.*;
import java.util.Scanner;
public class Ex3 {
    public static void Verifica(String nomeArq) {
    FileReader ler = new FileReader("");
    char[] novaString=new char[100]; 
    ler.read(novaString);
    String nuevaString= String.valueOf(novaString);
    nuevaString=nuevaString.toUpperCase();
    System.out.println(novaString);

    }
 public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
    String nomeArq, complemento =".txt";
    nomeArq=sc.nextLine();
    nomeArq=nomeArq+complemento;
    Verifica(nomeArq);    
    
    
}   
}
