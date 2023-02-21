/*
 * Autor - Allan Objetivo - • Faça também uma classe Lixao contendo um método main sendo que esse
 * terá dois objetos do tipo retângulo e chamará os métodos desenvolvidos na classe retângulo
 */
public class Lixao {
    public static void main(String[] args)
    {
        Retangulo retanguloUm = new Retangulo();
        Retangulo retanguloDois = new Retangulo();
        retanguloUm.setRetangulo();
        retanguloDois.setRetangulo();
        System.out.println("A diagonal é:" + Ex2.getDiagonal(retanguloUm.altura, retanguloUm.base));
        System.out.println("O perímetro é:" + Ex2.getPerimetro(retanguloUm.altura, retanguloUm.base));
        System.out.println("A área é:" + Ex2.getArea(retanguloUm.altura, retanguloUm.base));
        System.out.println("A diagonal é:" + Ex2.getDiagonal(retanguloDois.altura, retanguloDois.base));
        System.out.println("O perímetro é:" + Ex2.getPerimetro(retanguloDois.altura, retanguloDois.base));
        System.out.println("A área é:" + Ex2.getArea(retanguloDois.altura, retanguloDois.base));
    }
}
