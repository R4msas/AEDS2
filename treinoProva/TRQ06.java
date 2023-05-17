import java.util.*;

public class TRQ06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int numero = 1;
        int total = 0;

        int[][] matriz = new int[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                matriz[i][j] = numero;
                total += numero;
                numero++;
            }
        }

        int L = input.nextInt();
        int C = input.nextInt();

        // Imprimir a casa inicial do Batuke

        System.out.print(matriz[L][C] + " ");

        total -= matriz[L][C];

        int contadorCasas = 2;
        int rodada = 1;

        while (total > 0) {
            for (int i = 0; i < rodada; i++) {
                C++;
                try {
                    System.out.print(matriz[L][C] + " ");
                    total -= matriz[L][C];
                } catch (Exception e) {
                    System.out.print("");
                }

                if (total > 0) {
                    contadorCasas++;
                }
            }
            for (int i = 0; i < rodada; i++) {
                L++;
                try {
                    System.out.print(matriz[L][C] + " ");
                    total -= matriz[L][C];
                } catch (Exception e) {
                    System.out.print("");
                }

                if (total > 0) {
                    contadorCasas++;
                }
            }

            rodada++;

            for (int i = 0; i < rodada; i++) {
                C--;
                try {
                    System.out.print(matriz[L][C] + " ");
                    total -= matriz[L][C];
                } catch (Exception e) {
                    System.out.print("");
                }

                if (total > 0) {
                    contadorCasas++;
                }
            }
            for (int i = 0; i < rodada; i++) {
                L--;
                try {
                    System.out.print(matriz[L][C] + " ");
                    total -= matriz[L][C];
                } catch (Exception e) {
                    System.out.print("");
                }

                if (total > 0) {
                    contadorCasas++;
                }
            }

            rodada++;
        }

        System.out.println("");
        System.out.println(contadorCasas);

        input.close();
    }
}