#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* substr(char* jsonString, int beggining, int end);

char* pairs(char* jsonString);

char* Key(char* pair);

char* Value(char* pair, int keyLength);

char* doubleFixer(char* string);

typedef struct Personagem Personagem;
struct Personagem {
	char* nome;
	int altura;
	double peso;
	char* corDoCabelo;
	char* corDaPele;
	char* corDosOlhos;
	char* anoNascimento;
	char* genero;
	char* homeworld;
};

void Construtor(Personagem* personagem) {
	personagem->nome = (char*)malloc(50);
	personagem->altura = 0;
	personagem->peso = 0;
	personagem->corDoCabelo = (char*)malloc(50);
	personagem->corDaPele = (char*)malloc(50);
	personagem->corDosOlhos = (char*)malloc(50);
	personagem->anoNascimento = (char*)malloc(50);
	personagem->genero = (char*)malloc(50);
	personagem->homeworld = (char*)malloc(50);
}

void Ler(Personagem* personagem, char* filePath) {
	FILE* file = fopen(filePath, "r");

	if (file == NULL) {
		printf("Erro ao abrir o arquivo.\n");
		exit(0);
	}
	char* jsonString = malloc(500);
	fscanf(file, " %[^\n]", jsonString);
	fclose(file);

	// Remove as chaves do começo e fim do JSON
	jsonString[strlen(jsonString) - 1] = '\0';
	jsonString++;

	for (int i = 0; i < 9; i++) { // 9
		char* pair = pairs(jsonString);

		// Skippa para o próximo par Key:Value (para a próxima iteração)
		jsonString += strlen(pair) + 2;

		char* key = (char*)malloc(50);
		strcpy(key, Key(pair));

		char* value = (char*)malloc(50);
		strcpy(value, Value(pair, strlen(key)));

		// printf("key: %s\n", key);
		// printf("Value: %s\n", value);

		if (!strcmp(key, "name")) {
			strcpy(personagem->nome, value);
		} else if (!strcmp(key, "height")) {
			if (!strcmp(key, "unknown")) {
				personagem->altura = 0;
			} else {
				personagem->altura = atoi(value);
			}
		} else if (!strcmp(key, "mass")) {
			if (!strcmp(value, "unknown")) {
				personagem->peso = 0;
			} else {
				value = doubleFixer(value);
				personagem->peso = strtod(value, NULL);
			}
		} else if (!strcmp(key, "hair_color")) {
			personagem->corDoCabelo = value;
		} else if (!strcmp(key, "skin_color")) {
			personagem->corDaPele = value;
		} else if (!strcmp(key, "eye_color")) {
			personagem->corDosOlhos = value;
		} else if (!strcmp(key, "birth_year")) {
			personagem->anoNascimento = value;
		} else if (!strcmp(key, "gender")) {
			personagem->genero = value;
		} else if (!strcmp(key, "homeworld")) {
			personagem->homeworld = value;
		}
	}
}

void Imprimir(Personagem personagem) {
	printf(" ## %s", personagem.nome);
	printf(" ## %d", personagem.altura);
	printf(" ## %g", personagem.peso);
	printf(" ## %s", personagem.corDoCabelo);
	printf(" ## %s", personagem.corDaPele);
	printf(" ## %s", personagem.corDosOlhos);
	printf(" ## %s", personagem.anoNascimento);
	printf(" ## %s", personagem.genero);
	printf(" ## %s", personagem.homeworld);
	printf(" ## \n");
}

int main() {
	char* filePath = malloc(50);

	scanf("%s", filePath);
	// replaceAll(filePath, "é", "\u00e9");

	while (strcmp(filePath, "FIM")) {
		Personagem personagem;
		Construtor(&personagem);

		Ler(&personagem, filePath);
		Imprimir(personagem);

		scanf("%s", filePath);
	}
}

char* substr(char* string, int beggining, int end) {
	char* aux = (char*)malloc(500 * sizeof(char));
	for (int i = 0; i < end; i++) {
		aux[i] = string[beggining++];
		aux[i + 1] = '\0';
	}

	return realloc(aux, (strlen(aux) + 1) * sizeof(char));
}

char* pairs(char* jsonString) {
	for (int i = 0; i < strlen(jsonString); i++) {
		// !strcmp(substr(jsonString, i, i + 1), "',")
		if (jsonString[i] == '\'' && jsonString[i + 1] == ',') {
			return substr(jsonString, 0, i + 1);
		}
	}
}

char* Key(char* pair) {
	char* aux = (char*)malloc(500 * sizeof(char));

	for (int i = 0; i < strlen(pair); i++) {
		if (pair[i] == ':') {
			return substr(pair, 1, i - 2);
		}
	}
}

char* Value(char* pair, int keyLength) {
	int valueStart = keyLength + 5; // Skippa a chave - (+ 5 é pra skippar os espaços e ':' e '`')
	int valueEnd = strlen(pair) - valueStart - 1; // - 1 para não salvarmos o último '
	return substr(pair, valueStart, valueEnd);
}

char* doubleFixer(char* string) {
	char* aux = (char*)malloc(strlen(string) * sizeof(char));

	for (int i = 0, j = 0; i < strlen(string); i++) {
		if (string[i] != ',') {
			aux[j] = string[i];
			aux[i + 1] = '\0';
			j++;
		}
	}
	aux[strlen(string)] = '\0';
	return aux;
}