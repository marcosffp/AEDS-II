package com.example;

public class Ordenacao {

  public static int[] ordenar(int[] vetor) {
    return ordenar(vetor, 0);
  }

  private static int[] ordenar(int[] vetor, int i) {
    if (i < vetor.length) {
      if (i > 0 && vetor[i] < vetor[i - 1]) {
        int aux = vetor[i];
        vetor[i] = vetor[i - 1];
        vetor[i - 1] = aux;
        return ordenar(vetor, i - 1);
      } else {
        return ordenar(vetor, i + 1);
      }
    }
    return vetor;
  }
}
