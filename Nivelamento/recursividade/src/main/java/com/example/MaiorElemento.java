package com.example;

public class MaiorElemento {
  public static int maiorElemento(int[] array, int tam) {
    return maiorElementoRec(array, tam);
  }

  private static int maiorElementoRec(int[] array, int tam) {
    if (tam == 1) {
      return array[0];
    }
    int maiorAteAgora = maiorElementoRec(array, tam - 1);
    return (array[tam - 1] > maiorAteAgora) ? array[tam - 1] : maiorAteAgora;
  }
}
