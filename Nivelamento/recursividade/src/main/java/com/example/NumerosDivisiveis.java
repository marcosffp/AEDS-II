package com.example;

public class NumerosDivisiveis {

  public static int numeroDivisivel(int num) {
    if ((num % 3 != 0) && (num % 5 != 0)) {
      return numeroDivisivel(num - 1);
    }
    if (num == 0) {
      return 0;
    }

    return num + numeroDivisivel(num - 1);
  }
}
