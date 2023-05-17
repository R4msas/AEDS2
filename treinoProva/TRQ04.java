import java.util.*;

public class TRQ04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int linha = input.nextInt();
            int coluna = input.nextInt();

            int[][] matriz = new int[linha][coluna];

            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    matriz[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    // Testar os casos em que o número encontrado é zero
                    if (matriz[i][j] == 0) {
                        int top = 0, dir = 0, esq = 0, inf = 0;

                        // Testa com top
                        try {
                            top = matriz[i - 1][j];
                        } catch (Exception e) {
                            top = 0;
                        }

                        // Testa com dir
                        try {
                            dir = matriz[i][j + 1];
                        } catch (Exception e) {
                            dir = 0;
                        }

                        // Testa com esq
                        try {
                            esq = matriz[i][j - 1];
                        } catch (Exception e) {
                            esq = 0;
                        }

                        // Testa com inf
                        try {
                            inf = matriz[i + 1][j];
                        } catch (Exception e) {
                            inf = 0;
                        }

                        System.out.print(top + dir + esq + inf);
                    } else if (matriz[i][j] == 1) {
                        System.out.print(9);
                    }
                }
                System.out.println("");
            }
        }

        input.close();
    }
}