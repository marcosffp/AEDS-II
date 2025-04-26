package MergeSort;

import java.util.Comparator;

import Io.IOrdenator;

public class MergeSort<T extends Comparable<T>> implements IOrdenator<T> {

  private T[] dados;
  private Comparator<T> comparador;
  private long comparacoes;
  private long movimentacoes;
  private long inicio;
  private long termino;

  public MergeSort(T[] dados) {
    this.dados = dados;
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.inicio = System.nanoTime();
  }

  @Override
  public void setComparador(Comparator<T> comparador) {
    this.comparador = comparador;
  }

  @Override
  public T[] ordenar() {
    comparacoes = 0;
    movimentacoes = 0;
    iniciar();

    mergesort(0, dados.length - 1);

    terminar();
    return dados;
  }

  private void mergesort(int esq, int dir) {
    if (esq < dir) {
      int meio = (esq + dir) / 2;
      mergesort(esq, meio);
      mergesort(meio + 1, dir);
      intercalar(esq, meio, dir);
    }
  }

  private void intercalar(int esq, int meio, int dir) {
    int n1 = meio - esq + 1;
    int n2 = dir - meio;

    @SuppressWarnings("unchecked")
    T[] a1 = (T[]) new Comparable[n1];
    @SuppressWarnings("unchecked")
    T[] a2 = (T[]) new Comparable[n2];

    for (int i = 0; i < n1; i++) {
      a1[i] = dados[esq + i];
    }
    for (int j = 0; j < n2; j++) {
      a2[j] = dados[meio + 1 + j];
    }

    int i = 0, j = 0, k = esq;
    while (i < n1 && j < n2) {
      comparacoes++;
      if (comparador.compare(a1[i], a2[j]) <= 0) {
        dados[k] = a1[i++];
      } else {
        dados[k] = a2[j++];
      }
      movimentacoes++;
      k++;
    }

    while (i < n1) {
      dados[k++] = a1[i++];
      movimentacoes++;
    }
    while (j < n2) {
      dados[k++] = a2[j++];
      movimentacoes++;
    }
  }

  @Override
  public long getComparacoes() {
    return comparacoes;
  }

  @Override
  public long getMovimentacoes() {
    return movimentacoes;
  }

  private void iniciar() {
    inicio = System.nanoTime();
  }

  private void terminar() {
    termino = System.nanoTime();
  }

  @Override
  public double getTempoOrdenacao() {
    return (termino - inicio) / 1_000_000.0;
  }
}
