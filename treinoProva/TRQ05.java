import java.util.*;

class Ficha {
    private String nome;
    private String regiao;
    private int custo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
}

public class TRQ05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int qtdAlunos = input.nextInt();
        Ficha fichas[] = new Ficha[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            String nome = input.next();
            String regiao = input.next();
            int custo = input.nextInt();

            fichas[i] = new Ficha();

            fichas[i].setNome(nome);
            fichas[i].setRegiao(regiao);
            fichas[i].setCusto(custo);
        }

        ordenaPorInsercao(fichas, qtdAlunos);

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println(fichas[i].getNome());
        }

        input.close();
    }

    public static void ordenaPorInsercao(Ficha[] fichas, int tamanho) {
        // Ordenar por CUSTO
        for (int i = 1; i < tamanho; i++) {
            Ficha alunoTemporario = fichas[i];
            int j = i - 1;

            while ((j >= 0) && (fichas[j].getCusto() > alunoTemporario.getCusto())) {

                fichas[j + 1] = fichas[j];
                j--;
            }

            fichas[j + 1] = alunoTemporario;
        }

        // Ordenar por REGIÃO
        for (int i = 1; i < tamanho; i++) {
            Ficha alunoTemporario = fichas[i];
            int j = i - 1;

            while ((j >= 0) && (fichas[j].getCusto() == alunoTemporario.getCusto())
                    && (fichas[j].getRegiao().compareTo(alunoTemporario.getRegiao()) > 0)) {

                fichas[j + 1] = fichas[j];
                j--;
            }

            fichas[j + 1] = alunoTemporario;
        }
    }
}