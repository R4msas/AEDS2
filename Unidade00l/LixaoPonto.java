/*
 * Autor - Allan Objetivo - Um aluno desenvolveu a classe abaixo e pediu sua ajuda para compilá-la.
 * Para ajudar, você deve criar uma classe Ponto com as seguintes regras: • Quatro atributos
 * privados: double x, double y, int id e int nextID • Os atributos id e nextID serão alterados
 * somente por um método construtor. • Implemente os métodos get e set tanto para o atributo x como
 * para o y • Na declaração do atributo nextID, o mesmo deve receber zero. Além disso, a alteração
 * do valor desse atributo por um objeto sempre será compartilhada com qualquer objeto da classe
 * ponto • Implemente dois construtores sendo que o primeiro não recebe parâmetros e inicializa os
 * valores de x e y com zero. O segundo recebe dois parâmetros (cujos nomes são obrigatoriamente x e
 * y) e devem ser utilizados para inicializar os valores dos atributos x e y, respectivamente • Os
 * dois construtores devem atribuir o valor corrente do atributo nextID ao atributo id e incrementar
 * o valor de nextID. Observe que cada objeto terá um ID distinto • Implemente qualquer método que
 * seja necessário para compilar a classe LixaoPonto class LixaoPonto { public static void main
 * (String[] args){ Ponto p1 = new Ponto(4,3); Ponto p2 = new Ponto(8,5); Ponto p3 = new
 * Ponto(9.2,10); System.out.println("Distancia p1 entre e p2: " + p1.dist(p2));
 * System.out.println("Distancia p1 entre e (5,2): " + p1.dist(5,2));
 * System.out.println("Distancia (4,3) entre e (5,2): " + Ponto.dist(4,3,5,2));
 * System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1,p2,p3));
 * System.out.println("Area retangulo:" + p1.getAreaRetangulo(p2)); System.out.println("ID de P1: "
 * + p1.getID()); System.out.println("ID de P2: " + p2.getID()); System.out.println("ID de P3: " +
 * p3.getID()); System.out.println("Next ID: " + Ponto.getNextID()); } }
 * ---------------------------- Exercício
 */
import java.util.Scanner;
import java.lang.Math;

class Ponto {
    double x, y;
    int id, nextId;

    Ponto() {
        x = 0;
        y = 0;
    }

    Ponto(double x, double y) 
    {
        this.x=x;
        this.y=y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }
    public double Dist(double abcissa,double ordenada)//método que recebe um objeto e o valor dos coordenadas abcissas e ordenadas do plano cartesiano de um segundo objeto, faz-se um triangulo retângulo tendo como catetos a diferença entra as abcissas e a diferença entre as ordenas, sendo a distância entre os pontos desejados a hipotenusa deste triângulo. 
    {
        double difAbcissa=this.x-abcissa;
        double difOrdenada=this.y-ordenada;
        double hipotenusa=Math.sqrt(difAbcissa*difAbcissa+difOrdenada*difOrdenada);
        return hipotenusa;
    }
    public static double Dist(double abcissa,double ordenada,double abc, double ord)//mesmo método, porém recebe quatro coordenadas
    {
        double difAbcissa=abc-abcissa;
        double difOrdenada=ord-ordenada;
        double hipotenusa=Math.sqrt(difAbcissa*difAbcissa+difOrdenada*difOrdenada);
        return hipotenusa;
    }
    public static String isTriangulo(Ponto p_1,Ponto p_2,Ponto p_3)//neste método acionamos o método Dist para encontrar as três retas que formam a figura
    {   
        String resposta="A diferença entre os pontos não gera um triângulo";
        double lado1= p_1.Dist(p_2.x, p_2.y);
        double lado2= p_1.Dist(p_3.x, p_3.y);
        double lado3= p_3.Dist(p_2.x, p_2.y);
        double semiPerimetro=(lado1+lado2+lado3)/2;
        if(lado1<semiPerimetro&&lado2<semiPerimetro&&lado3<semiPerimetro)
        {
            resposta= "As retas oriundas da diferença entre os pontos formam um triângulo";
        }
       return resposta;

    }
    public double getAreaRetangulo(double abcissa, double ordenada)
    { 
        
       
    }
}


public class LixaoPonto {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Ponto p1 = new Ponto(4, 3);
        Ponto p2 = new Ponto(8, 5);
        Ponto p3 = new Ponto(9.2, 10);
        System.out.println("Distancia p1 entre e p2: " + p1.Dist(p2.x, p2.y));
        System.out.println("Distancia p1 entre e (5,2): " + p1.Dist(5, 2));
        System.out.println("Distancia (4,3) entre e (5,2): " + Ponto.Dist(4, 3, 5, 2));
        System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1, p2, p3));
        System.out.println("Area retangulo:" + p1.getAreaRetangulo(p2.x,p2.y));
        System.out.println("ID de P1: " + p1.getID());
        System.out.println("ID de P2: " + p2.getID());
        System.out.println("ID de P3: " + p3.getID());
        System.out.println("Next ID: " + Ponto.getNextID());

    }

}
