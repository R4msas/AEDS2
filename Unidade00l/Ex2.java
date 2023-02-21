
/*
 * Autor - Allan Objetivo - Faça uma classe retângulo contendo os atributos base e altura, pelo
 * menos dois métodos construtores, o método double getArea() que retorna a área do retângulo, o
 * método double getPerimetro() que retorna o perímetro do retângulo e o método double getDiagonal()
 * que retorna a diagonal do retângulo
 */
import java.util.Scanner;
import java.lang.Math;

class Retangulo {
   double base;
   double altura;

   Retangulo() {
      base = 0;
      altura = 0;
   }

   Retangulo(double b, double h) {
      base = b;
      altura = h;
   }

   public void setRetangulo()
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Informe a base do retângulo e a sua altura:");
      base = sc.nextDouble();
      altura = sc.nextDouble();
   }
}


public class Ex2 {
   public static double getArea(double altura, double base)
   {
      double area = altura * base;
      return area;
   }

   public static double getPerimetro(double altura, double base)
   {
      double perimetro = 2 * base + 2 * altura;
      return perimetro;
   }

   public static double getDiagonal(double altura, double base)
   {
      double diagonal = Math.pow((altura * altura + base * base), 0.5);
      return diagonal;
   }

   public static void main(String[] args)
   {
      Retangulo meuRetangulo = new Retangulo();
      meuRetangulo.setRetangulo();
      System.out.println("A diagonal é:" + getDiagonal(meuRetangulo.altura, meuRetangulo.base));
      System.out.println("O perímetro é:" + getPerimetro(meuRetangulo.altura, meuRetangulo.base));
      System.out.println("A área é:" + getArea(meuRetangulo.altura, meuRetangulo.base));


   }
}

