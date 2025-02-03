package com.example;

public class PrintRecursivo {
  public static void printRecursivo(int i) {
    System.out.println(i);
    if (i > 0) {
      printRecursivo(i - 1);

    }
    System.out.println(i);
  }
}
