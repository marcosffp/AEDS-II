package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(NumerosDivisiveis.numeroDivisivel(10));
        System.out.println(PalavraPalindromo.isPalindromo(new char[] { 'O', 'V', 'O' }));
        System.out.println(NumVogais.numVogais(new char[] { 'O', 'V', 'O' }));
        System.out.println(Recursivo.numRecursivo("OVO12@"));
        int[] vetor = { 5, 4, 3, 2, 1 };
        vetor = Ordenacao.ordenar(vetor);
        for (int i : vetor) {
            System.out.print(i+" ");
        }
        
        /*     Scanner scanner = new Scanner(System.in);
        int op;
        
        do {
            System.out.println("Escolha um algoritmo: ");
            System.out.println("1 - PrintRecursivo");
            System.out.println("2 - Fatorial");
            System.out.println("3 - Soma");
            System.out.println("4 - MaiorElemento");
            System.out.println("5 - SomaNumerosPares");
            System.out.println("6 - SomarVetorDouble");
            System.out.println("7 - NumRepeticao");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
        
            op = scanner.nextInt();
            scanner.nextLine();
        
            switch (op) {
                case 1:
                    PrintRecursivo.printRecursivo(2);
                    break;
                case 2:
                    System.out.println(Fatorial.fatorial(5));
                    break;
                case 3:
                    System.out.println(Soma.soma(5, 5));
                    break;
                case 4:
                    System.out.println(MaiorElemento.maiorElemento(new int[] { 1, 2, 3, 4, 5 }, 5));
                    break;
                case 5:
                    System.out.println(SomaNumerosPares.somaNumerosPares(10));
                    break;
                case 6:
                    System.out.println(SomarVetorDouble.somarVetorDouble(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
                    break;
                case 7:
                    System.out.println(NumRepeticao.numeroRepeticao(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }, 3.0));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
        
        scanner.close();
        }*/
    }
}
