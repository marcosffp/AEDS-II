package com.example;

public class NumVogais {
  public static int numVogais(char[] palavra) {
    return numVogais(palavra, 0);
  }

  private static int numVogais(char[] palavra, int i) {
    if (i == palavra.length) {
      return 0;
    }

    if (palavra[i] != 'A' && palavra[i] != 'E' && palavra[i] != 'I' && palavra[i] != 'O' && palavra[i] != 'U'
        && palavra[i] != 'a' && palavra[i] != 'e' && palavra[i] != 'i' && palavra[i] != 'o' && palavra[i] != 'u') {
      return numVogais(palavra, i + 1);
    } else {
      return 1 + numVogais(palavra, i + 1);

    }
  }
}
