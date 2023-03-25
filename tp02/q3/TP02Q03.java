import java.io.RandomAccessFile;
// import java.util.Scanner;

public class TP02Q03 {

	public static class Personagem {
		private String nome;
		private int altura;
		private double peso;
		private String corDoCabelo;
		private String corDaPele;
		private String corDosOlhos;
		private String anoNascimento;
		private String genero;
		private String homeworld;

		Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele, String corDosOlhos,
				String anoNascimento, String genero, String homeworld) {
			setNome(nome);
			setAltura(altura);
			setPeso(peso);
			setCorDoCabelo(corDoCabelo);
			setCorDaPele(corDaPele);
			setCorDosOlhos(corDosOlhos);
			setAnoNascimento(anoNascimento);
			setGenero(genero);
			setHomeworld(homeworld);
		}

		Personagem() {
			setNome("");
			setAltura(0);
			setPeso(0.0);
			setCorDoCabelo("");
			setCorDaPele("");
			setCorDosOlhos("");
			setAnoNascimento("");
			setGenero("");
			setHomeworld("");
		}

		// Setter e Getter para o atributo nome
		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		// Setter e Getter para o atributo altura
		public void setAltura(int altura) {
			this.altura = altura;
		}

		public int getAltura() {
			return altura;
		}

		// Setter e Getter para o atributo peso
		public void setPeso(double peso) {
			this.peso = peso;
		}

		public double getPeso() {
			return peso;
		}

		// Setter e Getter para o atributo corDoCabelo
		public void setCorDoCabelo(String corDoCabelo) {
			this.corDoCabelo = corDoCabelo;
		}

		public String getCorDoCabelo() {
			return corDoCabelo;
		}

		// Setter e Getter para o atributo corDaPele
		public void setCorDaPele(String corDaPele) {
			this.corDaPele = corDaPele;
		}

		public String getCorDaPele() {
			return corDaPele;
		}

		// Setter e Getter para o atributo corDosOlhos
		public void setCorDosOlhos(String corDosOlhos) {
			this.corDosOlhos = corDosOlhos;
		}

		public String getCorDosOlhos() {
			return corDosOlhos;
		}

		// Setter e Getter para o atributo anoNascimento
		public void setAnoNascimento(String anoNascimento) {
			this.anoNascimento = anoNascimento;
		}

		public String getAnoNascimento() {
			return anoNascimento;
		}

		// Setter e Getter para o atributo genero
		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getGenero() {
			return genero;
		}

		// Setter e Getter para o atributo homeworld
		public void setHomeworld(String homeworld) {
			this.homeworld = homeworld;
		}

		public String getHomeworld() {
			return homeworld;
		}

		public void Ler(String filePath) throws Exception {

			filePath = filePath.replaceAll("é", "\u00e9");
			RandomAccessFile file = new RandomAccessFile(filePath, "r");
			// String jsonString = file.readLine().replaceAll("é", "\u00e9");
			String jsonString = file.readLine();
			file.close();

			// Separando keys e values e atribuindo a suas variaveis
			String[] pairs = jsonString.substring(1, jsonString.length() - 1).split(", '");
			for (String pair : pairs) {
				String[] keyValue = pair.split(":");
				String key = keyValue[0].replaceAll("\'", "");
				String value = keyValue[1].replaceAll("\'", "").trim();

				if (key.equals("name")) {
					setNome(value);
				} else if (key.equals("height")) {
					if (value.equals("unknown")) {
						setAltura(0);
						continue;
					}
					setAltura(Integer.parseInt(value));
				} else if (key.equals("mass")) {
					if (value.equals("unknown")) {
						setPeso(0);
						continue;
					}
					setPeso(Double.parseDouble(value.replaceAll(",", "")));
				} else if (key.equals("hair_color")) {
					setCorDoCabelo(value);
				} else if (key.equals("skin_color")) {
					setCorDaPele(value);
				} else if (key.equals("eye_color")) {
					setCorDosOlhos(value);
				} else if (key.equals("birth_year")) {
					setAnoNascimento(value);
				} else if (key.equals("gender")) {
					setGenero(value);
				} else if (key.equals("homeworld")) {
					setHomeworld(value);
				} else {
					break;
				}
			}
		}

		public void Imprimir() {
			MyIO.print(" ## " + this.nome);
			MyIO.print(" ## " + this.altura);
			if (this.peso % 1.0 != 0) {
				MyIO.print(" ## " + String.format("%s", this.peso));
			} else {
				MyIO.print(" ## " + String.format("%.0f", this.peso));
			}
			MyIO.print(" ## " + this.corDoCabelo);
			MyIO.print(" ## " + this.corDaPele);
			MyIO.print(" ## " + this.corDosOlhos);
			MyIO.print(" ## " + this.anoNascimento);
			MyIO.print(" ## " + this.genero);
			MyIO.print(" ## " + this.homeworld);
			MyIO.print(" ## ");
			MyIO.println("");
		}

