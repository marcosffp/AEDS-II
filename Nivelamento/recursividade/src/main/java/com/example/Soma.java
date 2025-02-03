package com.example;

public class Soma {
  public static int soma(int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (m == 1) {
      return n;
    }
    return n + soma(n, m - 1);
  }
}
