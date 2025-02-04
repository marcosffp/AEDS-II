package com.example;

public class PalavraPalindromo {

  public static boolean isPalindromo(char[] palavra) {
    return isPalindromo(palavra, 0, palavra.length - 1);
  }

  private static boolean isPalindromo(char[] palavra, int i, int j) {
    if (i >= j) {
      return true;
    }
    if (palavra[i] != palavra[j]) {
      return false;
    }
    return isPalindromo(palavra, i + 1, j - 1);
  }
}
