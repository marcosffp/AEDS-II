package com.example;

public class SomaNumerosPares {
  public static int somaNumerosPares(int num) {
    return somaNumerosParesRec(num);
  }

  private static int somaNumerosParesRec(int num) {
    if (num % 2 != 0) {
      num--;
    }
    if (num == 0) {
      return 0;
    }
    return num + somaNumerosParesRec(num - 2);
  }
}
