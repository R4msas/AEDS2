#include <stdbool.h>
#include <stdio.h>
bool checa(int *array, int x, int d) {
   printf(" The length of int array is : %d \n", d); //Testando se o tamanho da array ta certo
  printf("O valor q c quer ver é %d\n",x); //Testando se o valor de checagem ta certo
  int m = d / 2; //Array divido por 2, só que começa no 0 por isso da um valor a frente
    printf("A metade é %d\n",m); //Testando se a metade da array ta certa
  if (x < array[m]) {
    printf("array na posição m %d\n",array[m]); //Testando se o valor na posição da metade da array ta certo
    for (int i = 0; i < m; i++) {
      if (x == array[i]) {
        printf("SELEÇÃO 1\n"); //Primeira saida
        return true;
      }
    }
  } else if (x > array[m]) {
printf("array na posição m %d\n",array[m]); //Testando se o valor na posição da metade da array ta certo
    for (int j = d; j > m; j--) {
      if (x == array[j]) {
        printf("SELEÇÃO 2\n"); //Segunda saida
        return true;
      }
    }
  }
  else 
    printf("SELEÇÃO 3\n"); //Terceira saida
    return false;
}

int main(void) {
  
  int x;
  int array[]={1,2,3,4,5,6,7,8,9,10};
  
  scanf("%d", &x); //Pede o valor de checagem


   printf(" The length of int array is : %d \n", sizeof(array) / sizeof(array[0])); //Printa o tamanho da array
  
  if (checa(array, x, (sizeof(array) / sizeof(array[0]))) == true)  //Chama a função passando a array o número que quer checar e o tamanho dela
    printf("Tem esse numero na sua array");
   else
    printf("NAO TEM PORRA");
  return (0);
}