		public Personagem clone() {
			Personagem cloned = new Personagem();

			cloned.nome = this.nome;
			cloned.altura = this.altura;
			cloned.peso = this.peso;
			cloned.corDoCabelo = this.corDoCabelo;
			cloned.corDaPele = this.corDaPele;
			cloned.corDosOlhos = this.corDosOlhos;
			cloned.anoNascimento = this.anoNascimento;
			cloned.genero = this.genero;
			cloned.homeworld = this.homeworld;

			return cloned;
		}
	}

	public static class Lista {
		private Personagem[] array;
		private int n;

		public Lista() {
			this(86);
		}

		public Lista(int tamanho) {
			array = new Personagem[tamanho];
			n = 0;
		}

		public void listaAction(String str, Personagem personagem) throws Exception {

			switch (str.substring(0, 2)) {
				case "II":
					personagem.Ler(str.substring(3));
					this.inserirInicio(personagem);
					break;
				case "I*":
					// System.out.println(str.substring(str.indexOf('/', 0)));
					personagem.Ler(str.substring(str.indexOf('/', 0)));
					this.inserir(personagem, Integer.parseInt(str.substring(3)));
					break;
				case "IF":
					personagem.Ler(str.substring(3));
					this.inserirFim(personagem);
					break;
				case "RI":
					System.out.println("(R) " + array[0].nome);
					this.removerInicio();
					break;
				case "R*":
					System.out.println("(R) " + array[Integer.parseInt(str.substring(3))].nome);
					this.remover(n - 1);
					break;
				case "RF":
					System.out.println("(R) " + array[n].nome);
					this.removerFim();
					break;
				default:
			}
		}

		/**
		 * Insere um elemento na primeira posicao da lista e move os demais
		 * elementos para o fim da lista.
		 * 
		 * @param personagem elemento a ser inserido.
		 * @throws Exception Se a lista estiver cheia.
		 */
		public void inserirInicio(Personagem personagem) throws Exception {

			// validar insercao
			if (n >= array.length) {
				throw new Exception("Erro ao inserir!");
			}

			// levar elementos para o fim do array
			for (int i = n; i > 0; i--) {
				array[i] = array[i - 1];
			}

			array[0] = personagem;
			n++;
		}

		/**
		 * Insere um elemento na ultima posicao da lista.
		 * 
		 * @param personagem elemento a ser inserido.
		 * @throws Exception Se a lista estiver cheia.
		 */
		public void inserirFim(Personagem personagem) throws Exception {

			// validar insercao
			if (n >= array.length) {
				throw new Exception("Erro ao inserir!");
			}

			array[n] = personagem;
			n++;
		}

		/**
		 * Insere um elemento em uma posicao especifica e move os demais
		 * elementos para o fim da lista.
		 * 
		 * @param personagem elemento a ser inserido.
		 * @param pos        Posicao de insercao.
		 * @throws Exception Se a lista estiver cheia ou a posicao invalida.
		 */
		public void inserir(Personagem personagem, int pos) throws Exception {

			// validar insercao
			if (n >= array.length || pos < 0 || pos > n) {
				throw new Exception("Erro ao inserir!");
			}

			// levar elementos para o fim do array
			for (int i = n; i > pos; i--) {
				array[i] = array[i - 1];
			}

			array[pos] = personagem;
			n++;
		}

		/**
		 * Remove um elemento da primeira posicao da lista e movimenta
		 * os demais elementos para o inicio da mesma.
		 * 
		 * @return resp int elemento a ser removido.
		 * @throws Exception Se a lista estiver vazia.
		 */
		public Personagem removerInicio() throws Exception {
			// validar remocao
			if (n == 0) {
				throw new Exception("Erro ao remover!");
			}

			Personagem resp = array[0];
			n--;

			for (int i = 0; i < n; i++) {
				array[i] = array[i + 1];
			}

			return resp;
		}

		/**
		 * Remove um elemento da ultima posicao da lista.
		 * 
		 * @return resp int elemento a ser removido.
		 * @throws Exception Se a lista estiver vazia.
		 */
		public Personagem removerFim() throws Exception {

			// validar remocao
			if (n == 0) {
				throw new Exception("Erro ao remover!");
			}

			return array[--n];
		}

		/**
		 * Remove um elemento de uma posicao especifica da lista e
		 * movimenta os demais elementos para o inicio da mesma.
		 * 
		 * @param pos Posicao de remocao.
		 * @return resp int elemento a ser removido.
		 * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
		 */
		public Personagem remover(int pos) throws Exception {

			// validar remocao
			if (n == 0 || pos < 0 || pos >= n) {
				throw new Exception("Erro ao remover!");
			}

			Personagem resp = array[pos];
			n--;

			for (int i = pos; i < n; i++) {
				array[i] = array[i + 1];
			}

			return resp;
		}

		/**
		 * Mostra os elementos da lista separados por espacos.
		 */
		public void mostrar() {
			System.out.print("[ ");
			for (int i = 0; i < n; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("]");
		}

		/**
		 * Procura um elemento e retorna se ele existe.
		 * 
		 * @param personagem elemento a ser pesquisado.
		 * @return <code>true</code> se o array existir,
		 *         <code>false</code> em caso contrario.
		 */
		public boolean pesquisar(Personagem personagem) {
			boolean retorno = false;
			for (int i = 0; i < n && retorno == false; i++) {
				retorno = (array[i] == personagem);
			}
			return retorno;
		}
	}

	public static void main(String[] args) throws Exception {

		MyIO.setCharset("ISO-8859-1");

		String input = MyIO.readLine();

		while (!input.equals("FIM")) {
			Personagem personagem = new Personagem();

			personagem.Ler(input);
			// personagem.Imprimir();

			input = MyIO.readLine();
		}

		// Scanner scanner = new Scanner(System.in);

		// Lista lista = new Lista(Integer.parseInt(scanner.nextLine()));
		Lista lista = new Lista(MyIO.readInt());

		while ((input = MyIO.readLine()) != null) {
			Personagem personagem = new Personagem();

			System.out.println(input);
			System.exit(0);

			lista.listaAction(input, personagem);
		}

		// scanner.close();

		for (int i = 0; i < lista.n; i++) {
			System.out.print("[" + i + "] ");
			lista.array[i].Imprimir();
		}
	}
}
