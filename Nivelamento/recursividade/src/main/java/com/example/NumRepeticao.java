package com.example;

public class NumRepeticao {
  public static int numeroRepeticao(double[] vetors, double num) {
    return numeroRepeticao(vetors, num, 0);
  }

  private static int numeroRepeticao(double[] vetors, double num, int tam) {
    if (tam == vetors.length) {
      return 0;
    }
    int numeroRepetido = numeroRepeticao(vetors, num, tam + 1);
    return vetors[tam] == num ? 1 + numeroRepetido : numeroRepetido;
  }

}
