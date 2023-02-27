import java.util.Scanner;

public class Ex1 {
public static void main(String[] args)
{
   Scanner sc =new Scanner(System.in);
    double ladoA =sc.nextDouble();
    double ladoB =sc.nextDouble();
    double ladoC =sc.nextDouble();
    if(ladoA==ladoB && ladoA==ladoC)
    {
        System.out.println("Triangulo isósceles");
    }
    else if(ladoA==ladoB||ladoB==ladoC||ladoA==ladoC)
    {
        System.out.println("Triângulo equilátero");
    }
    else
    {
        System.out.println("Triângulo escaleno");
    }


}


}