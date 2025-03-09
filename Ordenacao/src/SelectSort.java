public class SelectSort {
  public static int[] selectSort(int[] v) {
    for (int ref = 0; ref < v.length - 1; ref++) {
      int menor = ref;
      for (int i = ref + 1; i < v.length; i++) {
        if (v[ref] > v[i]) {
          menor = i;
        }
      }
      int aux = v[menor];
      v[menor] = v[ref];
      v[ref] = aux;
    }
    return v;
  }
}
