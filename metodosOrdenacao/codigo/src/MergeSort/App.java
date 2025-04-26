package MergeSort;

import java.util.Random;

public class App {
  static final int[] TAMANHOS_TESTE_MEDIO = { 12_500, 25_000, 50_000, 100_000, 200_000 };
  static Random aleatorio = new Random(42);

  /**
   * Gerador de vetores aleatórios de tamanho pré-definido.
   * 
   * @param tamanho Tamanho do vetor a ser criado.
   * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2),
   *         desordenado.
   */
  static Integer[] gerarVetor(int tamanho) {
    Integer[] vetor = new Integer[tamanho];
    for (int i = 0; i < tamanho; i++) {
      vetor[i] = aleatorio.nextInt(1, tamanho / 2);
    }
    return vetor;

  }

  public static void ordenar(int[] vetorTamanhos) {

    int tamVetor;
    Integer[] vetor;
    MergeSort<Integer> ordenacao;

    for (int i = 0; i < vetorTamanhos.length; i++) {
      tamVetor = vetorTamanhos[i];
      vetor = gerarVetor(tamVetor);
      ordenacao = new MergeSort<>(vetor);
      ordenacao.setComparador(Integer::compareTo);
      vetor = ordenacao.ordenar();

      System.out.printf("%,d;%,d;%,d;%.2f\n", tamVetor, ordenacao.getComparacoes(), ordenacao.getMovimentacoes(),
          ordenacao.getTempoOrdenacao());
    }
  }

  public static void main(String[] args) {

    System.out.println("Contagem de operações e medição "
        + "do tempo de execução do método de ordenação por Mesclagem");
    ordenar(TAMANHOS_TESTE_MEDIO);
  }
}