package com.example;

public class Recursivo {
  public static int numRecursivo(String palavra) {
    return numRecursivo(palavra.toCharArray(), palavra.length()-1);
      }
    
      private static int numRecursivo(char[] charArray, int i) {
        if (i < 0) {
          return 0;
        }

        if ((!(charArray[i] >= 65 && charArray[i] <= 90)) && charArray[i] != 'a' && charArray[i] != 'e'
            && charArray[i] != 'i' && charArray[i] != 'o' && charArray[i] != 'u') {
          return 1 + numRecursivo(charArray, i - 1);
        }
        return numRecursivo(charArray, i - 1);
      }
}
