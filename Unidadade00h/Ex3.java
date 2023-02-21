/*
 * Autor - Allan
 * Objetivo: • Faça um método recursivo que receba um array de inteiros e os ordene
*/
import java.util.Scanner;
 public class Ex3 {
    public static void ImprimeArray(int tamanhoDoArray,int array[])
    {
        System.out.println("Array ordenado:");
        for(int c=0;c<tamanhoDoArray;c++)
        {
            System.out.println(array[c]);
        }
    }
   public static void PreencheArrayInt (int tamanhoDoArray, int array[])
   {
    Scanner sc = new Scanner(System.in);
        for (int c=0;c<tamanhoDoArray;c++)
        {
            array[c]=sc.nextInt();
        }
   }
   public static void OrdenaArrayRecursivo (int tamanhoDoArray,int array[],int indiceNestaRecursao)
   {   
    int menor,aux, indiceMenor;
    menor =array[indiceNestaRecursao];
    indiceMenor=indiceNestaRecursao;
    for(int c=indiceNestaRecursao;c<tamanhoDoArray;c++)
    {
    if (menor>array[c])
    {
        menor=array[c];
        indiceMenor=c;
    }
    }
    aux=array[indiceNestaRecursao];
    array[indiceNestaRecursao]=menor;
    array[indiceMenor]=aux;
    if(indiceNestaRecursao<(tamanhoDoArray-1))
    {
        OrdenaArrayRecursivo(tamanhoDoArray,array,indiceNestaRecursao+1);
    }

       
   }  
    public static void main(String[] args) 
    {
    Scanner sc = new Scanner(System.in);
    int tamanhoDoArray=sc.nextInt();
    int [] array= new int[tamanhoDoArray];
    PreencheArrayInt(tamanhoDoArray,array);
    if (tamanhoDoArray>=0)
    {
    OrdenaArrayRecursivo(tamanhoDoArray,array,0);
    }
    ImprimeArray(tamanhoDoArray,array);
} 
}
