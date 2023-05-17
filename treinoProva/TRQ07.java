import java.util.*;

public class TRQ07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int vagoes = input.nextInt() + 1;
        int testes = input.nextInt();

        int[] trem = new int[vagoes];
        Arrays.fill(trem, 0);

        for (int i = 0; i < testes; i++) {
            int comando = input.nextInt();

            int total1 = 0;
            int total2 = 0;
            int total3 = 0;

            // Caso seja comando UM
            if (comando == 1) {
                int vagao = input.nextInt();
                int pessoas = input.nextInt();

                trem[vagao] += pessoas;
            } else if (comando == 2) {
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();
                int d = input.nextInt();

                for (int j = a; j <= b; j++) {
                    total1 += trem[j];
                }

                for (int j = c; j <= d; j++) {
                    total2 += trem[j];
                }

                if (c >= a && c <= b && d > a) {
                    for (int j = c; j <= b; j++) {
                        total3 += trem[j];
                    }
                } else if (c < a && d > a) {
                    total3 = total1;
                } else {
                    total3 = 0;
                }

                System.out.println(total1 + total2 - total3);
            }

        }

        input.close();
    }
}