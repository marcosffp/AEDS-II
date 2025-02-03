package com.example;

public class SomarVetorDouble {
  public static double somarVetorDouble(double[] vetors) {
    return somarVetorDouble(vetors, vetors.length);
  }

  private static double somarVetorDouble(double[] vetors, int tam) {
    if (tam == 1) {
      return vetors[0];
    }
    return vetors[tam - 1] + somarVetorDouble(vetors, tam - 1);
  }
}
