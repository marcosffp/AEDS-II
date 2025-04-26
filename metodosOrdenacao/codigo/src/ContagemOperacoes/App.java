package ContagemOperacoes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.Consumer;

/**
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 * Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class App {
  static final int[] TAMANHOS_TESTE_GRANDE = { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
  static final int[] TAMANHOS_TESTE_MEDIO = { 12_500, 25_000, 50_000, 100_000, 200_000 };
  static final int[] TAMANHOS_TESTE_PEQUENO = { 3, 6, 12, 24, 48 };
  static final double NANO_TO_MILLI = 1.0 / 1_000_000;
  static Random aleatorio = new Random(42);
  static long operacoes;

  /**
   * Código de teste 1. Este método...
   * 
   * @param vetor Vetor com dados para teste.
   * @return Uma resposta que significa....
   */
  static int codigo1(int[] vetor) {
    int resposta = 0;
    for (int i = 0; i < vetor.length; i += 2) {
      resposta += vetor[i] % 2;
      operacoes++;
    }
    return resposta;
  }

  /**
   * Código de teste 2. Este método...
   * 
   * @param vetor Vetor com dados para teste.
   * @return Uma resposta que significa....
   */
  static int codigo2(int[] vetor) {
    int contador = 0;
    for (int k = (vetor.length - 1); k > 0; k /= 2) {
      for (int i = 0; i <= k; i++) {
        contador++;
        operacoes++;
      }

    }
    return contador;
  }

  /**
   * Código de teste 3. Este método...
   * 
   * @param vetor Vetor com dados para teste.
   */
  static void codigo3(int[] vetor) {
    for (int i = 0; i < vetor.length - 1; i++) {
      int menor = i;
      for (int j = i + 1; j < vetor.length; j++) {
        operacoes++;
        if (vetor[j] < vetor[menor])
          menor = j;
      }
      int temp = vetor[i];
      vetor[i] = vetor[menor];
      vetor[menor] = temp;
    }
  }

  /**
   * Código de teste 4 (recursivo). Este método...
   * 
   * @param n Ponto inicial do algoritmo
   * @return Um inteiro que significa...
   */
  static int codigo4(int n) {
    operacoes++;
    if (n <= 2)
      return 1;
    else {
      return codigo4(n - 1) + codigo4(n - 2);
    }
  }

  /**
   * Gerador de vetores aleatórios de tamanho pré-definido.
   * 
   * @param tamanho Tamanho do vetor a ser criado.
   * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2),
   *         desordenado.
   */
  static int[] gerarVetor(int tamanho) {
    int[] vetor = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      vetor[i] = aleatorio.nextInt(1, tamanho / 2);
    }
    return vetor;

  }

  public static void testaVetor(int[] VETOR_TESTE, Consumer<int[]> funcao, String label) {
    int[] vet;
    int tamVet;
    long inicio, fim;
    double duracao;

    System.out.println(label);
    for (int i = 0; i < VETOR_TESTE.length; i++) {
      tamVet = VETOR_TESTE[i];
      vet = gerarVetor(tamVet);
      operacoes = 0;
      inicio = System.nanoTime();
      funcao.accept(vet);
      fim = System.nanoTime();
      duracao = (fim - inicio) * NANO_TO_MILLI;
      System.out.printf("%,d; %,d; %f\n", VETOR_TESTE[i], operacoes, duracao);
      salvarArquivo(label + ".csv", VETOR_TESTE[i], duracao, operacoes);
    }
  }

  public static void testaInteiros(int[] TAMANHO_TESTE, Consumer<Integer> funcao, String label) {
    int tamVet;
    long inicio, fim;
    double duracao;

    System.out.println(label);
    for (int i = 0; i < TAMANHO_TESTE.length; i++) {
      tamVet = TAMANHO_TESTE[i];
      operacoes = 0;
      inicio = System.nanoTime();
      funcao.accept(tamVet);
      fim = System.nanoTime();
      duracao = (fim - inicio) * NANO_TO_MILLI;
      System.out.printf("%,d; %,d; %.2f\n", TAMANHO_TESTE[i], operacoes, duracao);
      salvarArquivo(label + ".csv", TAMANHO_TESTE[i], duracao, operacoes);
    }
  }

  private static void salvarArquivo(String nomeArquivo, int VALOR_TESTE, double duracao, long operacoes) {
    String conteudo = String.format("%d; %d; %.2f\n", VALOR_TESTE, operacoes, duracao);
    try (FileWriter file = new FileWriter(nomeArquivo, true)) {
      file.append(conteudo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    testaVetor(TAMANHOS_TESTE_GRANDE, App::codigo1, "Testa Codigo 1 - Vetor Grande");
    testaVetor(TAMANHOS_TESTE_GRANDE, App::codigo2, "Testa Codigo 2 - Vetor Grande");
    testaVetor(TAMANHOS_TESTE_MEDIO, App::codigo3, "Testa Codigo 3 - Vetor Medio");
    testaInteiros(TAMANHOS_TESTE_PEQUENO, App::codigo4, "Testa Codigo 4 - Vetor Pequeno");
  }
}
